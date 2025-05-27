class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}

public class addTwoNumber {
    public static void main(String[] args) {
        int [] arr1 = {2, 4, 3};
        int [] arr2 = {5, 6, 4};
        ListNode head_l1 = new ListNode(arr1[0]);
        ListNode head_l2 = new ListNode(arr2[0]);
        ListNode current_l1 = head_l1; 
        ListNode current_l2 = head_l2;
        for (int i = 1; i < arr1.length; i++) {
            current_l1.next = new ListNode(arr1[i]);
            current_l1 = current_l1.next;
        }
        for (int i = 1; i < arr2.length; i++) {
            current_l2.next = new ListNode(arr2[i]);
            current_l2 = current_l2.next;
        }
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(head_l1, head_l2);
          printList(result);
        
    }
    static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val);
                if (head.next != null) System.out.print(" -> ");
                head = head.next;
            }
            System.out.println();
        }
}
