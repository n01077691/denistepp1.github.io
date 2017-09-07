<%@page import="java.sql.*" %>
<html>
<head>
<title>Basic Oracle from a jsp</title>
</head>
<body>
<p>This is jsp to accept a zipcode and return a list of student names</p>
  <%
    out.println("Programme: studzips.jsp <br>"); 
    try {
      // Load the JDBC driver 
      Class.forName("oracle.jdbc.OracleConnection");
      out.println("Driver loaded <br>");
    } 
    catch (ClassNotFoundException e){ 
      out.println("Could not load the driver <br>"); 
    }
    	String user = "n01077691";
	String passwd = "oracle";
	try {
      Connection conn = DriverManager.getConnection
         ("jdbc:oracle:thin:@munro.humber.ca:1521:msit" , user, passwd); 
      out.println("Database connected <br><br>");
      // 2. Create a statement
	  String zip  = request.getParameter("value1");
	  String stringQuery = 
("SELECT Last_name, first_name FROM instructor where zip = '10025'");
      PreparedStatement preState = conn.prepareStatement(stringQuery); 
      // 3. Create a result set  AND  4. Execute the query statement
	  ResultSet rset = preState.executeQuery();
	  // 5. Iterate through the result and print the instructor table
      out.println("LName , FName <br>"); 
      while(rset.next())
         out.println(rset.getString("Last_name") + ", " + rset.getString(2) + "<br>" );
      // 6. Close statement
      preState.close();
    }
    catch (SQLException e){ 
      out.println("Could not make Oracle connection"); 
    } 
	%>
</body>
</html>
