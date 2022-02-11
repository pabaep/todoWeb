<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.time.LocalDate, java.time.LocalTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String url = application.getContextPath() + "/"; %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Target Material Design Bootstrap Admin Template</title> 
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href="index.html"><strong>To do List</strong></a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right"> 
				
				  <li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>${param.uname}</b> <i class="material-icons right">arrow_drop_down</i></a></li>
            </ul>
        </nav>
		<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">

<li><a href="index.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
</li>
</ul>

  

	   <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="waves-effect waves-dark" href="index.html"><i class="fa fa-user"></i> Login</a>
                    </li>
                    <li>
                        <a href="todoweb?command=todoAll&uid=${requestScope.user.userId}" class="waves-effect waves-dark"><i class="fa fa-table"></i> To do List</a>
                    </li>
                    <li>
                        <a href="todoweb?command=addTodo&uid=${requestScope.user.userId}" class="active-menu waves-effect waves-dark"><i class="fa fa-edit"></i> Add To do List </a>
                    </li>

                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
		<div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            Add To Do List
                        </h1>
                        <div id="page-inner"> 
			 <div class="row">
			 <div class="col-lg-12">
			 <div class="card">
                        <div class="card-action">
                            Write To do
                        </div>
                        <div class="card-content">
    <form class="col s12" action="todoweb" method="post">
     <input type="hidden" name="command" value="addTodo">
     <input type="hidden" name="userid" value="${param.uid}">     
      <div class="row">
        <div class="input-field inline col s12">
          <input id="todoContent" name="todoContent" type="text" class="validate">
          <label for="todoContent">Content</label>
        </div>
      </div>
            <div class="row">
        <div class="input-field col s12">
 			Start Time<br>
          <input id="todoStart" name="todoStart" type="datetime-local" value="2022-02-11T12:00" class="validate">
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
        	End Time<br>
          <input id="todoEnd" name="todoEnd" type="datetime-local" value="2022-02-11T12:00"  class="validate">
        </div>
      </div>
      <div class="row">
        <div class="col s12">
         <div class="waves-effect waves-light btn">
          <input type="submit" value="Add">
         </div>
        </div>
      </div>
    </form>
	<div class="clearBoth"></div>
  </div>
    </div>
 </div>	
 </div>
									
		 </div>
            
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
	
	<script src="assets/materialize/js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
 

</body>

</html>