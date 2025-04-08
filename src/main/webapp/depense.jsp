<%@page import="models.Credit" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="depense" method="get">
        <p><label for="credit">credit: </label>
        <select name="credit" id="credit">
            <% for(Credit credit : (ArrayList<Credit>)request.getAttribute("credits")) { %>
            <option value="<%= credit.getId()%>"><%= credit.getLibelle() %></option>
            <% } %>
        </select></p>
        <% if(request.getAttribute("erreur") != null) { %>
            <p><%= request.getAttribute("erreur") %></p>
        <% } %>
        <p><label for="name">Libelle: </label>
        <input type="text" id="name" name="libelle"></p>
        <p><label for="montant">Montant: </label>
            <input type="number" id="montant" name="montant"></p>
        <p><input type="submit" value="Valider"></p>
    </form>
    <a href="formdepense">Dashboard</a>
    <a href="index.html">Credit</a>

</body>
</html>