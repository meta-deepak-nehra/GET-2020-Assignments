/**
 * This files includes validation for html values
 */
function validateFirstName() {
    var firstName = document.getElementById("empName").value;
    if (firstName.length === 0) {
        document.getElementById("validationMessage").innerHTML = "First Name can't be empty";
        return false;
    }
    if (firstName.length <= 2) {
        document.getElementById("validationMessage").innerHTML = "First name length must be greater than 2";
        return false;
    }
    if (/^[A-Za-z]+$/.test(firstName)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = "Entered first name is not valid";
        return false;
    }
}

function validateEmail() {
    var mail = document.getElementById("emailid").value;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    }
    if(mail.length==0){
    	document.getElementById("validationMessage").innerHTML = "Email can't be empty";
        return false;
    }
    document.getElementById("validationMessage").innerHTML = "Please enter a valid e-mail address!!";
    return false;
}

function validatePassword() {
	var password = document.getElementById("empPassword").value;
	var pattern4 = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
	if (pattern4.test(password) == false) {
        document.getElementById("validationMessage").innerText = " Enter a valid Password";
        return false;
    }
    if (pattern4.test(password) == true) {
        document.getElementById("validationMessage").innerText = "";
    }
}

function checkPassword(){
	var password = document.getElementById("empPassword").value;
    var confirmPassword = document.getElementById("empConfirmPassword").value;
    
	if (password != confirmPassword) {
        document.getElementById("validationMessage").innerText = "Password does not match";
        return false;
    }
    if (password == confirmPassword) {
        document.getElementById("validationMessage").innerText = "";
    }
}

function validatePhoneNumber(){
	var contact = document.getElementById("empPhoneNumber").value;
	 if (isNaN(contact) || contact.length < 8) {
         document.getElementById("validationMessage").innerText = "Contact number is not in proper format";
         return false;
     }
}


