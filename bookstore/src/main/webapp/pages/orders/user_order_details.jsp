<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/14
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>订单详情</title>
    <link type="text/css" rel="stylesheet" href="res/css/cart_style.css">
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div id="main">
    <div id="book">
        <c:if test="${param.orderStatus == 0}">
            <div>订单状态：待付款</div>
        </c:if>
        <c:if test="${param.orderStatus == 1}">
            <div>订单状态：待发货</div>
        </c:if>
        <c:if test="${param.orderStatus == 2}">
            <div>订单状态：待收货</div>
        </c:if>
        <c:if test="${param.orderStatus == 3}">
            <div>订单状态：已收货</div>
        </c:if>
        <c:if test="${param.orderStatus == 4}">
            <div>订单状态：已取消</div>
        </c:if>
        <div>收货地址：${param.address}</div>
        <table>
            <tr>
                <td>书名</td>
                <td>作者</td>
                <td>单价</td>
                <td>数量</td>
                <td>折扣</td>
                <td>总价</td>
            </tr>
            <c:forEach items="${ requestScope.order_item }" var="item">
                <tr>
                    <td>${ item.bookname }</td>
                    <td>${ item.author }</td>
                    <td>${ item.unit_price }</td>
                    <td>${ item.quantity }</td>
                    <td>${ requestScope.item.unit_price * (1 - requestScope.item.discount_rate * requestScope.item.quantity) + requestScope.item.discount}</td>
                    <td>${ requestScope.item.unit_price * requestScope.item.discount_rate * requestScope.item.quantity - requestScope.item.discount}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
