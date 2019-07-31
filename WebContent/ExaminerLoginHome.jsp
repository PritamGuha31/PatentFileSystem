<%@page import="com.pfs.bean.Examiner"%>
<%@page import="com.pfs.utils.CommonUtils"%>
<%@page import="com.pfs.utils.ExaminerUtils"%>
<%@page import="com.pfs.bean.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME EXAMINER</title>
<style type="text/css">
html
{ height: 100%;}

*
{ margin: 0;
  padding: 0;}

body
{ font: normal .80em 'trebuchet ms', arial, sans-serif;
  background: #FFF;
  color: #555;}

p
{ padding: 0 0 20px 0;
  line-height: 1.7em;}

img
{ border: 0;}

h1, h2, h3, h4, h5, h6 
{ color: #362C20;
  letter-spacing: 0em;
  padding: 0 0 5px 0;}

h1, h2, h3
{ font: normal 170% 'century gothic', arial;
  margin: 0 0 15px 0;
  padding: 15px 0 5px 0;
  color: #000;}

h2
{ font-size: 160%;
  padding: 9px 0 5px 0;
  color: #009FBC;}

h3
{ font-size: 140%;
  padding: 5px 0 0 0;}

h4, h6
{ color: #009FBC;
  padding: 0 0 5px 0;
  font: normal 110% arial;
  text-transform: uppercase;}

h5, h6
{ color: #888;
  font: normal 95% arial;
  letter-spacing: normal;
  padding: 0 0 15px 0;}

a, a:hover
{ outline: none;
  text-decoration: underline;
  color: #00C6F0;}

a:hover
{ text-decoration: none;}

blockquote
{ margin: 20px 0; 
  padding: 10px 20px 0 20px;
  border: 1px solid #E5E5DB;
  background: #FFF;}

ul
{ margin: 2px 0 22px 17px;}

ul li
{ list-style-type: circle;
  margin: 0 0 6px 0; 
  padding: 0 0 4px 5px;
  line-height: 1.5em;}

ol
{ margin: 8px 0 22px 20px;}

ol li
{ margin: 0 0 11px 0;}

.left
{ float: left;
  width: auto;
  margin-right: 10px;}

.right
{ float: right; 
  width: auto;
  margin-left: 10px;}

.center
{ display: block;
  text-align: center;
  margin: 20px auto;}

#main, #logo, #menubar, #site_content, #footer
{ margin-left: auto; 
  margin-right: auto;}

#header
{ background: #CCC;
  border-bottom: 1px solid #CCC;
  height: 186px;}
  
#banner
{  background: transparent url(banner.jpg) no-repeat;
  width: 860px;
  height: 180px;
  margin-bottom: 20px;
  border: 10px solid #DDD;}

#logo
{ width: 880px;
  position: relative;
  height: 140px;
  background: #F5F5F5;}

#logo #logo_text 
{ position: absolute; 
  top: 10px;
  left: 0;}

#logo h1, #logo h2
{ font: normal 300% 'century gothic', arial, sans-serif;
  border-bottom: 0;
  text-transform: none;
  margin: 0 0 0 9px;}

#logo_text h1, #logo_text h1 a, #logo_text h1 a:hover 
{ padding: 22px 0 0 0;
  color: #323232;
  letter-spacing: 0.1em;
  text-decoration: none;}

#logo_text h1 a .logo_colour
{ color: #00C6F0;}

#logo_text a:hover .logo_colour
{ color: #DDD;}

#logo_text h2
{ font-size: 120%;
  padding: 4px 0 0 0;
  color: #999;}

#menubar
{ width: 872px;
  height: 45px;
  padding-right: 8px;
  background: #DDD;
  border-top: 1px solid #CCC;} 

ul#menu
{ float: right;
  margin: 0;}

ul#menu li
{ float: left;
  padding: 0 0 0 9px;
  list-style: none;
  margin: 8px 4px 0 4px;}

ul#menu li a
{ font: normal 100% 'trebuchet ms', sans-serif;
  display: block; 
  float: left; 
  height: 20px;
  padding: 6px 20px 5px 20px;
  text-align: center;
  color: #FFF;
  text-decoration: none;
  background: #BBB;} 

ul#menu li.selected a
{ height: 20px;
  padding: 6px 20px 5px 11px;}

ul#menu li.selected
{ margin: 8px 4px 0 13px;
  background: #00C6F0;}

ul#menu li.selected a, ul#menu li.selected a:hover
{ background: #00C6F0;
  color: #FFF;}

ul#menu li a:hover
{ color: #323232;}

#site_content
{ width: 880px;
  overflow: hidden;
  margin: 20px auto 0 auto;
  padding: 0 0 10px 0;} 

#sidebar_container
{ float: left;
  width: 224px;}

.sidebar_top
{ width: 222px;
  height: 14px;
  background: transparent url(side_top.png) no-repeat;}

.sidebar_base
{ width: 222px;
  height: 14px;
  background: url(side_base.png) no-repeat;}

.sidebar
{ float: right;
  width: 222px;
  padding: 0;
  margin: 0 0 16px 0;}

.sidebar_item
{ background: url(side_back.png) repeat-y;
  padding: 0 15px;
  width: 192px;
  border: solid black 1px ;}

.sidebar li a.selected
{ color: #444;} 

.sidebar ul
{ margin: 0;} 

#content
{ text-align: left;
  width: 620px;
  padding: 0 0 0 5px;
  float: right;}
  
#content ul
{ margin: 2px 0 22px 0px;}

#content ul li, .sidebar ul li
{ list-style-type: none;
  background: url(bullet.png) no-repeat;
  margin: 0 0 0 0; 
  padding: 0 0 4px 25px;
  line-height: 1.5em;}

#footer
{ width: 100%;
  font-family: 'trebuchet ms', sans-serif;
  font-size: 100%;
  height: 80px;
  padding: 28px 0 5px 0;
  text-align: center; 
  background: #CCC;
  border-top: 1px solid #AAA;
  color: #FFF;}

#footer p
{ line-height: 1.7em;
  padding: 0 0 10px 0;}

#footer a
{ color: #FFF;
  text-decoration: none;}

#footer a:hover
{ color: #00C6F0;
  text-decoration: none;}

.search
{ color: #5D5D5D; 
  border: 1px solid #BBB; 
  width: 134px; 
  padding: 4px; 
  font: 100% arial, sans-serif;}

.form_settings
{ margin: 15px 0 0 0;}

.form_settings p
{ padding: 0 0 4px 0;}

.form_settings span
{ float: left; 
  width: 200px; 
  text-align: left;}
  
.form_settings input, .form_settings textarea
{ padding: 5px; 
  width: 299px; 
  font: 100% arial; 
  border: 1px solid #E5E5DB; 
  background: #FFF; 
  color: #47433F;}
  
.form_settings .submit
{ font: 100% arial; 
  border: 0; 
  width: 99px; 
  margin: 0 0 0 212px; 
  height: 33px;
  padding: 2px 0 3px 0;
  cursor: pointer; 
  background: #3B3B3B; 
  color: #FFF;}

.form_settings textarea, .form_settings select
{ font: 100% arial; 
  width: 299px;}

.form_settings select
{ width: 310px;}

.form_settings .checkbox
{ margin: 4px 0; 
  padding: 0; 
  width: 14px;
  border: 0;
  background: none;}

.separator
{ width: 100%;
  height: 0;
  border-top: 1px solid #D9D5CF;
  border-bottom: 1px solid #FFF;
  margin: 0 0 20px 0;}
  
  
table
{ margin: 10px 0 30px 0;}

table tr th, table tr td
{ background: #3B3B3B;
  color: #FFF;
  padding: 7px 4px;
  text-align: left;}
  
table tr td
{ background: #E5E5DB;
  color: #47433F;
  border-top: 1px solid #FFF;}

</style>
</head>
<%
	Examiner examiner=(Examiner)session.getAttribute("examiner");
	if(examiner == null){
		response.sendRedirect("Home.jsp");
	}
%>
<body>
<%
	List<Request> requestList = new ArrayList<Request>();
	CommonUtils cu=new CommonUtils();
	requestList = cu.getAllApprovedRequests();
	ExaminerUtils eu=new ExaminerUtils();
	List<Request> rlist =new ArrayList<Request>();
	rlist = eu.getAllPendingOrProcessingRequests();
%>


  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="Home.jsp">PATENT <span class="logo_colour">FILE SYSTEM</span></a></h1>
          <h2>An invention is not your own until it is patented...</h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li><a href="Home.jsp">Home</a></li>
          <li><a href="AboutUs.jsp">About Us</a></li>
          <li><a href="examinerServlet">Examiners</a></li>
          <li><a href="patentServlet">Patents</a></li>
          <li><a href="ContactUs.jsp">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
      <div id="banner">
      <img src="image/examiner.jpg" alt="image" style="width:860px;height:180px;">
      </div>
	  <div id="sidebar_container">
       
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <h3>Approved Patents</h3>
            <ul>
              <%
              	if(!requestList.isEmpty()){
              		for(Request r : requestList){
              			
              	
              %>
              <li>&#9688;  <a href="approvedPatents?rid=<%=r.getRid() %>">  <%= r.getRdesc().substring(0, 25) %>... </a> </li>
              <%
              	}
              }
              %>
            </ul>
          </div>
          <div class="sidebar_base"></div>
        </div>
        
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <h1>WELCOME <%= examiner.getEname() %></h1>
        <form action="logout" method="POST">
        <div class="form_settings">
        
        <span>&nbsp;</span><input class="submit" type="submit" name="logout" value=" LOGOUT " style="background-color: #000000; color: white; width: 100px; height: 35px;">
        </div>
        </form>
        
        <h4>PENDING/PROCESSING REQUEST DIRECTORY</h4>
        
        <table style="width:100%">
  <tr>
    <th>RID</th>
    <th>RDESC</th> 
  </tr>
  <tr>
  	<%
		if(!rlist.isEmpty()){
				
			for(Request r : rlist){
	%>
	
	<td> <%=r.getRid()%> </td> <td> <%=r.getRdesc()  %></td>
	</tr>
	<%
			}
		}
	%>
  	
</table>
        
        
        
        <h4> ENTER RID TO VIEW A REQUEST </h4>
        <form action="viewRequest" method="POST">
        <div class="form_settings">
            <p><span>RID: </span><input class="contact" type="text" name="rid" required/></p>
            
            
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="SUBMIT" /></p>
          </div>
          
          
       
        </form><br><br><br>
        
        <h4> ENTER RID TO CHANGE STATUS OF A REQUEST </h4>
        <form action="changeStatus" method="POST">
        <div class="form_settings">
            <p><span>RID: </span><input class="contact" type="text" name="rid" value="" required/></p>
            
            
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="SUBMIT" /></p>
          </div>
          
          
       
        </form><br><br><br>
        
        <h4> ENTER RID TO COMMENT ON A REQUEST </h4>
        <form action="addComment" method="POST">
        <div class="form_settings">
            <p><span>RID: </span><input class="contact" type="text" name="rid" value="" required /></p>
            
            
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="SUBMIT" /></p>
          </div>
          
          
       
        </form><br><br><br>
        
        
        
        
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      <p><a href="Home.jsp">Home</a> | <a href="AboutUs.jsp">About Us</a> | <a href="examinerServlet">Examiners</a> | <a href="patentServlet">Patents</a> | <a href="ContactUs.jsp">Contact Us</a></p>
      <p>Copyright &copy; PFS 2017 | Pritam Guha | Pallavi Datta | Koustav Chakraborty | Sreeradha Sen Sarma | Alina Ghosh </p>
    </div>
  </div>
</body>
</html>