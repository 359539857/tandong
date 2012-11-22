
var iPanel = {
		
		i$ : window.parent.jQuery,
				
		userApi : {
			addModuleData : "permission_add.do",
			saveModuleData : "permission_save.do",
			editModuleData : "permission_edit.do",
			loadModuleData : "permissiongroup_list.do"
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
		
		addModule : function(pp){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.addModuleData, this.i$("#operatorSet"));
			this.i$("#addModule").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "增加模块",
				modal : true,
				show : {effect : 'drop', direction : "up"},
				hide : {effect : 'drop', direction : "down"},
				position : "center",
				resizable : false,
				buttons : {
					"保存" : function() {
						var pars = {
							"sort" : iPanel.i$("#sort").val(),
							"name" : iPanel.i$("#name").val(),
							"parentPermission" : pp,
							"resource" : iPanel.i$("#resource").val()
						};
						if(iPanel.i$("#addModule").validationEngine("validate")){
							iPanel.saveModuleData(iPanel.userApi.saveModuleData, pars);
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
		},
		updateModule : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					$("#"+data.id).html(data.name);
					aPanel.hudMsg('success', '模块修改成功', 3000);
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '模块修改成功', 3000);
					return false;
				}
			});
		},
		editModule : function(id){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.editModuleData+"?id="+id, this.i$("#operatorSet"));
			this.i$("#addModule").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "修改模块",
				modal : true,
				show : {effect : 'drop', direction : "up"},
				hide : {effect : 'drop', direction : "down"},
				position : "center",
				resizable : false,
				buttons : {
					"保存" : function() {
						var pars = {
							"sort" : iPanel.i$("#sort").val(),
							"name" : iPanel.i$("#name").val(),
							"resource" : iPanel.i$("#resource").val()
						};
						if(iPanel.i$("#addModule").validationEngine("validate")){
							iPanel.updateModule(iPanel.userApi.saveModuleData, pars);
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
		},
		
		saveModuleData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					if(undefined == data.id){
						aPanel.hudMsg('error', '模块新增失败', 3000);
						return false;
					}else{
						var op = "<a href=permission_list.do?parentPermission="+ data.id +">【查看子模块】</a><a href=javascript:iPanel.editModule("+ data.id +")> 【修改】</a>";
						$("table.ajaxtable").find("tr").last().after("<tr><td>"+ data.sort +"</td><td><a href=permission_list.do?parentPermission="+ data.id +">" + data.name +"</a></td><td>"+ data.resource +"</td><td>"+ data.type +"</td><td>"+ op +"</td></tr>");
						iPanel.i$("#rightIframe").attr("height", Number(iPanel.i$("#rightIframe").attr("height")) + 40);
						aPanel.hudMsg('success', '模块新增成功', 3000);
						return true;
					}
					
				},
				error : function() {
					aPanel.hudMsg('error', '模块新增失败', 3000);
					return false;
				}
			});
		}
		
};

$(function() {
	
});