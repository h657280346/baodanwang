<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>逸尘智创后台管理系统-用户管理</title>
<style>
.ui-jqgrid-sortable {
	text-align: center;
}

.selectopts {
	display: none;
}

.input-elm {
	margin-left: 10px;
	margin-top: 5px;
}

.columns select {
	margin-top: 5px;
}

#jqgh_jqgrid_cb {
	display: flex;
	flex-direction: column;
}
</style>
</head>
<body>
	<!-- Bread crumb is created dynamically -->
	<!-- row -->
	<div class="row">
		<!-- col -->
		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
			<h1 class="page-title txt-color-blueDark">
				<!-- PAGE HEADER -->
				<i class="fa-fw fa fa-user"></i> 用户 <span>> 用户管理 </span>
			</h1>
		</div>
		<!-- end col -->
	</div>
	<!-- end row -->
	<!-- widget grid -->
	<section id="widget-grid" class=""> <!-- row -->
	<div class="row">
		<!-- NEW WIDGET START -->
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<table id="jqgrid"></table>
		<div id="pjqgrid"></div>
		<!-- WIDGET END -->
	</div>
	<!-- end row --> </section>
	<!-- end widget grid -->

	<script>
		pageSetUp();
		var pagefunction = function() {
			loadScript("js/plugin/jqgrid/jquery.jqGrid.min.js",
					run_jqgrid_function);

			function run_jqgrid_function() {
				jQuery("#jqgrid").jqGrid(
						{
							datatype : "json",
							height : 'auto',
							url : 'userList.action',
							editurl : "updataUser.action",
							colNames : [ '用户ID', 'openid', '头像', '昵称', '微信号',
									'电话', '地址', '详细地址', '真实姓名', '添加时间' ],
							colModel : [ {
								name : 'userId',
								index : 'user_id',
								align : "center",
								sortable : false,
								editable : true,
								key:true
							}, {
								name : 'userOpenid',
								index : 'user_openid',
								align : "center",
								sortable : false,
								editable : true,
								width : "200"
							}, {
								name : 'userAvatarurl',
								index : 'user_avatarUrl',
								align : "center",
								sortable : false,
								editable : true,
								search : false,
								formatter : imageFormat
							}, {
								name : 'userNickname',
								index : 'user_nickName',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'userWechatid',
								index : 'user_weChatId',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'userTel',
								index : 'user_tel',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'userAddress',
								index : 'user_address',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'userAddressdetail',
								index : 'user_addressDetail',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'userRealname',
								index : 'user_realName',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'userAddtime',
								index : 'user_addTime',
								align : "center",
								sortable : true,
								editable : true
							} ],
							prmNames : {
								page : "page", // 表示请求页码的参数名称  
								rows : "rows", // 表示请求行数的参数名称  
								sort : "sidx", // 表示用于排序的列名的参数名称  
								order : "sord", // 表示采用的排序方式的参数名称  
								search : "search", // 表示是否是搜索请求的参数名称  
								nd : null, // 表示已经发送请求的次数的参数名称  
								id : "id", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
								oper : "oper", // operation参数名称（我暂时还没用到）  
								editoper : "edit", // 当在edit模式中提交数据时，操作的名称  
								addoper : "add", // 当在add模式中提交数据时，操作的名称 
								deloper : "del", // 当在delete模式中提交数据时，操作的名称  
								subgridid : null, // 当点击以载入数据到子表时，传递的数据名称  
								npage : null,
								totalrows : null
							// 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal  
							},
							jsonReader : {
								root : "rows",
								page : "page",
								total : "totalPages",
								records : "records",
								repeatitems : false,
							},
							mtype : 'POST',
							rowNum : 10,
							rowList : [ 10, 20, 30 ],
							pager : '#pjqgrid',
							sortname : 'user_addTime',
							sortorder : "desc",
							toolbarfilter : true,
							viewrecords : true,
							caption : "用户信息",
							multiselect : true,
							multiselectWidth : "30",
							autowidth : true
						});
				function imageFormat(cellvalue, options, rowObject) {

					return '<img src="'
							+ cellvalue
							+ '"  style="border-radius:50%; width:40px;height:40px;" />';
				}
				;
				jQuery("#jqgrid").jqGrid('navGrid', "#pjqgrid", {
					edit : false,
					add : false,
					del : true
				});
				jQuery("#jqgrid").jqGrid('inlineNav', "#pjqgrid", {
					edit : false,
					add : false
				});
				// remove classes
				$(".ui-jqgrid").removeClass("ui-widget ui-widget-content");
				$(".ui-jqgrid-view").children().removeClass(
						"ui-widget-header ui-state-default");
				$(".ui-jqgrid-labels, .ui-search-toolbar").children()
						.removeClass("ui-state-default ui-th-column ui-th-ltr");
				$(".ui-jqgrid-pager").removeClass("ui-state-default");
				$(".ui-jqgrid").removeClass("ui-widget-content");

				// add classes
				$(".ui-jqgrid-htable").addClass(
						"table table-bordered table-hover");
				$(".ui-jqgrid-btable").addClass(
						"table table-bordered table-striped");
				$(".ui-pg-div").removeClass()
						.addClass("btn btn-sm btn-primary");
				$(".ui-icon.ui-icon-plus").removeClass().addClass("fa fa-plus");
				$(".ui-icon.ui-icon-pencil").removeClass().addClass(
						"fa fa-pencil");
				$(".ui-icon.ui-icon-trash").removeClass().addClass(
						"fa fa-trash-o");
				$(".ui-icon.ui-icon-search").removeClass().addClass(
						"fa fa-search");
				$(".ui-icon.ui-icon-refresh").removeClass().addClass(
						"fa fa-refresh");
				$(".ui-icon.ui-icon-disk").removeClass().addClass("fa fa-save")
						.parent(".btn-primary").removeClass("btn-primary")
						.addClass("btn-success");
				$(".ui-icon.ui-icon-cancel").removeClass().addClass(
						"fa fa-times").parent(".btn-primary").removeClass(
						"btn-primary").addClass("btn-danger");

				$(".ui-icon.ui-icon-seek-prev").wrap(
						"<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-prev").removeClass().addClass(
						"fa fa-backward");

				$(".ui-icon.ui-icon-seek-first").wrap(
						"<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-first").removeClass().addClass(
						"fa fa-fast-backward");

				$(".ui-icon.ui-icon-seek-next").wrap(
						"<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-next").removeClass().addClass(
						"fa fa-forward");

				$(".ui-icon.ui-icon-seek-end").wrap(
						"<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-end").removeClass().addClass(
						"fa fa-fast-forward");

				// update buttons

				$(window).on(
						'resize.jqGrid',
						function() {
							jQuery("#jqgrid").jqGrid('setGridWidth',
									$("#content").width());
						})
			} // end function

		}
		loadScript("js/plugin/jqgrid/grid.locale-en.min.js", pagefunction);
	</script>
</body>
</html>