package p70129;

public class Solution {

    public int[] solution(String s) {
        int count = 0;
        int zeroRemoved = 0;
        while(!s.equals("1")){
            int len = s.length();
            s = s.replace("0","");
            zeroRemoved += (len-s.length());
            s = Integer.toBinaryString(s.length());
            count++;
        }
        
        return new int[] {count,zeroRemoved};
    }

}
