<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息页面</title>
<style type="text/css">
#pic
{
   width: 300px;
}
</style>
<script type="text/javascript" src="jqlib/jquery-1.11.1.js"></script>
<script type="text/javascript">
$(function (){
	$("[name='image']").change(function(){
		$("#pic").attr("src",$(this).val());
	});
	$("[type='submit']").click(function(){
		var flag=true;
		$.ajax({
			type:"POST",
			async:false,
			url:"${pageContext.request.contextPath}/student/checkpwd",
			data:{"student.id":"${STUDENT.id}","student.pwd":$("#oldpwd").val()},
			success:function(data){
				if(data=="0"){
					$("#msg").html("旧密码输入错误!");
					flag=false;
				}
			}
		});
		if(!flag){
			return flag;
		}
		if($.trim($("[name='student.pwd']").val()).length==0){
			alert("ok");
			$("#msg").html("请输入新密码!");
			return false;
		}
		var p1=$("[name='student.pwd']").val();
		var p2=$("#pwd1").val();
		if(p1!=p2){
			$("#msg").html("两次输入密码不一致!");
			return false;
		}
	});
});
</script>
</head>
<body>
修改页面
<br/>
<br/>
<s:if test="#session.STUDENT==null">
   <jsp:forward page="${pageContext.request.contextPath }/login.jsp"></jsp:forward>
</s:if>
	<table>
		<tr>
			<td width="550">
<form action="${pageContext.request.contextPath }/student/update" enctype="multipart/form-data" method="post">
<table>
  <tr><td>用户名:</td><td><input type="text" name="student.name" value="${STUDENT.name }"/>
  <input type="hidden" name="student.id" value="${STUDENT.id }"/>
  </td></tr>
  <tr><td>旧密码:</td><td><input type="password" id="oldpwd"/></td></tr>
  <tr><td>新密码:</td><td><input type="password" name="student.pwd" value="${STUDENT.pwd }"/></td></tr>
  
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
        <s:select name="student.grade" list="#{'0':'一年级','1':'二年级','2':'三年级','3':'四年级'}" value="#session.STUDENT.grade">
        </s:select>
     </td>
  </tr>
  <tr>
    <td>电话号码:</td><td><input type="text" name="student.phone" value="${STUDENT.phone}"/>
  </tr>
  <tr>
     <td>照片:</td><td><input type="file" name="image" />
        <input type="hidden" name="student.photo" value="${STUDENT.photo }"/>
     </td>
  </tr>
  <tr><td colspan="2"><input type="submit" value="修改"/></td></tr>
</table>
</form>
</td>
	<td width="257">
	<s:if test="#session.STUDENT.photo==null">
	  <img src="images/th.jpeg" id="pic"/>
	</s:if>
	<s:else>
	  <img src="${STUDENT.photo }" id="pic"/>
	</s:else>
	</td>
</tr>	
</table>
</body>
<br/>
<br/>
<div id="msg"></div>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/main.jsp">返回主页</a>
</html>