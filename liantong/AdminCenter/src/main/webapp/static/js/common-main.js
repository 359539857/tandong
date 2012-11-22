
$(function() {
	$('ul#nav .collapse:not(.open)').parents('li').find('ul').hide();
	$('ul#nav .collapse').click(
		function() {
			if (!$(this).hasClass('open')) {
				$(this).parents('li').find('ul').stop(true, true).slideDown('fast');
				$(this).addClass('open');
			} else {
				$(this).parents('li').find('ul').stop(true, true).slideUp('fast');
				$(this).removeClass('open');
			}

			return false;
		});

	$('header').append('<a href="#" id="togglemenu">+</a>');
	$('#togglemenu').live('click', function() {
		if ($(this).html() == '+') {
			$('aside').slideDown();
			$('#togglemenu').html('-');
		} else {
			$('aside').slideUp();
			$('#togglemenu').html('+');
		}

		return false;
	});

	$('input.date_picker').date_input();

	$('input.color_picker').miniColors();

	$('.wysiwyg').wysiwyg({
		css : 'css/wysiwyg.css',
		brIE : false
	});

	$('a.modal').fancybox({
		'overlayOpacity' : 0.7,
		'overlayColor' : '#000',
		'padding' : 0
	});

	$('.check_all').click(function() {
		$(this).parents('form').find('input:checkbox').attr('checked',$(this).is(':checked'));
	});

	function drawCharts(sourceTable) {
		if (sourceTable.attr('rel')) {
			var chartType = sourceTable.attr('rel');
		} else {
			var chartType = 'line';
		}

		var chart_width = sourceTable.parent('div').width() - 50;
		if (chartType == 'line' || chartType == 'pie') {
			sourceTable.hide().visualize({
				type : chartType,
				width : chart_width,
				height : 240,
				colors : [ '#3aaef7', '#ec8526', '#68ae00', '#fa504c' ],
				lineDots : 'double',
				interaction : true,
				multiHover : 5,
				tooltip : true,
				tooltiphtml : function(data) {
					var html = '';
					for ( var i = 0; i < data.point.length; i++) {
						html += '<p class="chart_tooltip"><strong>' + data.point[i].value + '</strong> ' + data.point[i].yLabels[0] + '</p>';
					}
					return html;
				}
			}).appendTo('.stats_charts').trigger('visualizeRefresh');

		} else {
			sourceTable.hide().visualize({
				type : chartType,
				width : chart_width,
				height : 240,
				colors : [ '#6fb9e8', '#ec8526', '#9dc453', '#ddd74c' ]
			});
		}
		$('.visualize').css('margin-left', '35px');
	}

	$('table.stats').each(function() {
		drawCharts($(this));
	});

	$(window).resize(function() {
		$('.visualize').remove();
		$('table.stats').each(function() {
			drawCharts($(this));
		});
	});

	$('table .delete a').click(function() {
		if (confirm("确定删除本条记录吗？")) {
			$(this).parents('tr').fadeOut('slow', function() {
				$(this).remove();
				hudMsg('success', '记录删除成功', 3000);
			});
		}
		return false;
	});

	$('#content .message').hide().append('<span class="close" title="Dismiss"></span>').fadeOut('slow');
	$('#content .message .close').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	});

	$('#content .message .close').live('click', function() {
		$(this).parent().fadeOut('slow', function() {
			$(this).remove();
		});
	});

	$('.demo_success').click(function() {
		hudMsg('success', '消息成功发送');
		return false;
	});

	$('.demo_error').click(function() {
		hudMsg('error', '出错了');
		return false;
	});

	$('.demo_info').click(function() {
		hudMsg('info', 'Just so you know,<br />you rock!');
		return false;
	});

	$('.demo_custom').click(function() {
		hudMsg('beer', 'Cheers!');
		return false;
	});

	$('.searchform input.text').each(function() {
		var default_value = $(this).val();
		$('.searchform').append('<div class="loading"></div>');
		$('.searchform').append('<div class="quickresults"></div>');

		$(this).focus(function() {
			$(this).animate({
				width : '180px'
			}, 200);

			if ($(this).val() == default_value) {
				$(this).val('');
			}
		});
						
		$(this).keypress(function() {
			if ($(this).val().length > 2) {
				$('.searchform .loading').fadeIn('fast',function() {
					$.get('test.php',{
						search_string : $('.searchform input.text').val()
								},function(data) {
									$('.searchform .quickresults').html(data).fadeIn('fast',function() {
										$('.searchform .loading').fadeOut('fast');
									});
								},'html');
				});

			} else {
				$('.searchform .loading')
						.fadeOut('fast');
				$('.searchform .quickresults')
						.fadeOut('fast');
			}
		});

		$(this).blur(function() {
			$(this).animate({
				width : '100px'
			}, 200);
			$('.searchform .loading').fadeOut('fast');
			$('header form .quickresults').hide();

			if ($(this).val() == '') {
				$(this).val(default_value);
			}
		});

	});

	$('input.file.styled').each(function() {
		var custom_file_label = $(this).attr('title');
		$(this).wrap('<span class="custom_file" />');
		$(this).parents('.custom_file').append('<input type="button" class="button" value="' + custom_file_label + '" />');
	});

	$('.custom_file input:button').live('click', function() {
		$(this).parents('span').find('input:file').click();
	});

	$('.custom_file input.file').change(function() {
		$(this).parents('span').find('em').remove();
		var filename = $(this).val().replace(/^.*\\/, '');
		$(this).parents('span').append('<em>' + filename + '</em>');
	});

	$('.onoffbtn').each(function() {
		$(this).wrap('<span class="onoff_box" />');

		if ($(this).is(':checked')) {
			$(this).parents('span').addClass('checked');
		}
	});

	$('.onoff_box').live('click', function() {
		var onoffSwitch = $(this);
		var chckBox = $(this).find('input.onoffbtn');

		if (chckBox.is(':checked')) {
			onoffSwitch.animate({'background-position-x' : '0'}, 100, function() {
				chckBox.removeAttr('checked');
				$(this).removeClass('checked');
			});

		} else {
			onoffSwitch.animate({'background-position-x' : '-40px'}, 100, function() {
				chckBox.attr('checked', 'checked');
				$(this).addClass('checked');
			});
		}
	});

	$('.progress_complete').click(function() {
		var totalWidth = $(this).parents('.progress_bar').width();
		$(this).animate({width : totalWidth}, 600, function() {
			$(this).find('span').html('100%');
		});
	});

	$('ul.imglist').sortable({
		placeholder : 'ui-state-highlight'
	});

	$('.slider').slider({
		min : 0,
		max : 100,
		step : 10,
		value : 20,
		create : function(event, ui) {
			$(this).find('.ui-slider-handle').addClass('tt').attr('title', ($(this).slider('value') + '%'));
		},
		slide : function(event, ui) {
			$(this).find('.ui-state-active.ui-state-active').attr('title', (ui.value + '%'));
		}
	});

	$('.slider-range').slider({
		range : true,
		min : 0,
		max : 100,
		values : [ 20, 80 ],
		step : 10,
		create : function(event, ui) {
			$(this).find('.ui-slider-handle').addClass('tt').each(function() {
				var percent = $(this).parents('.slider-range').slider('values',($(this).index() - 1)) + '%';
				$(this).attr('title', percent);
			});
		},
		slide : function(event, ui) {
			$(this).find('.ui-slider-handle.ui-state-active').attr('title', (ui.value + '%'));
		}
	});

	$('.tt').tipsy({
		gravity : 's'
	});

	$('ul.imglist li').hover(function() {
			$(this).find('ul').css('display', 'none').stop(true, true).fadeIn('fast').css('display', 'block');
		}, function() {
			$(this).find('ul').stop(true, true).fadeOut(100);
		});

	$('ul.imglist .delete a').click(function() {
		if (confirm('确定删除本张图片吗?')) {
			$(this).parents('li').fadeOut('slow', function() {
				$(this).remove();
				hudMsg('success', '图片删除成功', 3000);
			});
		}
		return false;
	});

	function vcodeMsg(type, timeOut) {
		if (!timeOut) {
			timeOut = 200;
		}
		if (type != '') {
			var timer = setTimeout(function() {
				$('#loading').fadeOut('slow',function() {
					$(this).remove();
					$('#statearea').html('<img id=' + type + ' src="images/' + type + '.gif">');
				});
			}, timeOut);
		}
	}

	$('.text.vcode').keyup(function(e) {
		if ($(this).val().length == 4) {
			$.ajax({
				url : "/admin/ccjosn.do",
				data : 'checkCode=' + $(this).val(),
				cache : false,
				success : function(data) {
					if (data.code == 0) {
						var loadingGif = '<img id="loading" src="images/loading.gif">';
						$('#statearea').html(loadingGif);
						vcodeMsg('success');
						if (e.keyCode == 13) {
							submitPerssionSet();
						}

					} else {
						$('#statearea').html('<img id="loading" src="images/error.gif">');
						vcodeMsg('error');
					}
				}
			});
		}
	});

	aPanel.checkLogState();
	$('#rmbuser').click(function() {
		aPanel.saveUserInfo();
	});
	
	if($("#rightIframe").length > 0){
		aPanel.iframeEffect();
	}
	
});