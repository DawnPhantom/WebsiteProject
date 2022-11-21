<%--
  Created by IntelliJ IDEA.
  User: DAWN PHANTOM
  Date: 2022/11/10
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<label>验证码：&nbsp;&nbsp;&nbsp;</label>
<input class="itxt" type="text" autocomplete="off" tabindex="1"
       placeholder="请输入验证码" style="width: 95px;" name="token" id="token"/>
<img alt="图片丢失" src="kaptcha.jpg"
     style="float: right; margin-right: 20px; height: 36px; width: 105px" id="token_img">
<br/>
<br/>

<script type="text/javascript">
    $(function (){
        $("#token_img").click(function (){
            this.src="kaptcha.jpg?" + new Date();
        })
    })
</script>