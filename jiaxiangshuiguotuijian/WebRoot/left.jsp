<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

 <ul id="Nav" class="layui-nav layui-nav-tree">
					
 		            <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em>系统用户管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="allusers_add.jsp">管理员添加</a></dd>
                            <dd><a href="allusersList.do">管理员管理</a></dd>
							<%-- <dd><a href="yonghuzhuce_add.jsp">注册会添加</a></dd> --%>
                            <dd><a href="yonghuzhuceList.do">水果商管理</a></dd>
                            <dd><a href="guonongxinxiList.do">果农信息管理</a></dd>
                            <dd><a href="mod.jsp">修改密码</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em>变幻图管理</em>
                        </a>
                        <dl class="layui-nav-child">
                                <dd><a href="xinwentongzhi_add.jsp?lb=变幻图">变幻图添加</a></dd>
                                <dd><a href="xinwentongzhiList.do?lb=变幻图">变幻图查询</a></dd>
                            </dl>
                    </li>
					
					<li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe612;</i>
                            <em>新闻文章管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="xinwentongzhi_add.jsp?lb=站内新闻">站内新闻添加</a></dd>
                                <dd><a href="xinwentongzhiList.do?lb=站内新闻">站内新闻查询</a></dd>
                            <dd><a href="xinwentongzhi_add.jsp?lb=通知公告">通知公告添加</a></dd>
                                <dd><a href="xinwentongzhiList.do?lb=通知公告">通知公告查询</a></dd>
                            <dd><a href="xinwentongzhi_add.jsp?lb=行业资讯">行业资讯添加</a></dd>
                                <dd><a href="xinwentongzhiList.do?lb=行业资讯">行业资讯查询</a></dd>
                        </dl>
                    </li>
					 <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em>水果信息管理</em>
                        </a>
                        <dl class="layui-nav-child">
                                <dd><a href="shuiguoxinxi_add.jsp">水果信息添加</a></dd>
                                <dd><a href="shuiguoxinxiList.do">水果信息查询</a></dd>
                            </dl>
                    </li>
					<li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em>求购信息管理</em>
                        </a>
                        <dl class="layui-nav-child">
                                <dd><a href="qiugouxinxi_add.jsp">求购信息添加</a></dd>
                                <dd><a href="qiugouxinxiList.do">求购信息查询</a></dd>
                            </dl>
                    </li>
					<%-- <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em>站内新闻管理</em>
                        </a>
                        <dl class="layui-nav-child">
                                <dd><a href="xinwentongzhi_add.jsp">站内新闻添加</a></dd>
                                <dd><a href="xinwentongzhiList.do">站内新闻查询</a></dd>
                            </dl>
                    </li> --%>
					<li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em>系统基本管理</em>
                        </a>
                        <dl class="layui-nav-child">
                               
                                <dd><a href="youqinglianjie_add.jsp">友情连接添加</a></dd>
								<dd><a href="youqinglianjieList.do">友情连接查询</a></dd>
								<%-- <dd><a href="dx.jsp?lb=系统公告">系统公告设置</a></dd> --%>
								<dd><a href="dx.jsp?lb=系统简介">系统简介设置</a></dd>
								<dd><a href="liuyanbanList.do">留言板管理</a></dd>
								
                            </dl>
                    </li>

                </ul>