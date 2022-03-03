$(function () {
    showGoodsSelectInfo();

    $(".jian").click(function () {
        var goodsNum = $(this).parents().children(".goodsNum").val();
        var goodsNumSite = $(this).parents().children(".goodsNum");
        if (goodsNum > 1) {
            goodsNum--;
            var spuId = $(this).parents().children(".spuId").val();
            var skuId = $(this).parents().children(".skuId").val();
            $.post({
                url: "/reduceNum",
                data: {
                    "spuId": spuId,
                    "skuId": skuId,
                    "goodsNum": goodsNum
                },
                success: function (data) {
                    if (data == "true") {
                        goodsNumSite.val(goodsNum);
                        total();
                    } else {
                        alert("操作异常！");
                    }
                }
            });
        } else {
            alert("数量已达到最低");
        }
    });

    $(".jia").click(function () {
        var goodsNum = $(this).parents().children(".goodsNum").val();
        goodsNum++;
        var spuId = $(this).parents().children(".spuId").val();
        var skuId = $(this).parents().children(".skuId").val();
        var goodsNumSite = $(this).parents().children(".goodsNum");
        $.post({
            url: "/addNum",
            data: {
                "spuId": spuId,
                "skuId": skuId,
                "goodsNum": goodsNum
            },
            success: function (data) {
                if (data == "true") {
                    goodsNumSite.val(goodsNum);
                    total();
                } else if (data == "all") {
                    alert("库存不足");
                } else {
                    alert("操作异常");
                }
            }
        });
    });

    $(".delete").click(function () {
        var msg = "您确定要移除该商品吗";
        var addCarId = $(this).parents().children(".addCarId").val();
        console.log($(this).parents().children(".addCarId"));
        if (confirm(msg) == true) {
            console.log(addCarId);
            $.post({
                url: "/deleteCar",
                data: {
                    "addCarId": addCarId
                },
                success: function (data) {
                    if (data == "true") {
                        location.href = "/toAddCarPage";
                    } else {
                        alert("删除异常");
                    }
                }
            })
        }
    });

    $("#allSelect").click(function () {
        if (this.checked) {
            var userVIP = $(".userVIP").val();
            var totalPrice = 0;
            if (userVIP == 0) {
                $("input[name='goods']").each(function () {
                    this.checked = true;
                    var price = $(this).parents().parents().children(".skuPrice").html();
                    var num = $(this).parents().parents().children(".num").children(".goodsNum").val();
                    totalPrice = totalPrice + price * num;
                });
            } else {
                $("input[name='goods']").each(function () {
                    this.checked = true;
                    var price = $(this).parents().parents().children(".skuPrice").html();
                    var num = $(this).parents().parents().children(".num").children(".goodsNum").val();
                    totalPrice = totalPrice + price * num;
                });
            }
            var count = $(".goods").length;
            $("#alreadyGoods").html(count);
            $("#totalPrice").html(totalPrice.toFixed(2));
        } else {
            $("input[name='goods']").each(function () {
                this.checked = false;
            });
            $("#alreadyGoods").html(0);
            $("#totalPrice").html(0);
        }
    });

    $(".selectGoods").click(function () {
        var len = $(".goods").length;
        var count = 0;
        var totalPrice = 0;
        var userVIP = $(".userVIP").val();
        if (userVIP == 0) {
            $("input[name='goods']").each(function () {
                if (this.checked) {
                    var price = $(this).parents().parents().children(".skuPrice").html();
                    var num = $(this).parents().parents().children(".num").children(".goodsNum").val();
                    totalPrice = totalPrice + price * num;
                    count++;
                }
            });
        } else {
            $("input[name='goods']").each(function () {
                if (this.checked) {
                    var price = $(this).parents().parents().children(".skuPrice").html();
                    var num = $(this).parents().parents().children(".num").children(".goodsNum").val();
                    totalPrice = totalPrice + price * num;
                    count++;
                }
            });
        }
        $("#alreadyGoods").html(count);
        if (count == len) {
            $("input[name='allSelect']").prop("checked", true);
        } else {
            $("input[name='allSelect']").prop("checked", false);
        }

        $("#totalPrice").html(totalPrice.toFixed(2));
    });

    $(".jsan").click(function () {
        var orderInfoJson = "[";
        var orderDetailJson = "[";
        var orderId = "";
        var userId = 0;
        var infoGoodsAmount = 0;
        var infoTotalPrice = 0;

        var goodsName = "";
        var goodsAttrs = "";
        var deGoodsAmount = 0;
        var goodsPrice = 0;
        var deTotalPrice = 0;
        var goodsPic = "";
        var catalogId = 0;
        var spuId = "";
        var userVIP = $(".userVIP").val();
        var mydate = new Date();
        orderId = "o" + mydate.getDay() + mydate.getHours() + mydate.getMinutes() + mydate.getSeconds() + mydate.getMilliseconds() + Math.round(Math.random() * 10000);
        userId = $(".userId").val();
        var count = 0;
        $("input[name='goods']").each(function () {
            if (this.checked) {
                count++;
                deGoodsAmount = $(this).parents().parents().children('.num').children(".goodsNum").val();
                if (userVIP == 0) {
                    goodsPrice = $(this).parents().parents().children(".skuPrice").html();
                    infoTotalPrice = infoTotalPrice + deGoodsAmount * goodsPrice;
                    deTotalPrice = deGoodsAmount * goodsPrice
                } else {
                    goodsPrice = $(this).parents().parents().children(".discountPrice").html();
                    infoTotalPrice = infoTotalPrice + deGoodsAmount * goodsPrice;
                    deTotalPrice = deGoodsAmount * goodsPrice
                }
                infoGoodsAmount += deGoodsAmount * 1;
                goodsName = $(this).parents().parents().children(".goodsName").html();
                goodsAttrs = $(this).parents().parents().children(".goodsAttrs").html();
                goodsPic = $(this).parents().parents().children(".pic").children(".skuPic").html();
                catalogId = $(this).parents().parents().children(".num").children(".catalogId").val();
                spuId = $(this).parents().parents().children(".num").children(".spuId").val();
                orderDetailJson += "{'orderId':'" + orderId +
                    "','goodsName':'" + goodsName + "','goodsAttrs':'" +
                    goodsAttrs + "','goodsAmount':'" + deGoodsAmount +
                    "','goodsPrice':'" + goodsPrice + "','totalPrice':'" +
                    deTotalPrice.toFixed(2) + "','catalogId':'" +
                    catalogId + "','spuId':'" + spuId +
                    "','goodsPic':'" + goodsPic + "'},";
            }
        });
        orderDetailJson = orderDetailJson.substring(0, orderDetailJson.length - 1);
        orderDetailJson += "]";
        orderInfoJson = "{'id':'" + orderId + "','userId':'" + userId + "','goodsAmount':'" + infoGoodsAmount + "','totalPrice':'" + infoTotalPrice.toFixed(2) + "'}";
        if (count == 0) {
            alert("请先选择您想要购买的商品！");
        } else {
            $.post({
                url: "/addOrderFromCar",
                data: {
                    "orderDetailJson": orderDetailJson,
                    "orderInfoJson": orderInfoJson
                },
                success: function (data) {
                    if (data == "true") {
                        $("input[name='goods']").each(function () {
                            var carId = $(this).parents().parents().children(".carId").children(".addCarId").val();
                            $.post({
                                url: "/deleteCar",
                                data: {
                                    "addCarId": carId
                                },
                                success: function (data) {
                                    console.log(data);
                                }
                            });
                        });
                        location.href = "/toPayPage?orderId=" + orderId + "&userId=" + userId;
                    } else {
                        alert("购买异常,请重新尝试！");
                    }
                }
            })
        }
    });
});

function showGoodsSelectInfo() {
    var count = $(".goods").length;
    $("#totalGoods").html(count);
}

function total() {
    var totalPrice = 0;
    var userVIP = $(".userVIP").val();
    if (userVIP == 0) {
        $("input[name='goods']").each(function () {
            if (this.checked) {
                var price = $(this).parents().parents().children(".skuPrice").html();
                var num = $(this).parents().parents().children(".num").children(".goodsNum").val();
                totalPrice = totalPrice + price * num;
            }
        });
    } else {
        $("input[name='goods']").each(function () {
            if (this.checked) {
                var price = $(this).parents().parents().children(".skuPrice").html();
                var num = $(this).parents().parents().children(".num").children(".goodsNum").val();
                totalPrice = totalPrice + price * num;
            }
        });
    }
    $("#totalPrice").html(totalPrice.toFixed(2));
}