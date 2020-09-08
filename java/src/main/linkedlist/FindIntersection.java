package main.linkedlist;

import java.util.HashSet;

public class FindIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1, ptr2;
        ptr1 = headA;
        ptr2 = headB;
        if(ptr1 == null) return null;
        if(ptr2 == null) return null;
        HashSet<ListNode> visited = new HashSet<>();

        while(ptr1 != null) {
            visited.add(ptr1);
            ptr1 = ptr1.next;
        }

        while(ptr2 != null) {
            if(visited.contains(ptr2)) return ptr2;
            ptr2 = ptr2.next;
        }

        return null;
    }


    public static void main(String[] args) {
        FindIntersection solution = new FindIntersection();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode intersection = new ListNode(4);
        l2.next = intersection;
        l1.next.next.next = intersection;
        intersection.next = new ListNode(5);
        System.out.println(solution.getIntersectionNode(l1, l2));
    }

}
