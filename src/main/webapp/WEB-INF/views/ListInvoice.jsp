<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Invoice List</title>
</head>
<body>
    <h1>Invoice List</h1>
    
    <table border="1">
        <thead>
            <tr>
                 <th>USER</th>
                <th>Invoice Number</th>
                <th>Issue Date</th>
                <th>Due Date</th>
                <th>Active</th>
             
            </tr>
        </thead>
        <tbody>
            <c:forEach var="invoice" items="${listinvoice}">
                <tr>
                    <td>${invoice.user.username}</td>
                    <td>${invoice.invoiceNumber}</td>
                    <td>${invoice.issueDate}</td>
                    <td>${invoice.dueDate}</td>
                    <td>${invoice.active}</td>
                    
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
