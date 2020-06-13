<%@include file="inc/header.html"%>
<section class="">
	<div class="container">
		<div class="row center-sm">
			<div class="col-xs-12 col-sm-10 col-lg-6">
				<div class="whiteBg">
					<div class="row center-xs">
						<div class="col-xs-11 voffset5">
							<h1 class="pageHeading">Reset password</h1>							
						</div>
						<div class="col-xs-11 col-sm-10 col-md-8 voffset3">
							<form method="POST" name="resetPasswordForm" id="resetPasswordForm">								
								<div class="row">
									<div class="col-xs-12 voffset2">
										<div class="passwordWrap">
											<input type="password" name="new_password" class="form-control showHidePassword" placeholder="New password" required>
											<button type="button" class="passwordSwitcher passwordChange">show password</button>
										</div>
									</div>
									<div class="col-xs-12 voffset2">
										<div class="passwordWrap">
											<input type="password" name="confirm_password" class="form-control showHidePassword" placeholder="Confirm password" required>
											<button type="button" class="passwordSwitcher passwordChange">show password</button>
										</div>
									</div>
									<div class="col-xs-12 voffset2">
										<button type="button" class="btnLink fullWidth gradBg submitFormBtn"><span>Submit<i class="rightArrow white"></i></span></button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="formActionMessage hideMe">
						<div class="row center-xs">
							<div class="col-xs-11 voffset5">
								<h4 class="greenTxt">Successfully Done!</h4>
								<div class="btnsWrap voffset1">
									<a href="signup.jsp" class="btnLink"><span>Login here<i></i></span></a>
								</div>
							</div>								
							<div class="col-xs-12 voffset4">&nbsp;</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="inc/footer.html"%>