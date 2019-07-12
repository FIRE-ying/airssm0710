<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加监测信息</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript">
$(function(){
	 $("form").submit(function(){
		 var a = $("[name='monitorTime']").val();
		 if (a.contains("-")){
		     return true;
         }
         alert("监测日期必须符合日期格式,如:2013-01-01");
         return false;
	 })
});
function a() {

        var b = confirm("确定重置吗？");
        if (b==true) {
            location.href = '/weather/finddistrict';
        }else{

        }

}
</script>
</head>
<body>
<form action="/weather/addair" method="post">
      <table border="1" cellspacing="0" width="50%">
             <tr>
                 <td colspan="2" align="center"><h1 style="color:blue">添加空气质量信息</h1></td>
             </tr>
             <tr >
                 <td align="right"><strong>监测区域：</strong></td>
                 <td>
                      <select name="districtId">
                          <option value="-1">请选择</option>
                      <c:forEach items="${districts}" var="d">
                          <option value="${d.id}">${d.name}</option>
                      </c:forEach>
                      </select>
                 </td>
             </tr>
             <tr >
                 <td align="right"><strong>监测日期：</strong></td>
                 <td><input type="text" name="monitorTime"></td>
             </tr>
             <tr >
                 <td align="right" valign="top"><strong>PM10值：</strong></td>
                 <td><input type="text"  name="pm10"></td>
             </tr>
          <tr >
              <td align="right" valign="top"><strong>PM25值：</strong></td>
              <td><input type="text"  name="pm25"></td>
          </tr>
          <tr >
              <td align="right"><strong>监测站：</strong></td>
              <td><input type="text" name="monitoringStation"></td>
          </tr>
             <tr align="center" >
                 <td colspan="2">
                     <input type="submit" value="保存">
                     <input type="button"  value="重置" onclick="/*javascript:window.location.href='/weather/finddistrict'*/a()">
                     <input type="button" value="放弃" onclick="javascript:window.location.href='/weather/findall'">
                 </td>
             </tr>
      </table>
</form>
</body>
</html>