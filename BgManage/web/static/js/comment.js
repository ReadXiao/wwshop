$(function () {
});

function deleteComment(id,spuId) {
    var msg = "您确定要删除该评论吗";
    if (confirm(msg) == true) {
        $.post({
            url:"/deleteComment",
            data:{
                "id":id
            },
            success:function (data) {
                if(data=="true"){
                    alert("删除成功");
                    location.href = "/toComment?id="+spuId;
                }else {
                    alert("删除失败");
                }
            }
        })
    }

}