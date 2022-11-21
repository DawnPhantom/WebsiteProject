<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/6
  Time: 17:44
  管路员页面菜单
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link type="text/css" rel="stylesheet" href="res/css/common/admin.css">
<%@include file="/pages/common/header.jsp" %>
<c:if test="${ empty sessionScope.user }">
  <jsp:forward page="/client/clientServlet?action=paging"></jsp:forward>
</c:if>
<c:if test="${ sessionScope.user.permission != 1 }">
  <jsp:forward page="/client/clientServlet?action=paging"></jsp:forward>
</c:if>
<div id="header" style="margin-bottom: -20px">
  <span class="welcome_word">管理系统</span>
  <div>
    <a href="admin/bookServlet?action=pages">图书管理</a>
    <a href="admin/adminOrderServlet?action=paging">订单管理</a>
    <a href="history/historyServlet?action=paging">浏览历史管理</a>
    <a href="index.jsp">返回商城</a>
  </div>
</div>