package problems.medium;

/**
 * leetcode 6 Medium 
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern
 * on a given number of rows like this: (you may want to display this pattern in
 * a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 */
/**/
//55 ms, faster than 33.68% of Java online submissions for ZigZag Conversion.
public class ZigZagConversion {
	
	public String convert(String s, int numRows) {
		if(numRows==1) {
			return s;
		}
        String results[] = new String[numRows];  //String[0] to String[numRows-1]
        for(int i =0;i<numRows;i++) {
        	results[i]="";
        }
        int period = numRows*2-2;
        for(int i=0;i<s.length();i++) {
        	char thechar = s.charAt(i);
        	int local = i%period;
        	if(local<=(numRows-1)) {
        		results[local]+=thechar;
        	}
        	else {
        		local-=(numRows-1);
        		results[numRows-1-local]+=thechar;
        	}
        }
        String result="";
        for(int i=0;i<numRows;i++) {
        	result+=results[i];
        }
		return result;
    }
	
	public void test() {
		String test1 = convert("A",1);
		System.out.println(test1);
	}
}
