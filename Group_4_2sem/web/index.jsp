<%-- 
    Document   : index
    Created on : Apr 7, 2015, 10:11:24 AM
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

        <title>MDF Processing Tool</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet">

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
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">MDF Processing Tool</a>
                </div>


                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="">
                        <a href="index.html"><i class="fa fa-user"></i> Poul Preben</a>
                    </li>
                </ul>


                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                        </li>

                        <li>
                            <a href="index.html"><i class="fa fa-fw fa-bar-chart"></i> Statistics</a>
                        </li>

                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#dd-campaigns"><i class="fa fa-fw fa-bullhorn"></i> Campaigns <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="dd-campaigns" class="collapse">

                                <li>
                                    <a href="">View Campaign</a>
                                </li>

                                <li>
                                    <a href="#">New Campaign</a>
                                </li>

                                <li>
                                    <a href="#">Edit Campaign</a>
                                </li>

                            </ul>
                        </li>

                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#dd-users"><i class="fa fa-fw fa-users"></i> Users <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="dd-users" class="collapse">

                                <li>
                                    <a href="#">View Users</a>
                                </li>
                                <li>
                                    <a href="new-user.html">New User</a>
                                </li>
                                <li>
                                    <a href="#">Edit User</a>
                                </li>


                            </ul>
                        </li>
                    </ul>
                </div>



                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                MDF Processing Tool
                                <small>Dashboard</small>
                            </h1>

                        </div>
                    </div> <!-- /.row -->

                    <div class="row">
                        
                        
                        
                        
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                
                                <div class="panel-heading">
                                    <h4 class="panel-title"><span class="fa fa-newspaper-o"></span> News</h4>
                                </div>

                                <div class="panel-body">
                                    <div class="list-group">

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>
                                    </div>
                                </div>

                                <div class="panel-footer">
                                    <a href="#" class="text-info">View All <span class="fa fa-arrow-circle-o-right"></span></a>
                                </div>
                                
                            </div>
                        </div>
                        
                        <div class="col-lg-4">
                            <div class="panel panel-default">
                                
                                <div class="panel-heading">
                                    <h4 class="panel-title"><span class="fa fa-globe"></span> Recent Activity</h4>
                                </div>

                                <div class="panel-body">
                                    <div class="list-group">

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>

                                        <a href="#" class="list-group-item">
                                            <b>Title</b>
                                            <p>Excerpt excerpt excerpt</p>
                                        </a>
                                    </div>
                                </div>

                                <div class="panel-footer">
                                    <a href="#" class="text-info">View All <span class="fa fa-arrow-circle-o-right"></span></a>
                                </div>
                                
                            </div>
                        </div>
                    </div>



                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div><!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>

