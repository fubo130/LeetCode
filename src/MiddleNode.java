import java.util.ArrayList;
import java.util.List;

public class MiddleNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode arr1 = new ListNode(1);
        arr1.next = new ListNode(2);
        arr1.next.next = new ListNode(3);
        arr1.next.next.next = new ListNode(4);
        arr1.next.next.next.next = new ListNode(5);
        arr1.next.next.next.next.next = new ListNode(6);
        ListNode m = middleNode(arr1);
        while (m != null) {
            System.out.println(m.val);
            m = m.next;
        }
    }

    /**
     * function to find the mid element in an one way list
     *
     * One iterator iterate twice a time, while the other iterator iterate once a time.
     * @param head list of nodes
     * @return nodes after the middle node
     */
    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        while (temp!= null && temp.next != null) {
            temp = temp.next;
            temp = temp==null?null:temp.next;
            head = head.next;
        }



//        int count = 0;
//        ListNode temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//            count++;
//        }
//        int mid = count%2 == 0 ? count/2 : count/2+1;
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 0; i <= count; i++) {
//            if (i >= mid) {
//                arr.add(head.val);
//            }
//            head = head.next;
//        }
//        System.out.println(arr);
//        ListNode curr = new ListNode();
//        for (int i = 0; i < arr.size(); i++) {
//            curr.val = arr.get(i);
//            curr.next = new ListNode();
//        }
        return head;
    }
}
