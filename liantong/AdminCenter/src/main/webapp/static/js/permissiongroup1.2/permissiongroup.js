
var iPanel = {
		
		i$ : window.parent.jQuery,
				
		userApi : {
			loadModuleData : "permissiongroup_list.do",
			addGroupData : "permissiongroup_add.do",
			saveGroupData : "permissiongroup_save.do",
			editGroupData : "permissiongroup_edit.do",
			deleteGroupData : "permissiongroup_delete.do"
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
		
		addGroup : function(){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.addGroupData, this.i$("#operatorSet"));
			this.i$("#addGroup").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "增加权限组",
				modal : true,
				show : {effect : 'drop', direction : "up"},
				hide : {effect : 'drop', direction : "down"},
				position : "center",
				resizable : false,
				buttons : {
					"保存" : function() {
						var temp ="";
						for(var i=0; i<iPanel.i$("input:checkbox[name=permissions]:checked").length;i++){
							if(i>0){
								temp += ","+iPanel.i$("input:checkbox[name=permissions]:checked").eq(i).val();
							}else{
								temp += iPanel.i$("input:checkbox[name=permissions]:checked").eq(i).val();
							}
						}
						var pars = {
							"name" : iPanel.i$("#name").val(),
							"permissions" : temp
						};
						if(iPanel.i$("#addGroup").validationEngine("validate")){
							iPanel.saveGroupData(iPanel.userApi.saveGroupData, pars,"新增");
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
		},
		
		saveGroupData : function(getUrl, pars, msg){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					if("新增" == msg){
						var op = "<a href=javascript:iPanel.editGroup("+ data.id +")> 【修改】</a>";
						$("table.ajaxtable").find("tr").last().after("<tr><td>"+ data.id +"</td><td>"+ data.name +"</td><td>"+ op +"</td></tr>");
						iPanel.i$("#rightIframe").attr("height", Number(iPanel.i$("#rightIframe").attr("height")) + 40);
					}else{
						$("#"+data.id).html(data.name);
					}
					aPanel.hudMsg('success', msg+'权限组成功', 3000);
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', msg+'权限组失败', 3000);
					return false;
				}
			});
		},
		
		editGroup : function(id){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.editGroupData+"?id="+id, this.i$("#operatorSet"));
			this.i$("#addGroup").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "修改权限组",
				modal : true,
				show : {effect : 'drop', direction : "up"},
				hide : {effect : 'drop', direction : "down"},
				position : "center",
				resizable : false,
				buttons : {
					"保存" : function() {
						var temp ="";
						for(var i=0; i<iPanel.i$("input:checkbox[name=permissions]:checked").length;i++){
							if(i>0){
								temp += ","+iPanel.i$("input:checkbox[name=permissions]:checked").eq(i).val();
							}else{
								temp += iPanel.i$("input:checkbox[name=permissions]:checked").eq(i).val();
							}
						}
						var pars = {
							"name" : iPanel.i$("#name").val(),
							"permissions" : temp
						};
						if(iPanel.i$("#addGroup").validationEngine("validate")){
							iPanel.saveGroupData(iPanel.userApi.saveGroupData, pars,"修改");
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
		}
		
};

$(function() {
	iPanel.loadData(iPanel.userApi.loadModuleData, $("#permissiongroupInfo"));
});