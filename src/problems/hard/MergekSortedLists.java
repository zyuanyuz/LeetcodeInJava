package problems.hard;

/**
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

	/**
	 * 执行用时 : 129 ms , 在所有 java 提交中击败了 28.40% 的用户 内存消耗 : 49 MB , 在所有 java 提交中击败了
	 * 27.68% 的用户
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		ListNode resultHead = new ListNode(Integer.MIN_VALUE);
		resultHead.next = lists[0];
		for (int i = 1; i < lists.length; i++) {
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
				}
			}
			if (moveTwo != null) {
				moveOne.next = moveTwo;
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
		ListNode[] list = new ListNode[3];
		MergekSortedLists m = new MergekSortedLists();
		ListNode head = m.new ListNode(0);
		head.next = m.new ListNode(1);
		head.next.next = m.new ListNode(4);
		head.next.next.next = m.new ListNode(5);
		list[0] = head.next;
		head.next = m.new ListNode(1);
		head.next.next = m.new ListNode(3);
		head.next.next.next = m.new ListNode(4);
		list[1] = head.next;
		head.next = m.new ListNode(2);
		head.next.next = m.new ListNode(6);
		list[2] = head.next;
		m.mergeKLists(list);
	}
}
