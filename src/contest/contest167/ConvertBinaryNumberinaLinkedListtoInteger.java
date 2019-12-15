package contest.contest167;

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while(head!=null){
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(stringBuilder.toString(),2);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
