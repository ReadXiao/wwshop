<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/userJs/userRegist.js"></script>
</head>
<body class="templatemo-bg-gray">
<h1 class="margin-bottom-15">注册</h1>
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="#"
              method="post">
            <div class="form-inner">
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="username" class="control-label">用户名</label>
                        <input type="text" class="form-control" id="username" onblur="checkUserName()" placeholder="请输入您的用户名">
                    </div>
                    <div class="col-md-6">
                        <label for="name" class="control-label">真实姓名</label>
                        <input type="text" class="form-control" id="name" placeholder="请输入您的真实姓名">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="telPhone" class="control-label">电话</label>
                        <input type="text" class="form-control" id="telPhone" placeholder="请输入您的电话号码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-5">
                        <label for="code" class="control-label">验证码</label>
                        <input type="text" class="form-control" id="code"
                               placeholder="验证码" style="float: left">
                    </div>
                    <div class="col-md-3">
                        <label class="control-label">&nbsp;</label>
                        <input class="btn btn-default form-control" id="sendCode" type="button" value="获取验证码">
                    </div>
                    <div class="col-md-4 templatemo-radio-group">
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="sex1" value="男" checked> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="sex2" value="女"> 女
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label for="birthday" class="control-label">出生日期</label>
                        <input type="date" class="form-control" id="birthday">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="password" class="control-label">密码</label>
                        <input type="password" class="form-control" id="password" placeholder="请输入您的密码">
                    </div>
                    <div class="col-md-6">
                        <label for="password_confirm" class="control-label">确认密码</label>
                        <input type="password" class="form-control" id="password_confirm" placeholder="请您确认密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label><input type="checkbox">我同意 <a href="javascript:;" data-toggle="modal"
                                                             data-target="#templatemo_modal">服务条款</a> and <a href="#">隐私政策</a></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <input type="button" value="注册" class="btn btn-info" id="register">
                        <a href="userLogin.jsp" class="pull-right">登录</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
