$(function () {

    findByName();
});

function findByName() {
    $("#chaXun").click(function () {
        var goodsName = $("#goodsName").val();
        $.post({
            url: "/findSaleByName",
            data: {
                "goodsName": goodsName
            },
            success: function (data) {
                showSaleDetail(data)

            }
        })
    })
}

function showSaleDetail(data) {
    data = eval("(" + data + ")");
    var len;
    var str = "";
    for (len = 0; len < data.length; len++) {
        str+="  <tr>\n" +
            "                            <td>"+data[len].spuId+"</td>\n" +
            "                            <td>"+data[len].goodsName+"</td>\n" +
            "                            <td><img src=\""+data[len].goodsPic+"\" width='30px' height='40px'></td>\n" +
            "                            <td>"+data[len].goodsAttrs+"</td>\n" +
            "                            <td>"+data[len].count+"</td>\n" +
            "                            <td>"+data[len].saleSum+"</td>\n" +
            "                        </tr>"
    }
    $("#allGoodsSaleDetail").html(str);
}