<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Office Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <style>
        /* Basic Reset */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Layout Styles */
        .container {
            display: flex;
        }

        .sidebar {
            width: 200px;
            background-color: #f4f4f4;
            padding: 15px;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            margin-bottom: 10px;
        }

        .sidebar ul li a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        .main-content {
            flex: 1;
            padding: 20px;
        }

        nav {
            margin-bottom: 20px;
        }

        h1 {
            font-size: 24px;
            color: #333;
        }

        h2 {
            font-size: 20px;
            color: #555;
        }

        p {
            font-size: 16px;
            color: #666;
        }
        
        /* Basic Reset */
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

/* Layout Styles */
.container {
    display: flex;
}

.sidebar {
    width: 200px;
    background-color: #f4f4f4;
    padding: 15px;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
}

.sidebar ul {
    list-style: none;
    padding: 0;
}

.sidebar ul li {
    margin-bottom: 10px;
}

.sidebar ul li a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
}

.main-content {
    flex: 1;
    padding: 20px;
}

nav {
    margin-bottom: 20px;
}

h1 {
    font-size: 24px;
    color: #333;
}

h2 {
    font-size: 20px;
    color: #555;
}

p {
    font-size: 16px;
    color: #666;
}
        
    </style>
</head>
<body>
<c:if test="${empty logginuser}">

   <c:redirect url="login"></c:redirect>
 

</c:if>
 <jsp:include page="Navbar.jsp"></jsp:include>
    <div class="container">
        <div class="sidebar">
            <h2>Menu</h2>
            <ul>
                <li><a href="<c:url value='listTransactionLoginUser'/>">Manage Transactions</a></li>
                <li><a href="<c:url value='viewInvoices'/>">View Invoices</a></li>
            </ul>
        </div>
        <div class="main-content">
            <h1>Office Dashboard::welcome::${logginuser.email}</h1>
            <section>
                <h2>Overview</h2>
                <p>Welcome, Office User! Use the navigation above to manage your transactions and view invoices.</p>
            </section>
        </div>
    </div>
</body>
</html>
