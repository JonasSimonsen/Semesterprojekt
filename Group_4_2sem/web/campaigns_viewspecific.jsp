<%-- 
    Document   : campaigns_viewspecific
    Created on : Apr 10, 2015, 10:29:11 AM
    Author     : Emil
--%>

<%@page import="model.Campaign"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Campaigns - Specific Campaign</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <jsp:include page="includes/nav.jsp"/>
            <!-- /Navigation -->

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                CAMPAIGN
                                <small>#${camp.plan_number}</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->

                    <!-- Page Content -->
                    <div class="row">

                        <div class="col-md-8">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Information</b>
                                </div>
                                <div class="panel-body">
                                    <p><b>Description</b><br>
                                        </p>

                                    <p><b>Objective</b><br>
                                        </p>

                                    <p><b>Audience</b><br>
                                        </p>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class='row'> 

                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Campagin Details</b>
                                    <c:choose>
                                        <c:when test="${camp.status == 'PENDING'}">
                                            <span class="badge pull-right" style="background-color: #D9534F">${camp.status}</span>
                                        </c:when>  
                                        <c:when test="${camp.status == 'APPROVED'}">
                                            <span class="badge pull-right" style="background-color: #5CB85C">${camp.status}</span>
                                        </c:when> 
                                        <c:when test="${camp.status == 'IN PROGRESS'}">
                                            <span class="badge pull-right" style="background-color: #F0AD4E">${camp.status}</span>
                                        </c:when> 
                                    </c:choose>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Campaign No.</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>Partner No.</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>Country</td>
                                                <td></td>
                                            </tr>

                                            <tr>
                                                <td>Audience</td>
                                                <td></td>
                                            </tr>

                                            <tr>
                                                <td>Quarter</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>Start Date</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>End Date</td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>  
                                </div>
                            </div>
                        </div>



                        <div class="col-md-3">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Financial Details</b>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Currency</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>Requested Budget</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>Provided Budget</td>
                                                <td></td>
                                            </tr>


                                        </tbody>
                                    </table>  
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Proof of Execution</b>
                                </div>
                                <div class="panel-body">
                                    <p>
                                        

                                    </p>
                                </div>
                            </div>
                        </div>


                        <div class="col-md-4">

                        </div>
                    </div>


                    <div class="row">






                    </div> 
                    <!-- /Page Content -->



                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div><!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>

