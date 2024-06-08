package mc.project.merge_k_sorted_list;
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
 */
public class Main {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1, node1);

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2, node3);

        mergeKLists(new ListNode[]{node2, node4});
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode returnNode = new ListNode();
        ListNode currentNode = returnNode;
        int minNodeIndex;

        while(isNext(lists)) {
            minNodeIndex = findMinNodeIndex(lists);
            ListNode temp = lists[minNodeIndex].next;
            currentNode.next = lists[minNodeIndex];
            currentNode = currentNode.next;
            lists[minNodeIndex] = temp;
        }

        return returnNode.next;
    }

    public static boolean isNext(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    public static int findMinNodeIndex(ListNode[] lists) {
        int minNodeIndex = 0;
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[minNodeIndex] == null || lists[minNodeIndex].val > lists[i].val) {
                minNodeIndex = i;
            }
        }
        return minNodeIndex;
    }
}
