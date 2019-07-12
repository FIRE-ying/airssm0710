<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>检索空气质量监测信息库</title>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
       $(function () {
           $(" #a2 tr  :even").css("background-color","gray")
           $(" #a2 tr  :odd").css("background-color","white")
       })

    </script>


</head>
<body>
<div style="width=800px">
<form action="/weather/findall" method="post">

      <table border="1" cellspacing="0" width="800px" >
             <tr>
                  <td colspan="4" align="center"><h1 >空气质量监测信息库</h1></td>
             </tr>
             <tr>
                  <td align="right">按区域查询</td>
                  <td>
                  <select name="districtId">
                      <option value="-1">不限</option>
                      <c:forEach items="${districtlist}" var="d">
                      <option value="${d.id}" ${d.id==districtId?'selected':''}>${d.name}</option>
                      </c:forEach>
                  </select>
                  </td>
                  <td><input type="submit" value="查找" ></td>
                  <td><a href="/weather/finddistrict">添加空气质量信息</a></td>
             </tr>
      </table>
</form>
</div>
<div id="a2" style="width:800px">
        <table border="1" cellspacing="0"  width="800px" class="a">
             <tr>
                <td align="center"><strong>序号</strong></td>
                <td align="center"><strong>区域</strong></td>
                <td align="center"><strong>监测时间</strong></td>
                <td align="center"><strong>PM10数据</strong></td>
                 <td align="center"><strong>PM2.5数据</strong></td>
                 <td align="center"><strong>监测站</strong></td>
             </tr>
             <c:forEach items="${pageInfo.list}" var="air" varStatus="sta">
                 <c:forEach items="${air.districtList}" var="dist">

              <c:if test="${pageInfo.total>0}">
             <tr align="center">
                  <td>${sta.count}</td>
                  <td><a href="/weather/findbyid?id=${air.id}">${dist.name}</a></td>
                  <td><fmt:formatDate value="${air.monitorTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                  <td>${air.pm10}</td>
                 <td>${air.pm25}</td>
                 <td>${air.monitoringStation}</td>
             </tr>
              </c:if>
             </c:forEach>
             </c:forEach>
             <tr>
                  <td colspan="6" align="right">
                      <a href="/weather/findall?districtId=${districtId}">首页</a>|
                       <a href="/weather/findall?index=${pageInfo.prePage==0?1:pageInfo.prePage}&districtId=${districtId}"><< 上一页</a>|
                        <a href="/weather/findall?index=${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}&districtId=${districtId}">下一页 >> </a>|
                         <a href="/weather/findall?index=${pageInfo.pages}&districtId=${districtId}">尾页</a>&nbsp;&nbsp;&nbsp;
                         第${pageInfo.pageNum}页 /  共 ${pageInfo.pages}页    (${pageInfo.total}条)
                  </td>
             </tr>
        </table>
</div>
<c:if test="${pageInfo.total==0}">
    <tr>
        <td colspan="6" align="center">
            抱歉，暂无数据！
        </td>
    </tr>
</c:if>
</body>
</html>