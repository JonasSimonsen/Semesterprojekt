<%-- 
    Document   : int_users_search
    Created on : Apr 7, 2015, 10:11:43 AM
    Author     : Group 04
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
            <jsp:include page="includes/int_nav.jsp"/>
            <!-- /Navigation -->

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Users
                                <small>Overview</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->
                    
                    <!-- Page Content -->
                     <div class="row" style="margin-top: 40px;">
                        <div class="col-md-12">
                            <table class="table table-bordered table-striped">
                                <thead>
                                <th class="text-center">User ID</th>
                                <th class="text-center">Username</th>
                                <th class="text-center">First Name</th>
                                <th class="text-center">Last Name</th>
                                <th class="text-center">E-mail</th>
                                <th class="text-center">Organization</th>
                                <th class="text-center"></th>
                                </thead>
                                <tbody>
                                    <c:forEach var="p" items="${campList}">
                                        <tr>
                                            <td class="col-md-1 text-center"><b>#${p.partnerID}</b></td>
                                            <td class="col-md-2 text-center">${p.userName}</td>
                                            <td class="col-md-2 text-center">${p.firstName}</td>
                                            <td class="col-md-2 text-center">${p.lastName}</td>
                                            <td class="col-md-2 text-center">${p.organization}</td>
                                            <td class="col-md-1 text-center">${p.type}</td>
                                            <td class="col-md-2 text-center">
                                                <form action="ext_Campaign_ViewCampaign">
                                                    <input type="hidden" name="id" value="${p.partnerID}">
                                                    <button type="submit" class="btn btn-link">Remove</button>
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

