package mc.project.reorder_list;
/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);

        reorderList(node4);
    }

    public static void reorderList(ListNode head) {
        ListNode middleNode = head;
        ListNode lastNode = head;

        while (lastNode != null && lastNode.next != null) {
            lastNode = lastNode.next.next;
            middleNode = middleNode.next;
        }

        ListNode secondNodeList = middleNode.next;
        middleNode.next = null;
        ListNode reverseSecond = null;

        while(secondNodeList != null) {
            ListNode temp = secondNodeList.next;
            secondNodeList.next = reverseSecond;
            reverseSecond = secondNodeList;
            secondNodeList = temp;
        }


        ListNode first = head;
        ListNode second = reverseSecond;

        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
