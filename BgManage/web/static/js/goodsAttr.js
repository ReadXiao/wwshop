$(function () {
    showAllSku();

    $("#newSku").click(function () {
        var spuId = $("#spuId").html();
        location.href = "/toAddSku?spuId="+spuId;
    })

});

//展示某一商品的所有sku
function showAllSku() {
    var json = $("#json").html();
    var data = eval('(' + json + ')');
    var str = "";
    var len;
    for (len = 0; len < data.length; len++) {
        str += "<tr>" +
            "<td>" + data[len].id +
            "</td><td><img src='" + data[len].skuPic + "' width='30px' height='40px'>" +
            "</td><td>" + data[len].attrValues +
            "</td><td>" + data[len].skuPrice +
            "</td><td>" + data[len].discountPrice +
            "</td><td>" + data[len].amount +
            "</td><td>" + data[len].createTime +"</td>";
        var state = "";
        if (data[len].state == 0) {
           /* state = "正常";*/
            str += "<td><span style='color: green'>销售中</span></td>"+
                "<td>" +
                "<a href='/upAttr?id="+ data[len].id +"&spuId=" + data[len].spuId + "'>修改</a>"+"&nbsp;|&nbsp;"+
                "<a href='/deleteGoods?id="+data[len].id+"&spuId="+data[len].spuId+"' onClick=\"return confirm('确定下架该商品吗?');\">下架</a>"+
                "</td>";
        } else {
            state = "已下架" + ":" + data[len].deleteTime;
            str += "<td><span style='color: red'>"+state+"</span></td>"+
                "<td>" +
                "<a href='/upAttr?id="+ data[len].id +"&spuId=" + data[len].spuId + "'>修改</a>"+"&nbsp;|&nbsp;"+
                "<a href='/insertGoods?id="+data[len].id+"&spuId="+data[len].spuId+"' onClick=\"return confirm('确定重新上架该商品吗?');\">上架</a>"+
                "</td>";
        }
        $("#spuId").html(data[len].spuId);
    }
    $("#allAttrs").append(str);
}