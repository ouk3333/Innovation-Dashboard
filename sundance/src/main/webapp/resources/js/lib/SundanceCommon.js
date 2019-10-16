/**
 * 
 */

$.fn.serializeObject = function() {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                $.each(arr, function() {
                    obj[this.name] = this.value;
                });
            }//if ( arr ) {
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }
 
    return obj;
};

var getContextPath = function() {
	var href = location.href;
	var str = href.substring(0, href.lastIndexOf("/"));
	
	return str;
}

///////////////////////////////////////////////////


var SundanceCommon = {
	
	init : function() {
		var self = this;
		
		$('[data-toggle="tooltip"]').tooltip();
		
		self.GetSessionID();
	},
	
	GetSessionID : function() {
		
		var sessionID = sessionStorage.getItem("sessionID");
		
		if( sessionID == null || sessionID == undefined || sessionID == null ) {
		
			$("#userMenu_Login").css("display", "block");
			$("#userMenu_LogOut").css("display", "none");
			
			$("#TriumiLogoImg").attr("src", "/resources/css/img/TriumiFail.png");
			
			return null;
		} else {
			$("#userMenu_Login").css("display", "none");
			$("#userMenu_LogOut").css("display", "block");
			
			$("#TriumiLogoImg").attr("src", "/resources/css/img/TriumiSuccess.png");
			
			return sessionID;
		}
		
	},
	
	LoginFunc : function() {
		var self = this;
		
		var loginData = $('#loginForm').serializeObject();
		
		$.ajax({
			url: '/login',
			type: 'POST',
			dataType: 'JSON',
			data: {
				"content" : JSON.stringify(loginData)
			},
			success: function(data) {
				
				sessionStorage.setItem("sessionID", data.result.sessionID);
				
				$("#loginModal").modal("hide");
			},
			error: function(jqXHR, status, error){
				console.log("Error");
				console.log(b);
			},
			complete: function(data) {
				SundanceCommon.GetSessionID();
			}
			
		});
		
	},
	
	Logout : function() {
		var self = this;
		
		sessionStorage.clear();
		
		self.GetSessionID();
	}
	
}

$(document).ready(function() {
	SundanceCommon.init();
});