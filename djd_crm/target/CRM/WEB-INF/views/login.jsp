<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>xxx关系管理系统</title>
<link rel="stylesheet" href="/static/css/style.css">
    <%@include file="common.jsp"%>
    <script type="application/javascript">
        //页面加载完毕后
        $(function(){
            //监听按钮点击事件
            $("#submitBtn").on("click",function () {
                $("#loginForm").form("submit",{
                    url:"/login",
                    success:function (data) {
                        console.log(data);
                        //把接口返回的字符串转化为json
                        data = $.parseJSON(data);
                        if(data.success){
                            window.location.href = "/main";
                        }else{
                            $.messager.alert("温馨提示:","登录失败","error");
                        }
                    }
                });
            })
        })
    </script>
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form id="loginForm" method="post">
        <p><input type="text" name="username" value="" placeholder="账号"></p>
        <p><input type="password" name="password" value="" placeholder="密码"></p>
        <p class="submit">
        	<input type="button" id="submitBtn" value="登录">
        	<input type="button" id="resetBtn" value="重置">
        </p>
      </form>
    </div>
  </section>
</body>
<div style="text-align:center;" class="login-help">
	<p>xxxxx有限公司</p>
</div>

</html>