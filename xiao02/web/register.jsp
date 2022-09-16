<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>
<div class="sign_background">
    <div class="sign_background_in">
        <div class="sign_background_no1">
            <a href="index.html"><img src="img/logo.jpg" alt=""></a>
        </div>
        <div class="sign_background_no2">注册小米帐号</div>
           <div class="sign_background_no3">
        	<font color='red'></font>
            <div class="sign_background_no5">
             	<!-- enctype="multipart/form-data" -->
             	<form id="f4"  method="post"
					  action="${pageContext.request.contextPath}/userServlet">
					<input type="hidden" name="mark" value="register">
         
					<table style="width: 500px;" border="0" cellspacing="0">
             			<tr>
             				<td width="25%" class="_left">姓名：</td>
             				<td><input type="text" name="name"><span id="s_name"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">性别：</td>
             				<td>
             					男<input type="radio" name="sex" checked="checked" value="1">
             				 	女<input type="radio" name="sex" value="0">
							</td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">电话号码：</td>
             				<td><input type="text" id="phone_number" name="phone_number" ><span id="s_phone_number"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">所在地区：</td>
             				<td><input type="text" name="area"></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">用户名：</td>
             				<td><input type="text" id="username" name="username" ><span id="s_username"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">密码：</td>
             				<td><input type="password" id="password" name="password" ><span id="s_password"></span></td>
             			</tr>

             		</table>
             		<div class="sign_background_no6" id="btn" onclick="register()">立即注册</div>
             	</form>
             	 
            </div>
        </div>
        <div class="sign_background_no7">注册帐号即表示您同意并愿意遵守小米 <span>用户协议</span>和<span>隐私政策</span> </div>


    </div>
    <div class="sign_background_no8"><img src="img/sign01.jpg" alt=""></div>
	<script>
		function register(){
			//提交form表单
			$("#f4").submit();

		}

	</script>

</div>
</body>
</html>