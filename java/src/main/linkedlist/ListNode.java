package main.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void printList() {
        ListNode ptr = this;
        while(ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }


}


