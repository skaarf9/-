<%--
  Created by IntelliJ IDEA.
  User: skaarf9
  Date: 2020/10/19
  Time: 18:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单模块</title>
    <link rel="stylesheet" href="css/order.css" type="text/css">
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/myAjax.js"></script>
    <script type="text/javascript" src="js/oder.js"></script>
</head>
<body>
<div class="loginUser">欢迎XXX</div>
<input type="button" class = "return" value="返回">
<label class="searchBox">
    搜索<input type="text" class="search">
</label>
<span class="title"><h1>订单管理</h1></span>
<input type="button" class = "add" value="添加">
<table class="resultBox">
    <thead>
    <tr class="tHead">
        <th>ID</th>
        <th>货物名</th>
        <th>数量</th>
        <th>支付状态</th>
        <th>交付时间</th>
        <th>交付地点</th>
        <th>交付状态</th>
    </tr>
    </thead>
    <tbody class="data">
    <tr>
        <td>测试数据</td>
        <td>QQ星</td>
        <td>2</td>
        <td>N</td>
        <td>???</td>
        <td>????</td>
        <td>Y</td>
    </tr>
    </tbody>
</table>
<footer>成都信息工程大学</footer>
</body>
</html>
