<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title></title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="asset/vendors/feather/feather.css">
    <link rel="stylesheet" href="asset/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="asset/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="asset/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="asset/vendors/typicons/typicons.css">
    <link rel="stylesheet" href="asset/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="asset/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="asset/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="asset/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="asset/js/select.dataTables.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="asset/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="asset/images/favicon.png" />
  </head>
  <body class="with-welcome-text">
    <div class="container-scroller">
    
      
      <!-- partial:partials/_navbar.html -->
      <%@include file="NavbarDashbord.jsp" %>
       
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
          <%@include file="sidebar.jsp" %>
       
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
              <div class="col-sm-12">
                <div class="home-tab">
                 <!--  <div class="d-sm-flex align-items-center justify-content-between border-bottom">
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="nav-item">
                        <a class="nav-link active ps-0" id="home-tab" data-bs-toggle="tab" href="#overview" role="tab" aria-controls="overview" aria-selected="true">Massages</a>
                      </li>
                      
                    </ul>
                    
                  </div> -->
                  <div class="tab-content tab-content-basic">
                    <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview">
                      
                   
                      <div class="row">
                  
                        <div class="col-lg-4 d-flex flex-column">
                          
                        
                       <!--   
                          <div class="row flex-grow">
                            <div class="col-12 grid-margin stretch-card">
                              <div class="card card-rounded">
                                <div class="card-body">
                                  <div class="row">
                                    <div class="col-lg-12">
                                      <div class="d-flex justify-content-between align-items-center mb-3">
                                        <div>
                                          <h4 class="card-title card-title-dash">Last Massage</h4>
                                        </div>
                                      </div>
                                      
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div> -->
                        </div>
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
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="vendors/js/vendor.bundle.base.js"></script>
    <script src="asset/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="asset/vendors/chart.js/chart.umd.js"></script>
    <script src="asset/vendors/progressbar.js/progressbar.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="asset/js/off-canvas.js"></script>
    <script src="asset/js/template.js"></script>
    <script src="asset/js/settings.js"></script>
    <script src="asset/js/hoverable-collapse.js"></script>
    <script src="asset/js/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page-->
    <script src="asset/js/jquery.cookie.js" type="text/javascript"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="asset/js/dashboard.js"></script>
    <!-- <script src="asset/js/Chart.roundedBarCharts.js"></script> -->
    <!-- End custom js for this page-->
  </body>
  
  
</html>