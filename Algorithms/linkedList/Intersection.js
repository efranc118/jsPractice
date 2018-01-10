module.exports = {
  //param A : head node of linked list
  //param B : head node of linked list
  //return the head node in the linked list
  getIntersectionNode : function(A, B){
    var aPtr = A;
    var bPtr = B;
    var aLength = 0;
    var bLength = 0;
    while(aPtr !== null) {
      aPtr = aPtr.next;
      aLength++;
    }
    while(bPtr !== null) {
      bPtr = bPtr.next;
      bLength++;
    }
    var difference = aLength - bLength;
    aPtr = A;
    bPtr = B;
    while(difference < 0) {
      bPtr = bPtr.next;
      difference++;
    }
    while(difference > 0) {
      aPtr = aPtr.next;
      difference--;
    }
    while(aPtr !== null && bPtr !== null) {
      if(aPtr === bPtr) return aPtr;
      aPtr = aPtr.next;
      bPtr = bPtr.next;
    }
    return -1;
  }
};