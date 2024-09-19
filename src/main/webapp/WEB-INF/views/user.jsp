<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create New User</title>

    <!-- Include Toastr for notifications -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <!-- Bootstrap CSS -->
    <%@ include file="bootstraplink.jsp" %>

    <style>
      .form-container {
        background-color: #f9f9f9;
        padding: 20px;
        border-radius: 5px;
        margin-top: 40px;
      }
      .form-title {
        text-align: center;
        margin-bottom: 20px;
        font-size: 22px;
      }
      .form-group {
        margin-bottom: 15px;
      }
    </style>

    <!-- Toastr success message -->
    <script type="text/javascript">
        $(document).ready(function() {
            var message = '${addusermsg}';
            if (message) {
                toastr.success(message);
            }
        });
    </script>
  </head>

  <body class="with-welcome-text">
    <div class="container-scroller">
      <%@ include file="NavbarDashbord.jsp" %>
      <div class="container-fluid page-body-wrapper">
        <%@ include file="sidebar.jsp" %>

        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row justify-content-center">
              <div class="col-lg-6">
                <div class="form-container">
                  <h3 class="form-title">Create New User</h3>
                  <form action="saveuser" method="POST">
                    <div class="form-group">
                      <label for="username">Username:</label>
                      <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
                    </div>
                    <div class="form-group">
                      <label for="password">Password:</label>
                      <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
                    </div>
                    <div class="form-group">
                      <label for="email">Email:</label>
                      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
                    </div>
                    <div class="form-group">
                      <label for="role">Role:</label>
                      <select class="form-control" id="role" name="role" required>
                        <c:forEach items="${listrole}" var="p">
                          <option value="${p.roleId}">${p.roleName}</option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="form-group text-center">
                      <input type="submit" class="btn btn-primary" value="Create User">
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>

          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Premium 
                <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> 
                from BootstrapDash.
              </span>
              <span class="float-none float-sm-end d-block mt-1 mt-sm-0 text-center">
                Copyright © 2023. All rights reserved.
              </span>
            </div>
          </footer>
        </div>
      </div>
    </div>
  </body>
</html>
