package problems.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class P45 {

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 98.20% 的用户 内存消耗 : 40 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public String minNumber(int[] nums) {
        Integer[] inteArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            inteArray[i] = nums[i];
        }
        Arrays.sort(inteArray, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inteArray.length; i++) {
            sb.append(inteArray[i]);
        }
        return sb.toString();
    }

    class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer inteOne, Integer inteTwo) {
            if (inteOne.equals(inteTwo)) {
                return 0;
            } else {
                LinkedList<Integer> o1list = new LinkedList<>(), o2list = new LinkedList<>();
                int o1 = inteOne, o2 = inteTwo;
                int o1Tmp = 0, o2Tmp = 0;
                while (!(o1 == 0)) {
                    o1list.addFirst(o1 % 10);
                    o1 /= 10;
                }
                while (!(o2 == 0)) {
                    o2list.addFirst(o2 % 10);
                    o2 /= 10;
                }
                int maxTime = Integer.max(o1list.size(), o2list.size()) + 1, nowTime = 0;
                while (true) {
                    if (!o1list.isEmpty()) {
                        o1Tmp = o1list.pollFirst();
                        o1list.addLast(o1Tmp);
                    }
                    if (!o2list.isEmpty()) {
                        o2Tmp = o2list.pollFirst();
                        o2list.addLast(o2Tmp);
                    }
                    if (o1Tmp > o2Tmp) {
                        return 1;
                    } else if (o1Tmp < o2Tmp) {
                        return -1;
                    }
                    if (++nowTime >= maxTime) {
                        return 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        P45 p = new P45();
        String r = p.minNumber(new int[] { 12, 121 });
    }

}