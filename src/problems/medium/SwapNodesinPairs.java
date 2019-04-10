package problems.medium;

import java.util.Random;

/**
 * leetcode 24 Medium
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Note:
 * 
 * Your algorithm should use only constant extra space. You may not modify the
 * values in the list's nodes, only nodes itself may be changed.
 *
 */

public class SwapNodesinPairs {
	//3 ms, faster than 51.39% of Java online submissions for Swap Nodes in Pairs.
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		// 要求O(1)的空间复杂度
		ListNode backnode = null;
		ListNode tmpnode = head.next;
		if (tmpnode == null) { // 处理开始的两个节点的问题
			return head;
		} else {
			head.next = tmpnode.next; // 如果这里是null会不会出错?
			tmpnode.next = head;
			head = tmpnode;
			backnode = head.next;
		}

		while (backnode.next != null && backnode.next.next != null) { // backnode为将要交换两结点的前置结点
			tmpnode = backnode.next;
			backnode.next = backnode.next.next;
			tmpnode.next = backnode.next.next;
			backnode.next.next = tmpnode;
			backnode = tmpnode;
		}
		return head;
	}

	public void test() {
		ListNode head = new ListNode(1);
		ListNode pointnode = head;
		System.out.print(head.val + " ");
		Random rand = new Random(47);
		for (int i = 0; i < 4; i++) {
			int a = rand.nextInt(10);
			System.out.print(a + " ");
			pointnode.next = new ListNode(a);
			pointnode = pointnode.next;
		}
		System.out.println();
		ListNode result = swapPairs(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
