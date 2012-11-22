
var iPanel = {
		
		i$ : window.parent.jQuery,
				
		userApi : {
			loadUserData : "operator_list.do",
			addUserData : "operator_add.do",
			editUserData : "operator_edit.do",
			saveUserData : "operator_save.do",
			delUserData : "operator_delete.do",
			setUserData : "operator_setValid.do",
			searchUserData : "operator_search.do"
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
		
		searchData : function(getUrl, pars, Eltarget){
			$.ajax({
				type : "get",
				async : false,
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					Eltarget.html(data);
				},
				error : function() {
					aPanel.hudMsg('error', '数据加载失败', 3000);
				}
			});
		},
		
		updateUserData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					aPanel.hudMsg('success', '用户更新成功', 3000);
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '用户更新失败', 3000);
					return false;
				}
			});
		},
		
		deleteUserData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '用户删除失败', 3000);
					return false;
				}
			});
		},
		
		validateUserData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '用户冻结失败', 3000);
					return false;
				}
			});
		},
		
		saveUserData : function(getUrl, pars){
			$.ajax({
				type : "post",
				url : getUrl,
				cache: false,
				data : pars,
				success : function(data) {
					var op = "<a href=# class=edituser id=edituser"+ data.id +">【修改】</a><a href=# class=deleteuser id=deleteuser"+ data.id +">【删除】</a><a href=# class=\"validateuser flag0\" id=validateuser"+ data.id +">【无效】</a>";
					$("#operatorInfo").find("table tr").last().after("<tr><td>"+ $("#operatorInfo table tr").length +"</td><td>" + data.name +"</td><td>"+ data.role.name +"</td><td>有效</td><td class='opuser'>"+ op +"</td></tr>");
					iPanel.i$("#rightIframe").attr("height", Number(iPanel.i$("#rightIframe").attr("height")) + 40);
					aPanel.hudMsg('success', '用户新增成功', 3000);
					return true;
				},
				error : function() {
					aPanel.hudMsg('error', '用户新增失败', 3000);
					return false;
				}
			});
		},
		
		addNewUser : function(){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.addUserData, this.i$("#operatorSet"));
			this.i$("#adduser").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "新增帐号",
				modal : true,
				show : {effect : 'drop', direction : "up"},
				hide : {effect : 'drop', direction : "down"},
				position : "center",
				resizable : false,
				buttons : {
					"保存" : function() {
						var pars = {
							"id" : "",
							"name" : iPanel.i$("#name").val(),
							"password" : iPanel.i$("#npassword").val(),
							"roleId" : iPanel.i$("input:radio[name=roleId]:checked").val()
						};
						if(iPanel.i$("#adduser").validationEngine("validate") && iPanel.i$("#info_msg").html() == "支持3~8位字符输入"){
							iPanel.saveUserData(iPanel.userApi.saveUserData, pars);
							iPanel.i$(this).dialog("close");
						}
						
					}
				}
			}, "open");
		},
		
		editUser : function(getUrl, id, username){
			this.i$("#operatorSet").dialog("destroy");
			this.loadData(this.userApi.editUserData+"?id="+id, this.i$("#operatorSet"));
			this.i$("#name").val(username).attr("disabled", "disabled");
			this.i$("#adduser").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
			var win = this.i$("#operatorSet").dialog({
				title : "修改帐号",
				modal : true,
				show : {effect : 'drop', direction : "up"},
				hide : {effect : 'drop', direction : "down"},
				position : "center",
				resizable : false,
				buttons : {
					"保存" : function() {
						var pars = {
								"id" : id,
								"name" : username,
								"password" : iPanel.i$("#npassword").val(),
								"roleId" : iPanel.i$("input:radio[name=roleId]:checked").val()
						};
						if(iPanel.i$("#adduser").validationEngine("validate")){
							iPanel.updateUserData(iPanel.userApi.saveUserData, pars);
							iPanel.i$(this).dialog("close");
						}
				
					}
				}
			}, "open");
		},
		
		deleteUser : function(getUrl, pars){
			if (confirm('确定删除该用户吗?')) {
				this.deleteUserData(getUrl, pars);
				return true;
			}
			return false;
		},
		
		searchUser : function(name){
			pars = {"name" : name };
			if($("#searchuser").validationEngine("validate")){
				this.searchData(this.userApi.searchUserData, pars, $("#operatorInfo"));
			}
		}
		
};

$(function() {
	iPanel.loadData(iPanel.userApi.loadUserData, $("#operatorInfo"));
	
	$("td.opuser a.deleteuser").live("click",function(){
		var realId = {"id":this.id.substr(10)};
		if(iPanel.deleteUser(iPanel.userApi.delUserData, realId)){
			$(this).parents("tr").fadeOut("slow", function() {
				aPanel.hudMsg("success", "用户删除成功", 3000);
			});
		}
	});
	
	$("td.opuser a.edituser").live("click",function(){
		var realId = this.id.substr(8);
		var username = $.trim($(this).parents("tr").find("td").eq(1).html());
		iPanel.editUser(iPanel.userApi.editUserData, realId, username);
	});
	
	$("#searchuser").validationEngine({autoHidePrompt:true, autoHideDelay:2000, binded:true});
	$("#searchbtn").click(function(){
		iPanel.searchUser($("#operatorName").val());
	});
	
	$("td.opuser a.validateuser").live("click",function(){
		var realId = this.id.substr(12);
		if($(this).hasClass("flag1")){
			if (confirm('确定解冻该用户吗?')) {
				var pars = {"id":realId, "isValid":"1"};
				iPanel.validateUserData(iPanel.userApi.setUserData, pars);
				$(this).parents("td").prev().html("有效");
				$(this).html("【无效】").removeClass("flag1").addClass("flag0");
				return;
			}
		}
		if($(this).hasClass("flag0")){
			if (confirm('确定冻结该用户吗?')) {
				var pars = {"id":realId, "isValid":"0"};
				iPanel.validateUserData(iPanel.userApi.setUserData, pars);
				$(this).parents("td").prev().html("无效");
				$(this).html("【有效】").removeClass("flag0").addClass("flag1");
				return;
			}
		}
	});
});
