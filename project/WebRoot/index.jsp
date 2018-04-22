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

    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">
<link rel="stylesheet" href="fileuploadcss/jquery.fileupload.css">    
    
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
	</script> 
	<script type="text/javascript">
		function intere(){
			self.location.href="./interestingShow.action";
		}
		function plan(){
			self.location.href="./planShow.action";
		}
		function success(){
			self.location.href="./successShow.action";
		}
		function high(){
			self.location.href="./highlightsShow.action";
		}
		function user(){
			self.location.href="./userShow.action";
		}
		
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
                    <li class="active">
                        <a href="./index.action"><i class="fa fa-flask"></i> <span class="nav-label">主页</span> </a>
                    </li>
                    <li>
                        <a href="./userShow.action"><i class="fa fa-flask"></i> <span class="nav-label">用户管理</span></a>
                    </li>                    

                    <li >
                        <a href="./interestingShow.action"><i class="fa fa-flask"></i> <span class="nav-label">趣味项目</span></span></a>
                        
                    </li>
                    <li>
                        <a href="./successShow.action"><i class="fa fa-flask"></i> <span class="nav-label">成功案列</span></a>
                        
                    </li>
                    <li >
                        <a href="./highlightsShow.action"><i class="fa fa-flask"></i> <span class="nav-label">精彩回放</span></a>
                    </li>
                    <li >
                        <a href="./planShow.action"><i class="fa fa-flask"></i> <span class="nav-label">预约策划</span></a>
                    </li>
                    <li>
                        <a href="./contactShow.action"><i class="fa fa-flask"></i> <span class="nav-label">联系我们</span></a>
                    </li>
                    <li >
                        <a href="./yzsteamindex.action"><i class="fa fa-flask"></i> <span class="nav-label">约战项目</span></a>
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
                <div class="col-lg-9">
                    <h2>主页</h2>
                    
                </div>
            </div>
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-lg-3" onclick="intere()" style="cursor:pointer">
                        <div class="widget style1 navy-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-cloud fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 趣味项目 </span>
                                    <h2 class="font-bold">${requestScope.interesting }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="success()" style="cursor:pointer">
                        <div class="widget style1 navy-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-cloud fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 成功案列 </span>
                                    <h2 class="font-bold">${requestScope.success }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="high()" style="cursor:pointer">
                        <div class="widget style1 navy-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-cloud fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 精彩回放 </span>
                                    <h2 class="font-bold">${requestScope.highlights}</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="plan()" style="cursor:pointer">
                        <div class="widget style1 navy-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-cloud fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 预约策划 </span>
                                    <h2 class="font-bold">${requestScope.plan }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="user()" style="cursor:pointer">
                        <div class="widget style1 yellow-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 今日新增人数 </span>
                                    <h2 class="font-bold">${requestScope.today }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="user()" style="cursor:pointer">
                        <div class="widget style1 yellow-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 最近三天新增人数 </span>
                                    <h2 class="font-bold">${requestScope.three }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="user()" style="cursor:pointer">
                        <div class="widget style1 yellow-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 最近七天新增会员 </span>
                                    <h2 class="font-bold">${requestScope.senven }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3" onclick="user()" style="cursor:pointer">
                        <div class="widget style1 yellow-bg">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <span> 总会员 </span>
                                    <h2 class="font-bold">${requestScope.all }</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
               
                 	
                
                </div>
            	<div id="main" style="height:400px"></div>  
            
            
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
	
	<div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class=" ">
                            <h3 class="m-t-none m-b">修改密码</h3>


                            <form role="form" method="post" action="">
                                <div class="form-group">
                                    <label>原密码：</label>
                                    <input type="password" name="pass" placeholder="请输入原密码" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>新密码：</label>
                                    <input type="password" id="pass1" name="pass1" placeholder="请输入新密码" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>确认密码：</label>
                                    <input type="password" id="pass2" name="pass2" placeholder="请确认密码" class="form-control">
                                </div>
                                <div>
                                    <button class="btn btn-sm btn-primary pull-right m-t-n-xs"  onclick="sub()"><strong>修改密码</strong>
                                    </button>
                                </div>
                                <script type="text/javascript">
                                	function sub(){
                                		if(docement.getElementById("pass1").value!=docement.getElementById("pass2").value){
                                			alert("两次输入密码不正确");
                                		}
                                		
                                	}
                                	
                                </script>
                            </form>
                        </div>
                        
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

    <!-- Custom and plugin javascript -->
    <script src="js/hplus.js?v=2.2.0"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

	<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
	<script type="text/javascript">
	 var myChart = echarts.init(document.getElementById('main')); 
	 var option = {
		    title : {
		        text:'过去七天会员增长',
		        subtext: ''
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['增长会员数']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: true},
		            magicType : {show: true, type: 'line'},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['7','6','5','5','3','2','1']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value',
		            axisLabel : {
		                formatter: '{value} 人'
		            }
		        }
		    ],
		    series : [
		        {
		            name:'增长人数',
		            type:'line',
		            data:[${today6},${today5},${today4}, ${today3}, ${today2}, ${today1},${today}],
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            }
		        }
		    ]
		};
		myChart.setOption(option);
		                    
	</script>
	

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script><!--统计代码，可删除-->
	
	
	
	
</body>

</html>
