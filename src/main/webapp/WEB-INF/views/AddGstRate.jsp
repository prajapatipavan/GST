<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create GST Rate</title>
</head>
<body>
    <h1>Create New GST Rate</h1>
    <form action="createGSTRate" method="post">
        <label for="rate">Rate:</label>
        <input type="text" id="rate" name="rate" required /><br/><br/>

        <label for="effectiveRate">Effective Rate:</label>
        <input type="text" id="effectiveRate" name="effactiveRate" required /><br/><br/>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br/><br/>

        <input type="submit" value="Create GST Rate" />
    </form>
</body>
</html>
