package main.linkedlist;

import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> values = new PriorityQueue<>();

        for(ListNode node: lists) {
            while(node != null) {
                values.add(node.val);
                node = node.next;
            }
        }

        ListNode head = null;
        ListNode cur = head;
        while(!values.isEmpty()) {
            if(head == null) {
                head = new ListNode(values.remove());
                cur = head;
            }
            else {
                cur.next = new ListNode(values.remove());
                cur = cur.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        MergeKLists solution = new MergeKLists();
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode[] arr = new ListNode[]{node, node2, node3};

        System.out.println(solution.mergeKLists(arr));
    }

}
