/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2019-02-24 08:38:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<!-- 页面meta -->\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t\t<title>数据后台管理 - 用户</title>\r\n");
      out.write("\t\t<meta name=\"description\" content=\"用户\">\r\n");
      out.write("\t\t<meta name=\"keywords\" content=\"用户\">\r\n");
      out.write("\t\t<!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("\t\t<meta content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\" name=\"viewport\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 引入css -->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/css.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<!-- 引入css /-->\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"hold-transition skin-purple sidebar-mini\" style=\"overflow:scroll;overflow-x:hidden\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 页面头部 -->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<!-- 页面头部 /-->\r\n");
      out.write("\t\t<!-- 导航侧栏 -->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/aside.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<!-- 导航侧栏 /-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 内容区域 -->\r\n");
      out.write("\t\t<div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- 内容头部 -->\r\n");
      out.write("\t\t\t<section class=\"content-header\">\r\n");
      out.write("\t\t\t<h1>\r\n");
      out.write("\t\t\t\t用户管理 <small>用户表单</small>\r\n");
      out.write("\t\t\t</h1>\r\n");
      out.write("\t\t\t<ol class=\"breadcrumb\">\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index.jsp\"><i\r\n");
      out.write("\t\t\t\t\t\tclass=\"fa fa-dashboard\"></i> 首页</a></li>\r\n");
      out.write("\t\t\t\t<li><a\r\n");
      out.write("\t\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/list/1/5\">用户管理</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"active\">用户表单</li>\r\n");
      out.write("\t\t\t</ol>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t\t<!-- 内容头部 /-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/save\"\r\n");
      out.write("\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t<!-- 正文区域 -->\r\n");
      out.write("\t\t\t\t<section class=\"content\"> <!--产品信息-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-heading\">用户信息</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row data-type\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-2 title\">用户名称</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-4 data\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"username\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"用户名称\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-2 title\">密码</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-4 data\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" name=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"密码\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-2 title\">邮箱</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-4 data\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"邮箱\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-2 title\">联系电话</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-4 data\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"phoneNum\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"联系电话\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-2 title\">用户状态</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-4 data\">\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"form-control select2\" style=\"width: 100%\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"status\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"0\" >禁用</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"1\" selected=\"selected\">正常</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--订单信息/--> <!--工具栏-->\r\n");
      out.write("\t\t\t\t<div class=\"box-tools text-center\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn bg-maroon\">保存</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn bg-default\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"history.back(-1);\">返回</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--工具栏/--> </section>\r\n");
      out.write("\t\t\t\t<!-- 正文区域 /-->\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 内容区域 /-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 底部导航 -->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<!-- 底部导航 /-->\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\t<!-- 引入js -->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/js.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!-- 引入js /-->\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
