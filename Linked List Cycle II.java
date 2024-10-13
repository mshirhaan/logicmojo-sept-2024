public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                fast = head;

                while(fast!=slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }        
        return null;
    }
}
