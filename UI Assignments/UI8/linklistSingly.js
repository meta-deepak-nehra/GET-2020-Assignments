function Node(element) {
    this.element = element;
    this.next = null;
}

function Singly() {
    this.head = null;
}

Singly.prototype.addElementFirst = function(element) {
    var node = new Node(element);

    if (document.getElementById("element").value == "") {
        alert("Please Enter Data !!!");
        return;
    }

    if (this.head == null) {
        this.head = node;
    } else {
        node.next = this.head;
        this.head = node;
    }
    this.showElements();
    document.getElementById("element").value = "";
}

Singly.prototype.addElementLast = function(element) {
    var node = new Node(element);
    var current = null;

    if (document.getElementById("element").value == "") {
        alert("Please Enter Data !!!");
        return;
    }

    if (this.head == null) {
        this.head = node;
    } else {
        current = this.head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }
    this.showElements();
    document.getElementById("element").value = "";
}

Singly.prototype.showElements = function() {
    var current = this.head;
    var txt = "List is ";
    if (current == null) {
        txt += "Empty";
    } else {
        while (current != null) {
            txt += " ::> " + current.element;
            current = current.next;
        }
    }
    document.getElementById("show").innerHTML = txt;
}

Singly.prototype.deleteElementFirst = function() {
    if (this.head == null) {
        alert("Nothing To Delete ... Empty List !!!");
        return;
    } else {
        this.head = this.head.next;
    }
    this.showElements();
    document.getElementById("element").value = "";
}

Singly.prototype.deleteElementLast = function() {
    var current = null;
    if (this.head == null) {
        alert("Nothing To Delete ... Empty List !!!");
        return;
    } else if (this.head.next == null) {
        this.head = null;
    } else {
        current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    this.showElements();
    document.getElementById("element").value = "";
}

Singly.prototype.deleteElementOfValue = function(element) {
    var current = null;
    var previousNode = null;
    var flag = 0;

    if (document.getElementById("element").value == "") {
        alert("Please Enter Data !!!");
        return;
    }

    if (this.head == null) {
        alert("Nothing To Delete ... Empty List !!!");
        return;
    } else if (this.head.element == element) {
        this.head = this.head.next;
    } else {
        current = this.head;
        do {
            previousNode = current;
            current = current.next;
            if (current.element == element) {
                flag = 1;
                previousNode.next = current.next;
                break;
            }
        } while (current.next != null);
        if (flag == 0) {
            alert("No Such Element To Delete !!!");
        }
    }
    this.showElements();
    document.getElementById("element").value = "";
}
let singly = new Singly();