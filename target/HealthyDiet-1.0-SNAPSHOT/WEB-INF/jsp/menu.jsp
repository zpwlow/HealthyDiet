<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>
<%-- <%=basePath%> --%>

<html lang="en">

<head>
    <meta charset="utf-8">
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <title>菜谱列表</title>

<%--    <base href="http://localhost:8080/demo/">--%>

    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>i/logo.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="<%=basePath%>css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/app.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

</head>

<body data-type="widgets">
<script src="<%=basePath%>js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;"><img src="<%=basePath%>img/logo.png" alt=""></a>
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
                        <a href="javascript:;">欢迎您, <span>Amaze UI</span> </a>
                    </li>

                    <!-- 新邮件 -->
                    <li class="am-dropdown tpl-dropdown" data-am-dropdown>
                        <a href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle" data-am-dropdown-toggle>
                            <i class="am-icon-envelope"></i>
                            <span class="am-badge am-badge-success am-round item-feed-badge">4</span>
                        </a>
                        <!-- 弹出列表 -->
                        <ul class="am-dropdown-content tpl-dropdown-content">
                            <li class="tpl-dropdown-menu-messages">
                                <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                    <div class="menu-messages-ico">
                                        <img src="<%=basePath%>img/user04.png" alt="">
                                    </div>
                                    <div class="menu-messages-time">
                                        1小时前
                                    </div>
                                    <div class="menu-messages-content">
                                        <div class="menu-messages-content-title">
                                            <i class="am-icon-circle-o am-text-success"></i>
                                            <span>阿桐</span>
                                        </div>
                                        <div class="am-text-truncate">健康饮食小程序，是基于微信小程序的给用户推荐健康的、调养身体的美食 </div>
                                        <div class="menu-messages-content-time">2020-09-21 下午 15:40</div>
                                    </div>
                                </a>
                            </li>

                            <li class="tpl-dropdown-menu-messages">
                                <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                    <div class="menu-messages-ico">
                                        <img src="<%=basePath%>img/user02.png" alt="">
                                    </div>
                                    <div class="menu-messages-time">
                                        3天前
                                    </div>
                                    <div class="menu-messages-content">
                                        <div class="menu-messages-content-title">
                                            <i class="am-icon-circle-o am-text-warning"></i>
                                            <span>阿伟</span>
                                        </div>
                                        <div class="am-text-truncate"> 我们要为客户着想，想客户所想，做客户所做。 </div>
                                        <div class="menu-messages-content-time">2020-09-16 上午 12:23</div>
                                    </div>
                                </a>
                            </li>
                            <li class="tpl-dropdown-menu-messages">
                                <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                    <i class="am-icon-circle-o"></i> 进入列表…
                                </a>
                            </li>
                        </ul>
                    </li>

                    <!-- 新提示 -->
                    <li class="am-dropdown" data-am-dropdown>
                        <a href="javascript:;" class="am-dropdown-toggle" data-am-dropdown-toggle>
                            <i class="am-icon-bell"></i>
                            <span class="am-badge am-badge-warning am-round item-feed-badge">5</span>
                        </a>

                        <!-- 弹出列表 -->
                        <ul class="am-dropdown-content tpl-dropdown-content">
                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <div class="tpl-dropdown-menu-notifications-title">
                                        <i class="am-icon-line-chart"></i>
                                        <span> 有6个来自班级的通知</span>
                                    </div>
                                    <div class="tpl-dropdown-menu-notifications-time">
                                        12分钟前
                                    </div>
                                </a>
                            </li>
                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <div class="tpl-dropdown-menu-notifications-title">
                                        <i class="am-icon-star"></i>
                                        <span> 有2个来自学校的通知</span>
                                    </div>
                                    <div class="tpl-dropdown-menu-notifications-time">
                                        30分钟前
                                    </div>
                                </a>
                            </li>
                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <div class="tpl-dropdown-menu-notifications-title">
                                        <i class="am-icon-folder-o"></i>
                                        <span> 上午开会记录存档</span>
                                    </div>
                                    <div class="tpl-dropdown-menu-notifications-time">
                                        1天前
                                    </div>
                                </a>
                            </li>


                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <i class="am-icon-bell"></i> 进入列表…
                                </a>
                            </li>
                        </ul>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="javascript:;">
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
                    <img src="<%=basePath%>img/user06.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              小钟
          </span>
                <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
            </div>
        </div>


        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <li class="sidebar-nav-link">
                <a href="javascript:;">
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>


            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title active">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 数据列表
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
                    <li class="sidebar-nav-link">
                        <a href="javascript:;">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 文字列表
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="javascript:;" class="sub-active">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图文列表
                        </a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-nav-link">
                <a href="javascript:;">
                    <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
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
                            <div class="widget-title  am-cf">菜谱列表</div>


                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-9">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field ">
                                    <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
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
                                                        <a href="javascript:;">
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
                                                        <a href="javascript:;" >
                                                            <i class="am-icon-archive"></i> 查看
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del">
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
                                            <a href="?start=1">
                                                <span> << </span>
                                            </a>
                                        </li>
                                        <%--跳到前一页 同样做了判断 如果没有前一页 则不可点击前跳 class="disabled" --%>
                                        <li <c:if test="${!page.hasPreviouse}">class="am-disabled"</c:if> >
                                            <a href="?start=${page.start}">
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
                                                    <a href="?start=${status.index+1}"
                                                       <c:if test="${status.index==page.start}">class="current"</c:if>
                                                    >${status.count}</a>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                        <%--跳到下一页 同样做了判断 如果没有下一页 则不可点击后跳 class="disabled" --%>
                                        <li <c:if test="${!page.hasNext}">class="am-disabled"</c:if>>
                                            <a href="?start=${page.start+1+1}">
                                                <span> > </span>
                                            </a>
                                        </li>
                                        <%--跳到尾页 如果没有后一页 那么 跳到尾页的这个标签是不可点击的 class="disabled" --%>
                                        <li <c:if test="${!page.hasNext}">class="am-disabled"</c:if>>
                                            <a href="?start=${page.totalPage}">
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

<script src="http://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
<script src="<%=basePath%>js/app.js"></script>

</body>

</html>