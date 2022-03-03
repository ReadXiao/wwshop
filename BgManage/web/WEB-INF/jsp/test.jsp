<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#t1").click(function () {
                alert("123");
                $.ajax({
                    url: "${pageContext.request.contextPath}/t1",
                    success: function (data) {
                        var t1 = $("#tab");
                        var str = "";
                        console.log(data);

                        data= eval('(' + data + ')');
                        var len;
                        console.log(data.toString());
                        console.log(data.length);
                        for (len = 0; len < data.length; len++) {
                            str += "<tr class='table-hover'><td>" + data[len].id + "</td><td>" + data[len].value + "</td><td>" + data[len].attrName +"</td></tr>";
                        }
                        t1.append(str);
                    }

                })
            });
        });

    </script>
</head>
<body>
<p id="t1">你好</p>
<div class="col-md-12 column">
    <table class="table table-hover table-striped">
        <thead id="tab">
        <tr>
            <th>编号</th>
            <th>类别</th>
            <th>属性</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
