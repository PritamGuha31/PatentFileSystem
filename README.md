# PatentFileSystem
This is an online application related to filing patents in seamless manner built using JEE7 on the back-end, JSP as front-end, HTML, CSS and Bootstrap framework. <br>
MySQL was used as a database. I built the application using Eclipse and hosted it on the local server using Apache Tomcat.

<b>The system used four tables in the database: </b> <br>
i. Client: This table stores all the client related details. Clients are the people who file the patents in the system.
<br>
ii. Examiner: This table stores all the examiner related details. Examiners are those examine the patent request filed by the client and take necessary actions.
<br>
iii. Requests: This table stores all the patent request related information. These details are verified by the examiner during verification process.
<br>
iv. Comments: This table stores all the comments posted by the examiner and the client. Comments are generally posted on a particular patent request to gather more information or for getting more clarity.

<b> The list of columns used for the above tables are given as: </b> <br>
<b> 1. Client </b>
<table>
  <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
  </tr>
  <tr>
    <td> cid </td>
    <td> int(11) </td>
    <td> Primary </td>
    <td> Null </td>
    <td> Auto_increment </td>
  </tr>
  <tr>
    <td> cname </td>
    <td> varchar(30) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> cemail </td>
    <td> varchar(100) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> cpass </td>
    <td> varchar(20) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> caddress </td>
    <td> varchar(200) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> cphone </td>
    <td> bigint(20) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> caadhar </td>
    <td> bigint(20) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> cdob </td>
    <td> date </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
</table>
<br>
<b> 2. Comments </b>
<table>
  <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
  </tr>
  <tr>
    <td> comm_id </td>
    <td> int(11) </td>
    <td> Primary </td>
    <td> Null </td>
    <td> Auto_increment </td>
  </tr>
  <tr>
    <td> rid </td>
    <td> int(11) </td>
    <td> Foreign </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> comm_date </td>
    <td> date </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> comm_text </td>
    <td> varchar(1000) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> cid </td>
    <td> int(11) </td>
    <td> Foreign </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> eid </td>
    <td> int(11) </td>
    <td> Foreign </td>
    <td> Null </td>
    <td>  </td>
  </tr>
</table>
<br>
<b> 3. Examiner </b>
<table>
  <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
  </tr>
  <tr>
    <td> eid </td>
    <td> int(11) </td>
    <td> Primary </td>
    <td> Null </td>
    <td> Auto_increment </td>
  </tr>
  <tr>
    <td> ename </td>
    <td> varchar(30) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> epassword </td>
    <td> varchar(20) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> erole </td>
    <td> varchar(20) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> email </td>
    <td> varchar(100) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
</table>
<br>
<b> 4. Requests </b>
<table>
  <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
  </tr>
  <tr>
    <td> rid </td>
    <td> int(11) </td>
    <td> Primary </td>
    <td> Null </td>
    <td> Auto_increment </td>
  </tr>
  <tr>
    <td> cid </td>
    <td> int(11) </td>
    <td> Foreign </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> rdesc </td>
    <td> varchar(1000) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> rdate </td>
    <td> date </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
  <tr>
    <td> rstatus </td>
    <td> varchar(50) </td>
    <td>  </td>
    <td> Null </td>
    <td>  </td>
  </tr>
</table>
  
    
