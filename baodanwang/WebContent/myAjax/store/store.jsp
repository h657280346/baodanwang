<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>逸尘智创后台管理系统-商铺管理</title>
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
				<i class="fa-fw fa fa-building"></i> 商铺 <span>> 商铺管理 </span>
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
							url : 'storeList.action',
							editurl : "updataStore.action",
							colNames : [ '商铺ID', 'openid', '商铺名称', '商铺昵称',
									'商铺头像', '商铺地址', '商铺详细地址', '商铺自提点','自提点详细地址', '电话',
									'微信号', '二维码', '余额', '是否认证', '认证类型', '认证名称',
									'认证照片', '创建时间' ],
							colModel : [ {
								name : 'storeId',
								index : 'store_id',
								align : "center",
								sortable : false,
								editable : false,
								key : true
							}, {
								name : 'storeOpenid',
								index : 'store_openid',
								align : "center",
								sortable : false,
								editable : false
							}, {
								name : 'storeName',
								index : 'store_name',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeNickname',
								index : 'store_nickName',
								align : "center",
								sortable : false,
								editable : false
							}, {
								name : 'storeAvatarurl',
								index : 'store_avatarUrl',
								align : "center",
								sortable : false,
								editable : false,
								search : false,
								formatter : imageFormat
							}, {
								name : 'storeAddress',
								index : 'store_address',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeAddressdetail',
								index : 'store_addressDetail',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storePickupsite',
								index : 'store_pickUpSite',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storePickupsitedetail',
								index : 'store_pickUpSiteDetail',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeTel',
								index : 'store_tel',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeWechatid',
								index : 'store_weChatId',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeQrcode',
								index : 'store_QRCode',
								align : "center",
								sortable : false,
								editable : false,
								search : false,
								formatter : imageFormat1
							}, {
								name : 'balance',
								index : 'balance',
								align : "center",
								sortable : true,
								editable : true,
								search : true
							}, {
								name : 'storeRealnamestatus',
								index : 'store_realNameStatus',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeRealnametype',
								index : 'store_realNameType',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeRealname',
								index : 'store_realName',
								align : "center",
								sortable : false,
								editable : true
							}, {
								name : 'storeCertificationpicture',
								index : 'store_certificationPicture',
								align : "center",
								sortable : false,
								editable : false,
								search : false,
								formatter : imageFormat2
							}, {
								name : 'storeAddtime',
								index : 'store_addTime',
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
							sortname : 'store_addTime',
							sortorder : "desc",
							toolbarfilter : true,
							viewrecords : true,
							caption : "商铺信息",
							multiselect : true,
							autowidth : true
						});
				function imageFormat(cellvalue, options, rowObject) {
					return '<img src="'
							+ cellvalue
							+ '" style="border-radius:50%; width:40px;height:40px;" />';
				}
				;
				function imageFormat1(cellvalue, options, rowObject) {
					return '<img src="'
							+ cellvalue
							+ '" style="width:40px;height:40px;" />';
				}
				;
				function imageFormat2(cellvalue, options, rowObject) {
					var values = cellvalue.split(',');
					if (values[1] != null) {
						return '<img src="'
						+ values[0]
						+ '"  style="width:40px;height:40px;margin-right:5px;" /><img src="'
						+ values[1]
						+ '"  style="width:40px;height:40px;margin-left:5px;" />';
					} else {
						return '<img src="'
						+ values[0]
						+ '"  style="width:40px;height:40px;margin-right:5px;" />';
					}
				}
				;
				jQuery("#jqgrid").jqGrid('navGrid', "#pjqgrid", {
					edit : false,
					add : false,
					del : true
				});
				jQuery("#jqgrid").jqGrid('inlineNav', "#pjqgrid", {
					edit : true,
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