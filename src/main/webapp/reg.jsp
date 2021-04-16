<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8"
isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${path}/css/style.css">
    <style>
        form{
            width:270px;
        }
        input{
            width: 70%;
            background: #eee;
        }
        input:focus{
            background: #fff;
        }
        form{
            padding: 0 12px 12px;
        }
        label{
            display: block;
            padding-bottom:12px;
        }
        #img-vcode{
            width: 56px;
            height: 21px;
            float:right;
            position: relative;
            top:2px;
            left:-6px
        }
        .label-text{
            width: 30%;
            float: left;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <div id="header">
            <div style="float: right;padding-top: 24px"><%@ page import="java.util.*"%> <%@ page import="java.text.*"%><%    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%> <br/> <br/></div>
            <h1>旅游信息管理系统</h1>
        </div>
        <div id="header-bar"></div>
        <div id="content" style="height: 360px">
            <img src="img/timg.jpg" style="float: right;height: 320px">
            <h2>注册</h2>
            <form action="${path}/user/user_regist" method="post" onsubmit="return check()">                <script type="text/javascript">                    function check() {                        var nn = document.getElementsByClassName('inputgri');                        for (var i = 0; i < nn.length; i++) {                            if (!nn[i].value) {                                alert("有空值，请检查之后在重新提交");                                return false;                            }                        }                       /* var b = window.confirm("请确认提交是否提交表单");                        if (b) {*/                            return true;                      /*  } else {                            return false;                        }*/                    }                </script>
                <label>
                    <div class="label-text">账&emsp;号：</div>
                    <input type="text" name="user.username">
                </label>
                <label>
                    <div class="label-text">密&emsp;码：</div>
                    <input type="password" name="user.password">
                </label>
                <label>
                    <div class="label-text">邮&emsp;箱：</div>
                    <input type="text" name="user.email">
                </label>
                <img src="${path}/user/captcha" id="captchaImg" />
                <label>
                    <div class="label-text">验证码：</div>
                     <input type="text" name="captchaCode"><br />
                    <a href="javascript:void(0)"onclick="changeCaptcha()">看不清，换一张!~</a>&nbsp;<span
                        style="color:red">${errorMsg }</span><br />
                    <script type="text/javascript">
                        function changeCaptcha() {
                            // 根据ID获取到验证码图片对象
                            var captchaImg = document.getElementById('captchaImg');
                            captchaImg.src = '${path }/user/captcha?'
                                + Math.random();
                        }
                    </script>
                </label>
                <button type="submit">提 交</button>&emsp;
                <a href="${path}/login.jsp">去登录</a>
            </form>
        </div>
        <div id="footer">
            ABC@126.com
        </div>
    </div>
</body>
</html>