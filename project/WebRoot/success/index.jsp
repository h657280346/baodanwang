<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>逸尘智创后台管理</title>
    <meta name="keywords" content="SmartAdmin后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="SmartAdmin是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/table.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">

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
                               <input type="button" class="btn btn-w-m btn-info" value="添加" onclick="add()">
                            </div>
                            <div class="ibox-content">

                                <table class="table table-striped table-bordered table-hover dataTables-example">
                                    <thead>
                                        <tr>
                                        	<th></th>
                                            <th>标题</th>
                                            <th>时间</th>
                                            <th>访问量</th>
                                            <th>优先级</th>
                                            <th>轮播</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <c:forEach items="${requestScope.successes}"  var="item" varStatus="status">
                                        <tr class="gradeX">
                                            <td class="center" style="align-items: center"> <input type="checkbox" name="del" value="${item.id }" style="align:center"/></td>
                                            <td><a href="./findSuccessById.action?id=${item.id }">${item.title}</a></td>
                                            <td>${item.time }</td>
											<td>${item.view }</td>
                                            <td>${item.priority }</td>
                                            <c:if test="${item.figure !=''&&item.figure !=null}"><td>是</td></c:if>
                                            <c:if test="${item.figure ==''||item.figure ==null}"><td>否</td></c:if>
                                            <td class="center" style="width:30%"><input type="button" class="btn btn-w-m btn-primary" style="margin-right: 20px" value="修改" onclick="update('${item.id }')"/><input type="button" class="btn btn-w-m btn-danger" value="删除" onclick="dele('${item.id }')"/></td>
                                        </tr>
										</c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                        	<th></th>
                                            <th>标题</th>
                                            <th>时间</th>
                                            <th>访问量</th>
                                            <th>优先级</th>
                                            <th>轮播</th>
                                            <th>操作</th>
                                        </tr>
                                    </tfoot>
                                </table>
								<input type="button" class="btn btn-w-m btn-danger" value="删除" onclick="del()">
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
    <script src="js/plugins/jquery.metisMenu.js"></script>
    <script src="js/plugins/jquery.slimscroll.min.js"></script>

    <script src="js/plugins/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="js/plugins/jquery.dataTables.js"></script>
    <script src="js/plugins/dataTables.bootstrap.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/hplus.js?v=2.2.0"></script>
    <script src="js/plugins/pace.min.js"></script>
	
	
	<script type="text/javascript">
		function add(){
			window.location.href="./skipSuccess.action";
		}
		function update(id){
			window.location.href="./findSuccessById.action?id="+id;
		}
		function dele(id){
			if(confirm("此操作不可逆，是否继续执行？"))
			window.location.href="./successDelete.action?id="+id;
		}
		function del(){
			if(confirm("此操作不可逆，是否继续执行？")){
				var names = document.getElementsByName("del");
				var id = "";
	            var flag = false ;//标记判断是否选中一个                 
	            for(var i=0;i<names.length;i++){  
	                if(names[i].checked){  
	                        flag = true ;  
	                        id = id +names[i].value+","; 
	                 }  
	             }
	             if(!flag){  
	                alert("请最少选择一项！");  
	                return false ;  
	             }  
				window.location.href="./successDelete.action?id="+id;	
			}
			
		}
		
	</script>
	
	
	
    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            /* Init DataTables */
            var oTable = $('#editable').dataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable('../example_ajax.php', {
                "callback": function (sValue, y) {
                    var aPos = oTable.fnGetPosition(this);
                    oTable.fnUpdate(sValue, aPos[0], aPos[1]);
                },
                "submitdata": function (value, settings) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition(this)[2]
                    };
                },

                "width": "90%",
                "height": "100%"
            });


        });

        function fnClickAddRow() {
            $('#editable').dataTable().fnAddData([
                "Custom row",
                "New row",
                "New row",
                "New row",
                "New row"]);

        }
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script><!--统计代码，可删除-->

</body>

</html>
