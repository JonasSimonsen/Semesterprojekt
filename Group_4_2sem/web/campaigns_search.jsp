<%-- 
    Document   : campaigns_search
    Created on : Apr 10, 2015, 10:32:31 AM
    Author     : Emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>MDF Processing Tool -  New User</title>

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
                                <small>Search</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->

                    <!-- Page Content -->
                    <div class="row">
                        <div class="col-md-4">      
                            <h3 class="text-info">Search for campaign</h3>
                            <form action="campaign_ViewCampaign">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="id" placeholder="Enter campaign ID...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">Go!</button>
                                    </span>
                                </div>
                            </form>
                            <h3 class="text-info">List all campaigns</h3>          
                            <form action="campaign_ViewAll">
                                <div class="input-group">
                                    <button class="btn btn-default" type="submit">Get Campaign List</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="row" style="margin-top: 40px;">
                        <div class="col-md-12">
                            <table class="table table-bordered table-striped">
                                <thead>
                                <th class="text-center">Campaign No.</th>
                                <th class="text-center">Start Date</th>
                                <th class="text-center">End Date</th>
                                <th class="text-center">Quarter</th>
                                <th class="text-center">Status</th>
                                <th class="text-center">Link</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="p" items="${campList}">
                                        <tr>
                                            <td class="col-md-2 text-center"><b>#${p.planNumber}</b></td>
                                            <td class="col-md-2 text-center">${p.startDate}</td>
                                            <td class="col-md-2 text-center">${p.endDate}</td>
                                            <td class="col-md-2 text-center">${p.quarter}</td>
                                            <td class="col-md-2 text-center">
                                                <c:choose>
                                                    <c:when test="${p.status == 'PENDING'}">
                                                        <span class="" style="color: #D9534F"><b>${p.status}</b></span>
                                                            </c:when>  
                                                            <c:when test="${p.status == 'APPROVED'}">
                                                        <span class="" style="color: #5CB85C"><b>${p.status}</b></span>
                                                            </c:when> 
                                                            <c:when test="${p.status == 'IN PROGRESS'}">
                                                        <span class="" style="color: #F0AD4E"><b>${p.status}</b></span>
                                                            </c:when> 
                                                        </c:choose>
                                            </td>
                                            <td class="col-md-2 text-center">
                                                <form action="campaign_ViewCampaign">
                                                    <input type="hidden" name="id" value="${p.planNumber}">
                                                    <button type="submit" class="btn btn-link">View Campaign</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
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


