<%@ include file="../admin/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="com.s3graphics.util.PagerCmd"
    errorPage=""%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" type="text/javascript">
    function __doPostBack(eventTarget, eventArgument) {
        var theform;
        if (window.navigator.appName.toLowerCase().indexOf("microsoft") > -1) {
            theform = document.getElementById('Form1');
        }
        else {
            theform = document.getElementById('Form1');
        }
        if(eventTarget.indexOf("?") <= -1){
            eventTarget = eventTarget.replace("&","?");
        }
        if(eventTarget.indexOf("?&")){
            eventTarget = eventTarget.replace("?&","?");
        }
        theform.action  = eventTarget;
        theform.submit();
    }
    function pageSubmit(obj) {
        var index = obj.selectedIndex;
        var pageSize = document.getElementsByName('pageSize');
        for(i = 0; i < pageSize.length; i++) {
           pageSize[i].selectedIndex = index;
        }
        document.getElementById('Form1').submit();
    }

</script>

    
<div class="table_pagination right"  style="padding-top: 10px; padding-bottom: 5px; width:600px">
    <form name="Form1" method="post" action='<s:property value='pagerCmd.pageUrl'/>' id="Form1">
       <a href="javascript:void(0)" onclick="__doPostBack('<s:property value='pagerCmd.pageUrl' />&currentPage=1','')" >首页</a>
       <s:if test="pagerCmd.currentPage == 1">
           <a href="javascript:void(0)" >上一页</a>
       </s:if>
       <s:else>
           <a href="javascript:void(0)" onclick="__doPostBack('<s:property value='pagerCmd.pageUrl' />&currentPage=<s:property value="pagerCmd.currentPage-1" />','')" >上一页</a>
       </s:else><%--
       <%
       PagerCmd pagerCmd = (PagerCmd)request.getAttribute("pagerCmd");
       if(pagerCmd.)
       for(int i=0 ; i < 10 ; i ++){
       %>
        <a href="<s:url value='%{#pagerCmd.pageUrl}'> <s:param name='currentPage' value='%{(current-1)}'/></s:url>" class="<s:if test='%{pagerCmd.currentPage==(current-1)}'>active</s:if>">
             <s:property value=""/>
        </a>
       <%
       }
       %>
        --%>
        <s:bean name="org.apache.struts2.util.Counter" id="counter">
           <s:param name="first" value="pagerCmd.beginPage" />
           <s:param name="last" value="(pagerCmd.endPage )" />
           <s:iterator>
            <!--  <a href="<s:url value='%{#pagerCmd.pageUrl}'> <s:param name='currentPage' value='%{(current-1)}'/></s:url>" 
             class="<s:if test='%{pagerCmd.currentPage==(current-1)}'>active</s:if>"><s:property/></a> -->
             <a href="javascript:void(0)" onclick="__doPostBack('<s:property value='pagerCmd.pageUrl' />&currentPage=<s:property/>','')" class="<s:if test='%{pagerCmd.currentPage==(current-1)}'>active</s:if>"><s:property/></a>
           </s:iterator>
        </s:bean>
        
       <s:if test="pagerCmd.currentPage == pagerCmd.pageCount">
           <a href="javascript:void(0)" >下一页</a>
       </s:if>
       <s:else>
           <a href="javascript:void(0)" onclick="__doPostBack('<s:property value='pagerCmd.pageUrl' />&currentPage=<s:property value="pagerCmd.currentPage+1" />','')" >下一页</a>
       </s:else>
       <a href="javascript:void(0)" onclick="__doPostBack('<s:property value='pagerCmd.pageUrl' />&currentPage=<s:property value="pagerCmd.pageCount" />','')" >尾页</a>
    </form>
</div>


