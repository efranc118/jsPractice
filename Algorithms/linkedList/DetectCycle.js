function detectCycle(head) {
  let ptr = head;
  let fastPtr = head.next;

  while(fastPtr !== null) {

    if(fastPtr.next !== null && fastPtr.next.next !== null) {
      fastPtr = fastPtr.next.next;
    } else {
      return false;
    }
    ptr = ptr.next;
    if(ptr === fastPtr) return true;
  }
}



function LinkedListNode(value) {
  this.value = value;
  this.next = null;
}

let head = new LinkedListNode(1);
head.next = new LinkedListNode(2);
head.next.next = new LinkedListNode(3);
head.next.next = new LinkedListNode(4);
head.next.next.next = new LinkedListNode(5);
head.next.next.next.next = new LinkedListNode(6);
head.next.next.next.next.next = head.next.next;


console.log(detectCycle(head));

process.exit(0);