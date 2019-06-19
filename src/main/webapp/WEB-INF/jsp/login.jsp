<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title> HR医院人事管理系统 - 登录</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css" rel="stylesheet">
	<link href="<%=path %>/css/login.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
    	<meta http-equiv="refresh" content="0;ie.html" />
    	<![endif]-->
    <script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>    
    <script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>  
	<script  type="text/javascript">
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
	   	// 刷新验证码
	    function changeImg() {	    	
	   	    var imgSrc = $("#captchaImage");	   	    
	   	    imgSrc.attr("src", chgUrl());
	   	}
	   	//时间戳   
	   	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
	   	function chgUrl() {
	   		var timestamp = (new Date()).valueOf();
	   	  	var url = "<%=path %>"+"/captcha.jpg";
	   	  	if ((url.indexOf("&") >= 0)) {
	   	    	url = url + "×tamp=" + timestamp;
	   	  	} else {
	   	    	url = url + "?timestamp=" + timestamp;
	   	  	}
	   	  	return url;
	   	}       

    </script>

</head>
<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-12">			
			 	<form id="form"  >
					<h4 class="no-margins">
						<font color="#6C6C6C">登录：</font>
					</h4>
					<p class="m-t-md">
						<font color="#6C6C6C">欢迎登录人事管理系统</font>
					</p>
					<div class="form-group">
						<input type="text" class="form-control uname" placeholder="用户名" name="username" id="username" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control pword m-b" placeholder="密码" name="password" id="password" />
					</div>
					<div class="form-group">
					
					 	 <input type="text" id="captcha"  class="form-control"  style="width: 100%;" placeholder="验证码"   maxlength="6" name="captcha" />
	       			</div>	  	
	       			<div class="form-group">
   			     		 <img title="点击刷新验证码"   id="captchaImage"  src="<%=path %>/captcha.jpg" onclick="changeImg()"/>
	       			</div>	
	       			<div class="form-group">
	                    <div class="pull-left">
	                        <label class="rememberme mt-checkbox mt-checkbox-outline">
	                            <input type="checkbox" name="isRememberMe" id="isRememberMe" value="1" />
	                            <span>记住我</span>
	                        </label>
	                    </div>
	                </div>
	                <br>
					<p>
					  <h3 style="color: red">${error}</h1>
					</p>
					<button class="btn btn-success btn-block" type="button"  id="but">登录</button>
				</form>
			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">&copy; XX医院</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$("#but").click(function (){
			var username = $("#username").val();//获取表单的输入值;
			var password = $("#password").val();//获取表单的输入值;
			var captcha = $("#captcha").val();
			var isRememberMe = $("#isRememberMe").val();
			var formArray =$("#form").serializeArray();
		$.ajax({
			type: "POST",
			url: "/checkLogin",
			data:JSON.stringify({"username":username,"password":password,"captcha":captcha,"isRememberMe":isRememberMe}),
			//{"username":username,"password":password,"captcha":captcha,"isRememberMe":isRememberMe},
			dataType: "json",
			contentType: "application/json;charset=utf-8",
			cache: false,
			success: function(result) {
				if (result.code == 500) {
					window.alert(result.msg);
					location.reload(true);
				} else if (result.code==0) {
					window.location.href = "/admin/index1";
				} else if (result.msg == index2) {
					window.location.href = "/admin/index2";
				} else if (result.msg == index3) {
					window.location.href = "/admin/index3";
				} else if (result.msg == index4) {
					window.location.href = "/admin/index4";
				}
			}
			});
		});
	</script>
</body>
</html>
