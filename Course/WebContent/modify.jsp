<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息页面</title>
</head>
<body>
修改页面
<br/>
<br/>
<s:if test="#session.STUDENT==null">
   <jsp:forward page="${pageContext.request.contextPath }/login.jsp"></jsp:forward>
</s:if>
<form action="${pageContext.request.contextPath }/student/register" method="post">
<table>
  <tr><td>用户名:</td><td><input type="text" name="student.name" value="${STUDENT.name }"/></td></tr>
  <tr><td>旧密码:</td><td><input type="password" name="oldpwd"/></td></tr>
  <tr><td>新密码:</td><td><input type="password" name="student.pwd"/></td></tr>
  
  <tr>
     <td>重复新密码:</td>
     <td><input type="password" id="pwd1"/></td>
  </tr>
  <tr>
     <td>性别:</td>
     <td>
         <s:radio list="#{'1':'男','2':'女' }" name="student.sex" value="#session.STUDENT.sex">
         </s:radio>
     </td>
  </tr>
  <tr>
     <td>年级:</td>
     <td>
        <select name="student.grade">
           <option value="一年级">一年级</option>
           <option value="二年级">二年级</option>
           <option value="三年级">三年级</option>
           <option value="四年级">四年级</option>
        </select>
     </td>
  </tr>
  <tr><td colspan="2"><input type="submit" value="提交"/></td></tr>
</table>
</form>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/main.jsp">返回主页</a>
</body>
</html>