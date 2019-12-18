package problems.hard;

/**
 * TODO test
 * leetcode 23 hard MergekSortedLists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 *
 */
public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		ListNode resultHead = new ListNode(Integer.MIN_VALUE);
		resultHead.next = lists[0];
		for (int i = 0; i < lists.length; i++) {
			ListNode moveOne = resultHead;
			ListNode moveTwo = lists[i];
			while (moveOne.next != null && moveTwo != null) {
				if (moveOne.val <= moveTwo.val && moveOne.next.val >= moveTwo.val) {
					ListNode tmp = moveTwo;
					moveTwo = moveTwo.next;
					tmp.next = moveOne.next;
					moveOne.next = tmp;
					moveOne = moveOne.next;
				} else if (moveOne.next.val < moveTwo.val) {
					moveOne = moveOne.next;
				} else { // moveOne.val > moveTwo.val
					//do nothing
				}
			}
			if (moveTwo != null) {
				moveOne.next = moveTwo;
			}
		}
		return resultHead.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
