<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>HealthyDiet</title>

    <meta name="description" content="HealthyDiet">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>images/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>images/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="HealthyDiet" />
    <link rel="stylesheet" href="<%=basePath%>css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/app.css">
    <!-- 引入css样式文件 -->
    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet" />
    <!-- DataTables CSS -->
    <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet" />
    <!-- Custom Fonts -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css" />

    <!-- jQuery -->
    <script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <!-- Angular -->
    <script src="<%=basePath%>js/bower_components/angular/angular.min.js"></script>
    <script src="<%=basePath%>js/bower_components/angular-resource/angular-resource.min.js"></script>
    <script src="<%=basePath%>js/bower_components/angular-animate/angular-animate.min.js"></script>
    <!-- Angular Modules -->
    <script src="<%=basePath%>js/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="<%=basePath%>js/bower_components/angular-loading-bar/src/loading-bar.js"></script>
    <script src="<%=basePath%>js/bower_components/oclazyload/dist/ocLazyLoad.min.js"></script>
    <script src="<%=basePath%>js/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
    <!-- 引入js文件 -->
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=basePath%>js/metisMenu.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
    <script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<%=basePath%>js/sb-admin-2.js"></script>

    <script type="text/javascript">

        $(function init(){
            document.getElementById("${category}").selected = true;
        })

        function selectChange(){
            var category = $("#category option:selected").val();
            var menuName = $("#search").val();
            if(menuName != ""){
                var url = "<%=basePath%>menu/list.action?category=" + category + "&menuName=" + menuName;
            }else{
                var url = "<%=basePath%>menu/list.action?category=" + category;
            }
            window.location = url;
        }

        function pageChange(start){
            //获取被选中的option标签
            var category = $("#category option:selected").val();
            var menuName = $("#search").val();
            if(menuName != ""){
                var url = "<%=basePath%>menu/list.action?start=" + start + "&category=" + category + "&menuName=" + menuName;
            }else{
                var url = "<%=basePath%>menu/list.action?start=" + start + "&category=" + category;
            }
            window.location = url;
        }

        function searchMenuByName(){
            var category = $("#category option:selected").val();
            var menuName = $("#search").val();
            if(menuName != ""){
                var url = "<%=basePath%>menu/list.action?category=" + category + "&menuName=" + menuName;
            }else{
                var url = "<%=basePath%>menu/list.action?category=" + category;
            }
            window.location = url;
        }

        //通过menuId获取编辑的菜谱信息
        function queryMenuById(menuId) {
            $('#my-popup').modal({closeViaDimmer: false,});
            $.ajax({
                type:"get",
                url:"<%=basePath%>menu/queryMenuById.action",
                data:{"menuId":menuId},
                success:function(data) {
                    $("#doc-vld-id").val(data.menu_id);
                    $("#doc-vld-name").val(data.menu_name);
                    $("#doc-vld-kouwei").val(data.flavor);
                    $("#doc-vld-calorie").val(data.calorie);
                    $("#doc-vld-gongyi").val(data.technology);
                    $("#doc-vld-time").val(data.make_time);
                    $("#doc-select-fenlei").val(data.diseases);
                    $("#doc-vld-image").val(data.menu_url);
                }
            });
        }

        // 执行修改菜谱操作
        function updateMenu() {
            $.post("<%=basePath%>menu/update.action",
                {menu_id:$("#doc-vld-id").val(),
                    menu_name:$("#doc-vld-name").val(),
                    flavor:$("#doc-vld-kouwei").val(),
                    calorie:$("#doc-vld-calorie").val(),
                    technology:$("#doc-vld-gongyi").val(),
                    make_time:$("#doc-vld-time").val(),
                    diseases:$("#doc-select-fenlei").val(),
                    menu_url:$("#doc-vld-image").val()},
                function(data){
                    if(data == "OK"){
                        $("#my-popup").modal('close');
                        $("#alert-text").text("菜谱数据修改成功!");
                        $("#my-alert").modal({closeViaDimmer: false, onConfirm: function (){
                                window.location.reload();
                            }});
                    }else{
                        $("#my-popup").modal('close');
                        $("#alert-text").text("菜谱数据修改失败!");
                        $("#my-alert").modal({closeViaDimmer: false, onConfirm: function (){
                                window.location.reload();
                            }});
                    }
                });
        }

        function deleteMenu(menuId) {
            $('#my-confirm').modal({
                closeViaDimmer: false,
                onConfirm: function() {
                    $.post("<%=basePath%>menu/delete.action",{menuId:menuId},
                        function(data){
                            if(data == "OK"){
                                $("#alert-text").text("菜谱数据删除成功!");
                                $("#my-alert").modal({closeViaDimmer: false, onConfirm: function (){
                                    window.location.reload();
                                    }});
                            }else{
                                $("#alert-text").text("菜谱数据删除失败!");
                                $("#my-alert").modal({closeViaDimmer: false, onConfirm: function (){
                                        window.location.reload();
                                    }});
                            }
                        });
                },
                onCancel: function() {
                }
            });
        }

    </script>

