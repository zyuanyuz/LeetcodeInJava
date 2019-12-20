package problems.hard;

/**
 * leetcode 25 hard ReverseNodesinkGroup
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed.
 *
 */
public class ReverseNodesinkGroup {

	/**
	 * 执行用时 : 1 ms , 在所有 java 提交中击败了 81.63% 的用户 内存消耗 : 38 MB , 在所有 java 提交中击败了
	 * 82.83% 的用户
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode resultHead = new ListNode(0);
		ListNode revHead = resultHead, revTail = resultHead, tmp = null;
		int i = 0;
		for (; head != null; i = (++i) % k) {
			tmp = head;
			head = head.next;
			if (i == 0) {
				tmp.next = null;
				revTail = revHead;
				revHead.next = tmp;
				revHead = revHead.next;
			} else {
				tmp.next = revTail.next;
				revTail.next = tmp;
			}
		}
		if (i != 0) {
			revHead = revTail.next;
			revTail.next = null;
			while (revHead != null) {
				tmp = revHead;
				revHead = revHead.next;
				tmp.next = revTail.next;
				revTail.next = tmp;
			}
		}
		return resultHead.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ReverseNodesinkGroup r = new ReverseNodesinkGroup();
		ListNode n = r.new ListNode(1);
		n.next = r.new ListNode(2);
		n.next.next = r.new ListNode(3);
		n.next.next.next = r.new ListNode(4);
		n.next.next.next.next = r.new ListNode(5);
		n.next.next.next.next.next = r.new ListNode(6);
		n.next.next.next.next.next.next = r.new ListNode(7);
		r.reverseKGroup(n, 5);
	}
}
