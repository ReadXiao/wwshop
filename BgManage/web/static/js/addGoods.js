$(function () {
    showCatalog();

    //选择商品类别点击事件
    $(".selectCatalog").click(function () {
        var id = this.value;
        $.post({
            url: "findAttrs",
            data: {"id": id},
            success: function (data) {
                data = eval('(' + data + ')');
                var str = "";
                for (var len = 0; len < data.length; len++) {
                    str += "<span class='attrName'>" + data[len].attrName + " : " +
                        "</span><input type='hidden' class='attrId' value='" + data[len].attrId + "'>" +
                        "<input type='text' class='attrValue'>  "
                }
                $("#attrs").html(str);

            }
        })
    });

    //商品描述字数限制，不得大于100
    $('#goodsDesc').on("keyup", function () {
        $('#textNum').text($('#goodsDesc').val().length);//这句是在键盘按下时，实时的显示字数
        if ($('#goodsDesc').val().length > 100) {
            $('#textNum').text(100);//长度大于100时0处显示的也只是100
            $('#goodsDesc').val($('#goodsDesc').val().substring(0, 100));//长度大于100时截取钱100个字符
        }
    })
    $('#textNum').text($('#goodsDesc').val().length);//这句是在刷新的时候仍然显示字数

    //上传商品
    $("#uploadGoods").click(function () {
        var count = 0;
        var j = 0;
        for (j = 0; j < $(".goodsPic").length; j++) {
            if ($(".goodsPic").eq(j).val() != "") {
                count++;
            }
        }
        for (j = 0; j < $(".detailPic").length; j++) {
            if ($(".detailPic").eq(j).val() != "") {
                count++;
            }
        }
        for (j = 0; j < $(".attrPic").length; j++) {
            if ($(".attrPic").eq(j).val() != "") {
                count++;
            }
        }
        var catalogId = $(".selectCatalog option:selected").val();
        var goodsName = $("#goodsName").val();
        var spuPrice = $("#spuPrice").val();
        var goodsDesc = $("#goodsDesc").val();
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
        if (count == $(".goodsPic").length + $(".detailPic").length + $(".attrPic").length && catalogId != "" && goodsName != "" && spuPrice != "" && goodsDesc != "" && attrs != "" && skuPrice != "" && discountPrice != "" && amount != "") {
            var spuPic = uploadImg(".goodsPic");
            var detailPics = uploadImg(".detailPic");
            var attrPic = uploadImg(".attrPic");
            if (spuPic != "上传失败" && detailPics != "上传失败" && attrPic != "上传失败") {

                var s = "spuPic:" + spuPic + ",detailPics:" + detailPics + ",attrPic:" + attrPic + ",catalogId:" + catalogId + ",goodsName:" +
                    goodsName + ",spuPrice:" + spuPrice + ",attrs:" + attrs + ",skuPrice:" + skuPrice + ",discountPrice:" + discountPrice + ",amount:" + amount;
                console.log(s);
                $.post({
                    url: "/uploadGoods",
                    data: {
                        "catalogId": catalogId,
                        "goodsName": goodsName,
                        "spuPic": spuPic,
                        "spuPrice": spuPrice,
                        "goodsDesc": goodsDesc,
                        "detailPics": detailPics,
                        "attrs": attrs,
                        "skuPic": attrPic,
                        "skuPrice": skuPrice,
                        "discountPrice": discountPrice,
                        "amount": amount
                    },
                    success: function (data) {
                        if(data=="success"){
                            location.href="/toGoodsAdmin";
                        }else{
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

/*显示所有的分类*/
function showCatalog() {
    var catalog = $(".selectCatalog");
    var data = $("#allCatalog").html();
    data = eval('(' + data + ')');
    var len;
    var str = "";
    for (len = 0; len < data.length; len++) {
        str += "<option value='" + data[len].id + "' class='catalog'>" + data[len].value + "</option>"
    }
    catalog.append(str);
}

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
                if(json=="false"){
                    reValue = "上传失败";
                }else{
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


