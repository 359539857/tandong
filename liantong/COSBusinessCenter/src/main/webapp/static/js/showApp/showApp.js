var iPanel = {
	
	i$ : window.parent.jQuery,
	
	userApi : {
		loadAppRecommandData : "appAudit_showAppRecommand.do",
		addRecommandData : "appAudit_addAppRecommand.do",
		delRecommandData : "appAudit_delAppRecommand.do",
		setRecommandData : "appAudit_setAppRecommand.do",
		getSetRecommandInfoData : "appAudit_getSetAppRecommandInfo.do",
		getAddRankListInfoData : "appAudit_getAddRankListInfo.do",
		addRankListData : "appAudit_addAppRank.do",
		setRankData : "appAudit_setAppRank.do",
		getSetRankInfoData : "appAudit_getSetRankInfo.do",
		delRankData : "appAudit_delAppRank.do",
		addNewPackageData : "appAudit_addAppPackageInfo.do",
		savePackageData : "appAudit_savePackageData.do",
		delAppPackageData : "appAudit_delAppPackage.do",
		addAppPackageListData : "appAudit_addPackageList.do",
		delAppPackageListData : "appAudit_delAppPackageList.do",
		setAppStatusData : "appAudit_updateAppStatus.do"
	},
	
	loadData : function(getUrl, Eltarget){
		$.ajax({
			type : "get",
			async : false,
			url : getUrl,
			cache: false,
			success : function(data) {
				Eltarget.html(data);
			},
			error : function() {
				aPanel.hudMsg('error', '数据加载失败', 3000);
			}
		});
	},
	
	addRecommand : function(getUrl, pars){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					aPanel.hudMsg('success', '加入精选成功', 3000);
					return true;
				}else{
					aPanel.hudMsg('error', '加入精选失败', 3000);
					return false;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '加入精选失败', 3000);
				return false;
			}
		});
	},
	
	setRecommand : function(getUrl, pars){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					if(hudMsg_timer('success', '精选排序设置成功', 3000)){
						var timer = setTimeout(
							function() {
								iPanel.i$("#rightIframe").attr("src","appAudit_showAppRecommand.do?t=" + Math.random());
							}, 500
						);
					}
					return true;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '精选排序设置失败', 3000);
				return false;
			}
		});
	},
	
	setApp : function(getUrl, appUid, appName, appVerisonID){
		iPanel.i$("#operatorSet").dialog("destroy");
		iPanel.loadData(iPanel.userApi.getSetRecommandInfoData, iPanel.i$("#operatorSet"));
		iPanel.i$("#appName_set").html(appName);
		iPanel.i$("#setAppRecommand").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
		var win = iPanel.i$("#operatorSet").dialog({
			title : "设定排序位置",
			modal : true,
			show : {effect : 'drop', direction : "up"},
			hide : {effect : 'drop', direction : "down"},
			position : "center",
			resizable : false,
			buttons : {
				"保存" : function() {
					var pars = {
							"appVerisonID" : appVerisonID,
							"appUID" : appUid,
							"appPosition" : iPanel.i$("#appPosition").val()
					};
					if(iPanel.i$("#setAppRecommand").validationEngine("validate")){
						iPanel.setRecommand(iPanel.userApi.setRecommandData, pars);
						iPanel.i$(this).dialog("close");
					}
				}
			}
		}, "open");
	},
	setRankCate : function(getUrl, appUid, appVerisonID,appName){
		iPanel.i$("#operatorSet").dialog("destroy");
		iPanel.loadData(iPanel.userApi.getAddRankListInfoData, iPanel.i$("#operatorSet"));
		iPanel.i$("#appName_set").html(appName);
		iPanel.i$("#appAddRankList").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
		var win = iPanel.i$("#operatorSet").dialog({
			title : "选择排行类型",
			modal : true,
			show : {effect : 'drop', direction : "up"},
			hide : {effect : 'drop', direction : "down"},
			position : "center",
			resizable : false,
			buttons : {
				"保存" : function() {
					var pars = {
							"appVerisonID" : appVerisonID,
							"rankCateID" : iPanel.i$("#rankCate").val(),
							"appUID" : appUid
					};
					if(iPanel.i$("#appAddRankList").validationEngine("validate")){
						iPanel.addRank(iPanel.userApi.addRankListData, pars);
						iPanel.i$(this).dialog("close");
					}
				}
			}
		}, "open");
	},
	addRank : function(getUrl, pars){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					aPanel.hudMsg('success', '加入排行成功', 3000);
					return true;
				}else{
					aPanel.hudMsg('error', '加入排行失败', 3000);
					return false;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '加入排行失败', 3000);
				return false;
			}
		});
	},
	
	setAppData : function(getUrl, pars){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					if(hudMsg_timer('success', '排行排序设置成功', 3000)){
						var timer = setTimeout(
							function() {
								iPanel.i$("#rightIframe").attr("src","appAudit_showAppRankList.do?t=" + Math.random());
							}, 500
						);
					}
					return true;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '排行排序设置失败', 3000);
				return false;
			}
		});
	},
	
	setAppRank : function(getUrl, appUid, appName, appVerisonID){
		iPanel.i$("#operatorSet").dialog("destroy");
		iPanel.loadData(iPanel.userApi.getSetRankInfoData, iPanel.i$("#operatorSet"));
		iPanel.i$("#appName_set").html(appName);
		iPanel.i$("#setAppRank").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
		var win = iPanel.i$("#operatorSet").dialog({
			title : "设定排序位置",
			modal : true,
			show : {effect : 'drop', direction : "up"},
			hide : {effect : 'drop', direction : "down"},
			position : "center",
			resizable : false,
			buttons : {
				"保存" : function() {
					var pars = {
							"appVerisonID" : appVerisonID,
							"appUID" : appUid,
							"appPosition" : iPanel.i$("#appPosition").val(),
					};
					if(iPanel.i$("#setAppRank").validationEngine("validate")){
						iPanel.setAppData(iPanel.userApi.setRankData, pars);
						iPanel.i$(this).dialog("close");
					}
				}
			}
		}, "open");
	},
	setAppStatus : function(getUrl, pars){
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
								iPanel.i$("#rightIframe").attr("src","appAudit_showAppWaitingForSell.do?t=" + Math.random());
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
	},
	addNewPackage : function(){
		//iPanel.i$("#operatorSet").dialog("destroy");
		iPanel.loadData(this.userApi.addNewPackageData, this.i$("#operatorSet"));
		iPanel.i$("#addAppPackage").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
		var win = iPanel.i$("#operatorSet").dialog({
			title : "新增应用包",
			modal : true,
			show : {effect : 'drop', direction : "up"},
			hide : {effect : 'drop', direction : "down"},
			position : "center",
			resizable : false,
			buttons : {
				"保存" : function() {
					
					var pars = {
						"name" : iPanel.i$("#name").val(),
						"fileUrl" : iPanel.i$("#fileUrl").val(),
						"appPackageDesc" : iPanel.i$("#appPackageDesc").val()
					};
					if(iPanel.i$("#addAppPackage").validationEngine("validate")){
						iPanel.savePackageData(iPanel.userApi.savePackageData, pars);
						iPanel.i$(this).dialog("close");
					}
				}
			}
		}, "open");
	},
	savePackageData : function(getUrl, pars){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					if(hudMsg_timer('success', '新增包成功', 3000)){
						var timer = setTimeout(
							function() {
								iPanel.i$("#rightIframe").attr("src","appAudit_showAppPackage.do?t=" + Math.random());
							}, 500
						);
					}
					return true;
				}else if(data.code == -2){
					aPanel.hudMsg('info', '新增包失败 - 包名已存在', 3000);
					return false;
				}else{
					aPanel.hudMsg('error', '新增包失败', 3000);
					return false;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '新增包失败', 3000);
				return false;
			}
		});
	},
	
	addAppPackageList : function(getUrl, pars, appPackageName, appName){
		$.ajax({
			type : "post",
			url : getUrl,
			cache: false,
			data : pars,
			success : function(data) {
				if(data.code == 0){
					aPanel.hudMsg('success', '[ '+appName+' ] 加入【'+appPackageName+'】成功', 3000);
					return true;
				}else if(data.code == -2){
					aPanel.hudMsg('info', '[ '+appName+' ] 已存在【'+appPackageName+'】包中', 3000);
					return false;
				}else{
					aPanel.hudMsg('error', '[ '+appName+' ] 加入【'+appPackageName+'】失败', 3000);
					return false;
				}
			},
			error : function() {
				aPanel.hudMsg('error', '[ '+appName+' ] 加入【'+appPackageName+'】失败', 3000);
				return false;
			}
		});
	},
	
	delPublicMethod : function(getUrl, pars, is, info){//url、参数、当前元素、提示信息
		if (confirm(info)) {
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					if(data.code == 0){
						$(is).parents("tr").fadeOut("slow", function() {
							aPanel.hudMsg("success", '删除成功', 3000);
						});
					}else{
						aPanel.hudMsg("error", '删除失败', 3000);
					}
				},
				error : function() {
					aPanel.hudMsg("error", '删除失败', 3000);
				}
			});
		}
		else{
			return false;
		}
	}
};

