<%@page import="entity.Equipe"%>
<%@page import="entity.Projet"%>
<%@page import="java.util.List"%>
<%@page import="entity.Employe"%>
<%@page import="dao.EmployeImpl"%>
<%@page import="dao.EquipeImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="images/fav.ico" type="image/x-icon"  >
    <!------ Include the above in your HEAD tag ---------->
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Administrateur</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert2@7.8.2/dist/sweetalert2.all.js"></script>
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- font awesome CSS
		============================================ -->
    <link rel="stylesheet" href="css/font-awesome.min.css">



    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="css/main.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <style>
        .table-bordered {
            border: 1px solid #dddddd;
            border-collapse: separate;
            border-left: 0;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
        }

        .table {
            width: 100%;
            margin-bottom: 20px;
            background-color: transparent;
            border-collapse: collapse;
            border-spacing: 0;
            display: table;
        }

        .widget.widget-table .table {
            margin-bottom: 0;
            border: none;
        }

        .widget.widget-table .widget-content {
            padding: 0;
        }

        .widget .widget-header+.widget-content {
            border-top: none;
            -webkit-border-top-left-radius: 0;
            -webkit-border-top-right-radius: 0;
            -moz-border-radius-topleft: 0;
            -moz-border-radius-topright: 0;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .widget .widget-content {
            padding: 20px 15px 15px;
            background: #FFF;
            border: 1px solid #D5D5D5;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }

        .widget .widget-header {
            position: relative;
            height: 40px;
            line-height: 40px;
            background: #E9E9E9;
            background: -moz-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #e9e9e9));
            background: -webkit-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);
            background: -o-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);
            background: -ms-linear-gradient(top, #fafafa 0%, #e9e9e9 100%);
            background: linear-gradient(top, #fafafa 0%, #e9e9e9 100%);
            text-shadow: 0 1px 0 #fff;
            border-radius: 5px 5px 0 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1), inset 0 1px 0 white, inset 0 -1px 0 rgba(255, 255, 255, 0.7);
            border-bottom: 1px solid #bababa;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
            border: 1px solid #D5D5D5;
            -webkit-border-top-left-radius: 4px;
            -webkit-border-top-right-radius: 4px;
            -moz-border-radius-topleft: 4px;
            -moz-border-radius-topright: 4px;
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
            -webkit-background-clip: padding-box;
        }

        thead {
            display: table-header-group;
            vertical-align: middle;
            border-color: inherit;
        }

        .widget .widget-header h3 {
            top: 2px;
            position: relative;
            left: 10px;
            display: inline-block;
            margin-right: 3em;
            font-size: 14px;
            font-weight: 600;
            color: #555;
            line-height: 18px;
            text-shadow: 1px 1px 2px rgba(255, 255, 255, 0.5);
        }

        .widget .widget-header [class^="icon-"],
        .widget .widget-header [class*=" icon-"] {
            display: inline-block;
            margin-left: 13px;
            margin-right: -2px;
            font-size: 16px;
            color: #555;
            vertical-align: middle;
        }
        
        
        #header.header-scrolled {
    background: #fff;
    padding: 20px 0;
    height: 72px;
    transition: all 0.5s;
}
#header {
    padding: 17px 0;
    height: 70px;
    position: fixed;
    left: 0;
    top: 0;
    right: 0;
    transition: all 0.5s;
    z-index: 997;
    background-color: #d0faed;
    box-shadow: 5px 0px 15px #c3c3c3;
}
#header #logo h1 {
    font-size: 34px;
    margin: 0;
    padding: 0;
    line-height: 1;
    font-family: "Pacifico", sans-serif;
    font-weight: 700;
    letter-spacing: 3px;
}
#header #logo h1 a, #header #logo h1 a:hover {
    color: #000;
    padding-left: 10px;
    border-left: 4px solid grey;
}
#nav-menu-container {
    float: right;
    margin: 0;
}
.nav-menu > li {
    margin-left: 10px;
}
.nav-menu > li {
    float: left;
}
.nav-menu li {
    position: relative;
    white-space: nowrap;
}
.nav-menu, .nav-menu * {
    margin: 0;
    padding: 0;
    list-style: none;
}
.header-scrolled .nav-menu li:hover > a, .header-scrolled .nav-menu > .menu-active > a {
    color: #18d26e;
}
.header-scrolled .nav-menu a {
    color: black;
}
.nav-menu li:hover > a, .nav-menu > .menu-active > a {
    color: #18d26e;
}
.nav-menu a {
    padding: 7px 10px 7px 7px;
    text-decoration: none;
    display: inline-block;
    color: #000;
    font-family: "Montserrat", sans-serif;
    font-weight: 700;
    font-size: 13px;
    text-transform: uppercase;
    outline: none;
}
#mobile-nav-toggle {
    display: inline;
}
#mobile-nav-toggle {
    position: fixed;
    right: 0;
    top: 0;
    z-index: 999;
    margin: 20px 20px 0 0;
    border: 0;
    background: none;
    font-size: 24px;
    display: none;
    transition: all 0.4s;
    outline: none;
    cursor: pointer;
}
#mobile-body-overly {
    width: 100%;
    height: 100%;
    z-index: 997;
    top: 0;
    left: 0;
    position: fixed;
    background: rgba(0, 0, 0, 0.7);
    display: none;
}
body.mobile-nav-active #mobile-nav {
    left: 0;
}
#mobile-nav {
    position: fixed;
    top: 0;
    padding-top: 18px;
    bottom: 0;
    z-index: 998;
    background: rgba(0, 0, 0, 0.8);
    left: -260px;
    width: 260px;
    overflow-y: auto;
    transition: 0.4s;
}
#mobile-nav ul {
    padding: 0;
    margin: 0;
    list-style: none;
}
#mobile-nav ul li {
    position: relative;
}
#mobile-nav ul li a {
    color: #fff;
    font-size: 13px;
    text-transform: uppercase;
    overflow: hidden;
    padding: 10px 22px 10px 15px;
    position: relative;
    text-decoration: none;
    width: 100%;
    display: block;
    outline: none;
    font-weight: 700;
    font-family: "Montserrat", sans-serif;
}
#mobile-nav ul .menu-has-children i.fa-chevron-up {
    color: #18d26e;
}
#mobile-nav ul .menu-has-children i {
    position: absolute;
    right: 0;
    z-index: 99;
    padding: 15px;
    cursor: pointer;
    color: #fff;
}
#mobile-nav ul .menu-item-active {
    color: #18d26e;
}
#mobile-nav ul li li {
    padding-left: 30px;
}

