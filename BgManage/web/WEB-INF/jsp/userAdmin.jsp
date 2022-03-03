<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/user.js" type="text/javascript"></script>
    <style type="text/css">
        td{
            vertical-align: middle !important;
            font-family:  Verdana, Geneva, sans-serif;
            font-size: 14px;
        }
    </style>
</head>
<body>
<span id="allUser" hidden>${allUser}</span>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>用户列表——————————————显示所有用户</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div  class="col-md-4 column">
                <span id="state" hidden>2</span>
                <ul class="nav nav-tabs">
                    <li role="presentation" id="first" class="li active"><a id="findAllUser" href="#">全部用户</a></li>
                    <li role="presentation" id="second" class="li"><a id="normalUser" href="#">正常用户</a></li>
                    <li role="presentation" id="third" class="li"><a id="cancelUser" href="#">已注销用户</a></li>
                </ul>
            </div>
            <div class="col-md-8 column">
                <form style="float: right">
                    <div class="col-md-8">
                        <input type="text" id="username" class="form-control" name="username" placeholder="请输入要查询的商品名称">
                    </div>
                    <div class="col-md-1">
                        <input id="chaXun" type="button" class="btn btn-default" value="查询">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" >
                <thead>
                <tr>
                    <th class="col-md-1 column">用户编号</th>
                    <th class="col-md-1 column">用户头像</th>
                    <th class="col-md-1 column">用户名</th>
                    <th class="col-md-1 column">性别</th>
                    <th class="col-md-1 column">出生日期</th>
                    <th class="col-md-1 column">电话</th>
                    <th class="col-md-1 column">会员</th>
                    <th class="col-md-1 column">创建时间</th>
                    <th class="col-md-2 column">用户状态</th>
                    <th class="col-md-2 column">操作</th>
                </tr>
                </thead>
                <%--商品从数据库中查询出来--%>
                <tbody id="allUsers">

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
