<%@page import="org.gigue.*,org.demo.*,java.util.List"%>
<html>
<head>
<title>Guest List</title>
</head>
<body>

<h1>Guest List</h1>

<%
for (List<DbResultRow> guest : guests) {
	println(guest.name + "<br>");
}
%>

</body>
</html>
