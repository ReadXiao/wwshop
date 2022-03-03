<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <link href="../../static/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script language="javascript">

        $(function () {
            $(".unLogin").click(function () {
                var r=confirm("您确定要退出系统");
                if (r==true)
                {
                    top.location.href = "/unLogin";
                }else{
                    alert("感谢你还回来");
                }
            })
        })

        var t = null;

        t = setTimeout(time,1000);//开始执行

        function time()

        {

            clearTimeout(t);//清除定时器

            dt = new Date();

            var y=dt.getYear()+1900;

            var mm=dt.getMonth()+1;

            var d=dt.getDate();

            var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];

            var day=dt.getDay();

            var h=dt.getHours();

            var m=dt.getMinutes();

            var s=dt.getSeconds();

            if(h<10){h="0"+h;}

            if(m<10){m="0"+m;}

            if(s<10){s="0"+s;}

            document.getElementById("timeShow").innerHTML =  y+"年"+mm+"月"+d+"日"+weekday[day]+"&nbsp;"+h+":"+m+":"+s+"";

            t = setTimeout(time,1000); //设定定时器，循环执行

        }


    </script>
</head>
<body>
<div>
    <div class="templatemo-header">
        <div class="container">
            <div class="col-md-12">
                <h1 class="logo pull-left"><span id="timeShow"></span></h1>
                <form class="form-inline pull-right" role="form">
                    <button type="submit" class="btn btn-default unLogin">退出登录</button>
                </form>
            </div> <!-- col-md-12 -->
        </div> <!-- container -->
    </div>
</div>
</body>
</html>
