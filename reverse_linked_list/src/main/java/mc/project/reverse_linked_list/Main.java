package mc.project.reverse_linked_list;

import java.util.List;

public class Main {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode temp;

        while(head != null) {
            temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }

        return result;
    }
}
