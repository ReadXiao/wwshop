$(function () {
    showAllUser();

    $("#findAllUser").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        $("#state").html("2");
        $("#username").val("");
        var url = "/getAllUser";
        checkState(url);
    });

    $("#normalUser").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        $("#state").html("0");
        $("#username").val("");
        var url = "/getNormalUser";
        checkState(url);
    });

    $("#cancelUser").click(function () {
        $(".li").attr("class", "li");
        $(this).parent().attr("class", "li active");
        $("#state").html("1");
        $("#username").val("");
        var url = "/getCancelUser";
        checkState(url);
    });

    $("#chaXun").click(function () {
        var state = $("#state").html();
        var username = $("#username").val();
        $.post({
            url: "/findByName",
            data: {"username": username,
                "state":state
            },
            success: function (data) {
                $("#username").val("");
                showUser(data);
            }
        })
    })
});


//界面初始话显示所有用户信息
function showAllUser() {
    var allUser = $("#allUser").html();
    allUser = eval('(' + allUser + ')');
    var str = "";
    var len;
    for (len = 0; len < allUser.length; len++) {
        var state = "";
        var birthday = allUser[len].birthday.substring(0, 10);

        str += "<tr class='text-center'>" +
            "<td>" + allUser[len].id +
            "</td><td><img src='" + allUser[len].pic + "' width='30px' height='40px'>" +
            "</td><td>" + allUser[len].username +
            "</td><td>" + allUser[len].sex +
            "</td><td>" + birthday +
            "</td><td>" + allUser[len].telPhone;

        if (allUser[len].vip == 0) {
            var vip = "<span style='color: black'>非会员</span>";
        } else {
            var vip = "<span style='color: red'>会员</span>";
        }
        str += "</td><td>" + vip +
            "</td><td>" + allUser[len].createTime + "</td>";
        if (allUser[len].state == 0) {
            state = "<span  style='color: green'>正常</span>";
            str += "<td>" + state + "</td><td>" + "<a href='#' onClick=\"resetPassword(" + allUser[len].id + ")\">重置密码</a>" + "|" +
                "<a href='#' onClick=\"cancelUser(" + allUser[len].id + ")\">注销</a>" +
                "</td></tr>"
        } else {
            state = "<span style ='color:red'>已注销：" + allUser[len].deleteTime + "</span>";
            str += "<td>" + state + "</td><td>" + "<a href='#' onClick=\"unCancelUser(" + allUser[len].id + ")\">恢复</a>" +
                "</td></tr>"
        }

    }
    $("#allUsers").html(str);
}

//封装用户显示ajax返回的用户信息
function showUser(data) {
    var allUser = eval('(' + data + ')');
    var str = "";
    var len;
    for (len = 0; len < allUser.length; len++) {
        var state = "";
        var birthday = allUser[len].birthday.substring(0, 10);

        str += "<tr class='text-center'>" +
            "<td>" + allUser[len].id +
            "</td><td><img src='" + allUser[len].pic + "' width='30px' height='40px'>" +
            "</td><td>" + allUser[len].username +
            "</td><td>" + allUser[len].sex +
            "</td><td>" + birthday +
            "</td><td>" + allUser[len].telPhone;

        if (allUser[len].vip == 0) {
            var vip = "<span style='color: black'>非会员</span>";
        } else {
            var vip = "<span style='color: red'>会员</span>";
        }
        str += "</td><td>" + vip +
            "</td><td>" + allUser[len].createTime + "</td>";
        if (allUser[len].state == 0) {
            state = "<span  style='color: green'>正常</span>";
            str += "<td>" + state + "</td><td>" + "<a href='#' onClick=\"resetPassword(" + allUser[len].id + ")\">重置密码</a>" + "|" +
                "<a href='#' onClick=\"cancelUser(" + allUser[len].id + ")\">注销</a>" +
                "</td></tr>"
        } else {
            state = "<span style ='color:red'>已注销：" + allUser[len].deleteTime + "</span>";
            str += "<td>" + state + "</td><td>" + "<a href='#' onClick=\"unCancelUser(" + allUser[len].id + ")\">恢复</a>" +
                "</td></tr>"
        }

    }
    $("#allUsers").html(str);
}


//查找不同状态的用户信息
function checkState(x) {
    $.post({
        url: x,
        success: function (data) {
            showUser(data);
        }
    })
}


//重置密码
function resetPassword(id) {
    var msg = "您确定要重置该用户的密码吗？";
    if (confirm(msg) == true) {
        console.log("进来了吗");
        $.post({
            url: "/resetPassword",
            data: {"id": id},
            success: function (data) {
                if (data == "true") {
                    alert("该用户密码重置成功");
                } else {
                    alert("密码重置失败");
                }
            }
        })
    } else {
        console.log("错误码")
        return false;
    }
}

//注销用户
function cancelUser(id) {
    var msg = "您确定要注销该用户吗？";
    if (confirm(msg) == true) {

        $.post({
            url: "/cancelUser",
            data: {"id": id},
            success: function (data) {
                if (data == "false") {
                    alert("该用户恢复失败");
                } else {
                    showUser(data);
                    alert("该用户注销成功");
                }
            }
        })
    } else {
        return false;
    }
}
//重启用户
function unCancelUser(id) {
    var msg = "您确定要恢复该用户吗？";
    if (confirm(msg) == true) {
        $.post({
            url: "/unCancelUser",
            data: {"id": id},
            success: function (data) {
                if (data == "false") {
                    alert("该用户恢复失败");
                } else {
                    showUser(data);
                    alert("该用户恢复成功");
                }
            }
        })
    } else {
        return false;
    }
}