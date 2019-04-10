package problems.medium;

/**
 * leetcode 2 Medium
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

/* 优化思路： */
//Runtime: 39 ms, faster than 38.24% of Java online submissions for Add Two Numbers.
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(Integer.MAX_VALUE);
		ListNode index = head; // must operate the head rather than head.next
		int upnum = 0;
		int tmp = 0;
		while (l1 != null && l2 != null) {
			tmp = l1.val + l2.val + upnum;
			// System.out.println(tmp);
			if (tmp >= 10) {
				tmp = tmp - 10;
				index.next = new ListNode(tmp);

				upnum = 1;
			} else {
				index.next = new ListNode(tmp);
				upnum = 0;
			}
			// System.out.println(index.val);
			index = index.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			tmp = l1.val + upnum;
			if (tmp >= 10) {
				tmp = tmp - 10;
				index.next = new ListNode(tmp);
				upnum = 1;
			} else {
				index.next = new ListNode(tmp);
				upnum = 0;
			}
			index = index.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			tmp = l2.val + upnum;
			if (tmp >= 10) {
				tmp = tmp - 10;
				index.next = new ListNode(tmp);
				upnum = 1;
			} else {
				index.next = new ListNode(tmp);
				upnum = 0;
			}
			index = index.next;
			l2 = l2.next;
		}
		if (upnum == 1) {
			index.next = new ListNode(upnum);
		}
		return head.next;
	}

	// Test Case
	public void test() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode result = addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		
		System.out.println("---------");
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(5);
		ListNode l34 = addTwoNumbers(l3, l4);
		while (l34 != null) {
			System.out.print(l34.val + "->");
			l34 = l34.next;
		}
	}
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}


