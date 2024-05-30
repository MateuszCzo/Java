package mc.project.merge_two_sorted_lists;
/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class Main {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);

        mergeTwoLists(node3, node6);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode();
        ListNode currentNode = headNode;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }
        if(list1 != null) {
            currentNode.next = list1;
        }
        if(list2 != null) {
            currentNode.next = list2;
        }
        return headNode.next;
    }
}
