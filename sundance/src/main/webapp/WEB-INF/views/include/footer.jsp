<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

</div>

<footer class="sticky-footer bg-white">
  <div class="container my-auto">
    <div class="copyright text-center my-auto">
      <span>Copyright &copy; VMS Team (Sundance) 2019</span>
    </div>
  </div>
</footer>

</div>

</div>

<!-- 아래는 모달 -->

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
							<input type="text" class="form-control" id="userName" name="userName" value="administrator">
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
				<a class="btn btn-primary" href="javascript:SundanceCommon.LoginFunc();"">로그인</a>
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