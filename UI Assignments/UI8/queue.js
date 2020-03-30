function Queue() {
    this.elements = [];
}
Queue.prototype.enqueueElement = function(element) {

    if (element == "") {
        alert("Input cannot be null...!!");
    } else {
        this.elements.push(element);
        console.log(this.elements);
    }
    document.getElementById("inputString").value = "";
    this.viewQueue();

}

Queue.prototype.dequeueElement = function() {

    if (this.elements.length != 0) {
        var output = this.elements.shift();
        console.log(output);
        console.log(this.elements);
        this.viewQueue();
    } else
        alert("Queue is empty...!!");
    if (this.elements == "") {
        document.getElementById("demo").innerHTML = "Queue : Empty queue";
    }
}

Queue.prototype.viewQueue = function() {

    document.getElementById("demo").innerHTML = ("Queue : " +
        this.elements);;

}
let queue = new Queue();