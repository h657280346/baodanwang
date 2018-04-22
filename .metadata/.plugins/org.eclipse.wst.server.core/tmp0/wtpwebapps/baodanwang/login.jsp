<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html id="extr-page">
<head>
<meta charset="utf-8">
<title>逸尘智创后台管理-登录</title>
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- #CSS Links -->
<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/font-awesome.min.css">

<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
<link rel="stylesheet" type="text/css" media="screen"
	href="css/smartadmin-production-plugins.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/smartadmin-production.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/smartadmin-skins.min.css">

<!-- SmartAdmin RTL Support -->
<link rel="stylesheet" type="text/css" media="screen"
	href="css/smartadmin-rtl.min.css">
<!-- #FAVICONS -->
<link rel="shortcut icon" href="img/favicon/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">
</head>
<body class="animated fadeInDown">
	<div id="main" role="main">
		<!-- MAIN CONTENT -->
		<div id="content" class="container">
			<div class="row">
				<div
					class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
					<h1 class="txt-color-red login-header-big">逸尘智创后台管理</h1>
					<div class="hero">
						<div class="pull-left login-desc-box-l">
							<h4 class="paragraph-header">欢迎使用逸尘智创后台管理系统</h4>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
					<div class="well no-padding">
						<form action="login.action" id="login-form"
							class="smart-form client-form" method="post">
							<header> 登录 </header>
							<fieldset>
								<section>
									<label class="label">账号</label> <label class="input"><i
										class="icon-append fa fa-user"></i> <input type="text"
										name="username" maxlength="20"> <b
										class="tooltip tooltip-top-right"><i
											class="fa fa-user txt-color-teal"></i> 请输入账号</b></label>
								</section>
								<section>
									<label class="label">密码</label> <label class="input"><i
										class="icon-append fa fa-lock"></i> <input type="password"
										name="password" maxlength="20"> <b
										class="tooltip tooltip-top-right"><i
											class="fa fa-lock txt-color-teal"></i> 请输入密码</b></label>
								</section>
							</fieldset>
							<input type="hidden" value="${requestScope.error }" id="error" />
							<footer>
								<button type="submit" class="btn btn-primary">登录</button>
							</footer>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script src="js/plugin/pace/pace.min.js"></script>

	<!-- IMPORTANT: APP CONFIG -->
	<script src="js/app.config.js"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

	<!-- BOOTSTRAP JS -->
	<script src="js/bootstrap/bootstrap.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>


	<!-- MAIN APP JS FILE -->
	<script src="js/app.min.js"></script>

	<script>
		var error = document.getElementById("error").value;
		if (error != null && error != "") {
			alert(error)
		}
		function submits(e) {
			var userName = document.getElementsByName("userName");
			var password = document.getElementsByName("password");
			if (userName[0].value.length < 1 || password[0].value.length < 1) {
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>