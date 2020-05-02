<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!-- **Rishikesh pasham -->  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Winner Acknowledgement</title>
</head>
<body>
<!--Greeting and displaying mean and standard deviation -->
        <h1>Thanks for submitting the form</h1>
        <h2 style="color:green">You have won two movie tickets</h2>
        <h3>Standard Deviation is: ${dataBean.getStd()}</h3>
        <h3>Mean :  ${dataBean.getMean()}</h3>
        <ul style ="color:green">
            <%
                List<String> sids = (List<String>) request.getAttribute("stdids");
                for (String id : sids) {
            %>
            <li><b><a style="color:green" href="stddata?param=<%=id%>"><%= id %></a></b></li>
            <%
                }
            %>
        </ul>
        

</body>
</html>