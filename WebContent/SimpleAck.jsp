<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<!-- **Rishikesh pasham-->  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Acknowledgement</title>
</head>
<body>
<!-- Greeting and displaying standard deviation and mean -->
        <h1>Thanks for submitting survey form</h1>
        <h3>Standard Deviation is: ${dataBean.getStd()}</h3>
        <h3>Mean :  ${dataBean.getMean()}</h3>
        <ul style="color:green">
        
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