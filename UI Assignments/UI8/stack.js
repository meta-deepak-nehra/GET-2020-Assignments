function Stack() {
    this.elements = [];
}

Stack.prototype.pushInStack = function(element) {

    if (element != "") {
        this.elements.push(element);
        this.viewElements();

    } else {
        alert("Input can't be empty!!!!!")

    }
    document.getElementById("inputOfUser").value = "";


}

Stack.prototype.popFromStack = function() {

    if (this.elements == "") {
        alert("Stack is Empty");
    } else {
        this.elements.pop();
        this.viewElements();
    }
    if (this.elements == "") {
        document.getElementById("demo").innerHTML = "Stack : Empty stack";
    }
    document.getElementById("inputOfUser").value = "";


}

Stack.prototype.peekElement = function() {
    if (this.elements.length != 0) {
        document.getElementById("demo").innerHTML = ("Top element of stack : " + this.elements[this.elements.length - 1]);
    } else
        alert("Stack is empty...!!");

}

Stack.prototype.viewElements = function() {

    document.getElementById("demo").innerHTML = ("Stack : " +
        this.elements);

}


let stack = new Stack();