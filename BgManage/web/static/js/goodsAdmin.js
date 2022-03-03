$(function () {
    $.post({
        url: "/getAllGoods",
        success: function (data) {
            var str = "";
            data = eval('(' + data + ')');
            var len;
            for (len = 0; len < data.length; len++) {
                var state = "";
                str += "<tr class='text-center'>" +
                    "<td>" + data[len].id +
                    "</td><td><img src='" + data[len].spuPic +"' width='30px' height='40px'>"+
                    "</td><td>" + data[len].goodsName +
                    "</td><td>" +data[len].spuPrice+
                    "</td><td>" +data[len].goodsDesc+
                    "</td><td>" +data[len].createTime+"</td>";
                if(data[len].state==0){
                    state="<span  style='color: green'>正常</span>";
                    str+="<td>"+state+"</td><td>" + "<a href='/attrAdmin?id="+ data[len].id+"'>属性</a>"+"|"+
                        "<a href='/deleteSpu?id="+data[len].id+"' onClick=\"return confirm('确定下架该商品吗?');\">下架</a>" +"|"+
                        "<a href='/toComment?id="+ data[len].id+"'>评论</a>"+
                        "</td></tr>"
                }else{
                    state="<span style ='color:red'>已下架："+data[len].deleteTime+"</span>";
                    str+="<td>"+state+"</td><td>" + "<a href='/attrAdmin?id="+ data[len].id+"'>属性</a>"+"|"+
                        "<a href='/insertSpu?id="+data[len].id+"' onClick=\"return confirm('确定上架该商品吗?');\">上架</a>" +"|"+
                        "<a href='/toComment?id="+ data[len].id+"'>评论</a>"+
                        "</td></tr>"
                }

            }
            $("#allGoods").html(str);
        }
    });

    $("#chaXun").click(function () {
        $("#allGoods").html("");
        var goodsName = $("#goodsName").val();
        var state = $("#state").html();
        $.post({
            url: "/queryGoodsByName",
            data:{"goodsName":goodsName,
                "state":state
            },
            success: function (data) {
                $("#goodsName").val("");
                var str = "";
                data = eval('(' + data + ')');
                var len;
                for (len = 0; len < data.length; len++) {
                    var state = "";
                    str += "<tr class='text-center'>" +
                        "<td>" + data[len].id +
                        "</td><td><img src='" + data[len].spuPic +"' width='30px' height='40px'>"+
                        "</td><td>" + data[len].goodsName +
                        "</td><td>" +data[len].spuPrice+
                        "</td><td>" +data[len].goodsDesc+
                        "</td><td>" +data[len].createTime+"</td>";
                    if(data[len].state==0){
                        state="<span  style='color: green'>正常</span>";
                        str+="<td>"+state+"</td><td>" + "<a href='/attrAdmin?id="+ data[len].id+"'>属性</a>"+"|"+
                            "<a href='/deleteSpu?id="+data[len].id+"' onClick=\"return confirm('确定下架该商品吗?');\">下架</a>" +"|"+
                            "<a href='/toComment?id="+ data[len].id+"'>评论</a>"+
                            "</td></tr>"
                    }else{
                        state="<span style ='color:red'>已下架："+data[len].deleteTime+"</span>";
                        str+="<td>"+state+"</td><td>" + "<a href='/attrAdmin?id="+ data[len].id+"'>属性</a>"+"|"+
                            "<a href='/insertSpu?id="+data[len].id+"' onClick=\"return confirm('确定上架该商品吗?');\">上架</a>" +"|"+
                            "<a href='/toComment?id="+ data[len].id+"'>评论</a>"+
                            "</td></tr>";
                    }
                }
                $("#allGoods").html(str);
            }
        })
    });

    $("#allGoodsSpu").click(function () {
        $(".li").attr("class","li");
        $(this).parent().attr("class","li active");
        $("#state").html("2");
        $("#goodsName").val("");
        var url = "/getAllGoods";
        stateCheck(url);
    });

    $("#OnlineGoodsSpu").click(function () {
        $(".li").attr("class","li");
        $(this).parent().attr("class","li active");
        $("#state").html("0");
        $("#goodsName").val("");
        var url = "/OnlineGoodsSpu";
        stateCheck(url);
    });

    $("#unOnlineGoods").click(function () {
        $(".li").attr("class","li");
        $(this).parent().attr("class","li active")
        $("#state").html("1");
        $("#goodsName").val("");
        var url = "/unOnlineGoods";
        stateCheck(url);
    })
});

function stateCheck(url) {
    $.post({
        url: url,
        success: function (data) {
            var str = "";
            data = eval('(' + data + ')');
            var len;
            for (len = 0; len < data.length; len++) {
                var state = "";
                str += "<tr class='text-center'>" +
                    "<td>" + data[len].id +
                    "</td><td><img src='" + data[len].spuPic +"' width='30px' height='40px'>"+
                    "</td><td>" + data[len].goodsName +
                    "</td><td>" +data[len].spuPrice+
                    "</td><td>" +data[len].goodsDesc+
                    "</td><td>" +data[len].createTime+"</td>";
                if(data[len].state==0){
                    state="<span  style='color: green'>正常</span>";
                    str+="<td>"+state+"</td><td>" + "<a href='/attrAdmin?id="+ data[len].id+"'>属性</a>"+"|"+
                        "<a href='/deleteSpu?id="+data[len].id+"' onClick=\"return confirm('确定下架该商品吗?');\">下架</a>" +"|"+
                        "<a href='/toComment?id="+ data[len].id+"'>评论</a>"+
                        "</td></tr>"
                }else{
                    state="<span style ='color:red'>已下架："+data[len].deleteTime+"</span>";
                    str+="<td>"+state+"</td><td>" + "<a href='/attrAdmin?id="+ data[len].id+"'>属性</a>"+"|"+
                        "<a href='/insertSpu?id="+data[len].id+"' onClick=\"return confirm('确定上架该商品吗?');\">上架</a>" +"|"+
                        "<a href='/toComment?id="+ data[len].id+"'>评论</a>"+
                        "</td></tr>"
                }
            }
            $("#allGoods").html(str);
        }
    })
}
