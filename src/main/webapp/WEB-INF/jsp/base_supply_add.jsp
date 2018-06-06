<%@ page import="com.soecode.lyf.entity.Resource" %>
<%@ page import="com.soecode.lyf.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soecode.lyf.entity.Supply" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/10
  Time: 7:15
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    List<Product> list=(List<Product>)request.getAttribute("productList");
    List<Integer> listl=(List<Integer>)request.getAttribute("selectedproduct");
    Supply s=(Supply)request.getAttribute("supply");

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://use.typekit.net/wbi8ikb.js"></script>
    <script>try{Typekit.load({ async: true });}catch(e){}</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增采购</title>
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
                    <h5><%=(s!=null)?"修改供应商信息":"新增供应商"%></h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal" method="post" action="<%=basePath%>base/supply/<%=(s!=null)?"update":"add"%>/commit">
                        <%if(s!=null){%>
                        <div class="form-group">
                            <input name="supplyId" type="hidden" value="<%=s.getSupplyId().intValue()%>"/>
                            <label class="col-sm-2 control-label">名字: </label>
                            <div class="col-sm-4 "><input name="supplyName" max="20" type="text" class="form-control " value="<%=s.getSupplyName()%>"/></div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div id="resource">
                            <%if(listl.size()>0){
                                for (Integer i:listl
                                     ) {


                            %>
                            <div id="supply_resource" class="form-group">
                                <label class="col-sm-2 control-label">物资: </label>
                                <div class="col-sm-6">
                                    <select name="projectId" class="chosen-select form-control m-b" tabindex="2">
                                        <option value=""  disabled="disabled">选择物资</option>

                                        <%
                                            for (Product p:list
                                                    ) {

                                        %><option <%=(i.intValue()==p.getProductId().intValue())?"selected=\"selected\"":""%> value="<%=p.getProductId().intValue()%>" ><%=p.getProductName()%></option>

                                        <%}%>
                                    </select>
                                </div>

                            </div>
                            <%}}else{ %>
                            <div id="supply_resource" class="form-group">
                                <label class="col-sm-2 control-label">物资: </label>
                                <div class="col-sm-6">
                                    <select name="projectId" class="chosen-select form-control m-b" tabindex="2">
                                        <option value="" selected="selected" disabled="disabled">选择物资</option>

                                        <%
                                            for (Product p:list
                                                    ) {

                                        %><option value="<%=p.getProductId().intValue()%>" ><%=p.getProductName()%></option>

                                        <%}%>
                                    </select>
                                </div>

                            </div>
                            <%}%>
                        </div>
                        <%}else{%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名字: </label>
                            <div class="col-sm-4 "><input name="supplyName" max="20" type="text" placeholder="请输入供应商的名字" class="form-control "/></div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div id="resource">
                        <div id="supply_resource" class="form-group">
                            <label class="col-sm-2 control-label">物资: </label>
                            <div class="col-sm-6">
                                <select name="projectId" class="chosen-select form-control m-b" tabindex="2">
                                    <option value="" selected="selected" disabled="disabled">选择物资</option>

                                    <%
                                        for (Product p:list
                                                ) {

                                    %><option value="<%=p.getProductId().intValue()%>" ><%=p.getProductName()%></option>

                                    <%}%>
                                </select>
                            </div>
                        </div>
                        </div>
                        <%}%>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <span id="entry-plus" style="cursor: pointer;margin-left: 45%;margin-right:10%"><i class="fa fa-5x fa-plus-circle"></i></span>
                                <span id="entry-minus" style="cursor: pointer"><i class="fa fa-5x fa-minus-circle"></i></span>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-2 col-sm-offset-9">
                                <button type="submit" class="btn btn-primary showtoast">提交</button>
                                <a class="btn btn-white" href="<%=basePath%>base/supply/list">取消</a>
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
    $(document).on("click", "#entry-plus",function() {
        if($("#supply_resource div").length>=1) {
            var ob1=$("#supply_resource:last").clone(true);
            $("#resource").append(ob1);
            }


    });
    $(document).on("click", "#entry-minus",function() {
        if($("#supply_resource div").length>1){
            $("#supply_resource:last").remove();
        }
        else
        alert($("#supply_resource div").length)
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

