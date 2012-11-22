var iPanel = {
		
		i$ : window.parent.jQuery,
				
		userApi : {
			loadRoleData : "role_list.do",
			updateRoleData : "role_save.do",
			addRoleData : "role_add.do",
			saveRoleData : "role_save.do",
			editRoleData : "role_edit.do",
			deleteRoleData : "role_delete.do"
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
		
		updateRoleData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					$("#"+data.id).html(data.name);
					aPanel.hudMsg('success', '角色更新成功', 3000);
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '角色更新失败', 3000);
					return false;
				}
			});
		},
		
		addRole : function(){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.addRoleData, this.i$("#operatorSet"));
			this.i$("#addRole").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "增加新角色",
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
							"id" : iPanel.i$("#id").val(),
							"permissions" : temp,
							"appType" : iPanel.i$("#appType").val()
						};
						if(iPanel.i$("#addRole").validationEngine("validate") && iPanel.i$("#role_info").html() == "支持3~12位字符或中文输入"){
							iPanel.saveRoleData(iPanel.userApi.saveRoleData, pars);
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
		},
		
		saveRoleData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					var op = "<a href=\"javascript:iPanel.editRole('"+ data.id +"','"+data.name+"')\"> 【修改】</a><a class=\"deletelink\" id=\"deletelink"+data.id+"\" href=\"#\">【删除】</a>";
					var aa = "<tr><td>"+ data.id +"</td><td><span id='"+data.id+"'>"+ data.name +"</span></td><td class=\"opuser\">"+ op +"</td></tr>";
					$("#roleListInfo").find("table tr").last().after(aa)
					iPanel.i$("#rightIframe").attr("height", Number(iPanel.i$("#rightIframe").attr("height")) + 40);
					aPanel.hudMsg('success', '角色新增成功', 3000);
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '角色新增失败', 3000);
					return false;
				}
			});
		},
		
		editRole : function(id,username){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.editRoleData+"?id="+id, this.i$("#operatorSet"));
			this.i$("#name").val(username).attr("disabled", "disabled");
			this.i$("#addRole").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "修改角色",
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
							"id" : iPanel.i$("#id").val(),
							"permissions" : temp,
							"appType" : iPanel.i$("#appType").val()
						};
						if(iPanel.i$("#addRole").validationEngine("validate")){
							iPanel.updateRoleData(iPanel.userApi.updateRoleData, pars);
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
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
						}else if(data.code == 1){
							aPanel.hudMsg("info", '角色正在使用，不能删除!', 3000);
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
	iPanel.loadData(iPanel.userApi.loadRoleData, $("#roleListInfo"));
	
	$("td.opuser a.deletelink").live("click",function(){
		var realId = {"id":this.id.substr(10)};
		iPanel.delPublicMethod(iPanel.userApi.deleteRoleData, realId, this, '确定删除该角色吗?');
	});
	
	$("td.opuser a.edituser").live("click",function(){
		var realId = this.id.substr(8);
		var username = $.trim($(this).parents("tr").find("td").eq(1).html());
		iPanel.editUser(iPanel.userApi.editUserData, realId, username);
	});

});
