
var aPanel = {
		
		hudMsg : function(type, message, timeOut){
			$('.hudmsg').remove();
			if (!timeOut) {
				timeOut = 3000;
			}
			var timeId = new Date().getTime();
			if (type != '' && message != '') {
				$('<div class="hudmsg ' + type + '" id="msg_' + timeId + '"><img src="images/msg_' + type + '.png" alt="" />' + message + '</div>').hide().appendTo('body').fadeIn();

				var timer = setTimeout(function() {
					$('.hudmsg#msg_' + timeId + '').fadeOut('slow', function() {
						$(this).remove();
					});
				}, timeOut);
			}
		},
		
		checkLogState : function(){
			if ($.cookie("rmbuser") == "true") {
				$("#rmbuser").attr("checked", true);
				$("#username").val($.cookie("userName"));
				$("#password").val($.cookie("passWord"));
			} else {
				$("#username").val("");
			}
		},
		
		saveUserInfo : function(){
			if ($("#rmbuser").attr("checked")) {
				var userName = $("#username").val();
				var passWord = $("#password").val();
				$.cookie("rmbuser", "true", {
					expires : 7
				});
				$.cookie("userName", userName, {
					expires : 7
				});
				$.cookie("passWord", passWord, {
					expires : 7
				});
			} else {
				$.cookie("rmbuser", "false", {
					expires : -1
				});
				$.cookie("userName", '', {
					expires : -1
				});
				$.cookie("passWord", '', {
					expires : -1
				});
			}
		},
		
		iframeEffect : function(){
			$("#rightIframe").load(function(){
				var mainheight = $(this).contents().find("body").height() + 40;
				$(this).attr('height', mainheight)
			});
		}
		
};