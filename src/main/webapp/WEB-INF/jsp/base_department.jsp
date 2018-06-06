<%@ page import="com.soecode.lyf.entity.Supply" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soecode.lyf.entity.Product" %>
<%@ page import="com.soecode.lyf.entity.Department" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/10
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    List<Department> list=(List<Department>)request.getAttribute("departmentList");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://use.typekit.net/wbi8ikb.js"></script>
    <script>try{Typekit.load({ async: true });}catch(e){}</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>物资品名信息管理</title>
    <meta name="keywords" content="add course">
    <meta name="description" content="add course page">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=basePath%>css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.css?v=4.7.0" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!-- Dadepicker -->
    <link href="<%=basePath%>css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <!-- Drop Zone -->
    <link href="<%=basePath%>css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/cheney.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>部门信息管理</h5>
                    <div class="col-sm-2 pull-right" style="padding-right:0;">
                        <a class="btn btn-primary btn-sm btn-block" href="<%=basePath%>base/department/add"><i class="fa fa-edit"></i> 新增部门</a>
                    </div>
                </div>

                <div class="ibox-content">
                    <div class="clients-list">
                        <ul class="nav nav-tabs">
                            <span class="pull-right small text-muted"><%=list.size()%> 个部门</span>
                            <li class="active"><a data-toggle="tab" href="#tab-1"><i class="fa fa-user"></i>部门名字信息列表</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="tab-1" class="tab-pane active" style="height: 528px;">
                                <div class="full-height-scroll">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover">
                                            <tbody>
                                            <tr>
                                                <td></td>
                                                <td>部门名字</td>
                                                <td>&nbsp;&nbsp;操作</td>
                                                <td></td>
                                            </tr>
                                            <%for(Department s:list){%>
                                            <tr>
                                                <td></td>
                                                <td><a   class="client-link"><%=s.getDepartmentName()%></a></td>
                                                <td><strong><a  href="<%=basePath%>base/department/<%=s.getDepartmentId().intValue()%>/update" class="client-link">修改</a>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <a  href="<%=basePath%>base/department/<%=s.getDepartmentId().intValue()%>/delete" class="client-link">删除</a>
                                                </strong></td>
                                                <td></td>

                                            </tr>
                                            <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>js/content.min.js?v=1.0.0"></script>
<script src="<%=basePath%>js/plugins/toastr/toastr.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".showtoast").click(function(){
            var shortCutFunction="success";
            var msg="信息已录入";
            var title="操作成功";
            var $showDuration="3000";
            var $hideDuration="1000";
            var $timeOut="5000";
            var $extendedTimeOut="1000";
            var $showEasing="swing";
            var $hideEasing="linear";
            var $showMethod="fadeIn";
            var $hideMethod="fadeOut";
            toastr.options={
                closeButton:true,
                debug:false,
                progressBar:true,
                positionClass:"toast-top-full-width",
                onclick:null};
            if($showDuration){
                toastr.options.showDuration=$showDuration
            }if($hideDuration){
                toastr.options.hideDuration=$hideDuration
            }if($timeOut){
                toastr.options.timeOut=$timeOut
            }if($extendedTimeOut){
                toastr.options.extendedTimeOut=$extendedTimeOut
            }if($showEasing){
                toastr.options.showEasing=$showEasing
            }if($hideEasing){
                toastr.options.hideEasing=$hideEasing
            }if($showMethod){
                toastr.options.showMethod=$showMethod
            }if($hideMethod){
                toastr.options.hideMethod=$hideMethod
            }if(!msg){
                msg=getMessage()
            }
            var $toast=toastr[shortCutFunction](msg,title);
        });
    });
</script>
<script>
    $(function(){
        $("#scale").change(function(){
            if($("#scale").val()!="combo"){
                $("#number").attr("disabled",false);
                $("#combo-hidden").attr("hidden",false);
                if($("#scale").val()=="large"){
                    if($("#small-hidden").prop("hidden")){
                        $("#capacity").attr("disabled",false);
                        $("#small-hidden").attr("hidden",false);
                    }
                } else {
                    if(!$("#small-hidden").prop("hidden")){
                        $("#capacity").attr("disabled",true);
                        $("#small-hidden").attr("hidden",true);
                    }
                }
            } else {
                $("#number").attr("disabled",true);
                if(!$("#small-hidden").prop("hidden")){
                    $("#capacity").attr("disabled",true);
                    $("#small-hidden").attr("hidden",true);
                }
                $("#combo-hidden").attr("hidden",true);
            }
        })
    });
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
