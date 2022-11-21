<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="/pages/common/static.jsp" %>
    <link type="text/css" rel="stylesheet" href="res/css/regist_style.css">
    <title>注册会员</title>

    <script type="text/javascript">
        $(function (){
            $("#username").blur(function (){
                var username = this.value;
                $.getJSON("/bookstore/userServlet?action=ajaxUsernameCheck","username="+username,function(data){
                    console.log(data)
                })
            })
        })
    </script>

    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                //验证用户名
                var usernameText = $("#username").val();
                var usernamePatt = /^\w{6,15}$/;
                if (!usernamePatt.test(usernameText)) {
                    $("span.errorMsg").text("用户名应为6-15位数字/字母");
                    return false;
                } else $("span.errorMsg").text("");

                //验证密码
                var passwordText = $("#password").val();
                var passwordPatt = /^\w{8,18}$/;
                if (!passwordPatt.test(passwordText)) {
                    $("span.errorMsg").text("密码应为8-15位数字/字母");
                    return false;
                } else $("span.errorMsg").text("");

                //确认密码
                var passwordConfirmText = $("#repwd").val();
                if (passwordConfirmText != passwordText) {
                    $("span.errorMsg").text("两次密码输入不一致");
                    return false;
                } else $("span.errorMsg").text("");

                //验证邮箱
                var emailText = $("#email").val();
                var emailPatt = /^[\w]+@[\w]+[.][a-z]+$/;
                if (!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("邮箱格式错误");
                    return false;
                } else $("span.errorMsg").text("");
            })
        })
    </script>
</head>

<body>
<c:if test="${ not empty sessionScope.user }">
    <jsp:forward page="/client/clientServlet?action=paging"></jsp:forward>
</c:if>
<%@include file="/pages/common/header.jsp" %>

<div class="login_banner">
    <div id="login_content">
        <span>欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="title">
                    <h1>注册会员</h1>
                    <span class="errorMsg">
                        ${ empty requestScope.msg ? "":requestScope.msg }
                    </span>
                </div>

                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
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
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               value="${ requestScope.email }"
                               autocomplete="off" tabindex="1" name="email" id="email"/>
                        <br/>
                        <br/>
                        <%@include file="/pages/common/verification_code.jsp" %>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>

</html>