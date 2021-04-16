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
            width: 64%;
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
            width: 36%;
            float: left;
        }

        #img-show {
            width: 135px;
            height: 135px;
            display: block;
            margin: 0 auto;
            object-fit: cover;
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
    <div id="content" style="height: 410px">
        <img src="../img/timg.jpg" style="float: right;height: 320px">
        <h2>修改景点</h2>
        <form action="${path}/sce/sce_updateView?pid=${scenic.id}"  enctype="multipart/form-data" method="post" onsubmit="return check()">                <script type="text/javascript">                    function check() {                        var nn = document.getElementsByClassName('inputgri');                        for (var i = 0; i < nn.length; i++) {                            if (!nn[i].value) {                                alert("有空值，请检查之后在重新提交");                                return false;                            }                        }                       /* var b = window.confirm("请确认提交是否提交表单");                        if (b) {*/                            return true;                      /*  } else {                            return false;                        }*/                    }                </script>
            <label>
                <div class="label-text">景&emsp;&emsp;点：</div>
                <input type="text" name="scenic.scenic" value="${scenic.scenic}" class="inputgri">
            </label>
            <label>
                <div class="label-text">印象图片：</div>
                <div style="text-align: center;padding-left: 36%">
                    <img src="${path}/img/${scenic.cover}" alt="" id="img-show">
                    <input type="file" name="cover" id="imgfile" style="display: none" onchange="imgfileChange()">
                </div>
                <script>
                    function imgfileChange() {
                        var img_show = document.getElementById("img-show");
                        var imgfile = document.getElementById("imgfile");

                        var freader = new FileReader();
                        freader.readAsDataURL(imgfile.files[0]);
                        freader.onload = function (e) {
                            img_show.src = e.target.result;
                        };
                    }
                </script>
            </label>
            <label>
                <div class="label-text">旺季时间：</div>
                <input type="text" name="scenic.peakSeason" value="${scenic.peakSeason}" class="inputgri">
            </label>
            <label>
                <div class="label-text">旺季门票：</div>
                <input type="text" name="scenic.hprice" value="${scenic.hprice}" class="inputgri">
            </label>
            <label>
                <div class="label-text">淡季门票：</div>
                <input type="text" name="scenic.lprice" value="${scenic.lprice}" class="inputgri">
            </label>
            <label>
                <div class="label-text">所属省份：</div>
                <select name="scenic.sid">
                 <c:forEach items="${provinceList}" var="p">
                         <c:if test="${(scenic.sid).equals(p.id)}">
                             <option value="${p.id}" selected="selected">${p.province}</option>
                         </c:if>
                         <c:if test="${!(scenic.sid).equals(p.id)}">
                             <option value="${p.id}">${p.province}</option>
                         </c:if>
                     </c:forEach>
                  <%--  <c:forEach items="provinceList" var="p">
                        <option VALUE=""></option>
                        <option value="${p.id}">${p.province}</option>
                    </c:forEach>--%>
                </select>
            </label>
            <button type="submit">提 交</button>&emsp;
            <a href="${path}/sce/sce_queryAndPage?currPage=1">返回</a>
        </form>
    </div>
    <div id="footer">
        ABC@126.com
    </div>
</div>
</body>
</html>