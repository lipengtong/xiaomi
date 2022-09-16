<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>优就业-小米电商项目</title>
    <meta charset="UTF-8">
    <link rel="icon" href="Images/logo_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: "微软雅黑";
            background: url("img/register123.png");
            background-size: 100%;
            background-repeat: no-repeat;
        }

        .form-signin {
            max-width: 400px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            background: rgba(255,255,255,0.5);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
            font-size: 24px;
            margin-left: 90px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }


        #message{
            font-size: 14px;
            color:red;
            margin-left: 40px;
        }

        .input-block-level{
            width: 300px;
            margin-left: 40px;
        }
        .input-medium{
            margin-left: 40px;
        }
        .code_images{
            width: 115px;
            height: 35px;
            margin-top: -15px;
            margin-left: 10px;
        }
        .error{
            color: red;
            font-size: 12px;
        }

    </style>
</head>
<body>
<div class="container">

    <form  id="tv_form_login" class="form-signin" method="post"
           action="${pageContext.request.contextPath}/userServlet">
        <input type="hidden" name="mark" value="checkLogin">
        <h2 class="form-signin-heading" >登录系统</h2>
        <span id="message" class="message">${msg }</span><br>
        <input type="text" name="username" class="input-block-level" value="" placeholder="账号">
        <input type="password" name="password" class="input-block-level" placeholder="密码" value="">
        <input type="text" name="verify" class="input-medium" placeholder="验证码">
        <img id="code" class="code_images"  src="${pageContext.request.contextPath}/img/3HW7.jpg" />
        <p style="text-align: center;">
            <input id="login" type="button" value="登录" name="login" class="btn btn-large btn-primary" style="width: 150px;"/>
            <a href="register.jsp">请先注册</a>

        </p>
    </form>
</div>
<script type="text/javascript">
       /*给图片点击事件*/
        $("#code").click(function () {
            this.src="${pageContext.request.contextPath}/verifyCodeServlet?date="+new Date();
        });
    //第一次动态生成一张验证码
    function changeCode() {
//根据id来获取节点对象
        var code = document.getElementById("code");
//修改src的属性值
        code.src="${pageContext.request.contextPath}/verifyCodeServlet?date="+new Date();
    }
    //调用方法
    changeCode();

       //登录的验证
       $("#login").click(function () {
           //获取用户名
           var username = $("input[name='username']").val();
           //对用户名进行验证
           if (username ==null || username =="") {
               $("#message").html("用户名不能为空");
               //结束方法
               return;
           }
           //获取密码
           var password =$("input[name='password']").val();
           //对密码进行验证
           if (password ==null || password ==""){
               $("#message").html("密码不能为空");
               //结束方法
               return;
           }
           //获取验证码
           var verify =$("input[name='verify']").val();
           if (verify ==null || verify==""){
               $("#message").html("验证码不能为空");
               //结束方法
               return;
           }
           //发送ajax来验证验证码是否正确
           $.ajax({
               "url":"${pageContext.request.contextPath}/userServlet",
               "type":"post",
               "data":{"mark":"checkCode","code":verify},
               "dataType":"text",
               "success":function (data) {
                   //使用if来进行判断
                   if (data=="true"){
                       //在js中提交form表单
                       $("#tv_form_login").submit();
                   }else {
                       alert("验证码输入不正确");
                   }
               },
               "error":function () {
                   alert("请求失败");
               }
           });

       });





</script>
</body>
</html>