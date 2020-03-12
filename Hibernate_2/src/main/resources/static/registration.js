function registration() {

	var Name = document.getElementById('Name').value;
	var namePattern = /^[A-Za-z ]{3,25}$/;
	if (!namePattern.test(Name)) {
		alert("Enter valid Name");
		return false;
	}
	var Number = document.getElementById('MobileNumber').value;
	var numberPattern = /^[0-9]{9,15}$/;
	if (!numberPattern.test(Number)) {
		alert("Enter valid Mobile Number");
		return false;
	}
	var password = document.getElementById('Password').value;
	var Confirmpassword = document.getElementById('ConfirmPassword').value;
	if (password !=Confirmpassword) {
		alert("Password and Confirm password must be same");
		return false;
	}
	var email = document.getElementById("EmailID").value;
	var emailPattern = /^[A-za-z0-9_.]{3,}@[A-za-z]{3,7}[.]{1}[A-za-z.]{2,6}$/;
	if (!emailPattern.test(email)) {
		alert("Enter valid Email ID");
		return false;
	}
	return true;
}
