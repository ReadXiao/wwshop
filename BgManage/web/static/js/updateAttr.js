$(function () {
    $("#updateAttr").click(function () {
        var msg = "您确定要修改该商品的信息吗？";
        if (confirm(msg) == true) {
            var skuPrice = $("#skuPrice").val();
            var discountPrice = $("#discountPrice").val();
            var amount = $("#amount").val();
            var id = $("#skuId").val();
            var spuId = $("#spuId").val();

            $.post({
                url: "/updateAttr",
                data: {
                    "skuPrice": skuPrice,
                    "discountPrice": discountPrice,
                    "amount": amount,
                    "id": id,
                    "spuId": spuId
                },
                success: function (data) {
                    if (data != "false") {
                        location.href = "/attrAdmin?id=" + data;
                    }else{
                        alert("修改失败！");
                    }
                }
            })
        }
    })
});