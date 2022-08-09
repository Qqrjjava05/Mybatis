<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/8/9
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="jquery/jQuery-v3.6.0.js"></script>
<script>
    $(function () {
        //添加
        $("#btn").click(function () {

            $.ajax({
                url: "doc?m=insert",
                data: $("#f").serialize(),
                dataType:"json",
                success: function (o) {
                    if(o){
                        location.reload();
                    }
                }

            });
        })




    });
</script>
<body>

<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>地址</th>
        <th>所在医院</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="doc">
        <tr>
            <td>${doc.id}</td>
            <td>${doc.name}</td>
            <td>${doc.sex}</td>
            <td>${doc.address}</td>
            <td>${doc.hospital.name}</td>
            <td></td>
        </tr>
    </c:forEach>
</table>
<br/>
<h2>添加医生</h2>
<form id="f">
    <input type="hidden" name="id" id="id">
    姓名: <input type="text" name="name" id="name"><br>
    性别: <input type="radio" name="sex" class="sex1" value="男">男
    <input type="radio" name="sex" class="sex1" value="女">女<br>

    家庭住址:<input type="text" id="address" name="address">

<br>

    所在医院:<input type="radio" name="hid" class="hoses" value="1" >大医院
        <input type="radio" name="hid" class="hoses" value="2" >小医院
        <input type="radio" name="hid" class="hoses" value="3" >中医院
        <input type="radio" name="hid" class="hoses" value="4" >医院
<br>

    <input type="button" value="提交" id="btn">
</form>
</body>
</html>
