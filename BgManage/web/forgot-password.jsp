<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="static/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <script src="static/js/jquery-3.4.1.js"></script>
    <script src="static/js/forgot-password.js"></script>
</head>
<body class="templatemo-bg-gray">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">忘记密码</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="/login" method="post">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <label for="telPhone" class="control-label fa-label"><i class="glyphicon glyphicon-phone"></i></label>
                        <input type="text" class="form-control" id="telPhone" placeholder="电话号码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="code" class="control-label fa-label"><i class="glyphicon glyphicon-pencil"></i></label>
                        <input type="text" class="form-control" style="width:298px; float: left " id="code" placeholder="验证码">
                        <input class="btn btn-default" id="sendCode" type="button" style="width: 110px; height: 33px; float: right" value="获取验证码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <input type="button" disabled="disabled" value="登录" class="btn btn-info login">
                        <a href="login.jsp" class="text-right pull-right">密码登录</a>
                    </div>
                </div>
            </div>
            <hr>
        </form>
    </div>
</div>
</body>
</html>
