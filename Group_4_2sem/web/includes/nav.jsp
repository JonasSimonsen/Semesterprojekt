<%-- 
    Document   : nav
    Created on : Apr 7, 2015, 11:21:10 AM
    Author     : Emil
--%>

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
                                    <a href="users_new.jsp">New User</a>
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
