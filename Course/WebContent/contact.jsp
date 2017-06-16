<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/contact/update" method="post">
   <table>
      <tr><td>姓名：</td><td><input type="text" name="contact.name" value="${STUDENT.contact.name}"/></td></tr>
      <tr><td>关系：</td><td><input type="text" name="contact.relation"></td></tr>
      <tr><td>性别：</td><td>
         <s:radio list="#{'0':'男','1':'女' }" name="contact.sex"></s:radio>
      </td></tr>
      <tr><td>电话：</td><td><input type="text" name="contact.phone"/></td></tr>
      <tr><td colspan="2"><input type="submit" value="提交"/></td></tr>
   </table>
</form>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/main.jsp">返回主页</a>
</body>
</html>