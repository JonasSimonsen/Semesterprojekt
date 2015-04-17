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
                    <div class='row'> 

                        <div class="col-md-4 ">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Partner Details</b>

                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Submission Date</td>
                                                <td class="text-right">${camp.submit_date}</td>
                                            </tr>
                                            <tr>
                                                <td>Contact Name</td>
                                                <td class="text-right">${camp.contact_name}</td>
                                            </tr>
                                            <tr>
                                                <td>Contact E-mail</td>
                                                <td class="text-right">${camp.contact_email}</td>
                                            </tr>

                                            <tr>
                                                <td>Contact Phone</td>
                                                <td class="text-right">${camp.contact_phone}</td>
                                            </tr>

                                            <tr>
                                                <td>Company Name</td>
                                                <td class="text-right">${camp.company_name}</td>
                                            </tr>

                                            <tr>
                                                <td>Company Address</td>
                                                <td class="text-right">${camp.company_address}</td>
                                            </tr>


                                        </tbody>
                                    </table>  
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Dell enterprise products to be discussed</b>
                                </div>
                                <div class="panel-body">
                                    <c:choose>
                                        <c:when test="${camp.storage_sc4000 == 1 || camp.storage_ps4210 == 1 || camp.storage_solutions == 1 || camp.storage_flash == 1 || camp.storage_fluidcache == 1 || camp.storage_data_protection == 1}">

                                            <p class="text-muted"><b>Storage</b></p>

                                            <c:choose>
                                                <c:when test="${camp.storage_sc4000 == 1}">
                                                    <p>Dell storage SC4000 series</p>
                                                </c:when>
                                                <c:when test="${camp.storage_ps4210 == 1}">
                                                    <p>Dell storage PS4210 series</p>
                                                </c:when>
                                                <c:when test="${camp.storage_solutions == 1}">
                                                    <p>Dell storage solutions</p>
                                                </c:when>
                                                <c:when test="${camp.storage_flash == 1}">
                                                    <p>Flash at the price of disk</p>
                                                </c:when>
                                                <c:when test="${camp.storage_fluidcache == 1}">
                                                    <p>Fluid cache for SAN</p>
                                                </c:when>
                                                <c:when test="${camp.storage_data_protection == 1}">
                                                    <p>Data protection</p>
                                                </c:when>
                                            </c:choose>
                                            <hr>
                                        </c:when>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${camp.server_newgen == 1 || camp.server_win2003 == 1 || camp.server_x86 == 1 || camp.server_vrtx == 1}">

                                            <p class="text-muted"><b>Server</b></p>

                                            <c:choose>
                                                <c:when test="${camp.server_newgen == 1}">
                                                    <p>The latest generation of Dell PowerEdge servers</p>
                                                </c:when>
                                                <c:when test="${camp.server_win2003 == 1}">
                                                    <p>Windows Server 2003 migration</p>
                                                </c:when>
                                                <c:when test="${camp.server_x86 == 1}">
                                                    <p>x86 server transition</p>
                                                </c:when>
                                                <c:when test="${camp.server_vrtx == 1}">
                                                    <p>PowerEdge VRTX</p>
                                                </c:when>
                                            </c:choose>
                                            <hr>
                                        </c:when>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${camp.networking_sdn == 1 || camp.networking_user_centric == 1}">

                                            <p class="text-muted"><b>Networking</b></p>

                                            <c:choose>
                                                <c:when test="${camp.server_newgen == 1}">
                                                    <p>Software-defined networking (SDN): data center networking</p>
                                                </c:when>
                                                <c:when test="${camp.server_win2003 == 1}">
                                                    <p>User-centric networking</p>
                                                </c:when>
                                            </c:choose>
                                            <hr>
                                        </c:when>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${camp.solutions_cloud == 1 || camp.solutions_converged == 1 || camp.solutions_blade == 1 || camp.solutions_futureready == 1 || camp.solutions_poweredge == 1 || camp.solutions_sds == 1}">

                                            <p class="text-muted"><b>Solutions</b></p>

                                            <c:choose>
                                                <c:when test="${camp.solutions_cloud == 1}">
                                                    <p>Cloud client-computing</p>
                                                </c:when>
                                                <c:when test="${camp.solutions_converged == 1}">
                                                    <p>Converged infrastructure hardware</p>
                                                </c:when>
                                                <c:when test="${camp.solutions_blade == 1}">
                                                    <p>Dell converged blade data center</p>
                                                </c:when>
                                                <c:when test="${camp.solutions_futureready == 1}">
                                                    <p>Optimized enterprise (Future-ready IT)</p>
                                                </c:when>
                                                <c:when test="${camp.solutions_poweredge == 1}">
                                                    <p>PowerEdge FX architecture</p>
                                                </c:when>
                                                <c:when test="${camp.solutions_sds == 1}">
                                                    <p>Software-defined storage (SDS)</p>
                                                </c:when>
                                            </c:choose>
                                            <hr>
                                        </c:when>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${camp.campaign_component != null}">
                                            <p><b>Software component</b></p>
                                            <p>${camp.campaign_component}</p>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div> 
                        </div>



                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Program Overview</b>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Program Date</td>
                                                <td class="text-right">${camp.program_date}</td>
                                            </tr>
                                            <tr>
                                                <td>Start Time</td>
                                                <td class="text-right">${camp.start_time}</td>
                                            </tr>
                                            <tr>
                                                <td>End Time</td>
                                                <td class="text-right">${camp.end_time}</td>
                                            </tr>
                                            <tr>
                                                <td>Estimated # of attendees:</td>
                                                <td class="text-right">${camp.attendum}</td>
                                            </tr>
                                            <tr>
                                                <td>Venue Name</td>
                                                <td class="text-right">${camp.venue_name}</td>
                                            </tr>
                                            <tr>
                                                <td>Venue Address</td>
                                                <td class="text-right">${camp.venue_address}</td>
                                            </tr>


                                        </tbody>
                                    </table>  
                                </div>


                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Type of lead generating program</b>
                                </div>
                                <div class="panel-body">
                                    <p><b>Type</b></p>
                                    <c:choose>
                                        <c:when test="${camp.face_to_face == 1}">
                                            <p>Face-to-Face event</p>
                                        </c:when>
                                        <c:when test="${camp.tradeshow == 1}">
                                            <p>Tradeshows</p>
                                        </c:when>
                                        <c:when test="${camp.multitouch == 1}">
                                            <p>Multi-touch campaign</p>
                                        </c:when>
                                        <c:when test="${camp.door_opener == 1}">
                                            <p>Door opener campaign</p>
                                        </c:when>
                                        <c:when test="${camp.third_party == 1}">
                                            <p>Third party campaign</p>
                                        </c:when>
                                        <c:when test="${camp.direct_mail == 1}">
                                            <p>Direct mail</p>
                                        </c:when>
                                        <c:when test="${camp.blitz == 1}">
                                            <p>Blitz campaign (appt-setting or opportunity blitz)</p>
                                        </c:when>
                                    </c:choose>

                                    <p><b>Program description and/or agenda</b></p>
                                    <c:choose>
                                        <c:when test="${camp.program_desc != null}">
                                            <p>${camp.program_desc}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p>No additional description has been given.</p>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div> 

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Target Audience</b>

                                </div>
                                <div class="panel-body">
                                    <c:choose>
                                        <c:when test="${camp.target_smb == 1 || camp.target_le == 1 || camp.target_pub == 1}">

                                            <c:choose>
                                                <c:when test="${camp.target_smb == 1}">
                                                    <p>SMB (Small & Medium Business)</p>
                                                </c:when>
                                                <c:when test="${camp.target_le == 1}">
                                                    <p>LE (Large Enterprise, LEA & G500)</p>
                                                </c:when>
                                                <c:when test="${camp.target_pub == 1}">
                                                    <p>PUB (Public, Federal, Education and Healthcare</p>
                                                </c:when>
                                            </c:choose>
                                            <hr>
                                        </c:when>
                                    </c:choose>

                                </div>
                            </div> 
                        </div>


                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Additional Details</b>
                                    <c:choose>
                                        <c:when test="${camp.status == 'PENDING'}">
                                            <span class="badge pull-right" style="background-color: #D9534F">${camp.status}</span>
                                        </c:when>  
                                        <c:when test="${camp.status == 'POE APPROVED'}">
                                            <span class="badge pull-right" style="background-color: #5CB85C">${camp.status}</span>
                                        </c:when> 
                                        <c:when test="${camp.status == 'BUDGET APPROVED'}">
                                            <span class="badge pull-right" style="background-color: #ff9900">${camp.status}</span>
                                        </c:when>
                                        <c:when test="${camp.status == 'BUDGET DISAPPROVED'}">
                                            <span class="badge pull-right" style="background-color: #D9534F">${camp.status}</span>
                                        </c:when>
                                        <c:when test="${camp.status == 'POE DISAPPROVED'}">
                                            <span class="badge pull-right" style="background-color: #D9534F">${camp.status}</span>
                                        </c:when>     
                                    </c:choose>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Total projected cost</td>
                                                <td>${camp.cost}</td>
                                            </tr>
                                            <tr>
                                                <td>Total MDF requesting</td>
                                                <td>${camp.mdf_req}</td>
                                            </tr>
                                            <tr>
                                                <td>Method of reimbursement</td>
                                                <td>${camp.reimbursement}</td>
                                            </tr>

                                        </tbody>
                                    </table>  

                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Participating Technology Partners</td>
                                                <td>${camp.partners}</td>
                                            </tr>
                                            <tr>
                                                <td>Total Technology Partners MDF contribution</td>
                                                <td>${camp.mdf_contr}</td>
                                            </tr>
                                            <tr>
                                                <td>Estimated # of opportunities</td>
                                                <td>${camp.opportunities}</td>
                                            </tr>
                                            <tr>
                                                <td>Estimated revenue from program</td>
                                                <td>${camp.est_renevue}</td>
                                            </tr>

                                        </tbody>
                                    </table> 




                                </div>
                            </div> 
                        </div>

                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <b>Proof of Execution</b>
                                </div>
                                <div class="panel-body">

                                    <c:if test="${camp.has_poe != 1}">

                                        <form action="campaign_SavePOE" method="post" enctype='multipart/form-data'>
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="${camp.plan_number}">
                                                <input type="file" name="fIlE_UpLoAd-N1C3-F1Le-4-h4X">
                                            </div>              
                                            <div class="form-group">
                                                <button class="btn btn-default" type="submit">Upload</button>
                                            </div>  
                                        </form>

                                    </c:if>        

                                    <hr>
                                    <c:if test="${camp.has_poe == 1}">

                                        <form action="campaign_LoadPOE">
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="${camp.plan_number}">
                                                <button class="btn btn-default" action="submit">Load POE</button>
                                            </div>
                                        </form>

                                    </c:if>


                                </div>

                            </div>
                        </div>

                    </div>


                    <div class="row">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="panel panel-danger">
                                <div class="panel-heading">
                                    <b>Admin Panel</b>
                                </div>
                                <div class="panel-body">
                                    <div class="col-xs-3">
                                        <form action="campaign_ApproveBudget">
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="${camp.plan_number}">
                                            </div>

                                            <div class="form-group text-center">
                                                <button class="btn btn-default" type="submit">
                                                    Approve Budget
                                                </button> 
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-xs-3">
                                        <form action="campaign_DisapproveBudget">
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="${camp.plan_number}">
                                            </div>

                                            <div class="form-group text-center">
                                                <button class="btn btn-default" type="submit">
                                                    Disapprove Budget
                                                </button> 
                                            </div>
                                        </form>    
                                    </div>

                                    <div class="col-xs-3">
                                        <form action="campaign_ApprovePOE">
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="${camp.plan_number}">
                                            </div>

                                            <div class="form-group text-center">
                                                <button class="btn btn-default" type="submit">
                                                    Approve POE
                                                </button> 
                                            </div>
                                        </form>    
                                    </div>

                                    <div class="col-xs-3">
                                        <form action="campaign_DisapprovePOE">
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="${camp.plan_number}">
                                            </div>

                                            <div class="form-group text-center">
                                                <button class="btn btn-default" type="submit">
                                                    Disapprove POE
                                                </button> 
                                            </div>
                                        </form>    
                                    </div>
                                </div>
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

