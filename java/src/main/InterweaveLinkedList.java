package main;

public class InterweaveLinkedList {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = l1;
        if(l1.val >= l2.val) {
            head = l2;
            helper(head, l1, l2.next);
        }
        else helper(head, l1.next, l2);
        return head;
    }

    public void helper(ListNode head, ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return;
        if(l1 == null) {
            head.next = l2;
            helper(head.next, l1, l2.next);
        }
        else if(l2 == null) {
            head.next = l1;
            helper(head.next, l1.next, l2);
        }
        else if(l1.val <= l2.val ) {
            head.next = l1;
            helper(head.next, l1.next, l2);
        }
        else {
            head.next = l2;
            helper(head.next, l1, l2.next);
        }
    }

    public static void main(String[] args) {
        InterweaveLinkedList solution = new InterweaveLinkedList();
//        System.out.println(solution.mergeTwoLists());
    }

}
