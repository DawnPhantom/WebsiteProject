<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/3
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<meta charset="UTF-8">
<%
    String basePath = request.getScheme() + "://"
                    + request.getServerName() + ":"
                    + request.getServerPort()
                    + request.getContextPath() + "/";
%>
<base href=<%=basePath%>>
<link type="text/css" rel="stylesheet" href="res/css/common/common.css">
<script type="text/javascript" src="res/script/jquery-1.7.2.js"></script>
