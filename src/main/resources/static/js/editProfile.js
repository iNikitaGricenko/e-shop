function editProfile() {
	var fileInput = document.getElementById('photoFile');
	var file = fileInput.files[0];
	var formData = new FormData();
	$("#RegisterDate").type = 'date'
	var body = {
		"login":$("#ProfileLogin").val(),
		"password":$("#Password").val(),
		"firstName":$("#FirstName").val(),
		"secondName":$("#SecondName").val(),
		"middleName":$("#MiddleName").val(),
		"phone":$("#MainPhone").val(),
		"city":$("#City").val(),
		"registerDate":$("#RegisterDate").val()
	}
	$("#RegisterDate").type = 'text'
	body = JSON.stringify(body);
	formData.append("photoFile", file)
	formData.append("requestUser", body)
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8088/api/user',
		dataType: 'json',
		cache: false,
		contentType: false,
		processData: false,
		data: formData,
		success: function (data) {
			var temporaryDate = new Date();
			$("#ProfileImage").attr("src", "/"+data.photo+"?"+temporaryDate.getTime());
			$("#ProfileLogin").attr("value", data.login);
			$("#FirstName").attr("value", data.firstName);
			$("#SecondName").attr("value", data.secondName);
			$("#MiddleName").attr("value", data.middleName);
			$("#MainPhone").attr("value", data.phone);
			$("#City").attr("value", data.city);
			$("#RegisterDate").attr("value", data.registerDate);
			$("#ProfileImage").load(location.href + " #ProfileImage");
		},
		error: function (data) {
			alert("Error");
		}
	})
}