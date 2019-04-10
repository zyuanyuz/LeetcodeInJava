package problems.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

/**
 * leetcode 19 Medium
 * 
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 */

public class RemoveNthNodeFromEndofList {
	//16 ms, faster than 2.33% of Java online submissions for Remove Nth Node From End of List.
	public ListNode removeNthFromEndone(ListNode head, int n) {
		Map<Integer,ListNode> map = new HashMap<>();
		ListNode pointnode = head;
		int i = 1;
		while(pointnode != null) {
			map.put(i, pointnode);
			pointnode = pointnode.next;
			i++;
		}
		if(i-n-1==0) {  				  //如果删除点是第一个点
			return head.next;
		}
		else {
			pointnode = map.get(i-n-1);   //得到待删除点的前一个点
			pointnode.next = pointnode.next.next;
			return head;
		}
		
	}
	
	
	public ListNode removeNthFromEnd(ListNode head,int n) {
		
		return head;
	}

	public void test() { // 考虑删除头节点和尾节点的情况测试
		Random random = new Random(48);
		ListNode head = new ListNode(random.nextInt(20));
		ListNode pointnode = head;
		for (int i = 0; i < 30; i++) {
			pointnode.next = new ListNode(random.nextInt(20));
			pointnode = pointnode.next;
		}
		ListNode resultnode = removeNthFromEnd(head, 10);
		while (resultnode != null) {
			System.out.print(resultnode.val + " ");
			resultnode = resultnode.next;
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
