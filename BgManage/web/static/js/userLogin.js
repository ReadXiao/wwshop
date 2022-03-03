$(function () {
    $("#userLogin").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var checkCode = $("#checkCode").val();
        if (username.length==0 || password.length==0 || checkCode.length==0){
            alert("您的用户名密码或者验证码为空！");
        }else{
            $.post({
                url:"/userLoginByPass",
                data:{"username":username,"password":password,"checkCode":checkCode},
                success:function (data) {
                    if (data == "success"){
                        location.href="/userLogin";
                    }else if(data == "codeFail"){
                        $("#checkCode").val("");
                        alert("验证码错误");
                    }else {
                        $("#username").val("");
                        $("#password").val("");
                        $("#checkCode").val("");
                        alert("用户名密码错误")
                    }
                }
            })
        }
    })
});