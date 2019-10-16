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
								<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">등록된 카메라 개수</div>
								<div class="h5 mb-0 font-weight-bold" id="loginChk">&nbsp;</div>
							</div>
							<div class="col-auto">
								<i class="icon fas fa-sync-alt" style="font-size: 32px;" onclick="triumIDashBoard.GetIPDevices()" data-toggle="tooltip" data-placement="top" title="새로고침"></i>
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
		
		<div class="row">
			<div class="col-xl-12">
				<div class="card shadow mb-4">
					<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
						<h6 class="m-0 font-weight-bold text-primary">Camera Result : 1, 14, 15</h6>
						<div class="no-arrow">
							<a class="" href="#">
								<i class="icon fas fa-sync-alt" style="font-size: 32px;" onclick="triumIDashBoard.GetIPDevice()" data-toggle="tooltip" data-placement="top" title="가져오기"></i>
							</a>
						</div>
					</div>
					<div class="card-body">
						<div class="chart-area">
							<div class="chartjs-size-monitor">
								<div class="chartjs-size-monitor-expand">
									<div class="" id="GetIPDeviceResult" name="GetIPDeviceResult">
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>

</html>
