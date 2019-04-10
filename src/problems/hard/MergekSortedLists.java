package problems.hard;

/**
 * leetcode 23 hard
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
		ListNode result;
		ListNode[] pointnode = new ListNode[lists.length];
		for (int i = 0; i < lists.length; i++) {
			pointnode[i] = lists[i];
		}
		

		return null;
	}

	public void test() {

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
