package contest.contest167;

import java.util.ArrayList;
import java.util.List;

//
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int length = 0, lowCopy = low;
        List<Integer> result = new ArrayList<>();

        while (lowCopy != 0) {
            lowCopy /= 10;
            length++;
        }

        for (;; length++) {
            int oneResult = 0;

            for (int i = 0; i < length; i++) {
                oneResult = oneResult * 10 + (oneResult % 10 + 1); // 1234
            }
            int firstDigit = 1;
            do {
                if (oneResult > high) {
                    return result;
                } 
                if(oneResult >= low){
                    result.add(oneResult);
                }
                
                oneResult = ((oneResult) % (int) Math.pow(10, length - 1)) * 10 + (oneResult % 10 + 1);
                firstDigit++;
            } while (firstDigit <= 10 - length);
        }
    }

    // low = 10 , high = 1000000000
    public static void main(String[] args) {
        SequentialDigits s = new SequentialDigits();
        System.out.println(s.sequentialDigits(100, 234));
    }
}