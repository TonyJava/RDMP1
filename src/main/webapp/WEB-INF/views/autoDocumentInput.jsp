<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("gb2312"); %>

<form class="form-signin" role="form" action="autoDocument" method="post">
	<h4 class="form-signin-heading">ʹ�����ر�Ҷ˹�㷨�������Զ�����</h4>
	<textarea id="article" cols="300" name="article" type="text" class="form-control" placeholder="��������������" required autofocus ></textarea><br />
	<button class="btn btn-lg btn-primary btn-block" type="submit">�Զ�����</button>
</form>