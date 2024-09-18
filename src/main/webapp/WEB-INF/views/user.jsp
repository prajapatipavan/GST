<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>S</title>

  <title>Create New User</title>
    
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
 
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
  </head>
  
  <script type="text/javascript">
        $(document).ready(function() {
            var message = '${addusermsg}';
            if (message) {
                toastr.success(message);
            }
        });
    </script>
  <body class="with-welcome-text">
  
  <%@ include file="bootstraplink.jsp" %>
    <div class="container-scroller">
    
      
   
      <%@include file="NavbarDashbord.jsp" %>
       
   
      <div class="container-fluid page-body-wrapper">
        
          <%@include file="sidebar.jsp" %>
       
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
              <div class="col-sm-12">
                <div class="home-tab">
                  <div class="d-sm-flex align-items-center justify-content-between border-bottom">
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="nav-item">
                        <a class="nav-link active ps-0" id="home-tab" data-bs-toggle="tab" href="#overview" role="tab" aria-controls="overview" aria-selected="true">Overview</a>
                      </li>
                      
                    </ul>
                    
                  </div>
                  <div class="tab-content tab-content-basic">
                    <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview">
                      
                   
                      <div class="row">
                  <h2>Create New User</h2>
    <form action="saveuser" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

         
      <label for="role">ROLE:</label>
        <select id="role" name="role" required>
            <c:forEach items="${listrole}" var="p">
                <option value="${p.roleId}">${p.roleName}</option>
            </c:forEach>
        </select><br/><br/> 
        <input type="submit" value="Create User">
    </form>
                   
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
         
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash.</span>
              <span class="float-none float-sm-end d-block mt-1 mt-sm-0 text-center">Copyright © 2023. All rights reserved.</span>
            </div>
          </footer>
       
        </div>
      
      </div>
      
    </div>
  

  </body>
</html>