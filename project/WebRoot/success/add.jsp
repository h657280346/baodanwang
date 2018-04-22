<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>逸尘智创后台管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
     <script src="js/modernizr.js"></script>
    <link href="css/inserthtml.com.radios.css" rel="stylesheet" type="text/css"/>



			<style>
.div1{
float: left;

position:relative;
}
.div2{
text-align:center;
padding-top:12px;
font-size:15px;
font-weight:800
}
.inputstyle{
    width: 144px;
    height: 41px;
    cursor: pointer;
    font-size: 30px;
    outline: medium none;
    position: absolute;
    filter:alpha(opacity=0);
    -moz-opacity:0;
    opacity:0; 
    left:0px;
    top: 0px;
}
</style>
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">
	<script>  
	var loadImageFile = (function () {   
		if (window.FileReader) {   
		var oPreviewImg = null, oFReader = new window.FileReader(),   
		rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;   
		  
		  
		oFReader.onload = function (oFREvent) {   
		if (!oPreviewImg) {   
		var newPreview = document.getElementById("imagePreview");   
		
		oPreviewImg = new Image();   
		oPreviewImg.style.width = "400px";   
		oPreviewImg.style.height = "280px";   
		newPreview.appendChild(oPreviewImg);   
		}   
		oPreviewImg.src = oFREvent.target.result;   
		};   
		  
		  
		return function () {   
		var aFiles = document.getElementById("imageInput").files;   
		if (aFiles.length === 0) { return; }   
		if (!rFilter.test(aFiles[0].type)) { alert("必须是图片!"); return; }   
		oFReader.readAsDataURL(aFiles[0]);   
		}   
		  
		  
		}   
		if (navigator.appName === "Microsoft Internet Explorer") {   
		return function () {   
		alert(document.getElementById("imageInput").value);   
		document.getElementById("imagePreview").filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.getElementById("imageInput").value;   
		  
		  
		}   
		}   
		})();
	var loadImageFile1 = (function () {   
		if (window.FileReader) {   
		var oPreviewImg = null, oFReader = new window.FileReader(),   
		rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;   
		  
		  
		oFReader.onload = function (oFREvent) {   
		oPreviewImg=null;
		if (!oPreviewImg) {
		var newPreview = document.getElementById("imagePreview1");   
		
		oPreviewImg = new Image();   
		oPreviewImg.style.width = "400px";   
		oPreviewImg.style.height = "280px";   
		newPreview.appendChild(oPreviewImg);   
		}   
		oPreviewImg.src = oFREvent.target.result;   
		};   
		  
		  
		return function () {   
		var aFiles = document.getElementById("imageInput1").files;  
		if (aFiles.length === 0) { return; }   
		if (!rFilter.test(aFiles[0].type)) { alert("必须是图片!"); return; }   
		oFReader.readAsDataURL(aFiles[0]);   
		}   
		  
		  
		}   
		if (navigator.appName === "Microsoft Internet Explorer") {   
		return function () {   
		alert(document.getElementById("imageInput1").value);   
		document.getElementById("imagePreview1").filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.getElementById("imageInput").value;   
		  
		  
		}   
		}   
		})();

	</script>  
