<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="../admin/include.jsp"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
<link rel="stylesheet" type="text/css" media="screen" href="../admin/css/error.css">
</head>

<body>
<div id="wrapper">
<a class="logo" href="#"></a>
  <div id="main">
    <div id="header">
      <h1><img class="icon" src="../admin/images/error_icon.png" alt="Warning, error">error !</h1>
    </div>
    <div id="content">
      <h2>你的操作发生错误，异常信息：</h2>
      <p><s:property value="mess" /></p>
      <div class="utilities">
        <!-- <input class="left" id="search" placeholder="search..." type="text"> -->
        <div class="button-container right"><a class="button" href="/admin/admin/adminLogin.jsp">Go Back...</a></div>
        <div style="clear: both"></div>
      </div>
    </div>
  </div>
</div>

</body></html>