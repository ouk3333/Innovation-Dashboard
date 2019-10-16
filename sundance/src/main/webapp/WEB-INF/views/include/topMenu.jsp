<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="wrapper">

<%@ include file="/WEB-INF/views/include/sideMenu.jsp" %>

<div id="content-wrapper" class="d-flex flex-column">

<div id="content">

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">

		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow">
			<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<img class="img-profile" src="${pageContext.request.contextPath}/resources/css/img/TriumiNormal.png" id="TriumiLogoImg">
			</a>
			<!-- Dropdown - User Information -->
			<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown" id="userMenu">
				<div id="userMenu_Login">
					<a class="dropdown-item" href="#" data-toggle="modal" data-target="#loginModal">
						<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그인
					</a>
				</div>
				<div id="userMenu_LogOut">
					<a class="dropdown-item" href="javascript:SundanceCommon.Logout()">
						<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그아웃
					</a>
				</div>
			</div>
		</li>

    </ul>

</nav>