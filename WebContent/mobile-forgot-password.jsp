<%@include file="inc/header.html"%>
<section class="">
	<div class="container">
		<div class="row center-sm">
			<div class="col-xs-12 col-sm-10 col-lg-6">
				<div class="whiteBg">
					<div class="row center-xs">
						<div class="col-xs-11 voffset5">
							<h1 class="pageHeading">Forgot Password?</h1>
							<h6 class="voffset1">Enter the mobile number associated with your account</h6>
							<h6><small>We will send 6-digit SMS code on your mobile</small></h6>
						</div>
						<div class="col-xs-11 col-sm-10 col-md-8 voffset3">
							<form method="POST" name="loginForm" id="loginForm">								
								<div class="row">
									<div class="col-xs-12 voffset2">
										<div class="mobileNumberWrap">
											<div class="custmSelect">
												<select name="country_code">
													<option selected="+91">+91 IN</option>
													<option>+93 SL</option>
												</select>
											</div>
											<input type="tel" name="phone_number" maxlength="10" class="form-control numberOnly" placeholder="Mobile number" required>
										</div>
									</div>
									<div class="col-xs-12 voffset2">
										<button type="button" class="btnLink fullWidth gradBg submitFormBtn"><span>Send<i class="rightArrow white"></i></span></button>
									</div>
								</div>
							</form>
						</div>
						<div class="col-xs-12 voffset4">
							<h6>If you also forgot your mobile number</h6>
							<div class="btnsWrap">
								<a href="forgot-password.jsp" class="btnLink"><span>Reset via email<i></i></span></a>
							</div>
						</div>
						<div class="col-xs-12 voffset3">&nbsp;</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="inc/footer.html"%>