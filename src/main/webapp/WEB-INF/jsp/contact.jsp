<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎页-集成R语言的数据挖掘平台</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/navbar-fixed-top.css" rel="stylesheet">
  </head>
  <body>
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">RDMP</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.do">首页</a></li>
            <li><a href="about.do">关于</a></li>
            <li class="active"><a href="contact.do">联系我们</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">功能导航 <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">分类</a></li>
                <li><a href="#">聚类</a></li>
                <li><a href="#">预测</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">其它</li>
                <li><a href="#">时间序列</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="userInfo.do">${sessionScope.userName}</a></li>
            <li><a href="loginOut.do">注销</a></li>
          </ul>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="jumbotron">
      	所属：中国科学技术大学<br />
      	地址：江苏省苏州市吴中区仁爱路166号<br />
      </div>
    </div>
    <script src='js/jquery-1.11.0.min.js'></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>