<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Star Admin2 </title>

  </head>
  <body class="with-welcome-text">
    <div class="container-scroller">
    
       <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 18px;
            text-align: left;
        }
        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        
         #searchInput{
        width:26%;
        position: relative;
        left: 70%;
        
        }
            
        #transactionTable {
    width: 100%; /* Make the table take up the full width of its container */
    max-width: 1200px; /* Adjust as needed for your layout */
    margin: 0 auto; /* Center the table horizontally */
    border-collapse: collapse; /* Collapse table borders to remove spacing between cells */
}

#transactionTable th, #transactionTable td {
    padding: 8px; /* Add padding for readability */
    text-align: left; /* Align text to the left */
    border: 1px solid #ddd; /* Add a light border for separation */
}
    </style>
     <%@include file="bootstraplink.jsp"%>
    
     
      <%@include file="NavbarDashbord.jsp" %>
       
  
      <div class="container-fluid page-body-wrapper">
    
          <%@include file="sidebar.jsp" %>
       

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
                   <div class="col-sm-14 col-18 text-right m-b-90">
             <a href="Adduser" class="btn btn-primary btn-rounded float-left" ><i class="fa fa-plus"></i> Add USER</a>
            </div>

    <h1>List Of User</h1>
       <input type="text" id="searchInput" onkeyup="filterTable()" placeholder="Search for data..." title="Type in a keyword">
  <table id="dataTable" class="display">
        <thead>
            <tr>
                <td>UserName</td>
                <td>Email</td>
                <td>Status</td>
                   <td>Role</td>
                  <td>Action</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listuser}" var="c">
                <tr>
                    <td>${c.username}</td>
                    <td>${c.email}</td>
               
                    <td>${c.active}</td>
                    <td>${c.role.roleName}</td>
                       <td><a href="deleteuser?userId=${c.userId}" class="btn btn-danger">DELETE</a> |
                     
                     <a href="edituser?userId=${c.userId}" class="btn btn-info">EDIT</a>
                     
                     </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
                   
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash.</span>
              <span class="float-none float-sm-end d-block mt-1 mt-sm-0 text-center">Copyright © 2023. All rights reserved.</span>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <script>
        function filterTable() {
            var input, filter, table, tr, td, i, j, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("dataTable");
            tr = table.getElementsByTagName("tr");

            for (i = 1; i < tr.length; i++) {
                tr[i].style.display = "none"; // Hide the row initially
                td = tr[i].getElementsByTagName("td");

                for (j = 0; j < td.length; j++) {
                    if (td[j]) {
                        txtValue = td[j].textContent || td[j].innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                            break; // Once a match is found, no need to check further cells in this row
                        }
                    }
                }
            }
        }
    </script>
  </body>
</html>