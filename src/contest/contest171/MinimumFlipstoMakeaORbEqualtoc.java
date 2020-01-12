package contest.contest171;
//leetcode 5308
public class MinimumFlipstoMakeaORbEqualtoc {

    public int minFlips(int a, int b, int c) {
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        String binaryC = Integer.toBinaryString(c);
        int maxlength = maxlength(binaryA, binaryB, binaryC);
        binaryA = makeUpString(binaryA, maxlength);
        binaryB = makeUpString(binaryB, maxlength);
        binaryC = makeUpString(binaryC, maxlength);
        int flips = 0;
        for (int i = 0; i < maxlength; i++) {
            if (binaryA.charAt(i) == binaryC.charAt(i) && binaryB.charAt(i) == binaryC.charAt(i)) {
                continue;
            } else if (binaryA.charAt(i) != binaryC.charAt(i) && binaryB.charAt(i) == binaryC.charAt(i)) {
                if (binaryC.charAt(i) == '0') {
                    flips++;
                } else
                    continue;
            } else if (binaryA.charAt(i) == binaryC.charAt(i) && binaryB.charAt(i) != binaryC.charAt(i)) {
                if (binaryC.charAt(i) == '0') {
                    flips++;
                } else
                    continue;
            } else if (binaryA.charAt(i) != binaryC.charAt(i) && binaryB.charAt(i) != binaryC.charAt(i)) {
                if (binaryC.charAt(i) == '1') {
                    flips++;
                } else
                    flips += 2;
            }
        }
        return flips;
    }

    private int maxlength(String a, String b, String c) {
        int max = Math.max(a.length(), b.length());
        max = Math.max(max, c.length());
        return max;
    }

    private String makeUpString(String str, int length) {
        if (str.length() < length) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < length - str.length(); i++) {
                s.append("0");
            }
            s.append(str);
            return s.toString();
        }
        return str;
    }
}