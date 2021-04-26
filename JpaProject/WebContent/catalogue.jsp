<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
   import="Jpa.demo.entities.Cat"
   import="java.util.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogue</title>
</head>
<body>
<table border="1">
<tr>
<td>Reference</td>
<td>Titre</td>
<td>Auteur</td>
<td>Prix</td>


</table>

<hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<Cat> c= (List<Cat>)request.getAttribute("catalogue");
            for (Cat cat: c) { %>
                <li> <%= cat %> </li> <%
            } %>
    </ol><hr>

</body>
</html>