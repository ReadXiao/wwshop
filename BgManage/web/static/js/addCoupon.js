$(function () {
    $("#button").click(function () {
        var minPrice = $("#minPrice").val();
        var discountPrice = $("#discountPrice").val();
        var deadline = $("#deadline").val();
        var count = $("#count").val();
        var catalogId = $("#catalog").val();

        var msg = "您确定要发布该优惠卷吗";
        if (confirm(msg) == true) {
            $.post({
                url:"/insertCoupon",
                data:{
                    "minPrice":minPrice,
                    "discountPrice":discountPrice,
                    "deadline":deadline,
                    "count":count,
                    "catalogId":catalogId
                },
                success:function (data) {
                    if(data=="true"){
                        alert("发布成功！");
                        location.href = "/toCouponAdmin";
                    }
                }
            })
        }
    })
});