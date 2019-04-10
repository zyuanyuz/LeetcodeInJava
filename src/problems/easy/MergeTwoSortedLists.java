package problems.easy;

import java.util.Random;

/**
 * leetcode 21 easy
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 */
public class MergeTwoSortedLists {
	//11 ms, faster than 98.80% of Java online submissions for Merge Two Sorted Lists.
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode resultnode = new ListNode(0), pointnode = resultnode;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				//System.out.println("case1:" + l1.val + " " + l2.val);
				pointnode.next = l1;
				pointnode = pointnode.next;
				l1 = l1.next;
			} else {
				//System.out.println("case2:" + l2.val);
				pointnode.next = l2;
				pointnode = pointnode.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			while (l1 != null) {
				pointnode.next = l1;
				pointnode = pointnode.next;
				l1 = l1.next;
			}
		} else if (l2 != null) {
			while (l2 != null) {
				pointnode.next = l2;
				pointnode = pointnode.next;
				l2 = l2.next;
			}
		}

		return resultnode.next;
	}

	public void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		//ListNode l2 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode result = mergeTwoLists(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
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
