$(function () {
    $(".item:eq(0)").addClass("active");
    $(".banben").click(function () {
        $("#goodsNum").val(1);
        $(".banben").addClass("old");
        $(".banben").removeClass("now");
        $(this).removeClass("old");
        $(this).addClass("now");
    })
});
var spuId;
var skuId;
var goodsName;
var attrValues;
var skuPrice;
var discountPrice;
var skuPic;

/*
* a:goodsName
* b:attrValues
* c:skuPrice
* d:discountPrice
* e:skuPic
* f:skuId
* */
function showAttrAndPrice(a, b, c, d, e, f) {
    skuId = f;
    goodsName = a;
    attrValues = b;
    skuPrice = c;
    discountPrice = d;
    skuPic = e;
    var vip = $("#userVIP").html();
    $("#nameAttrs").html(a + "&nbsp;&nbsp;" + b);
    $("#normalPrice").html("<span>原价：" + c + "元</span>&nbsp;&nbsp;");
    $("#disCountPrice").html("<span>会员价：" + d + "元</span>");
    if (vip == 1) {
        $("#totalPrice").html(discountPrice);
    } else {
        $("#totalPrice").html(skuPrice);
    }
}

function addCar() {
    spuId = $("#spuId").html();
    var catalogId = $("#catalogId").html();
    if (skuId==null){
        alert("请先选择商品！");
    }else {
        var goodsNum = $("#goodsNum").val();
        if (goodsNum<=0){
            alert("添加商品不能为0!");
        }else{
            $.post({
                url:"/addCar",
                data:{
                    "spuId":spuId,
                    "skuId":skuId,
                    "goodsName":goodsName,
                    "skuPrice":skuPrice,
                    "discountPrice":discountPrice,
                    "goodsAttrs":attrValues,
                    "goodsNum":goodsNum,
                    "catalogId":catalogId
                },
                success:function (data) {
                    if (data=="none"){
                        alert("请登录先！");
                    }else if (data == "false"){
                        alert("添加失败");
                    }else {
                        alert("添加成功，可前往购物车查看！");
                    }
                }
            })
        }
    }

}

function jian() {
    if (skuId==null){
        alert("请先选择商品！");
    }else {
        var goodsNum = $("#goodsNum").val();
        spuId = $("#spuId").html();
        if (goodsNum<=0){
            goodsNum=0;
        }else{
           goodsNum--;
        }
        var userVIP = $("#userVIP").html();
        var totalPrice;
        if (userVIP == 1){
            totalPrice = goodsNum*discountPrice;
            $("#totalPrice").html(totalPrice.toFixed(2));
        }else{
            totalPrice = goodsNum*skuPrice;
            $("#totalPrice").html(totalPrice.toFixed(2));
        }
        $("#goodsNum").val(goodsNum);
    }

}

function jia() {
    if (skuId==null){
        alert("请先选择商品");
    }else {
        spuId = $("#spuId").html();
        var goodsNum = $("#goodsNum").val();
        var totalPrice;
        $.post({
            url:"/checkNum",
            data: {
                "spuId":spuId,
                "skuId":skuId,
                "goodsNum":goodsNum
            },
            success:function (data) {
                var userVIP = $("#userVIP").html();
                if (data=="true"){
                    goodsNum = goodsNum*1+1;
                    if (userVIP == 1){
                        totalPrice = goodsNum*discountPrice;
                        $("#totalPrice").html(totalPrice.toFixed(2));
                    }else{
                        totalPrice = goodsNum*skuPrice;
                        $("#totalPrice").html(totalPrice.toFixed(2));
                    }
                    $("#goodsNum").val(goodsNum);
                }else{
                    alert("库存不足！");
                }
            }
        })
    }
}