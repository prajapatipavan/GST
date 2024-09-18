<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Navigation Bar</title>
    <style>
        /* Style the navigation bar */
        .navbar {
            overflow: hidden;
            background-color: #333;  /* Dark background color */
            padding: 14px 16px;
        }

        /* Style the links inside the navigation bar */
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Change the color of links on hover */
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Right-align a link in the navbar */
        .navbar a.right {
            float: right;
        }
    </style>
</head>
<body>

    <!-- Navigation bar -->
    <div class="navbar">
        <a href="listTransaction">Home</a>
       
        <a href="disactivatetransactionlist">DisActivate Transactions</a>
        <a href="#" class="right">${logginuser.email }</a>
    </div>

    <div style="padding:20px;">
        <h1>Welcome to the Transaction Management System</h1>
        <p>Use the navigation bar to manage your transactions and profile.</p>
    </div>

</body>
</html>
