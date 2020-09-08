package main.linkedlist;

public class MergeLinkedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, curPtr, minPtr;
        head = curPtr = minPtr = null;
        if(l2 == null) return l1;
        if(l1 == null) return l2;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                minPtr = l1;
                l1 = l1.next;
            }
            else{
                minPtr = l2;
                l2= l2.next;
            }
            if(head == null) {
                head = minPtr;
                curPtr = head;
            } else {
                curPtr.next = minPtr;
                curPtr = curPtr.next;
            }
        }
        if(l1 != null) curPtr.next = l1;
        if(l2 != null) curPtr.next = l2;

        return head;
    }


    public static void main(String[] args) {
        MergeLinkedLists solution = new MergeLinkedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(solution.mergeTwoLists(l1, l2));
    }

}
