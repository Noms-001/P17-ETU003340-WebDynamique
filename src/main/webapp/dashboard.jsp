<%@ page import="models.Credit" %>
<%@ page import="models.Depense" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Credit</th>
            <th>Total Depenses</th>
            <th>Reste</th>
        </tr>
        <% int i = 0;
            ArrayList<Double> depenses = (ArrayList<Double>)request.getAttribute("depenses");
            ArrayList<Double> restes = (ArrayList<Double>)request.getAttribute("restes");
            for(Credit credit : (ArrayList<Credit>)request.getAttribute("credits")) { %>
                <tr>
                    <td><%= credit.getLibelle()%></td>
                    <td><%= depenses.get(i)%></td>
                    <td><%= restes.get(i)%></td>
                </tr>
                <% i++;
            } %>
    </table>
    <a href="index.html">Credit</a>
    <a href="formcredit">Depense</a>
</body>
</html>