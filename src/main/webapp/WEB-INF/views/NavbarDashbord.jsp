
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dropdown Test</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>



<nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex align-items-top flex-row">
    <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-start">
      <div class="me-3">
      
      <c:if test="${empty logginuser}">
      
         <c:redirect url="login"></c:redirect>
      
      </c:if>
        
      </div>
      <div>
        <a class="navbar-brand brand-logo" href="index.html">
          <h3>GST BOOK</h3>
        </a>
        <a class="navbar-brand brand-logo-mini" href="index.html">
          <img src="asset/images/logo-mini.svg" alt="logo" />
        </a>
      </div>
    </div>
    <div class="navbar-menu-wrapper d-flex align-items-top">
      <ul class="navbar-nav">
        <li class="nav-item fw-semibold d-none d-lg-block ms-0">
          <h1 class="welcome-text">Hello <span class="text-black fw-bold"></span>,${logginuser.username}</h1>
          <h3 class="welcome-sub-text">Enjoy....!!!! </h3>
        </li>
        
        
        
      </ul>
      
      
    <ul class="navbar-nav ms-auto">
      <li class="nav-item dropdown d-none d-lg-block user-dropdown">
        <a class="nav-link" id="UserDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          <img class="img-xs rounded-circle clickable-profile-image" src="asset/images/faces/face8.jpg" alt="Profile image"  >
           <p> ${logginuser.username} </p>
        </a>
        <ul class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
          <li>
            <a class="dropdown-item" href="#"><i class="mdi mdi-account-outline text-primary me-2"></i> My Profile <span class="badge badge-pill badge-danger">1</span></a>
          </li>
          
          <li>
            <a class="dropdown-item" href="logout"><i class="mdi mdi-power text-primary me-2"></i> Log Out</a>
          </li>
        </ul>
      </li>
    </ul>
        
    </div>
  </nav>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>

  <script>
    $(document).ready(function(){
      $('.clickable-profile-image').on('click', function(e){
        e.stopPropagation();
        $(this).closest('.user-dropdown').find('.dropdown-menu').toggle();
      });
      $(document).on('click', function(e){
        if (!$(e.target).closest('.user-dropdown').length) {
          $('.dropdown-menu').hide();
        }
      });
    });
  </script>

</body>
</html>
