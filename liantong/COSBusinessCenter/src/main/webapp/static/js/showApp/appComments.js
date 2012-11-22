var iPanel = {
	
	i$ : window.parent.jQuery,
	
	userApi : {
		setCommentsData : "appAudit_updateAppComments.do"
	},
	setComments : function(getUrl, pars){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					if(hudMsg_timer('success', '状态更新成功', 3000)){
						var timer = setTimeout(
							function() {
								iPanel.i$("#rightIframe").attr("src","appAudit_showAppComments.do?t=" + Math.random());
							}, 1500
						);
					}
					return true;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '状态更新失败', 3000);
				return false;
			}
		});
	}
};

$(function() {
	
	$("td.commentState a.setComments").live("click",function(){
		var pars = {
				"commentID" : this.id.substr(3),
				"commentState" : iPanel.i$(this).attr("commentState")
			};
		iPanel.setComments(iPanel.userApi.setCommentsData, pars);
	});
	
});
function hudMsg_timer(type, message, timeOut) {

	$('.hudmsg').remove();

	if( ! timeOut ) {
		timeOut = 3000;
	}
	
	var timeId = new Date().getTime();
	
	if( type != '' && message != '' ) {
	
		$('<div class="hudmsg '+type+'" id="msg_'+timeId+'"><img src="images/msg_'+type+'.png" alt="" />'+message+'</div>').hide().appendTo('body').fadeIn();
		
		var timer = setTimeout(
			function() {
				$('.hudmsg#msg_'+timeId+'').fadeOut('slow', function() {
					$(this).remove();
				});
			}, timeOut
		);
		return true;
	}
}


