$(function () {
    var userId = $(".userId").html();
    var orderId = $(".orderId").html();
    var addressId = 0;
    var minPrice = 0;
    var userCouponId = 0;
    var discountPrice = 0;
    var totalPrice = $("#totalPrice").html();
    var addressValueSite;
    var upAddressId = 0;
    var consigneeSite;
    var telPhoneSite;
    var clickTimeId;
    var checkSelect = 0;
    $(".shade_content").hide();
    $(".shade").hide();
    $('.Caddress .add_mi').click(function () {
        var addMin = $(this);
        var addId = $(this).children(".addressId").html();
        clearTimeout(clickTimeId);
        //执行延时
        clickTimeId = setTimeout(function () {
            //此处为单击事件要执行的代码
            $(".add_mi").removeClass("selectedAddress")
            addMin.css('background', 'url("../../images/mail_1.jpg") no-repeat').siblings('.add_mi').css('background', 'url("images/mail.jpg") no-repeat')
            checkSelect = 1;
            addressId = addId;
        }, 250);
    });


    //这些ajax的后台代码写在了购物车的后台中
    $('.Caddress .add_mi').dblclick(function () {
        clearTimeout(clickTimeId);
        $(".shade_content").show();
        $(".shade").show();
        $("#insertAddress").hide();
        $("#updateAddress").show();
        upAddressId = $(this).children(".addressId").html();
        addressValueSite = $(this).children(".adds").children(".addressValue");
        consigneeSite = $(this).children(".consignee");
        telPhoneSite = $(this).children(".adds").children(".telPhone");

        $("#address").val(addressValueSite.html());
        $("#name_").val(consigneeSite.html());
        $("#phone").val(telPhoneSite.html());
    });

    $("#insertAddress").click(function () {
        var len = $(".add_mi").length;
        if (len >= 5) {
            alert("你添加的地址数量已达上限");
        } else {
            var input_out = $(".input_style");
            var count = 0;
            for (var i = 0; i <= input_out.length; i++) {
                if ($(input_out[i]).val() == "") {
                    $(input_out[i]).css("border", "1px solid red");
                    count++;
                }
            }
            if (count > 0) {
                alert("添加地址信息不能存在空值");
            } else {
                var addressValue = $("#address").val();
                var consignee = $("#name_").val();
                var telPhone = $("#phone").val();
                var addressId = Math.round( Math.random() * 10000 + Math.random() * 10000 + Math.random() * 10000);
                console.log(addressId);
                $.post({
                    url: "/insertAddress",
                    data: {
                        "addressId": addressId,
                        "userId": userId,
                        "addressValue": addressValue,
                        "consignee": consignee,
                        "telPhone": telPhone
                    },
                    success: function (data) {
                        if (data == "true") {
                            alert("添加成功");
                            var str = "<div class=\"add_mi\">\n" +
                                "            <span hidden class=\"addressId\">" + addressId + "</span>\n" +
                                "            <p style=\"border-bottom:1px dashed #ccc;line-height:28px;\" class=\"consignee\">" + consignee + "</p>\n" +
                                "            <p><span>" + addressValue + "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>" + telPhone + "</span></p>\n" +
                                "        </div>";
                            $(".Caddress").append(str);
                            $(".shade_content").hide();
                            $(".shade").hide();
                        } else {
                            alert("添加异常");
                        }
                    }
                })
            }
        }
    });

    $("#updateAddress").click(function () {
        var input_out = $(".input_style");
        var count = 0;
        for (var i = 0; i <= input_out.length; i++) {
            if ($(input_out[i]).val() == "") {
                $(input_out[i]).css("border", "1px solid red");
                count++;
            }
        }
        if (count > 0) {
            alert("修改地址时不能存在空值");
        } else {
            var addressValue = $("#address").val();
            var consignee = $("#name_").val();
            var telPhone = $("#phone").val();
            $.post({
                url: "/updateAddress",
                data: {
                    "addressId":upAddressId,
                    "addressValue": addressValue,
                    "consignee": consignee,
                    "telPhone": telPhone
                },
                success: function (data) {
                    if (data == "true") {
                        alert("修改成功");
                        addressValueSite.html(addressValue);
                        consigneeSite.html(consignee);
                        telPhoneSite.html(telPhone);
                        $(".shade_content").hide();
                        $(".shade").hide();
                    }
                }
            })
        }
    });

    $(".userCoupon").click(function () {
        var couponMinPrice = $(this).children(".minPrice").html();
        var couponDiscountPrice = $(this).children(".discountPrice").html();
        if (totalPrice > couponMinPrice) {
            $(".userCoupon").addClass("old1");
            $(".userCoupon").removeClass("now1");
            $(this).removeClass("old1");
            $(this).addClass("now1");
            minPrice = couponMinPrice;
            discountPrice = couponDiscountPrice;
            userCouponId = $(this).children(".userCouponId").html();
        } else {
            alert("您不满足该优惠卷的条件，无法使用");
            $(".userCoupon").addClass("old1");
            $(".userCoupon").removeClass("now1");
            minPrice = 0;
            discountPrice = 0;
            userCouponId = 0;
        }
    });

    $(".btn_closing").click(function () {
        /*userId;
        orderId;
        addressId;
        minPrice;
        userCouponId;
        discountPrice;
        totalPrice;*/
        if (checkSelect==0){
            alert("请先选择地址");
        }else{
            var payMoney = totalPrice-discountPrice;
            var msg = "请确定付款"+payMoney+"吗？";
            if (confirm(msg) == true){
                $.post({
                    url:"/payOrder",
                    data:{
                        "orderId":orderId,
                        "userCouponId":userCouponId
                    },
                    success:function (data) {
                        if (data=="true"){
                            alert("付款成功");
                            location.href="/myOrder"
                        }else{
                            alert("付款失败，请重新付款！");
                        }
                    }
                })
            }
        }

    })

});

function onclick_close() {
    var shade_content = $(".shade_content");
    var shade = $(".shade");
    if (confirm("确认关闭么！此操作不可恢复")) {
        shade_content.hide();
        shade.hide();
    }
}

function onclick_open() {
    $(".shade_content").show();
    $(".shade").show();
    $("#insertAddress").show();
    $("#updateAddress").hide();
    var input_out = $(".input_style");
    for (var i = 0; i <= input_out.length; i++) {
        if ($(input_out[i]).val() != "") {
            $(input_out[i]).val("");
        }
    }
}


