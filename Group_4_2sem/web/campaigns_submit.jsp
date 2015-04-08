<%-- 
    Document   : campaigns_submit
    Created on : Apr 8, 2015, 12:42:16 PM
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

        <title>MDF Processing Tool - Submit Campaign</title>

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
            <jsp:include page="includes/nav.jsp"/>
            <!-- /Navigation -->

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                MDF Processing Tool
                                <small>Campaigns</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->

                    <!-- Page Content -->
                    <div class="row">
                        <div class="col-md-4">
                            <h3 class="text-info">Submit Campaign</h3>

                            <form action="campaign_NewCampaign">
                                <!-- COUNTRY -->
                                <div class="form-group">
                                    <label for="country" class="">Country</label>
                                    <input type="text" class="form-control form-horizontal" name="country" placeholder="3 chars. ex. FIN/DAN/USA" required>
                                </div>
                                <div class="form-group">
                                    <label for="description" class="">Description</label>
                                    <textarea class="form-control resize-none" name="description" required rows="6"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="audience" class="">Audience</label>
                                    <input type="text" class="form-control" name="audience" required>
                                </div>
                                <div class="form-group">
                                    <label for="currency" class="">Currency</label>
                                    <select class="form-control" name="currency">
                                        <option selected value="">Select Currency</option>
                                        <option value="AUD">AUD</option>
                                        <option value="CHF">CHF</option>
                                        <option value="DKK">DKK</option>
                                        <option value="EUR">EUR</option>
                                        <option value="GBP">GBP</option>
                                        <option value="INR">INR</option>
                                        <option value="JPY">JPY</option>
                                        <option value="NOK">NOK</option>
                                        <option value="SEK">SEK</option>
                                        <option value="USD">USD</option>
                                    </select>
                                </div>
                                
                                <div class="form-group">
                                    <label for="cost" class="">Cost</label>
                                    <input type="text" class="form-control" name="cost" placeholder="Ex. 18200 (No symbols)" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="quarter" class="">Quarter</label>
                                    <input type="text" class="form-control" name="quarter" placeholder="FY16Q2" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="start-date" class="">Start date</label>
                                    <input type="date" class="form-control" name="start-date" placeholder="YYYY-MM-DD" required>
                                </div>
                                <div class="form-group">
                                    <label for="end-date" class="">End date</label>
                                    <input type="date" class="form-control" name="end-date" placeholder="YYYY-MM-DD" required>
                                </div>
                                <div class="form-group">
                                    <label for="objective" class="">Objective</label>
                                    <textarea class="form-control" name="objective"  required></textarea>
                                </div>
                                
                                
                                
                                <!-- SUBMIT BUTTON -->
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Submit Campaign</button>
                                </div> 
                            </form>

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

