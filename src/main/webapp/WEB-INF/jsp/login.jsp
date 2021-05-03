<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="login-content" data-ng-app="materialAdmin">


<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="Generator" content="EditPlus®">
	<meta name="Author" content="">
	<meta name="Keywords" content="">
	<meta name="Description" content="">
	<title>登录页面</title>

	<base href="http://localhost:8080/demo/">

	<!-- Vendor CSS -->
	<link href="css/material-design-iconic-font/css/material-design-iconic-font.min.css" rel="stylesheet" type="text/css">
	<!-- CSS -->
	<link href="css/app.min.1.css" rel="stylesheet" type="text/css">

	<script src="http://www.jq22.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- Angular -->
	<script src="js/bower_components/angular/angular.min.js"></script>
	<script src="js/bower_components/angular-resource/angular-resource.min.js"></script>
	<script src="js/bower_components/angular-animate/angular-animate.min.js"></script>


	<!-- Angular Modules -->
	<script src="js/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
	<script src="js/bower_components/angular-loading-bar/src/loading-bar.js"></script>
	<script src="js/bower_components/oclazyload/dist/ocLazyLoad.min.js"></script>
	<script src="js/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>

	<!-- Common js -->
	<script src="js/bower_components/angular-nouislider/src/nouislider.min.js"></script>
	<script src="js/bower_components/ng-table/dist/ng-table.min.js"></script>

	<!-- Placeholder for IE9 -->
	<!--[if IE 9 ]>
	<script src="js/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
	<![endif]-->
	<!-- App level -->
	<script src="js/app.js"></script>
	<script src="js/controllers/main.js"></script>
	<script src="js/controllers/ui-bootstrap.js"></script>


	<!-- Template Modules -->
	<script src="js/modules/form.js"></script>

	<script>
		// 判断是登录账号和密码是否为空
		function check(){
			var userName = $("#userName").val();
			var password = $("#password").val();
			//alert("账号:"+userName+"密码："+password);
			if(userName=="" || password==""){
				$("#message").text("账号或密码不能为空！");
				return false;
			}
			return document.getElementById('_form').submit();
		}

	</script>

</head>
<body class="login-content" data-ng-controller="loginCtrl as lctrl">


<div class="lc-block" id="l-login" data-ng-class="{'toggled':lctrl.login === 1}">
	<h1 class="lean">管理员</h1>

	<form id="_form" action="${pageContext.request.contextPath }/login.action" method="post">

		<div class="input-group m-b-20">
				<span class="input-group-addon">
					<i class="zmdi zmdi-account"></i>
				</span>
			<div class="fg-line">
				<input id="userName" type="text" name="userName"
					   class="form-control" placeholder="账号" regex="^\w{3,16}$"/>
			</div>
		</div>

		<div class="input-group m-b-20">
				<span class="input-group-addon">
					<i class="zmdi zmdi-male"></i>
				</span>
			<div class="fg-line">
				<input id="password" type="password" name="password"
					   class="form-control" placeholder="密码" regex="^\w+"/>
			</div>
		</div>

		<div class="clearfix"></div>

		<font color="red">
			<%-- 提示信息--%>
			<span id="message">${msg}</span>
		</font>

		<div class="checkbox">
			<label>
				<input type="checkbox" name="rememberMe"  />
				<i class="input-helper">
					记住密码
				</i>
			</label>
		</div>

		<a onclick="check()"
		   class="btn btn-login btn-danger btn-float">
			<i class="zmdi zmdi-arrow-forward"></i>
		</a>
	</form>

	<ul class="login-navigation">
		<li class="bgm-red" ></li>
		<li class="bgm-orange"></li>
	</ul>
</div>


</body>

</html>