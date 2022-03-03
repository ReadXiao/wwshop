$(function () {

});

function myCoupon() {
    $.post({
        url:"/toMyCoupon",
        success:function (data) {
            if (data=="true"){
                alert("您好");
                window.open("/toMyCouponPage");
            }else{
                alert("请先登录!");
            }
        }
    })
}

/*
* x:minPrice
* y:discountPrice
* z:deadline
* r:catalogId
* p:couponsId
* */
function getCoupon(x,y,z,r,p) {
    $.post({
        url:"/toMyCoupon",
        success:function (data) {
            if (data=="true"){
                $.post({
                    url:"/insertIntoCoupon",
                    data:{
                        "minPrice":x,
                        "discountPrice":y,
                        "deadline":z,
                        "catalogId":r,
                        "couponsId":p
                    },
                    success:function (data2) {
                        if (data2=="true"){
                            alert("恭喜你，领取成功！");
                        }else if(data2=="false"){
                            alert("抱歉，领取失败");
                        }else if (data2=="already"){
                            alert("您已经领取过该优惠券！");
                        }else {
                            alert("该优惠卷已抢光！");
                        }
                    }
                })
            }else{
                alert("请先登录！");
            }
        }
    })
}

function toUseCoupon(catalogId) {
    var page=0;
    location.href="/findGoodsByCatalogId?catalogId=" + catalogId + "&page="+page;
}