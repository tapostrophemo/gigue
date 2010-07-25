<%@page%>
<html>
<head>
<title>Sign the Guestbook</title>
</head>
<body>

<h1>Sign the Guestbook</h1>

<%= Gigue.form.formOpen("/sign"); %>
 <label>Your name:</label> <input type="text" name="name">
 <br>
 <label>Comments</label>
 <br>
 <textarea name="comments" rows="2" columns="15"></textarea>
 <br>
 <input type="submit" value="Save">
</form>

</body>
</html>

