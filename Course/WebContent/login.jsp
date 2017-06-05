<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
登陆页面
<br/>
<br/>
<body>
<form action="${pageContext.request.contextPath }/student/login" method="post">
  <table>
    <tr><td>用户名:</td><td><input type="text" name="student.name"/></td></tr>
    <tr><td>密码:</td><td><input type="password" name="student.pwd"/></td></tr>  
    <tr><td colspan="2"><input type="submit" value="提交"/></td></tr>
  </table>
</form>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/main.jsp">返回主页面</a>
</body>
</html>