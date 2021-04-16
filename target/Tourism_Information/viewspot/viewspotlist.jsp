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

        tbody tr:nth-child(4n), tbody tr:nth-child(4n-1) {
            background: #f2f2f2;
        }

        #pages {
            text-align: center;
            padding: 8px 0;
        }

        .page {
            min-width: 50px;
            display: inline-block;
        }

        .viewspotimg {
            width: 135px;
            height: 135px;
            margin-left: -10px;
            display: block;
            object-fit: cover;
        }
    </style>
</head>
<body>
<div id="wrap">
    <div id="header">
        <div style="float: right;padding-top: 24px">
            <%@ page import="java.util.*"%> <%@ page import="java.text.*"%><%    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%> <br/> <br/>&emsp;
            <a href="${path}/user/safe" style="color:#fff;float: right">安全退出</a>
        </div>
        <h1>旅游信息管理系统</h1>
    </div>
    <div id="header-bar"></div>
    <div id="content">
        <h2>${province.province }景点列表</h2>
        <table>
            <thead>
            <tr>
                <th width="14%">ID</th>
                <th width="20%">景点</th>
                <th width="12%">印象图</th>
                <th width="16%">旺季时间</th>
                <th width="10%">旺季门票</th>
                <th width="10%">淡季门票</th>
                <th width="18%">操作</th>
            </tr>
            </thead>
            <c:forEach items="${scenicList}" var="p">
            <tbody>
            <tr>
                <td rowspan="2">${p.id}</td>
                <td rowspan="2">${p.scenic}</td>
                <td><img src="${path}/img/${p.cover}" class="viewspotimg"></td>
                <td>${p.peakSeason}</td>
                <td>${p.hprice}</td>
                <td>${p.lprice}</td>
                <td style="text-align: center">
                    <a href="${path}/sce/sce_deleteView?pid=${p.id}">删除景点</a><br>
                    <a href="${path}/sce/sce_updateFirst?pid=${p.id}">修改景点</a>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <div style="height: 56px;font-size: 14px;line-height: normal">
                        <b style="color:#467aa7">简介：</b>${p.introduction}
                    </div>
                </td>
            </tr>

            </tbody>
            </c:forEach>
        </table>
        <a href="${path}/sce/sce_addFirst">
            <button type="button">添加景点</button>
        </a>&emsp;
        <a href="${path}/pro/pro_queryAndPage?currPage=1">返回省份列表</a>
        <div id="pages">
            <!--分页导航开始-->
            <!-- //首页 -->
            <center>
                <a
                        href="${path }/sce/sce_queryAndPage?currPage=1" style="text-decoration: none">
                    <input type="button" value="首页"> &nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //上一页 -->

                <a
                        href="${path }/sce/sce_queryAndPage?currPage=${currPage-1}" style="text-decoration: none">
                    <input type="button" value="上一页"> &nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //当前页 -->

                <%-- <c:forEach begin="1" end="${countPage}" var="i"> --%>
                <a
                        href="${path }/sce/sce_queryAndPage?currPage=${currPage}" style="text-decoration: none">当前第${currPage}/${countPage}页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <%-- </c:forEach> --%>


                <!-- //下一页 -->

                <a
                        href="${path }/sce/sce_queryAndPage?currPage=${currPage+1}" style="text-decoration: none">
                    <input type="button" value="下一页">&nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //最后一页 -->
                <a href="${path }/sce/sce_queryAndPage?currPage=${countPage}" style="text-decoration: none">
                    <input type="button" value="尾页">&nbsp;&nbsp;&nbsp;&nbsp;
                </a>
                <!--分页导航结束-->
        </div>
    </div>
    <div id="footer">
        ABC@126.com
    </div>
</div>
</body>
</html>