//FaceSet ========================= Start

function checkEmpty( o , name) {
   var str="<font color='red'>不可以为空!</font> ";
	var actionName = document.getElementsByName(name).value;   
	
	if(actionName!=""){
    	o.innerHTML=str ;
    	return false ;
	}
  return true ;
}

function CloseWin()
{
var ua=navigator.userAgent
var ie=navigator.appName=="Microsoft Internet Explorer"?true:false
if(ie){
    var IEversion=parseFloat(ua.substring(ua.indexOf("MSIE ")+5,ua.indexOf(";",ua.indexOf("MSIE "))))
if(IEversion< 5.5){
    var str = '<object id=noTipClose classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
    str += '<param name="Command" value="Close"></object>';
    document.body.insertAdjacentHTML("beforeEnd", str);
    document.all.noTipClose.Click();
    }
    else{
    window.opener =null;
    window.close();
    }
}
else{
window.close()
}
}

function faceSetPARGetPage() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      $('info').innerHTML = req.responseText;
      $('resultMegs').innerHTML = "";
    } else {
      changeStyle("resultMegs","errormsg");
      $('resultMegs').innerHTML = "Load error!";
    }
  }
}


function faceSetPAR() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      var resXML = req.responseXML;
      var codeid = getResponseXMLMsgsCodeid(resXML);
      if (codeid == "0") {
        changeStyle("resultMegs","msg3");
        hiddenElement("info");
      }
      else {
        changeStyle("resultMegs","errormsg");
      }
      $('resultMegs').innerHTML = getResponseXMLMsgsMessage(resXML)
      + "<a href=\"javascript:faceSetLoadPage();\">" + adminConfirmLink + "</a>";
    } else {
      alert("There was a problem retrieving the XML data:\n" +req.statusText);
    }
  }
}
//FaceSet ========================= End

//ForbidSet ========================= Start
function forbidSetLoadPage() {
  changeStyle("resultMegs","msg2");
  $('resultMegs').innerHTML = adminPageLoading;
  displayElement("info");
  var url = "adminForbidSet.bbscs?action=info&ajax=shtml";
  var callback = forbidSetPARGetPage;
  executeXhrOfGet(callback, url);
}

function forbidSetPARGetPage() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      $('info').innerHTML = req.responseText;
      $('resultMegs').innerHTML = "";
    } else {
      changeStyle("resultMegs","errormsg");
      $('resultMegs').innerHTML = "Load error!";
    }
  }
}

function adminForbidSetAction() {
  changeStyle("resultMegs","msg2");
  $('resultMegs').innerHTML = adminDataSubmit;
  var url = "adminForbidSet.bbscs";
  var useForbidValue = getRadioValue("adminForbidSetForm","useForbid");
  var data = "action=save&ajax=xml&useForbid="+useForbidValue+"&forbidIP="+$('forbidIP').value
  +"&forbidEmail="+$('forbidEmail').value;
  //alert(data);
  var callback = firbidSetPAR;
  executeXhrOfPost(callback, url, data);
}

function firbidSetPAR() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      var resXML = req.responseXML;
      var codeid = getResponseXMLMsgsCodeid(resXML);
      if (codeid == "0") {
        changeStyle("resultMegs","msg3");
        hiddenElement("info");
      }
      else {
        changeStyle("resultMegs","errormsg");
      }
      $('resultMegs').innerHTML = getResponseXMLMsgsMessage(resXML)
      + "<a href=\"javascript:forbidSetLoadPage();\">" + adminConfirmLink + "</a>";
    } else {
    }
  }
}
//ForbidSet ========================= End

function godelete(url) {
   var aa= window.confirm("是否删除!");
       if (aa) {
          window.location.href=url;
         }else return;
     }


function godeleteAppCategory(id) {

	   var aa= window.confirm("是否删除!");
	       if (aa) {
	    	   $.getJSON("/admin/isDeleteCategory.do?id=" + id,function(data){
	    		   if(data.code == 0){
	    			   alert(data.code);
	    			   return;
	    			   window.location.href="appManage_deleteAppType.do?id=" + id;
	    		   }else{
	    			   alert("不能删除有应用的应用类型和应用分类!");
	    		   }
	    	   },"json");
	         }else return;
	     }

function godeleteAppType(id) {

	   var aa= window.confirm("是否删除!");
	       if (aa) {
	    	   $.getJSON("/admin/isDeleteType.do?id=" + id,function(data){
	    		   if(data.code == 0){
	    			   window.location.href="appManage_deleteAppType.do?id=" + id;
	    		   }else{
	    			   alert("不能删除有应用的应用类型和应用分类!");
	    		   }
	    	   },"json");
	         }else return;
	     }