</head>

<body data-type="widgets">
<script src="<%=basePath%>js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;"><img src="<%=basePath%>images/logo.png" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
            </div>
            <!-- 搜索 -->
            <div class="am-fl tpl-header-search">
                <form class="tpl-header-search-form" action="javascript:;">
                    <button class="tpl-header-search-btn am-icon-search"></button>
                    <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
                </form>
            </div>
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span> ${sessionScope.USER_SESSION.userName}</span> </a>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="<%=basePath%>admin/logout.action">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="<%=basePath%>images/user06.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              ${sessionScope.USER_SESSION.userName}
          </span>
                <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
            </div>
        </div>


        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <li class="sidebar-nav-heading">Page <span class="sidebar-nav-heading-info"> 数据处理页面</span></li>
            <li class="sidebar-nav-link">
                <a href="${pageContext.request.contextPath }/menu/list.action" class="sub-active">
                    <span class="am-icon-home sidebar-nav-link-logo"></span> 菜谱信息
                </a>
            </li>

            <li class="sidebar-nav-link">
                <a href="${pageContext.request.contextPath }/user/list.action">
                    <span class="am-icon-table sidebar-nav-link-logo"></span> 用户信息
                </a>
            </li>

            <li class="sidebar-nav-link">
                <a href="${pageContext.request.contextPath }/userBehavior/recommendMenu.action">
                    <span class="am-icon-bar-chart sidebar-nav-link-logo"></span> 用户行为信息
                </a>
            </li>

            <li class="sidebar-nav-heading">Page<span class="sidebar-nav-heading-info"> 管理员信息页面</span></li>
            <li class="sidebar-nav-link">
                <a href="${pageContext.request.contextPath }/admin/changePassword.action">
                    <i class="am-icon-key sidebar-nav-link-logo"></i> 修改密码
                </a>
            </li>
        </ul>
    </div>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">菜谱信息列表</div>

                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                    <select id="category" data-am-selected="{maxHeight: 300,btnSize: 'sm'}" onchange="selectChange()">
                                        <option id="所有类别" value="所有类别">所有类别</option>
                                        <option id="早餐" value="早餐">早餐</option>
                                        <option id="午餐" value="午餐">午餐</option>
                                        <option id="晚餐" value="晚餐">晚餐</option>
                                        <option id="减肥" value="减肥">减肥</option>
                                        <option id="美容" value="美容">美容</option>
                                        <option id="清热解毒" value="清热解毒">清热解毒</option>
                                        <option id="头痛" value="头痛">头痛</option>
                                        <option id="消化不良" value="消化不良">消化不良</option>
                                        <option id="营养不良" value="营养不良">营养不良</option>
                                        <option id="高血压" value="高血压">高血压</option>
                                        <option id="高血脂" value="高血脂">高血脂</option>
                                        <option id="更年期" value="更年期">更年期</option>
                                        <option id="抗癌防癌" value="抗癌防癌">抗癌防癌</option>
                                        <option id="口腔溃疡" value="口腔溃疡">口腔溃疡</option>
                                        <option id="尿路结石" value="尿路结石">尿路结石</option>
                                        <option id="糖尿病" value="糖尿病">糖尿病</option>
                                        <option id="痛经" value="痛经">痛经</option>
                                        <option id="产妇" value="产妇">产妇</option>
                                        <option id="老人" value="老人">老人</option>
                                        <option id="幼儿" value="幼儿">幼儿</option>
                                        <option id="乳母" value="乳母">乳母</option>
                                        <option id="学龄期" value="学龄期">学龄期</option>
                                        <option id="婴儿" value="婴儿">婴儿</option>
                                        <option id="运动员" value="运动员">运动员</option>
                                        <option id="孕妇" value="孕妇">孕妇</option>
                                        <option id="便秘" value="便秘">便秘</option>
                                        <option id="腹泻" value="腹泻">腹泻</option>
                                        <option id="感冒" value="感冒">感冒</option>
                                        <option id="咳喘" value="咳喘">咳喘</option>
                                        <option id="呕吐" value="呕吐">呕吐</option>
                                        <option id="失眠" value="失眠">失眠</option>
                                        <option id="哮喘" value="哮喘">哮喘</option>
                                    </select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input id="search" value="${search}" type="text" class="am-form-field ">
                                    <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button" onclick="searchMenuByName()"></button>
          </span>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                    <thead>
                                    <tr>
                                        <th>菜谱缩略图</th>
                                        <th>菜谱名</th>
                                        <th>口味</th>
                                        <th>卡路里</th>
                                        <th>烹饪工艺</th>
                                        <th>制作时间</th>
                                        <th>分类</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${page.rows}" var="row">
                                        <tr class="gradeX">
                                            <td>
                                                <img src="${row.menu_url}" class="tpl-table-line-img" height="90" width="90" alt="">
                                            </td>
                                            <td class="am-text-middle">${row.menu_name}</td>
                                            <td class="am-text-middle">${row.flavor}</td>
                                            <td class="am-text-middle">${row.calorie}</td>
                                            <td class="am-text-middle">${row.technology}</td>
                                            <td class="am-text-middle">${row.make_time}</td>
                                            <td class="am-text-middle">${row.diseases}</td>
                                            <td class="am-text-middle">
                                                <div class="tpl-table-black-operation">
                                                    <a href="#"  data-toggle="modal" onclick="queryMenuById(${row.menu_id})">
                                                        <i class="am-icon-pencil"></i> 编辑
                                                    </a>
                                                    <a href="#" class="tpl-table-black-operation-del" onclick="deleteMenu(${row.menu_id})">
                                                        <i class="am-icon-trash"></i> 删除
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <div class="am-u-lg-12 am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <%--跳到首页 这里做了判断 如果没有前一页 那么 跳到首页的这个标签是不可点击的 class="disabled" --%>
                                        <li <c:if test="${!page.hasPreviouse}">class="am-disabled"</c:if> >
                                            <a href="#" onclick="pageChange(1)">
                                                <span> << </span>
                                            </a>
                                        </li>
                                        <%--跳到前一页 同样做了判断 如果没有前一页 则不可点击前跳 class="disabled" --%>
                                        <li <c:if test="${!page.hasPreviouse}">class="am-disabled"</c:if> >
                                            <a href="#" onclick="pageChange(${page.start})">
                                                <span> < </span>
                                            </a>
                                        </li>
                                        <%--中间的分页  显示各页号--%>
                                        <%-- begin:开始的元素 end:最后一个元素 varStatus:代表循环状态的变量名称 --%>
                                        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                                            <c:if test="${status.count-page.start<=page.end  && status.index>=page.index}">
                                                <%--
                                                status.index==page.start 判断是否是目前的这一页 --%>
                                                <li <c:if test="${status.index==page.start}">class="am-active am-disabled"</c:if>>
                                                    <a href="#" onclick="pageChange(${status.index+1})"
                                                       <c:if test="${status.index==page.start}">class="current"</c:if>
                                                    >${status.count}</a>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                        <%--跳到下一页 同样做了判断 如果没有下一页 则不可点击后跳 class="disabled" --%>
                                        <li <c:if test="${!page.hasNext}">class="am-disabled"</c:if>>
                                            <a href="#" onclick="pageChange(${page.start+1+1})">
                                                <span> > </span>
                                            </a>
                                        </li>
                                        <%--跳到尾页 如果没有后一页 那么 跳到尾页的这个标签是不可点击的 class="disabled" --%>
                                        <li <c:if test="${!page.hasNext}">class="am-disabled"</c:if>>
                                            <a href="#" onclick="pageChange(${page.totalPage})">
                                                <span> >> </span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="http://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
