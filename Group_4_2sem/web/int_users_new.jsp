<%-- 
    Document   : users_new
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
            <jsp:include page="includes/nav.jsp"/>
            <!-- /Navigation -->

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                USER
                                <small>New user</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->
                    
                    <!-- Page Content -->
                    <div class="row">
                        <div class="col-md-3">
                            <h3 class="text-info">Create new user</h3>
                            <div class="">
                                <form action="user_NewUser">
                                    <!-- USERNAME -->
                                    <div class="form-group">
                                        <label for="username" class="">Username</label>
                                        <input type="text" class="form-control" name="username" placeholder="" required>
                                    </div>
                                    <!-- PASSWORD -->
                                    <div class="form-group">
                                        <label for="password" class="">Password</label>
                                        <input type="password" class="form-control" name="password" placeholder="" required>
                                    </div>
                                    <!-- FIRST NAME -->
                                    <div class="form-group">
                                        <label for="first-name" class="">First name</label>
                                        <input type="text" class="form-control" name="first-name" placeholder="" required>
                                    </div>
                                    <!-- LAST NAME -->
                                    <div class="form-group">
                                        <label for="last-name" class="">Last name</label>
                                        <input type="text" class="form-control" name="last-name" placeholder="" required>
                                    </div>
                                    <!-- E-MAIL -->
                                    <div class="form-group">
                                        <label for="email" class="">E-mail</label>
                                        <input type="email" class="form-control" name="email" placeholder="" required>
                                    </div>
                                    <!-- PHONE -->
                                    <div class="form-group">
                                        <label for="phone" class="">Phone Number</label>
                                        <input type="phone" class="form-control" name="phone" placeholder=""required>
                                    </div>
                                    <!-- ORGANIZATION -->
                                    <div class="form-group">
                                        <label for="organization" class="">Organization/Retailer</label>
                                        <input type="text" class="form-control" name="organization" placeholder="" required>
                                    </div>
                                    <!-- USER TYPE -->
                                    <div class="form-group">
                                        <label for="user-type" class="">Type</label>
                                        <div class="radio">
                                            <label><input type="radio" name="user-type-internal">Internal User</label>
                                        </div>
                                        <div class="radio">
                                            <label><input type="radio" name="user-type-external">External User</label>
                                        </div>
                                    </div>
                                    <!-- ORGANIZATION -->
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">Create user</button>
                                    </div> 
                                </form>
                            </div>
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

