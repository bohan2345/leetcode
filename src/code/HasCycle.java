package code;

public class HasCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head,fast=head;
        while(true){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==null||fast==null){
                return false;
            }
            if(slow==fast){
                return true;
            }
        }
    }
}
