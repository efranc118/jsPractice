public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return solve(head, head.next);
    }

    public ListNode solve(ListNode prev, ListNode current) {
        if(current.next == null) {
            current.next = prev;
            prev.next = null;
            return current;
        } else {
            ListNode result = solve(current, current.next);
            current.next = prev;
            prev.next = null;
            return result;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode node = new ListNode(1);
        ListNode secondNode = new ListNode(2);
//        ListNode thirdNode = new ListNode(3);
//        ListNode fourthNode = new ListNode(4);
//        ListNode fifthNode = new ListNode(5);
        node.next = secondNode;
//        secondNode.next = thirdNode;
//        thirdNode.next = fourthNode;
//        fourthNode.next = fifthNode;
        ListNode result = solution.reverseList(node);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
