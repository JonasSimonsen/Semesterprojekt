8<%-- 
    Document   : campaigns_submit
    Created on : Apr 8, 2015, 12:42:16 PM
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
                                Campaign
                                <small>Submit campaign</small>
                            </h1>
                        </div>
                    </div> 
                    <!-- /Page Heading -->

                    <!-- Page Content -->
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="text-info">Enterprise Field Marketing:</h3>
                            <h4 class="text-info">Marketing Development Fund (MDF) Request</h4>
                            <hr>

                            <form action="campaign_NewCampaign">
                                <div class="form-group">
                                    <label for="submit_date">Submission Date</label>
                                    <input class="form-control" type="text" name="submit_date" placeholder="YYYY-MM-DD" required>
                                </div>
                                <div class="form-group">
                                    <label for="contact_name">Contact Name</label>
                                    <input class="form-control" type="text" name="contact_name" placeholder="Jørgen Andersen" required>
                                </div>
                                <div class="form-group">
                                    <label for="company_name">Company Name</label>
                                    <input class="form-control" type="text" name="company_name" placeholder="JørgenIT A/S" required>
                                </div>
                                <div class="form-group">
                                    <label for="company_address">Company Address (city, state & zip)</label>
                                    <input class="form-control" type="text" name="company_address" placeholder="Havevej 20, 2970 Hørsholm" required>
                                </div>
                                <div class="form-group">
                                    <label for="contact_email">E-mail</label>
                                    <input class="form-control" type="text" name="contact_email" placeholder="mail@jorgenit.dk" required>
                                </div>
                                <div class="form-group">
                                    <label for="contact_phone">Phone</label>
                                    <input class="form-control" type="text" name="contact_phone" placeholder="+45 4545 4545" required>
                                </div>

                                <p class="text-muted">To best support your marketing needs, Dell recommends a 6+ week lead time (from the actual start date of the activity) to allow sufficient time for campaign development and promotion. The MDF request form allows you to fully detail your proposal for your marketing manager’s review.</p>
                                <span style="margin-right: 5px;" class="glyphicon glyphicon-info-sign"></span><strong>Please note, each field within the form must be completed for your request to be reviewed and/or approved.<br>Any submissions containing incomplete forms will be returned.</strong>
                                <hr>
                                <h4 class="text-info">Program overview:</h4>
                                <div class="form-group">
                                    <label for="program_date">Program Date:</label>
                                    <input class="form-control" type="text" name="program_date" placeholder="YYYY-MM-DD" required>
                                </div>
                                <div class="form-group">
                                    <label for="start_time">Start Time:</label>
                                    <input class="form-control" type="text" name="start_time" placeholder="12:00 pm" required>
                                </div>
                                <div class="form-group">
                                    <label for="end_time">End Time:</label>
                                    <input class="form-control" type="text" name="end_time" placeholder="12:00 am" required>
                                </div>
                                <div class="form-group">
                                    <label for="attendum">Estimated # of attendees</label>
                                    <input class="form-control" type="text" name="attendum" placeholder="1" required>
                                </div>
                                <div class="form-group">
                                    <label for="venue_name">Venue Name</label>
                                    <input class="form-control" type="text" name="venue_name" placeholder="" required>
                                </div>
                                <div class="form-group">
                                    <label for="venue_address">Venue Address</label>
                                    <input class="form-control" type="text" name="venue_address" placeholder="Havevej 20, 2970 Hørsholm" required>
                                </div>
                                <hr>
                                <h4 class="text-info">Type of lead generating program</h4>
                                <div class="form-group">
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="face_to_face" value="1">Face-to-face event</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="tradeshow" value="1">Tradeshows</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="multitouch" value="1">Multi-touch campaign</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="door_opener" value="1">Door opener campaign</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="third_party" value="1">Third party campaign</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="direct_mail" value="1">Direct mail</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="blitz" value="1">Blitz campaign (appt-setting or opportunity blitz)</label>
                                    </div>
                                    <div class="form-group">
                                        <label for="venue_address">Program description and/or agenda:</label>
                                        <textarea class="form-control" name="program_desc"></textarea>
                                    </div>
                                </div>
                                <hr>
                                <h4 class="text-info">Dell enterprise products to be discussed</h4>

                                <div class="form-group">
                                    <label>Storage</label>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="storage_sc4000" value="1">Dell storage SC4000 series</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="storage_ps4210" value="1">Dell storage PS4210 series</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="storage_solutions" value="1">Dell storage solutions</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="storage_flash" value="1">Flash at the price of disk</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="storage_fluidcache" value="1">Fluid cache for SAN</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="storage_data_protection" value="1">Data protection</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Server</label>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="server_newgen" value="1">The latest generation of Dell PowerEdge servers</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="server_win2003" value="1">Windows Server 2003 migration</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="server_x86" value="1">x86 server transition</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="server_vrtx" value="1">PowerEdge VRTX</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Networking</label>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="networking_sdn" value="1">Software-defined networking (SDN): data center networking</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="networking_user_centric" value="1">User centric networking</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Solutions</label>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="solutions_cloud" value="1">Cloud client-computing</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="solutions_converged" value="1">Coverged infrastructure hardware</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="solutions_blade" value="1">Dell converged blade data center</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="solutions_futureready" value="1">Optimized enterprise (Future-ready IT)</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="solutions_poweredge" value="1">PowerEdge FX architecture</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="solutions_sds" value="1">Software-defined storage (SDS)</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="campaign_component">Is there a software component to your campaign?</label>
                                    <p>If so, please detail the specific software component(s) in the space below.</p>
                                    <textarea class="form-control" name="campaign_component" placeholder=""></textarea>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <label>Target audience</label>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="target_smb" value="1">SMB (Small & Medium Business)</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="target_le" value="1">LE (Large Enterprise, LEA & G500)</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="target_pub" value="1">PUB (Public, Federal, Education and Healthcare)*</label>
                                    </div>
                                    <br><p class="text-muted">
                                        <span style="margin-right: 5px;" class="glyphicon glyphicon-info-sign"></span>
                                        *Partners need to comply with PUB restrictions and limitations within any programs. See additional information within the terms and conditions.</p>
                                </div>

                                <hr>
                                <h4 class="text-info">Additional program information</h4>

                                <div class="form-group">
                                    <label for="cost">Total projected cost of program</label>
                                    <input class="form-control" type="text" name="cost" placeholder="" required>
                                </div>
                                <div class="form-group">
                                    <label for="mdf_req">Total MDF requesting from Dell</label>
                                    <input class="form-control" type="text" name="mdf_req" placeholder="" required>
                                    <br><p class="text-muted">
                                        <span style="margin-right: 5px;" class="glyphicon glyphicon-info-sign"></span>
                                        Dell will fund up to fifty percent (50%*) of the projected total cost, based on actual costs incurred for the activity.<br>
                                        *See terms and conditions for rules and restrictions.
                                    </p>
                                </div>
                                <div class="form-group">
                                    <label for="reimbursement">Preferred method of reimbursement (AMEX or check/EFT)</label>
                                    <select class="form-control" name="reimbursement" required>
                                        <option selected value="">Select payment method</option>
                                        <option value="American Express">American Express</option>
                                        <option value="Check">Check</option>
                                        <option value="EFT"> Electronic Funds Transfer</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="partners">Participating Technology Partner(s) (VMware, Microsoft, etc.)</label>
                                    <input class="form-control" type="text" name="partners" placeholder="" required>
                                </div>
                                <div class="form-group">
                                    <label for="mdf_contr">Total Technology Partner(s) MDF contribution</label>
                                    <input class="form-control" type="text" name="mdf_contr" placeholder="" required>
                                </div>
                                <div class="form-group">
                                    <label for="opportunities">Estimated # of opportunities (deals registrered through Dell Deal Registration)</label>
                                    <input class="form-control" type="text" name="opportunities" placeholder="" required>
                                </div>
                                <div class="form-group">
                                    <label for="est_renevue">Estimated revenue from program</label>
                                    <input class="form-control" type="text" name="est_renevue" placeholder="" required>
                                </div>

                                <hr>

                                <p>Following the completion of this form, please submit your full MDF request to your Enterprise Field
                                    Marketing Manager for consideration and review. You may expect a response within 48 - 72 hours, provided all necessary details have been supplied.</p>

                                <div class="form-group">
                                    <br>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="terms" value="" required>I have read and accepted the <a href="#">Terms and Conditions</a> required to proceed.</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Submit Campaign</button>
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

