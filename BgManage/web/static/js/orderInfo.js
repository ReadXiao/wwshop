$(function () {
    initPage();

    $("#unPay").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        var state = 0;
        $("#state").html(state);
        $("#username").val("");
        $.post({
            url: "/findUnPayOrder",
            data: {
                "state": state
            },
            success: function (data) {
                showOrderInfos(data)
            }
        })
    });

    $("#unSendGoods").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        var state = 1;
        $("#state").html(state);
        $("#username").val("");
        $.post({
            url: "/findUnSendOrder",
            data: {
                "state": state
            },
            success: function (data) {
                showOrderInfos(data)
            }
        })
    });

    $("#unReceived").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        var state = 2;
        $("#state").html(state);
        $("#username").val("");
        $.post({
            url: "/findUnReceiveOrder",
            data: {
                "state": state
            },
            success: function (data) {
                showOrderInfos(data)
            }
        })
    });

    $("#already").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        var state = 3;
        $("#state").html(state);
        $("#username").val("");
        $.post({
            url: "/findAlreadyOrder",
            data: {
                "state": state
            },
            success: function (data) {
                showOrderInfos(data)
            }
        })
    });

    $("#chaXun").click(function () {
        var username = $("#username").val();
        var state = $("#state").html();
        $("#username").val("");
        $.post({
            url: "/findOrderByUserName",
            data: {
                "username": username,
                "state": state
            },
            success: function (data) {
                showOrderInfos(data);
            }
        })
    })
});

//初始话页面
function initPage() {
    var data = $("#orders").html();
    showOrderInfos(data);
}

//后台数据显示
function showOrderInfos(data) {
    data = eval("(" + data + ")");
    var len;
    var str = "";
    for (len = 0; len < data.length; len++) {
        str += " <tr>\n" +
            "                        <td>" + data[len].id + "</td>\n" +
            "                        <td>" + data[len].username + "</td>\n" +
            "                        <td>" + data[len].goodsAmount + "</td>\n" +
            "                        <td>" + data[len].totalPrice + "</td>\n" +
            "                        <td>" + data[len].createTime + "</td>\n" +
            "                        <td>" + data[len].payTime + "</td>\n";
        if (data[len].state == 0) {
            str += "                        <td>未付款</td>\n";
        } else if (data[len].state == 1) {
            str += "                        <td>未发货</td>\n"
        } else if (data[len].state == 2) {
            str += "                        <td>未收货</td>\n"
        } else {
            str += "                        <td>已完成</td>\n"
        }
        str += "                        <td>" + data[len].expressWay + "</td>\n" +
            "                        <td>" + data[len].expressNum + "</td>\n" +
            "                        <td><a href='/toOrderInfoDetail?orderId=" + data[len].id + "&state=" + data[len].state + "&addressId=" + data[len].addressId + "'>详情</a></td>\n" +
            "                    </tr>"

    }
    $("#allOrderInfos").html(str);
}