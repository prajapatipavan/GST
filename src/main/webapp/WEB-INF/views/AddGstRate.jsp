<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create New GST Rate</title>

    <!-- Include Bootstrap CSS -->
    <%@ include file="bootstraplink.jsp" %>

    <style>
      /* Simple form styling */
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
                  <h3 class="form-title">Create New GST Rate</h3>
                  <form action="createGSTRate" method="post">
                    <div class="form-group">
                      <label for="rate">Rate:</label>
                      <input type="text" class="form-control" id="rate" name="rate" placeholder="Enter GST rate" required>
                    </div>
                    <div class="form-group">
                      <label for="effectiveRate">Effective Rate:</label>
                      <input type="text" class="form-control" id="effectiveRate" name="effectiveRate" placeholder="Enter effective rate" required>
                    </div>
                    <div class="form-group">
                      <label for="description">Description:</label>
                      <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter description" required></textarea>
                    </div>
                    <div class="form-group text-center">
                      <input type="submit" class="btn btn-primary" value="Create GST Rate">
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
