$(function () {
    $("#sendCode").click(function () {
        var telPhone = $("#telPhone").val();
        if (!(/^1[3456789]\d{9}$/.test(telPhone))) {
            alert("电话号码输入错误,请重新输入");
        } else {
            $.post({
                url: "/sendRegisterCode",
                data: {"telPhone": telPhone},
                success: function (data) {
                    if (data == "true") {
                        $("#telPhone").attr("disabled", true);
                        $("#sendCode").attr("disabled", true);
                        $(".login").attr("disabled", false);
                        for (var i = 1; i <= end; i++) {
                            window.setTimeout("update(" + i + ")", i * 1000); //当i=60时执行update方法
                        }
                    } else if (data == "false") {
                        alert("发送失败！");
                    } else {
                        alert("该电话号码已使用！");
                        $("#telPhone").val("");
                    }
                }
            })
        }
    });

    $("#register").click(function () {
        var username = $("#username").val();
        var name = $("#name").val();
        var telPhone = $("#telPhone").val();
        var messageCode = $("#code").val();
        var sex = $("input[name='sex']:checked").val();
        var birthday = $("#birthday").val();
        var password = $("#password").val();
        var rePassword = $("#password_confirm").val();

        console.log(username + "：" + name + "：" + telPhone + "：" + messageCode + "：" + sex + "：" + birthday + "：" + password + "：" + rePassword);
        if (username == "" || name == "" || telPhone == "" || messageCode == "" || birthday == "" || password == "" || rePassword == "") {
            alert("输入不能存在空值");
        }else {
            if (password==rePassword){
                $.post({
                    url:"/insertUserInfo",
                    data:{
                        "username":username,
                        "name":name,
                        "telPhone":telPhone,
                        "messageCode":messageCode,
                        "sex":sex,
                        "birthday":birthday,
                        "password":password
                    },
                    success:function (data) {
                        if (data == "true"){
                            alert("注册成功");
                            location.href="userLogin.jsp";
                        }else if(data == "false"){
                            alert("注册失败");
                        }else if (data == "codeError"){
                            alert("验证码错误");
                            $("#code").val("");
                        }else{
                            alert("请先获取验证码");
                            $("#telPhone").val("");
                            $("#code").val("");
                        }
                    }
                });
            }else{
                alert("两次密码不一致！");
                $("#password").val("");
                $("#password_confirm").val("");
            }
        }
    });

});
var end = 60;

function update(number) {
    if (number == end) {
        $("#sendCode").attr("disabled", false);//设置名字为按钮的文本可用
        $("#sendCode").val("获取验证码");
    } else {
        var endsceond = end - number;
        $("#sendCode").val(endsceond + "s");
    }
}//实现发送验证码倒计时

function checkUserName() {
    var username = $("#username").val();
    if (username == "") {
        alert("用户名不能为空");
    } else {
        $.post({
            url: "/checkUserName",
            data: {
                "username": username
            },
            success: function (data) {
                if (data == "true") {
                    alert("该用户名已存在！");
                    $("#username").val("");
                }
            }
        })
    }
}