class Queue {

  constructor() {
    this.firstStack = [];
    this.secondStack = [];
  }

  enqueue(value) {
    this.firstStack.push(value);
  }

  dequeue() {
    if(this.secondStack.length) {
      return this.secondStack.pop();
    } else {
      while(this.firstStack.length) {
        this.secondStack.push(this.firstStack.pop());
      }
      if(this.secondStack.length) {
        return this.secondStack.pop();
      }
    }
    return null;
  }
}



let queue = new Queue();
queue.enqueue(5);
queue.enqueue(4);
queue.enqueue(3);
console.log(queue.dequeue());
console.log(queue.dequeue());
queue.enqueue(2);
queue.enqueue(1);
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());