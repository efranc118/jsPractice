package main.linkedlist;

public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        System.out.println(solution.deleteDuplicates(l1));
    }

}