.menu-has-children ul
{display: none;}

.sf-arrows .sf-with-ul {
  padding-right: 30px;
}

.sf-arrows .sf-with-ul:after {
  content: "\f107";
  position: absolute;
  right: 15px;
  font-family: FontAwesome;
  font-style: normal;
  font-weight: normal;
  color:black;
}

.sf-arrows ul .sf-with-ul:after {
  content: "\f105";
}


.nav-menu li:hover > ul,
.nav-menu li.sfHover > ul {
  display: block;
}
.nav-menu ul {
    margin: 4px 0 0 0;
    padding: 10px;
    box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.25);
    background: #fff;
}
.nav-menu ul {
    position: absolute;
    display: none;
    top: 100%;
    left: 0;
    z-index: 99;
}

.sf-arrows .sf-with-ul {
    padding-right: 30px;
}
.nav-menu li {
    position: relative;
    white-space: nowrap;
}


@media (max-width: 768px){
#nav-menu-container {
    display: none;
}

#mobile-nav-toggle {
    display: inline;
}
}
    </style>
</head>

<body>

  <header id="header">
    <div class="container">

      <div id="logo" class="pull-left">
        <h1><a><span style="color:#456988; text-shadow: 2px 2px #fffdaf">Green</span><span style="color:#24b084; text-shadow: 2px 2px #fffdaf">IT</span></a></h1>
      </div>

      <nav style="border:1px groove #ff0000;"  id="nav-menu-container">
        <ul  class="nav-menu">
          <li ><a style="color:red; " href="DeconnectSer">Se déconnecter</a></li>
          
          
                 </ul>
      </nav><!-- #nav-menu-container -->

    </div>
  </header>
    <h1  style="text-align:center; color:#006666; margin-top:8%">Bienvenue : <%=session.getAttribute("nom")%> <%=session.getAttribute("prenom")%> </h1>
   
<div class="row" style="margin-top: 5%">
  <a href="AcceuilAdmin.jsp"><div class="col-lg-3 col-md-6 col-md-offset-3">
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="row">
          <div class="col-xs-3">
            <i class="fa fa-male fa-5x"></i>
          </div>
          <div class="col-xs-9 text-right">
            <h1>Employés</h1>
          </div>
        </div>
      </div>
      
        <div class="panel-footer">
          <span class="pull-left">Voir détails</span>
          <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
          <div class="clearfix"></div>
        </div>
     
    </div>
  </div>
  </a>
  <a href="AcceuilAdmin2.jsp">
  <div class="col-lg-3 col-md-6">
    <div class="panel panel-success">
      <div class="panel-heading">
        <div class="row">
          <div class="col-xs-3">
            <i class="fa  fa-users fa-5x"></i>
          </div>
          <div class="col-xs-9 text-right">
            <h1>Equipes</h1>
          </div>
        </div>
      </div>
     
        <div class="panel-footer">
          <span class="pull-left">Voir détails</span>
          <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
          <div class="clearfix"></div>
        </div>
     
    </div>
  </div>
  </a>

</div>



</body>

</html>