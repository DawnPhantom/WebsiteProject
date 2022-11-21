<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/3
  Time: 22:51
  所有页面的标识
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link type="text/css" rel="stylesheet" href="res/css/common/header.css">
<script type="text/javascript" scr="res/css/script/jquery-1.7.2.js"></script>
<div id="login_header">
    <image class="logo_img" alt="图片丢失" src="res/img/index_logo.png"></image>
    <div style="text-align: right">
        <c:if test="${ empty sessionScope.user }">
            <a href="pages/users/login.jsp">登录</a> |
            <a href="pages/users/regist.jsp">注册用户</a>
        </c:if>
        <c:if test="${ not empty sessionScope.user }">
            <span>用户:&nbsp;<span class="um_span">${ sessionScope.user.username }</span></span>
            <a href="order/userOrderServlet?action=paging">查看订单</a> |
            <a href="client/cartServlet?action=paging&page_Size=5">购物车</a> |
            <a href="userServlet?action=logout">注销登录</a> |
            <a href="">返回主页</a>
            <c:if test="${sessionScope.user.permission == 1}">
               &nbsp;|&nbsp;<a href="admin/bookServlet?action=pages&page_Size=5">管理页</a>
            </c:if>
        </c:if>
    </div>
</div>
