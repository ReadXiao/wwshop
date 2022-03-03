<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <script src="../../layui/layui.js"></script>
    <script src="../../static/js/comment.js"></script>
    <style type="text/css">
        td{
            vertical-align: middle !important;
            font-family:  Verdana, Geneva, sans-serif;
            font-size: 14px;
        }
        .article-container {
            background-color: #ffffff;
            padding-top: 20px;
            width: 1024px;
            margin: 20px auto;
        }

        p {
            text-indent: 2em;
            font-size: 18px;
        }

        .NavLinks img {
            width: 100%;
            height: 100%;
        }

        .hitShowPic span {
            font-size: 15px;
            text-align: center;
        }

        /*以下评论的css*/
        .show_reply_list {
            margin-right: 1em;
            color: grey;
        }

        .comment_list {
            background-color: #ffffff;
            padding-top: 5px;
            width: 900px;
            margin: 0 auto;
        }

        .comment {
            width: 900px;
            margin-top: 10px;
        }

        .comment_content {
            clear: both;
            margin: 5px 50px;
            font-size: 16px;
            vertical-align: middle !important;
            font-family: Verdana, Geneva, sans-serif;
        }

        .imgdiv {
            width: 80px;
            height: 70px;
            float: left;

        }

        .imgcss {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .comment_name {
            margin-left: 10px;
            color: #3D9EEA;
            font-size: 16px;
            font-weight: bolder;
        }

        .layui-icon {
            font-size: 13px;
            color: grey;
        }

        .del {
            float: right;

        }

        .del_comment {
            margin-right: 50px;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>评论管理</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 column">
            <table class="table">
                <tr>
                    <td class="col-md-1 column"><img src="${goodsSpu.spuPic}" width="120px" height="120px"></td>
                    <td class="col-md-11 column">${goodsSpu.goodsName}</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="article-container">
        <div class="comment_list">
            <h3 style="text-indent: 2em;">评论列表</h3>
            <hr>
            <c:forEach items="${comments}" var="comments">
                <hr>
                <div class="comment">
                    <div class="imgdiv">
                        <img class="imgcss" src="${comments.userPic}"/>
                    </div>
                    <div class="conmment_details">
                        <div style="float:left;">
                            <span class="comment_name">${comments.userName} </span>     <span>${comments.commentTime}</span><p></p>
                            <span>${comments.goodsAttrs}</span>

                        </div>
                        <div class="del">
                            <span class="show_reply_list"> <c:choose>
                                <c:when test="${comments.grade == 0 }">
                                    非常差，非常不满意
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${comments.grade == 2 }">
                                        比较差，不满意
                                    </c:if>
                                    <c:if test="${comments.grade == 2 }">
                                        一般
                                    </c:if>
                                    <c:if test="${comments.grade == 3 }">
                                        还以，比较满意
                                    </c:if>
                                    <c:if test="${comments.grade == 3 }">
                                       非常满意
                                    </c:if>
                                </c:otherwise>
                            </c:choose></span>
                            <i class="layui-icon layui-icon-praise" style="font-size: 13px; color: #1E9FFF;">赞(${comments.likenum})</i>
                            <a class="del_comment" href="#" onclick="deleteComment(${comments.id},'${comments.spuId}')" data-id="1"> <i class="icon layui-icon"
                                                                   style="font-size: 13px; color: red;">删除</i></a>
                        </div>
                        <div class="comment_content">${comments.comment}
                            <img src="${comments.commentPics}" height="60px" width="60px">
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
