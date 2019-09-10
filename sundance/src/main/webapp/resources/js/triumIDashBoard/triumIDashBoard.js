/**
 * 
 */

var programId = "triumIDashBoard";

window.name = programId;

var triumIDashBoard = {
	isLogin : false,

	init : function() {
		var self = this;
		
		loginCheck(isLogin);
	},

	loginFunc : function() {
		var self = this;
		
		var loginData = $('#loginForm').serializeObject();
		
		console.log(JSON.stringify(loginData));

		$.ajax({
			url: getContextPath() + '/login',
			type: 'POST',
			dataType: 'JSON',
			data: {
				"content" : JSON.stringify(loginData)
			},
			success: function(data) {
				
				console.log("success");
				console.log(data);
				
				self.loginCheck(true);
			},
			error: function(jqXHR, status, error){
				
				self.loginCheck(false);
				console.log("Error");
				console.log(b);
			}
			
		});
		
	},
	
	loginCheck : function(_isLogin) {
		if( _isLogin ) {
			$("#userMenu_Login").css("display", "none");
			$("#userMenu_LogOut").css("display", "block");
			
			$("#loginChk").text("Login");
			$("#loginChk").css("color", "green");
		} else {
			$("#userMenu_Login").css("display", "block");
			$("#userMenu_LogOut").css("display", "none");
			
			$("#loginChk").text("Login Fail");
			$("#loginChk").css("color", "red");
		}
	},
};

$(document).ready(function() {
	triumIDashBoard.init();
});