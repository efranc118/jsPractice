package main.linkedlist;

public class RemoveNthFromLast {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode trailer, slow, fast;
        trailer = slow = fast = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            if(slow != head) trailer = trailer.next;
            slow = slow.next;
        }
        if(slow == head) return head.next;
        else trailer.next = slow.next;
        return head;
    }


    public static void main(String[] args) {
        RemoveNthFromLast solution = new RemoveNthFromLast();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(solution.removeNthFromEnd(l1, 2));
    }

}
