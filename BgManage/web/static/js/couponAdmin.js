$(function () {
    $("#validCoupon").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        $("#state").html("2");
        $("#goodsName").val("");
        var url = "/getValidCoupon";
        stateCheck(url);
    });

    $("#unValidCoupon").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        $("#state").html("0");
        $("#goodsName").val("");
        var url = "/getUnValidCoupon";
        stateCheck(url);
    });

});

function stateCheck(url) {
    $.post({
        url: url,
        success: function (data) {
            showCoupon(data)
        }
    })
}

function cancelCoupon(id) {
    var state = $(".active").children('input').val();
    $.post({
        url: "/cancelCoupon",
        data:{
            "id":id,
            "state":state
        },
        success:function (data) {
            if(data=="false"){
                alert("撤销失败");
            }else {
                alert("撤销成功！");
                showCoupon(data);
            }
        }
    })
}

function showCoupon(data) {
    var str = "";
    data = eval('(' + data + ')');
    var len;
    for (len = 0; len < data.length; len++) {
        str+="<li>\n" +
            "                    <div class=\"cone\">\n" +
            "                        <div class=\"d2\">"+data[len].value+"券</div>\n" +
            "                        <div class=\"d1\">\n" +
            "                            <div>\n" +
            "                                <span>"+data[len].discountPrice+"</span>\n" +
            "                                <span>元</span>\n" +
            "                            </div>\n" +
            "                            <div>\n" +
            "                                <p>满"+data[len].minPrice+"元可用</p>\n" +
            "                                <p>仅限购买"+data[len].value+"类商品使用：剩余"+data[len].count+"张</p>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                        <div class=\"d3\">\n" +
            "                            <p>【ww商城】有效期至"+data[len].deadline+"</p>\n" +
            "                            <button onclick=\"cancelCoupon("+data[len].id+")\">撤销此卷</button>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </li>"
    }
    $("#allCoupons").html(str);
}