</head>

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">

                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${sessionScope.admin.name }</strong>
                             </span>  <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li> <a   href="./pass.action">修改密码</a></li>
                                <li><a href="./loginOut.action">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            SmartAdmin
                        </div>

                    </li>
                    <li>
                        <a href="./index.action"><i class="fa fa-flask"></i> <span class="nav-label">主页</span> </a>
                        
                    </li>
                    <li >
                        <a href="./yzsteamindex.action"><i class="fa fa-flask"></i> <span class="nav-label">约战项目主页</span> </a>
                    </li>
                    <li>
                        <a href="./userShow.action"><i class="fa fa-flask"></i> <span class="nav-label">用户管理</span></a>
                    </li>                    

                    <li >
                        <a href="./interestingShow.action"><i class="fa fa-flask"></i> <span class="nav-label">趣味项目</span></span></a>
                        
                    </li>
                    <li class="active">
                        <a href="./successShow.action"><i class="fa fa-flask"></i> <span class="nav-label">成功案列</span></a>
                        
                    </li>
                    <li>
                        <a href="./highlightsShow.action"><i class="fa fa-flask"></i> <span class="nav-label">精彩回放</span></a>
                    </li>
                    <li >
                        <a href="./planShow.action"><i class="fa fa-flask"></i> <span class="nav-label">预约策划</span></a>
                    </li>
                    <li>
                        <a href="./contactShow.action"><i class="fa fa-flask"></i> <span class="nav-label">联系我们</span></a>
                    </li>
                </ul>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    
                    <ul class="nav navbar-top-links navbar-right">
 

 
                </nav>
            </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>成功案列</h2>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
            <div class="wrapper wrapper-content animated fadeInRight">
                       
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>添加成功案列</h5>
                            </div>
                            <div class="ibox-content">
                                <form method="post" class="form-horizontal" action="./successAdd.action" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标题</label>

                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="title" required="" aria-required="true">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">作者</label>

                                        <div class="col-sm-10">
                                            <input type="text"  class="form-control" name="author" required="" aria-required="true">
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
									
									<div class="form-group">
                                        <label class="col-sm-2 control-label">优先级</label>

                                        <div class="col-sm-10">
                                            <input type="text"  class="form-control" name="priority" required="" aria-required="true">
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>                                    
                                    
									
									<div class="form-group">
                                        <label class="col-sm-2 control-label">轮播图</label>

                                        <div class="col-sm-10" style="width:211px">
                                            <input type="checkbox" id="checkbox-11-1" /><label for="checkbox-11-1"></label>
                                        </div>
                                    </div>
                                    <div class="form-group" id="fig" style="display:none">
                                        <label class="col-sm-2 control-label"></label>

                                        <div class="div1 col-sm-10" >
    										<div class="div2 btn btn-w-m btn-info">上传图片</div>
    										<input type="file" class="inputstyle" name="figure" onchange="loadImageFile1()" id="imageInput1" >
										</div>
                                        
										
                                    </div>
                                     <div id="imagePreview1" class="form-group" align="center">
									</div>
                                    <div class="hr-line-dashed"></div>
											
									
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">图片</label>

                                        <div class="div1 col-sm-10">
    										<div class="div2 btn btn-w-m btn-info">上传图片</div>
    										<input type="file" class="inputstyle" name="myPhoto" onchange="loadImageFile()" id="imageInput" required="" aria-required="true">
										</div>
                                        
										
                                    </div>
                                    <div id="imagePreview" class="form-group" align="center">   
									</div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">介绍</label>

                                        <div class="col-sm-10">
                                        	<script id="container" name="introduction" type="text/plain" style="height:500px">
    										</script>
    										<!-- 配置文件 -->
    										<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
    										<!-- 编辑器源码文件 -->
    										<script type="text/javascript" src="utf8-jsp/ueditor.all.js"></script>
    										<!-- 实例化编辑器 -->
    										<script type="text/javascript">
        										var ue = UE.getEditor('container');
    										</script>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <div class="col-sm-4 col-sm-offset-2">
                                            <button class="btn btn-primary" type="submit">保存内容</button>
                                            <button class="btn btn-white" type="reset">取消</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="pull-right">
                    By：<a href="#" target="_blank">Ming's blog</a>
                </div>
                <div>
                    <strong>Copyright</strong> SmartAdmin &copy; 2014
                </div>
            </div>

        </div>
    </div>


    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

			<script type="text/javascript">
	$(document).ready(function () {
		var flag = false;
		$("#checkbox-11-1").change(function(){
			
			
			if(!flag){
				$("#fig").show();
			}else{
				
				$("#fig").hide();
				var file = $("#imageInput1");
				file.after(file.clone().val(""));
				
				file.remove();
				document.getElementById("imagePreview1").innerHTML="";
				//$("#imagePreview1").empty();
			};
			flag=!flag;
		});	
		
	});
	</script>
    <!-- Custom and plugin javascript -->
    <script src="js/hplus.js?v=2.2.0"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
    </script>
	<script src="laydate/laydate.js"></script>
	<script type="text/javascript">
	laydate.render({
        elem: '#time', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
	</script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script><!--统计代码，可删除-->
	
</body>

</html>
