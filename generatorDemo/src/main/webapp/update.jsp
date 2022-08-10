<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/8/10
  Time: 8:25
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
    let lid = localStorage.getItem("id");
    $(function (){
        //doc
        $.ajax({
            url:"doc?m=queryA",
            data:{id:lid},
            dataType:"json",
            success:function (o){
                $("#name").val(o.name);
                $("#hosid").val(o.hospital.hid);
                $("#address").val(o.address);
                $(".sex1[value="+o.sex+"]").prop("checked",true);
                $(".hoses[value="+o.hospital.id+"]").prop("checked",true);
            }
        });

        //提交
        $("#btn").click(function () {

            $.ajax({
                url: "doc?m=update",
                // 提交全部带有name属性的数据
                data: $("#f").serialize(),
                type: "post",
                dataType: "json",
                success: function (obj) {
                    if (obj) {
                        location = "view.jsp"
                    }
                }

            });
        })


    })



</script>
<body>
<form id="f">
    <input type="hidden" id="id" name="id">
    姓名: <input type="text" name="name" id="name"><br>
    性别: <input type="radio" name="sex" class="sex1" value="男">男
    <input type="radio" name="sex" class="sex1" value="女">女<br>

    家庭住址:<input type="text" id="address" name="address">

    <br>

    所在医院:<input type="radio" name="hid" class="hoses" value="1">大医院
    <input type="radio" name="hid" class="hoses" value="2">小医院
    <input type="radio" name="hid" class="hoses" value="3">中医院
    <input type="radio" name="hid" class="hoses" value="4">医院
    <br>

    <input type="button" value="提交" id="btn">
</form>


</body>
</html>
