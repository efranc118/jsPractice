package main.linkedlist;



public class ReversePartialLinkedList {

    ListNode tail = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) {
            ListNode result = reverseNodes(head, n);
            return result;
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    public ListNode reverseNodes(ListNode cur, int count) {
        if(count == 1) {
            tail = cur.next;
            return cur;
        }
        ListNode result = reverseNodes(cur.next, count - 1);
        cur.next.next = cur;
        cur.next = tail;
        return result;
    }



    public static void main(String[] args) {
        ReversePartialLinkedList solution = new ReversePartialLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.reverseBetween(head, 2, 4).printList();
    }

}


