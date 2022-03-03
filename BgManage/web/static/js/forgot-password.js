$(function () {
    $("#sendCode").click(function () {
        var telPhone = $("#telPhone").val();
        if (!(/^1[3456789]\d{9}$/.test(telPhone))) {
            alert("电话号码输入错误,请重新输入");
        } else {
            $.post({
                url: "/sendCode",
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
                        alert("电话号码不存在！");
                        $("#telPhone").val("");
                    }
                }
            })
        }
    });

    $(".login").click(function () {
        var telPhone = $("#telPhone").val();
        var messageCode = $("#code").val();
        if (messageCode.length==0){
            alert("验证码为空！")
        }else{
            $.post({
                url: "/loginByMessage",
                data: {"telPhone":telPhone,"messageCode":messageCode},
                success:function (data) {
                    if (data=="false"){
                        $("#checkCode").val("");
                        alert("验证码错误！")
                    }else{
                        location.href="/login";
                    }
                }
            })
        }
    })

});
var end = 60;
function update(number){
    if(number==end){
        $("#sendCode").attr("disabled",false);//设置名字为按钮的文本可用
        $("#sendCode").val("获取验证码");
    }else{
        var endsceond=end-number;
        $("#sendCode").val(endsceond+"s");
    }
}//实现发送验证码倒计时