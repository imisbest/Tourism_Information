<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${path}/css/style.css">
    <style>
        form {
            width: 270px;
        }

        input {
            width: 70%;
            background: #eee;
        }

        input:focus {
            background: #fff;
        }

        form {
            padding: 0 12px 12px;
        }

        label {
            display: block;
            padding-bottom: 12px;
        }

        .label-text {
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
        <img src="../img/timg.jpg" style="float: right;height: 320px">
        <h2>修改省份</h2>
        <form action="${path}/pro/pro_updateOver?pid=${province.id}" method="post" onsubmit="return check()">                <script type="text/javascript">                    function check() {                        var nn = document.getElementsByClassName('inputgri');                        for (var i = 0; i < nn.length; i++) {                            if (!nn[i].value) {                                alert("有空值，请检查之后在重新提交");                                return false;                            }                        }                       /* var b = window.confirm("请确认提交是否提交表单");                        if (b) {*/                            return true;                      /*  } else {                            return false;                        }*/                    }                </script>
            <label>
                <div class="label-text">省&emsp;份：</div>
                <input type="text" name="province.province" value="${province.province}"  class="inputgri">
            </label>
            <label>
                <div class="label-text">标&emsp;签：</div>
                <input type="text" name="province.taglib" value="${province.taglib}" class="inputgri">
            </label>
            <button type="submit">提 交</button>&emsp;
            <a href="${path}/pro/pro_queryAndPage?currPage=1&pid=${province.id}">返回</a>
        </form>
    </div>
    <div id="footer">
        ABC@126.com
    </div>
</div>
</body>
</html>