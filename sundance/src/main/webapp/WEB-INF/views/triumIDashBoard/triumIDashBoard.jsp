<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>VMS Team Project</title>
	
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
</head>

<body id="page-top">

	<%@ include file="/WEB-INF/views/include/topMenu.jsp" %>

	<div class="container-fluid">

	    <!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Trium I Interop Server Protocol</h1>
		</div>
		
		<div class="row">
		
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">접속 여부</div>
								<div class="h5 mb-0 font-weight-bold" id="loginChk">&nbsp;</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-left-success shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-success text-uppercase mb-1">Earnings (Annual)</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">$215,000</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-left-info shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks</div>
								<div class="row no-gutters align-items-center">
									<div class="col-auto">
										<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
									</div>
									<div class="col">
										<div class="progress progress-sm mr-2">
											<div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-left-warning shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Pending Requests</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-comments fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

<!-- Logout Modal-->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="loginModalTitle">Trium I Login</h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			
			<div class="modal-body" id="loginModalBody">
				<form method="POST" name="loginForm" id="loginForm">
					<input type="hidden" value="@ExternalClient" id="hostType" name="hostType">
					<div class="row">
						<div class="col-lg-3" style="text-align: right;">
							<span> 아이디 : </span>
						</div>
						<div class="col-lg-9">
							<input type="text" class="form-control" id="userName" name="userName">
						</div>
					</div>
					<div class="m-1"></div>
					<div class="row">
						<div class="col-lg-3" style="text-align: right;">
							<span> 비밀번호 : </span>
						</div>
						<div class="col-lg-9">
							<input type="password" class="form-control" id="userPassword" name="userPassword">
						</div>
					</div>
				</form>
			</div>
			
			<div class="modal-footer" id="loginModalFooter">
				<!-- <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button> -->
				<a class="btn btn-primary" href="javascript:triumIDashBoard.loginFunc();"">로그인</a>
			</div>
		</div>
	</div>
</div>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			
			<div class="modal-body">
				Select "Logout" below if you are ready to end your current session.
			</div>
			
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

</body>

</html>
