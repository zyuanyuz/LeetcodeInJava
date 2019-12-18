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
		if(lists.length==0){
			return null;
		}
		ListNode resultHead = new ListNode(0);
		resultHead.next = lists[0];
		for(int i=0;i<lists.length;i++){
			ListNode moveOne = resultHead;
			ListNode moveTwo = lists[i];
			while(moveOne != null){
				if(moveOne.next.val < moveTwo.val){

				}
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
