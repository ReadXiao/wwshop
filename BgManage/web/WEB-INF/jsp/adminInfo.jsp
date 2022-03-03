<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/goodsAdmin.js" type="text/javascript"></script>
    <style type="text/css">
        td {
            vertical-align: middle !important;
            font-family: Verdana, Geneva, sans-serif;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>管理员信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th class="col-md-6 column">姓名</th>
                    <th class="col-md-6 column">电话</th>
                </tr>
                </thead>
                <%--商品从数据库中查询出来--%>
                <tbody>
                <tr>
                    <td>${adminInfo.name}</td>
                    <td>${adminInfo.telPhone}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
