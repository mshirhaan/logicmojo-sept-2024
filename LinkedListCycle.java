//TC: O(n) SC: O(n)
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

// TC: O(n) SC: O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        int count = 0;

        while (fast != null) {
            count++;
            if (fast == null || fast.next == null) {
                System.out.println(count);
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                System.out.println(count);
                return true;
            }
        }
        System.out.println(count);
        return false;
    }
}
