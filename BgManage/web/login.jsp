<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="static/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <script src="static/js/jquery-3.4.1.js"></script>
    <script src="static/js/login.js"></script>
</head>
<body class="templatemo-bg-gray">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">管理员登录</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <label for="username" class="control-label fa-label"><i class="glyphicon glyphicon-user"></i></label>
                        <input type="text" class="form-control" id="username" placeholder="用户名">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><i class="glyphicon glyphicon-lock"></i></label>
                        <input type="password" class="form-control" id="password" placeholder="密码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="checkCode" class="control-label fa-label"><i class="glyphicon glyphicon-pencil"></i></label>
                        <input type="text" class="form-control" style="width:298px; float: left " id="checkCode" placeholder="验证码">
                        <img src="/checkCode" class="img-rounded" style="width: 110px; height: 33px; float: right" onclick="this.src=this.src+'?'">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <input type="button" value="登录" class="btn btn-info passLogin">
                        <a href="forgot-password.jsp" class="text-right pull-right">忘记密码？</a>
                    </div>
                </div>
            </div>
            <hr>
        </form>
    </div>
</div>
</body>
</html>
