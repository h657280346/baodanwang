<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>逸尘智创后台管理系统-团购管理</title>
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
				<i class="fa-fw fa fa-shopping-cart"></i> 团购 <span>> 团购管理 </span>
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
							url : 'bulkList.action',
							editurl : "updataBulk.action",
							colNames : [ '团购ID', '归属商铺ID', '团购名称', '团购介绍',
									'团购背景图', '团购状态', '是否填写微信号', '是否展示首页',
									'团购二维码图片', '取货方式', '创建时间' ],
							colModel : [ {
								name : 'bulkId',
								index : 'bulk_id',
								align : "center",
								sortable : false,
								editable : true,
								key : true
							}, {
								name : 'storeId',
								index : 'store_id',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'bulkTitle',
								index : 'bulk_title',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'bulkAnnouncement',
								index : 'bulk_announcement',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'bulkPicture',
								index : 'bulk_picture',
								align : "center",
								sortable : false,
								search : false,
								editable : true,
								formatter : imageFormat
							}, {
								name : 'bulkStatus',
								index : 'bulk_status',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'bulkWechatidstatus',
								index : 'bulk_weChatIdStatus',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'bulkShowstatus',
								index : 'bulk_showStatus',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'bulkWechatcodepicture',
								index : 'bulk_WeChatCodePicture',
								align : "center",
								sortable : false,
								search : false,
								editable : true,
								formatter : imageFormat
							}, {
								name : 'bulkPickupway',
								index : 'bulk_pickupway',
								align : "center",
								sortable : false,
								editable : true,
								formatter : pickupWayFormat
							}, {
								name : 'bulkAddtime',
								index : 'bulk_addTime',
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
							sortname : 'bulk_addTime',
							sortorder : "desc",
							toolbarfilter : true,
							viewrecords : true,
							caption : "团购信息",
							multiselect : true,
							multiselectWidth : "30",
							autowidth : true
						});
				function imageFormat(cellvalue, options, rowObject) {
					return '<img src="'
							+ cellvalue
							+ '"  style="width:40px;height:40px;" />';
				}
				;
				function pickupWayFormat(cellvalue, options, rowObject) {
					var ways = cellvalue.split(',');
					var result = "";
					for(var i=0;i<ways.length;i++){
						if(ways[i] == "1" ){
							result = result + "免费上门,"
						}else if(ways[i] == "2"){
							result = result + "同城,"
						}else if(ways[i] == "3"){
							result = result + "快递,"
						}else {
							result = result + "自提,"
						}
					}	
					result = result.substr(0, result.length-1);
					return result;
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