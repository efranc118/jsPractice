/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {

  let listSize = lists.length;
  if(listSize < 1) return null;
  if(listSize === 1) return lists[0];
  let head = lists[0];
  for(let i = 1; i < lists.length; i++) {
    head = mergeLists(head, lists[i]);
  }
  return head;
};


 function ListNode(val) {
     this.val = val;
     this.next = null;
 }

function mergeLists(firstList, secondList) {
  let head = null;
  let firstPtr = firstList;
  let secondPtr = secondList;
  let newList = head;

  while(firstPtr !== null && secondPtr !== null) {
    if(firstPtr.val <= secondPtr.val) {
      if(head == null) {
        head = firstPtr;
        newList = head;
        firstPtr = firstPtr.next;
      }
      else {
        newList.next = firstPtr;
        newList = newList.next;
        firstPtr = firstPtr.next;
      }
    }
    else {
      if(head == null) {
        head = secondPtr;
        newList = head;
        secondPtr = secondPtr.next;
      }
      else {
        newList.next = secondPtr;
        newList = newList.next;
        secondPtr = secondPtr.next;
      }
    }

  }
  if(firstPtr !== null) {
    if(head == null) head = firstPtr;
    else newList.next = firstPtr;
  }

  if(secondPtr !== null) {
    if(head == null) head = secondPtr;
    else newList.next = secondPtr;
  }
return head;
}


let first = new ListNode(1);
first.next = new ListNode(4);
first.next.next = new ListNode(5);


let second = new ListNode(1);
second.next = new ListNode(3);
second.next.next = new ListNode(4);

let third = new ListNode(2);
third.next = new ListNode(6);

let array = [first, second, third];

mergeKLists(array);

