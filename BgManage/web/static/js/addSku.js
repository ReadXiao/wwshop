$(function () {
    //上传商品
    $("#uploadGoods").click(function () {
        var count = 0;
        var j = 0;
        for (j = 0; j < $(".attrPic").length; j++) {
            if ($(".attrPic").eq(j).val() != "") {
                count++;
            }
        }
        var attrs = "[";
        for (var len = 0; len < $(".attrId").length; len++) {
            var attrId = $(".attrId").eq(len).val();
            var attrValue = $(".attrValue").eq(len).val();
            attrs += "{'attrId':'" + attrId + "','attrValue':'" + attrValue + "'}";
        }
        attrs += "]";
        var skuPrice = $("#skuPrice").val();
        var discountPrice = $("#discountPrice").val();
        var amount = $("#amount").val();
        var fileName = $("#attrPic").val();
        var spuId = $("#spuId").html();
        if (count == $(".attrPic").length && fileName !="" && attrs != "" && skuPrice != "" && discountPrice != "" && amount != "") {
            var attrPic = uploadImg(".attrPic");
            if (attrPic != "上传失败") {

                $.post({
                    url: "/uploadSku",
                    data: {
                        "spuId":spuId,
                        "attrs": attrs,
                        "skuPic": attrPic,
                        "skuPrice": skuPrice,
                        "discountPrice": discountPrice,
                        "amount": amount
                    },
                    success: function (data) {
                        if (data == "success") {
                            location.href = "/attrAdmin?id="+spuId;
                        } else {
                            alert("上传失败，请重新上传！")
                        }
                    }
                })
            } else {
                alert("图片上传失败！");
            }
        } else {
            alert("请将商品信息填写完整！");
        }
    })
});

//上传图片到页面并显示图片
function showUploadImg(x, y) {
    var name, fileName, personsFile;
    personsFile = document.getElementById(x);
    name = personsFile.value;
    fileName = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
    if (fileName !== "png" && fileName !== "jpg") {
        alert("上传图片格式不正确，请重新上传");
    } else {
        document.getElementById(y).src = window.URL.createObjectURL(personsFile.files[0]);
    }
}

//将图片上传到服务器
function uploadImg(x) {
    var reValue = "";
    var formData = new FormData();//序列化表单，将上传类型设置为文件对象
    for (var i = 0; i < $(x).length; i++) {
        formData.append("file", $(x)[i].files[0]);
    }
    $.ajax({
        type: 'post',
        url: '/uploadPic',
        data: formData,
        async: false,//将ajax的同步异步改为同步
        cache: false,//文件不设置缓存
        processData: false,//数据不被转换为字符串
        contentType: false,//上传文件时使用，避免 JQuery 对其操作
        success:
            function (json) {
                if (json == "false") {
                    reValue = "上传失败";
                } else {
                    reValue = json;
                }
            },
        error:
            function () {
                alert("上传失败");
                reValue = "上传失败";
            }
    });
    return reValue;
}
