<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>空气质量信息维护</title>
</head>
<body>
<form action="/weather/updateair" method="post">
<input type="hidden" name="id" value="${airQualityIndex.id}">
     <table border="1" cellspacing="0" width="50%">
             <tr >
                 <td align="right"><strong>监测区域：</strong></td>
                 <td>
                      <select name="districtId">
                      <c:forEach items="${districtList}" var="d">
                          <option value="${ d.id}" ${d.id==airQualityIndex.districtId?'selected':'' }>${d.name}</option>
                     </c:forEach>
                      </select>
                 </td>
             </tr>
             <tr >
                 <td align="right"><strong>监测日期：</strong></td>
                 <td><input type="text" name="monitorTime" value="<fmt:formatDate value="${airQualityIndex.monitorTime}" pattern="yyyy-MM-dd"></fmt:formatDate> "></td>
             </tr>
             <tr >
                 <td align="right" valign="top"><strong>PM10值</strong></td>
                 <td><input type="text"  name="pm10" value="${airQualityIndex.pm10}"></td>
             </tr>
         <tr >
             <td align="right" valign="top"><strong>PM25值</strong></td>
             <td><input type="text"  name="pm25" value="${airQualityIndex.pm25}"></td>
         </tr>
         <tr >
             <td align="right"><strong>监测站</strong></td>
             <td><input type="text" name="monitoringStation" value="${airQualityIndex.monitoringStation}"></td>
         </tr>
             <tr align="center">
                  <td colspan="2">最后修改时间：<fmt:formatDate value="${airQualityIndex.lastModifyTime}"
 pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
             </tr>
             <tr align="center" >
                 <td colspan="2">
                     <input type="submit" value="保存">
                     <input type="button"  value="删除" onclick="javascript:window.location.href='/weather/deleteair?id=${airQualityIndex.id}'">
                     <input type="button" value="返回" onclick="javascript:window.location.href='/weather/findall'">
                 </td>
             </tr>
      </table>
</form>
</body>
</html>
