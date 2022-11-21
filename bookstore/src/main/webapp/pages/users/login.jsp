<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <title>用户登录</title>
    <link type="text/css" rel="stylesheet" href="res/css/login_style.css">
</head>

<body>
<c:if test="${ not empty sessionScope.user }">
    <jsp:forward page="/client/clientServlet?action=paging"></jsp:forward>
</c:if>
<%@include file="/pages/common/header.jsp" %>

<div class="login_banner">
    <div id="login_content">
        <span>欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="title">
                    <h1>书城会员</h1>
                    <a href="pages/users/regist.jsp">立即注册</a>
                </div>

                <div class="msg_content">
                    <b></b>
                    <span class="errorMsg">
<%--                            <%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
                            ${ empty requestScope.msg ? "请输入用户名和密码":requestScope.msg}
                        </span>
                </div>

                <div class="form">
                    <form action="userServlet?action=login" method="post">
<%--                        <input type="hidden" name="action" value="login">--%>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               value="${ requestScope.username }"
                               autocomplete="off" tabindex="1" name="username" id="username"/>
                        <br/>
                        <br/>

                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>

                        <%@include file="/pages/common/verification_code.jsp" %>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>

</html>