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
                                CAMPAIGNS
                                <small>Campaign No. ${camp.planNumber}</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->

                    <!-- Page Content -->
                    <div class="row">

                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Information</b>
                                </div>
                                <div class="panel-body">
                                    <p><b>Description</b><br>
                                        ${camp.description}</p>

                                    <p><b>Objective</b><br>
                                        ${camp.objective}</p>

                                    <p><b>Audience</b><br>
                                        ${camp.audience}</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Campagin Details</b>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Campaign No.</td>
                                                <td>${camp.planNumber}</td>
                                            </tr>
                                            <tr>
                                                <td>Partner No.</td>
                                                <td>${camp.partnerNumber}</td>
                                            </tr>
                                            <tr>
                                                <td>Country</td>
                                                <td>${camp.country}</td>
                                            </tr>

                                            <tr>
                                                <td>Audience</td>
                                                <td>${camp.audience}</td>
                                            </tr>
                                            <tr>
                                                <td>Status</td>
                                                <td>

                                                    <c:choose>
                                                        <c:when test="${camp.status == 'PENDING'}">
                                                            <b style='color:red;'>${camp.status}</b>
                                                        </c:when>  
                                                        <c:when test="${camp.status == 'APPROVED'}">
                                                        <b style='color:green;'>${camp.status}</b>
                                                    </c:when> 
                                                    <c:when test="${camp.status == 'IN PROGRESS'}">
                                                        <b style='color:orange;'>${camp.status}</b>
                                                    </c:when> 
                                                </c:choose>


                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Quarter</td>
                                                <td>${camp.quarter}</td>
                                            </tr>
                                            <tr>
                                                <td>Start Date</td>
                                                <td>${camp.startDate}</td>
                                            </tr>
                                            <tr>
                                                <td>End Date</td>
                                                <td>${camp.endDate}</td>
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
                                                <td>${camp.currency}</td>
                                            </tr>
                                            <tr>
                                                <td>Requested Budget</td>
                                                <td>${camp.cost}</td>
                                            </tr>
                                            <tr>
                                                <td>Provided Budget</td>
                                                <td>${camp.mdfBudget}</td>
                                            </tr>


                                        </tbody>
                                    </table>  
                                </div>
                            </div>
                        </div>


                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Feedback</b>
                                </div>
                                <div class="panel-body">
                                    <p>
                                        <c:choose>
                                            <c:when test="${camp.poeRequirement == 'null'}">
                                                Sorry, requirements have not yet been made.
                                            </c:when>  
                                            <c:otherwise>
                                                ${camp.poeRequirement}
                                            </c:otherwise>
                                        </c:choose>

                                    </p>
                                </div>
                            </div>
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

