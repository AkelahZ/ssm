<%@ page import="com.soecode.lyf.entity.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/10
  Time: 4:27
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    User_Result user=(User_Result)session.getAttribute("user");

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://use.typekit.net/wbi8ikb.js"></script>
    <script>try {
        Typekit.load({async: true});
    } catch (e) {
    }</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>物资管理系统</title>
    <meta name="keywords" content="index">
    <meta name="description" content="index page">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css?v=4.7.0">
    <link href="<%=basePath%>css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/cheney.css" rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="<%=basePath%>img/profile_small.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold"><%=user.getUserName()%></strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li>
                                <a href="###" data-toggle="modal" data-target="#myModal2">修改密码</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="<%=basePath%>index">安全退出</a>
                            </li>
                        </ul>
                        <div class="modal inmodal" id="myModal2" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content animated bounceInRight">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span
                                                aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
                                        </button>
                                        <i class="fa fa-edit modal-icon"></i>
                                        <h4 class="modal-title">修改密码</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label>原密码</label>
                                            <input type="text" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>新密码</label>
                                            <input type="text" placeholder="最少6位字符" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>确认新密码</label>
                                            <input type="text" placeholder="重复输入" class="form-control">
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary showtoast"
                                                    data-dismiss="modal">保存
                                            </button>
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="logo-element">H+
                    </div>
                </li>
                <!--0-->
                <li>
                    <a href="#">
                        <i class="fa fa fa-sign-in"></i>
                        <span class="nav-label">物资入库</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>order/order_create" data-index="0">创建采购单</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>order/order_exam_list" data-index="1">审核入库</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>rend/revert_list" data-index="2">借出归还</a>
                        </li>
                    </ul>
                </li>

                <!--1-->
                <li>
                    <a href="#">
                        <i class="fa fa fa-sign-out"></i>
                        <span class="nav-label">物资出库</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>resource/recieve" data-index="0">部门领用</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>resource/rend" data-index="1">物资借出</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>resource/rend_exam_list" data-index="2">借出审核</a>
                        </li>
                    </ul>
                </li>
                <!--2-->
                <li>
                    <a href="#">
                        <i class="fa fa fa-american-sign-language-interpreting"></i>
                        <span class="nav-label">物资处理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="404.html" data-index="0">库存盘点</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="404.html" data-index="1">部门报损</a>
                        </li>

                    </ul>
                </li>
                <!--3-->
                <li>
                    <a href="#">
                        <i class="fa fa fa-line-chart"></i>
                        <span class="nav-label">查询统计</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="404.html" data-index="0">采购单查询</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="404.html" data-index="1">部门领用查询</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="404.html" data-index="3">部门报损查询</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="404.html" data-index="4">借出查询</a>
                        </li>


                    </ul>
                </li>
                <!--4-->
                <li>
                    <a href="#">
                        <i class="fa fa fa-briefcase"></i>
                        <span class="nav-label">基础信息</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>base/supply/list" data-index="0">供应商信息管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>base/product/list" data-index="1">物资信息管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>base/department/list" data-index="2">部门信息管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>base/user/list" data-index="3">用户信息管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>base/role/list" data-index="4">权限角色管理</a>
                        </li>
                    </ul>

                </li>
            </ul>
       </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="<%=basePath%>system_index">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="<%=basePath%>index" class="roll-nav roll-right J_tabExit"><i class="fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main" style="height: calc(100% - 80px);">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=basePath%>system_index" frameborder="0"
                    data-id="system_index" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2017 <a href="###">Gosanke</a>
            </div>
        </div>
    </div>
</div>
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>js/plugins/layer/layer.min.js"></script>
<script src="<%=basePath%>js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=basePath%>js/contabs.min.js"></script>
<script src="<%=basePath%>js/plugins/pace/pace.min.js"></script>
<script src="<%=basePath%>js/plugins/toastr/toastr.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".showtoast").click(function () {
            var shortCutFunction = "success";
            var msg = "信息已录入";
            var title = "操作成功";
            var $showDuration = "3000";
            var $hideDuration = "1000";
            var $timeOut = "5000";
            var $extendedTimeOut = "1000";
            var $showEasing = "swing";
            var $hideEasing = "linear";
            var $showMethod = "fadeIn";
            var $hideMethod = "fadeOut";
            toastr.options = {
                closeButton: true,
                debug: false,
                progressBar: true,
                positionClass: "toast-top-full-width",
                onclick: null
            };
            if ($showDuration) {
                toastr.options.showDuration = $showDuration
            }
            if ($hideDuration) {
                toastr.options.hideDuration = $hideDuration
            }
            if ($timeOut) {
                toastr.options.timeOut = $timeOut
            }
            if ($extendedTimeOut) {
                toastr.options.extendedTimeOut = $extendedTimeOut
            }
            if ($showEasing) {
                toastr.options.showEasing = $showEasing
            }
            if ($hideEasing) {
                toastr.options.hideEasing = $hideEasing
            }
            if ($showMethod) {
                toastr.options.showMethod = $showMethod
            }
            if ($hideMethod) {
                toastr.options.hideMethod = $hideMethod
            }
            if (!msg) {
                msg = getMessage()
            }
            var $toast = toastr[shortCutFunction](msg, title);
        });
    });
</script>
</body>
</html>
