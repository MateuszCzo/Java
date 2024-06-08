package mc.project.remove_n_th_node_from_end_of_list;
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Main {
     public static class ListNode {
         static int counter = 0;

         int val;
         ListNode next;

         ListNode() {
             counter++;
         }

         ListNode(int val) {
             counter++;
             this.val = val;
         }

         ListNode(int val, ListNode next) {
             counter++;
             this.val = val;
             this.next = next;
         }
     }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1, node1);

        removeNthFromEnd(node2, 1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int listLength = 1;
        ListNode countNode = head;

        while(countNode.next != null) {
            listLength++;
            countNode = countNode.next;
        }

        ListNode ReturnNode = new ListNode();
        ListNode searchNode = ReturnNode;
        searchNode.next = head;

        while(listLength - n > 0) {
            searchNode = searchNode.next;
            listLength--;
        }

        searchNode.next = searchNode.next.next;

        return ReturnNode.next;
    }
}
