/**
 * 
 */

var programId = "triumIDashBoard";

window.name = programId;

var triumIDashBoard = {
	isLogin : false,

	init : function() {
		var self = this;
		
		self.SendKeepAlive();
	},
	
	SendKeepAlive : function() {
		var self = this;
		
		$.ajax({
			url: '/SendKeepAlive',
			type: 'POST',
			dataType: 'JSON',
			data: {
				"content": ""
			},
			success: function(data) {
				
				setTimeout(function() {
					self.SendKeepAlive();
				}, 1000);
				
			},
			error: function(jqXHR, status, error) {
				console.log(status);
				console.log(error);
			}
		});
	},
	
	GetIPDevices : function() {
		var self = this;
		
		$.ajax({
			url: getContextPath() + '/GetIPDevices',
			type: 'POST',
			dataType: 'JSON',
			data: {
				"content": ""
			},
			success : function(data) {
				console.log(data);
			},
			error : function(jqXHR, status, error) {
				console.log(status);
				console.log(error);
			}
		});
	},
	
	GetIPDevice : function() {
		
		var self = this;
		
		//GetIPDeviceResult
		var deviceID = [1, 14, 15];
		
		for(var i = 0; i < deviceID.length - 1; i++) {
			
			var content = {};
			
			content.deviceID = deviceID[i].toString();
			
			$.ajax({
				url : getContextPath() + '/GetIPDevice',
				type: 'POST',
				dataType: 'JSON',
				data : {
					"content": JSON.stringify(content)
				},
				success : function(data) {
					
				},
				error : function(jqXHR, status, error) {
					console.log(status);
					console.log(error);
				}
			});
			
			break;
		}
	},
};

$(document).ready(function() {
	triumIDashBoard.init();
});