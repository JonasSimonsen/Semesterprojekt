<%-- 
    Document   : newjsp
    Created on : Apr 19, 2015, 5:01:50 PM
    Author     : Emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login - MDF Processing Tool</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        
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
        <div class="col-md-2 col-md-offset-5" style="margin-top:100px;">
            <div class="panel panel-default">
                
                <div class="panel-body">
                    
                    
                    <img src="img/MDF-processing-tool-logo.png" class="img-responsive center-block"/>
                    
                    <form action="user_Login">
                        <div class="form-group">
                            <input type="text" class="form-control" name="username" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                        <div class="form-group text-center">
                            <button class="btn btn-primary" type="submit">Log in</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
