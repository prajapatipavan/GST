<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/addProduct" method="post">
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" required><br><br>

    <label for="productprize">Product Price:</label>
    <input type="number" id="productprize" name="productprize" step="0.01" required><br><br>

    <label for="productDescription">Product Description:</label>
    <textarea id="productDescription" name="productDescription" required></textarea><br><br>

    <label for="category">Category:</label>
    <input type="text" id="category" name="category" required><br><br>

    <label for="rate">Gst Rate:</label>
    <input type="text" class="form-control" id="rate" name="rate" placeholder="Enter GST rate" required>

    <label for="date">Date:</label>
    <input type="date" id="date" name="date" required><br><br>

    <button type="submit">Add Product</button>
</form>

</body>
</html>