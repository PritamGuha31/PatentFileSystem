<%@page import="com.pfs.utils.CommonUtils"%>
<%@page import="com.pfs.utils.ExaminerUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pfs.bean.Request"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>CONTACT US</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" />
</head>

<body>
<%
	List<Request> rlist=new ArrayList<Request>();
	CommonUtils cu=new CommonUtils();
	rlist=cu.getAllApprovedRequests();
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
          <li class="selected"><a href="ContactUs.jsp">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
     <div id="banner">
     
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3687.6181682800834!2d88.41324531495727!3d22.44339298524936!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a0272166e4cb263%3A0x27f12170efd9ddee!2sFuture+Institute+of+Engineering+and+Management!5e0!3m2!1sen!2sin!4v1525599309014" width="1200" height="200" frameborder="0" style="border:0" allowfullscreen></iframe>
      </div>
      <div id="sidebar_container">
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
           <h3>Login</h3>
            <form method="POST" action="login_request" id="search_form">
              <p>
                <input class="search" type="email" name="email" placeholder="Enter email ID" required/><br><br>
                <input class="search" type="password" name="password" placeholder="Enter password" required/><br><br>
                <select name="usertype" style="height: 25px; width: 145px;" class="search">
                <option value="">Select user type...</option>
                <option value="client"> Client </option>
                <option value="examiner"> Examiner </option>
                </select><br><br>
                
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="submit" type="submit" name="contact_submitted" value=" LOGIN " style="background-color: #000000; color: white; width: 100px; height: 35px;"></p>
                <a href="Register.jsp"> Don't have an account? Click here and register... </a>
            <br> <br>
            </form>
          </div>
          <div class="sidebar_base"></div>
        </div>
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
             <!--  insert your sidebar items here  -->
            <h3>Approved Patents</h3> 
            <ul >
            <%
            	if(!rlist.isEmpty()){
            		for(Request r : rlist){
            %>
            	<li>  <a href="approvedPatents?rid=<%=r.getRid() %>">  <%= r.getRdesc().substring(0, 25) %>... </a> </li>
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
        <h1>Contact Us</h1>
               
          <div class="form_settings">
            <h4> CONTACT DETAILS </h4><br>
        
        <ul>
            <%
              			
              	
              %>
              <p> <label><b>COMPANY NAME:</b></label> <label ><%="PFS"%></label> </p>
              <p> <label><b>EMAIL:</b></label> <label ><%="admin@pfs.com" %></label> </p>
  			<p> <label><b>PHONE NO.:</b></label> <label > <%=1800120569 %></label></p>
  			<p> <label><b>FAX:</b></label> <label > <%=22-335699456 %></label></p>
  			<p> <label><b>ADDRESS:</b></label> <label ><%= "Sonarpur Station Rd, Mission Pally, Narendrapur, Kolkata, West Bengal 700150"%></label> </p>
        <hr>
        <br> <br>
              <%
              	
              %>
              
            </ul>
        </div>    
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
