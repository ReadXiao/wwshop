<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/css/basic-grey.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/addCoupon.js" type="text/javascript"></script>
</head>
<body>
<div class="div">
    <form action="" method="post" class="smart-green">
        <h1>WW商城
            <span>发起优惠卷</span>
        </h1>
        <label>
            <span>适用类别 :</span><select id="catalog" name="selection">
            <c:forEach var="catalogs" items="${catalogs}">
                <option value="${catalogs.id}">${catalogs.value}</option>
            </c:forEach>
        </select>
        </label>
        <label>
            <span>最低限价 :</span>
            <input id="minPrice" type="text" name="minPrice" placeholder="请输入该优惠卷最低可使用额度" />
        </label>
        <label>
            <span>减免金额 :</span>
            <input id="discountPrice" type="text" name="discountPrice" placeholder="请输入该优惠卷可减免的金额" />
        </label>
        <label>
            <span>截止时间 :</span>
            <input id="deadline" type="date" value="${localDate}" min="${localDate}"/>
        </label>
        <label>
            <span>数量 :</span>
            <input id="count" type="text" name="count" placeholder="请输入该优惠卷发布的数量" />
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="button" id="button" value="发布" />
        </label>
    </form>
</div>
</body>
</html>
