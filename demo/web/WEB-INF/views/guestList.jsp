<%@page%>
<html>
<head>
<title>Guest List</title>
</head>
<body>

<h1>Guest List</h1>

<%
for (List<Gigue.DbResultRow> guests : guest) {
	println(guest.name + "<br>");
}
%>

</body>
</html>