<script src="<%=basePath%>js/main/app.js"></script>

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">HealthyDiet</div>
        <div id="alert-text" class="am-modal-bd">
            菜谱数据删除成功!
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>

<!-- 编辑菜谱信息模态框 -->
<div class="am-popup" id="my-popup" style="z-index: 9999;">
    <div class="am-popup-inner">
        <div class="am-popup-hd">
            <h4 class="am-popup-title">编辑菜谱信息</h4>
            <span data-am-modal-close
                  class="am-close">&times;</span>
        </div>
        <div class="am-popup-bd">
            <form id="edit_menu_form" class="am-form" data-am-validator>
                <fieldset>
                    <input type="hidden" id="doc-vld-id"/>

                    <div class="am-form-group">
                        <label for="doc-vld-name">菜谱名：</label>
                        <input type="text" id="doc-vld-name" minlength="1" placeholder="输入菜谱名" required/>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-vld-kouwei">口味：</label>
                        <input type="text" id="doc-vld-kouwei" minlength="1" placeholder="输入菜谱口味" required/>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-vld-calorie">卡路里：</label>
                        <input type="text" id="doc-vld-calorie" minlength="1" placeholder="输入菜谱的卡路里" required/>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-vld-gongyi">烹饪工艺：</label>
                        <input type="text" id="doc-vld-gongyi" minlength="1" placeholder="输入菜谱烹饪方式" required/>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-vld-time">制作时间：</label>
                        <input type="text" id="doc-vld-time" minlength="1" placeholder="输入菜谱制作时间" required/>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-select-fenlei">分类</label>
                        <select id="doc-select-fenlei" required>
                            <option value="早餐">早餐</option>
                            <option value="午餐">午餐</option>
                            <option value="晚餐">晚餐</option>
                            <option value="减肥">减肥</option>
                            <option value="美容">美容</option>
                            <option value="清热解毒">清热解毒</option>
                            <option value="头痛">头痛</option>
                            <option value="消化不良">消化不良</option>
                            <option value="营养不良">营养不良</option>
                            <option value="高血压">高血压</option>
                            <option value="高血脂">高血脂</option>
                            <option value="更年期">更年期</option>
                            <option value="抗癌防癌">抗癌防癌</option>
                            <option value="口腔溃疡">口腔溃疡</option>
                            <option value="尿路结石">尿路结石</option>
                            <option value="糖尿病">糖尿病</option>
                            <option value="痛经">痛经</option>
                            <option value="产妇">产妇</option>
                            <option value="老人">老人</option>
                            <option value="幼儿">幼儿</option>
                            <option value="乳母">乳母</option>
                            <option value="学龄期">学龄期</option>
                            <option value="婴儿">婴儿</option>
                            <option value="运动员">运动员</option>
                            <option value="孕妇">孕妇</option>
                            <option value="便秘">便秘</option>
                            <option value="腹泻">腹泻</option>
                            <option value="感冒">感冒</option>
                            <option value="咳喘">咳喘</option>
                            <option value="呕吐">呕吐</option>
                            <option value="失眠">失眠</option>
                            <option value="哮喘">哮喘</option>
                        </select>
                        <span class="am-form-caret"></span>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-vld-image">菜谱图片url：</label>
                        <input type="text" id="doc-vld-image" minlength="1" placeholder="输入网络图片url" required/>
                    </div>

                    <button class="am-btn am-btn-secondary" type="button" onclick="updateMenu()" style="width: 100%; text-align: center;">提交</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">HealthyDiet</div>
        <div class="am-modal-bd">
            你，确定要删除这条菜谱记录吗？
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>

</body>

</html>