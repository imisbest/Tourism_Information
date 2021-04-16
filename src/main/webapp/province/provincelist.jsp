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
        table {
            width: 100%;
            margin-bottom: 15px;
            border-collapse: collapse;
            table-layout: fixed;
        }

        th, td {
            border: 1px solid #CBD6DE;
            padding-left: 10px;
            line-height: 28px;
        }

        th {
            text-align: left;
            background: linear-gradient(#edf2f5, #dce9f2, #edf2f5);
            color: #467aa7;
        }

        tbody tr:nth-child(even) {
            background: #f2f2f2;
        }

        #pages {
            text-align: center;
            padding-top: 8px;
        }

        .page {
            min-width: 50px;
            display: inline-block;
        }
    </style>
</head>
<body>
<div id="wrap">
    <div id="header">
        <div style="float: right;padding-top: 24px">
            <%@ page import="java.util.*"%> <%@ page import="java.text.*"%><%    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%> <br/> <br/>&emsp;
            <a href="${path}/user/user_safeOut" style="color:yellow;float: right"><input type="button"  value="安全退出" style="background-color: yellow"></a>
        </div>
        <h1>旅游信息管理系统</h1>
    </div>
    <div id="header-bar"></div>
    <div id="content" style="height: 360px">
        <h2>省份列表</h2>
        <table>
            <thead>
            <tr>
                <th width="15%">ID</th>
                <th width="20%">省份</th>
                <th width="25%">标签</th>
                <th width="15%">景点个数</th>
                <th width="25%">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${provinceList}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.province}</td>
                <td>${p.taglib}</td>
                <td>${p.spots}</td>
                <td>
                    <a href="${path}/pro/pro_deleteAction?pid=${p.id}">删除省份</a>
                    <a href="${path}/sce/sce_queryAndPage?currPage=1&pid=${p.id}">景点列表</a>
                    <a href="${path}/pro/pro_updateprovince?pid=${p.id}">修改省份</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="${path}/province/addprovince.jsp">
            <button type="button">添加省份</button>
        </a>
        <div id="pages">
            <!--分页导航开始-->
            <!-- //首页 -->
            <center>
                <a
                        href="${path }/pro/pro_queryAndPage?currPage=1" style="text-decoration: none">
                    <input type="button" value="首页"> &nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //上一页 -->

                <a
                        href="${path }/pro/pro_queryAndPage?currPage=${currPage-1}" style="text-decoration: none">
                    <input type="button" value="上一页"> &nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //当前页 -->

                <%-- <c:forEach begin="1" end="${countPage}" var="i"> --%>
                <a
                        href="${path }/pro/pro_queryAndPage?currPage=${currPage}" style="text-decoration: none">当前第${currPage}/${countPage}页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <%-- </c:forEach> --%>


                <!-- //下一页 -->

                <a
                        href="${path }/pro/pro_queryAndPage?currPage=${currPage+1}" style="text-decoration: none">
                    <input type="button" value="下一页">&nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //最后一页 -->
                <a href="${path }/pro/pro_queryAndPage?currPage=${countPage}" style="text-decoration: none">
                    <input type="button" value="尾页">&nbsp;&nbsp;&nbsp;&nbsp;
                </a>
                <!--分页导航结束-->
            </center>
        </div>
    </div>
    <div id="footer">
        ABC@126.com
    </div>
</div>
</body>
</html>