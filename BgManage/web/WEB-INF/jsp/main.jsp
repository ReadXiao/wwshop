<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/25
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $.post({
                url:"/loading",
                success:function (data) {
                    var str = "";
                    data= eval('(' + data + ')');
                    str+="<tr><td>上次登录时间</td><td style='color: red; font-weight: bold'>"+data.visitedTime+"</td></tr><tr><td>上次退出登录时间</td><td style='color: red; font-weight: bold'>"+data.endTime+"</td></tr>";
                    $("#tabBody").html(str);
                }
            })
        })
    </script>
</head>
<body style="padding: 0px">
<div class="col-md-8" style="margin-top: 50px">
    <table class="table table-hover table-condensed" >
        <tbody id="tabBody">

        </tbody>
    </table>
</div>
</body>
</html>
