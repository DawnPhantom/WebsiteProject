<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/13
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>订单页</title>
    <link type="text/css" rel="stylesheet" href="res/css/cart_style.css">
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div id="main">
    <div id="book">
        <table>
            <tr>
                <td>订单号</td>
                <td>创建日期</td>
                <td>订单状态</td>
                <td>查看</td>
                <td>操作</td>
                <td>服务</td>
            </tr>
            <c:forEach items="${ requestScope.pages.items }" var="order">
                <tr>
                    <td>${order.orderid}</td>
                    <td>${order.date}</td>
                    <c:if test="${order.orderStatus == 0}">
                        <td>待付款</td>
                    </c:if>
                    <c:if test="${order.orderStatus == 1}">
                        <td>待发货</td>
                    </c:if>
                    <c:if test="${order.orderStatus == 2}">
                        <td>待收货</td>
                    </c:if>
                    <c:if test="${order.orderStatus == 3}">
                        <td>已收货</td>
                    </c:if>
                    <c:if test="${order.orderStatus == 4}">
                        <td>已取消</td>
                    </c:if>
                    <td><a class="show_details"
                           href="order/userOrderServlet?action=orderDetails&orderID=${order.orderid}&orderStatus=${order.orderStatus}&address=${order.cus_address}">查看详情</a>
                    </td>
                    <c:if test="${order.orderStatus == 0}">
                        <td><a>去付款</a></td>
                        <td><a href="order/userOrderServlet?action=cancelOrder&orderid=${order.orderid}">取消订单</a>
                        </td>
                    </c:if>
                    <c:if test="${order.orderStatus == 1}">
                        <td><a></a></td>
                    <td><a href="order/userOrderServlet?action=cancelOrder&orderid=${order.orderid}">取消订单</a>
                    </c:if>
                    <c:if test="${order.orderStatus == 2}">
                        <td><a></a></td>
                        <td><a>申请售后</a></td>
                    </c:if>
                    <c:if test="${order.orderStatus == 3}">
                        <td><a></a></td>
                        <td><a>申请售后</a></td>
                    </c:if>
                    <c:if test="${order.orderStatus == 4}">
                        <td><a></a></td>
                        <td><a></a></td>
                    </c:if>

                </tr>
            </c:forEach>
        </table>
        <%@include file="/pages/common/page_stript.jsp" %>
    </div>
</div>
</body>
</html>
