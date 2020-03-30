String.prototype.repeatify = function(repeatation) {

    string = "";
    for (let loopCount = 0; loopCount < repeatation; loopCount++) {
        string = string + this;
    }
    return string;

};

function repeat() {
    var repeatation = document.getElementById("repeatationCount").value;
    var string = document.getElementById("inputString").value;
    if (string == "") {
        alert("Input cannot be null");
    } else if (repeatation == "") {
        alert("Repeatation should only be in number")
    } else if (repeatation < 2) {
        alert("Repeatation must be greater than 1");
    } else {
        document.getElementById("repeatedString").innerHTML = string.repeatify(repeatation)

    }

}