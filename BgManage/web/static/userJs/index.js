$(function () {
    checkLogin();
    catalogShow();
    $("#findGoods").click(function () {
        var goodsName = $("#search").val();
        alert(goodsName);
        var page = 0;
        location.href = "/findGoodsByName?goodsName=" + goodsName + "&page=" + page;
    })


});

function checkLogin() {
    $.post({
        url: "/checkLogin",
        success: function (data) {
            if (data == "true") {
                $("#unLogin").css("display", "none");
                $("#alreadyLogin").css("display", "block");
            }
        }
    })
}

function catalogShow() {
    $.post({
        url: "/showCatalog",
        success: function (data) {
            var str = "";
            var len;
            data = eval('(' + data + ')');
            for (len = 0; len < data.length; len++) {
                var page = 0;
                str += "<li>\n" +
                    "                        <a href='/findGoodsByCatalogId?catalogId=" + data[len].id + "&page=" + page + "'>" + data[len].value + " <span class=\"sr-only\">(current)</span></a>\n" +
                    "                    </li>"
            }
            $("#catalogs").html(str);
        }
    })
}

function showMoreGoods() {
    var page = $("#page").html();
    var typeValue = $("#typeValue").html();
    var catalogId = $("#catalogId").html();
    var type = $("#type").html();
    console.log(type);
    if (type == "catalogId") {
        $.post({
            url: "/getMoreGoodsByCatalogId",
            data: {
                "catalogId": catalogId,
                "page": page
            },
            success: function (data) {
                console.log(data);
                if (data == "null") {
                    alert("没有更多商品！")
                } else {
                    data = eval("(" + data + ")");
                    var len;
                    var str="";
                    for (len=0;len<data.length;len++){
                        str+="<div class=\"mingxing fl mb20 col-md-3\" style=\"border:2px solid #fff;width:230px;cursor:pointer;\" onmouseout=\"this.style.border='2px solid #fff'\" onmousemove=\"this.style.border='2px solid red'\">\n" +
                            "                    <div class=\"sub_mingxing\"><a href=\"/detailGoods?spuId="+data[len].id+"\" target=\"_blank\"><img src=\""+data[len].spuPic+"\" alt=\"\"></a></div>\n" +
                            "                    <div class=\"pinpai\"><a href=\"/detailGoods?spuId="+data[len].id+"\" target=\"_blank\">"+data[len].goodsName+"</a></div>\n" +
                            "                    <div class=\"youhui\">"+data[len].goodsDesc+"</div>\n" +
                            "                    <div class=\"jiage\">"+data[len].spuPrice+"元</div>\n" +
                            "                </div>"
                    }
                    $("#goodsList").append(str);
                    $("#page").html(page++);
                }
            }
        })
    } else {
        $.post({
            url: "/getMoreGoodsByGoodsName",
            data: {
                "goodsName": typeValue,
                "page": page
            },
            success: function (data) {
                if (data == "null") {
                    alert("没有更多商品！")
                } else {
                    data = eval("(" + data + ")");
                    var len;
                    var str="";
                    for (len=0;len<data.length;len++){
                        str+="<div class=\"mingxing fl mb20 col-md-3\" style=\"border:2px solid #fff;width:230px;cursor:pointer;\" onmouseout=\"this.style.border='2px solid #fff'\" onmousemove=\"this.style.border='2px solid red'\">\n" +
                            "                    <div class=\"sub_mingxing\"><a href=\"/detailGoods?spuId="+data[len].id+"\" target=\"_blank\"><img src=\""+data[len].spuPic+"\" alt=\"\"></a></div>\n" +
                            "                    <div class=\"pinpai\"><a href=\"/detailGoods?spuId="+data[len].id+"\" target=\"_blank\">"+data[len].goodsName+"</a></div>\n" +
                            "                    <div class=\"youhui\">"+data[len].goodsDesc+"</div>\n" +
                            "                    <div class=\"jiage\">"+data[len].spuPrice+"元</div>\n" +
                            "                </div>"
                    }
                    $("#goodsList").append(str);
                    $("#page").html(page++);
                }
            }
        })
    }
}

function toAddCar() {
    $.post({
        url:"/toAddCar",
        success:function (data) {
            if (data=="unLogin"){
                alert("您还没有登录！");
            }else {
                window.open("/toAddCarPage");
            }

        }
    })
}

function toAddCoupon() {
    window.open("/toGetCouponPage");
}