$(function() {
	
	$("td.appInfo a.delRecommand").live("click",function(){
		var pars = {
				"appVerisonID" : iPanel.i$(this).attr("appVerisonID"),
				"appUID" : this.id.substr(3)
			};
		iPanel.delPublicMethod(iPanel.userApi.delRecommandData, pars,this, '确定取消该精选吗?');
	});
	$("td.appInfo a.delRank").live("click",function(){
		var pars = {
				"appVerisonID" : iPanel.i$(this).attr("appVerisonID"),
				"appUID" : this.id.substr(3)
			};
		iPanel.delPublicMethod(iPanel.userApi.delRankData, pars, this, '确定取消该排行吗?');
	});
	$("td.appInfo a.setRecommand").live("click",function(){
		var appUid = this.id.substr(4);
		var appName = this.name;
		var appVerisonID = iPanel.i$(this).attr("appVerisonID");
		iPanel.setApp(iPanel.userApi.getSetRecommandInfoData, appUid, appName, appVerisonID);
	});
	
	$("td.appInfo a.getRank").live("click",function(){
		var appUid = this.id.substr(4);
		var appVerisonID = iPanel.i$(this).attr("appVerisonID");
		var appName = this.name;
		iPanel.setRankCate(iPanel.userApi.getAddRankListInfoData, appUid, appVerisonID, appName);
	});
	
	$("td.appInfo a.addRecommand").live("click",function(){
		var pars = {
				"appVerisonID" : iPanel.i$(this).attr("appVerisonID"),
				"appUID" : this.id.substr(3),
			};
		iPanel.addRecommand(iPanel.userApi.addRecommandData, pars);
	});
	
	$("td.appInfo a.setRank").live("click",function(){
		var appUid = this.id.substr(4);
		var appName = this.name;
		var appVerisonID = iPanel.i$(this).attr("appVerisonID");
		iPanel.setAppRank(iPanel.userApi.getSetRankInfoData, appUid, appName, appVerisonID);
	});
	
	$("td.appInfo a.addPackage").live("click",function(){
		var pars = {
				"appVerisonID" : iPanel.i$(this).attr("appVerisonID"),
				"appUID" : iPanel.i$(this).attr("appuid"),
				"appPKGID" : iPanel.i$(this).attr("appPkgId"),
				"appIcon" : iPanel.i$(this).attr("appIcon"),
				"appPkgName" : iPanel.i$(this).attr("appPkgName")
			};
		iPanel.addAppPackageList(iPanel.userApi.addAppPackageListData, pars, iPanel.i$(this).attr("appPkgName"), iPanel.i$(this).attr('appName'));
	});
	$("td.appInfo a.delAppPack").live("click",function(){
		var pars = {
				"appPKGID" : this.id.substr(4)
			};
		iPanel.delPublicMethod(iPanel.userApi.delAppPackageData, pars,this, '确定删除该应用包吗?');
	});
	$("td.appInfo a.delAppforPL").live("click",function(){
		var pars = {
				"appPKGID" : iPanel.i$(this).attr("appPKGID"),
				"appUID" : iPanel.i$(this).attr("appUID")
			};
		iPanel.delPublicMethod(iPanel.userApi.delAppPackageListData, pars,this,'确定删除该应用吗?');
	});
	$("td.appInfo a.setAppV").live("click",function(){
		var pars = {
				"appVerisonID" : this.id.substr(3),
				"status" : iPanel.i$(this).attr("status"),
				"appUID" : iPanel.i$(this).attr("appUID")
			};
		iPanel.setAppStatus(iPanel.userApi.setAppStatusData, pars);
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

