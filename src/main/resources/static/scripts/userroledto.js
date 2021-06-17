alert("Welcome to CreateUserRoleDto page")
$(document)
		.on(
				"click",
				"#new_user-submit_button",
				function() {
					alert("Are you sure to post the data")
					var firstName = $("#new_user-user_firstName").val();
					var lastName = $("#new_user-user_lastName").val();
					var emailId = $("#new_user-user_emailId").val();
				    var address = $("#new_user-user_address").val();
				    var roleName = $("#new_user-role_name").val();
				    var roleDescription = $("#new_user-role_description").val();
									
				$.ajax({
						type : 'POST',
						dataType : 'text',
						contentType : 'application/json; charset=utf-8',
						url : "/orgUserRoleDto/create-user-role-dto",
						data : JSON.stringify({
							"firstName" : firstName,
							"lastName" : lastName,
							"emailId" : emailId,
							"address" : address,
							"roleName" : roleName,
							"roleDescription" : roleDescription
							})
							})
							})		