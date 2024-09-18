<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
     <title>Add New Role</title>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
 
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    
</head>
 <script type="text/javascript">
        $(document).ready(function() {
            var message = '${roleaddmsg}';
            if (message) {
                toastr.success(message);
            }
        });
    </script>
<body>
    <h2>Add New Role</h2>
    <form action="saverole" method="POST">
        <label for="role_name">Role Name:</label>
        <input type="text" id="role_name" name="roleName"><br><br>
        <input type="submit" value="Add Role">
    </form>
</body>
</html>
