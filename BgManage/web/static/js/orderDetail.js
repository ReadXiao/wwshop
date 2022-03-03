$(function () {
    var state = $("#state").html();
    if(state==1){
        $("#sendGoods").attr('disabled',false);
    }
});

function sendOrder(orderId) {
    $.post({
        url:"/sendOrder",
        data:{
            "orderId":orderId
        },
        success:function (data) {
            if (data == "true"){
                alert("发货成功！");
                location.href="/toOrderAdmin";
            }else {
                alert("发货失败！")
            }
        }
    })
}