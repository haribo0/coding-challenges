package challenges.programmers.level1.p81301;

class Solution {
    public int solution(String s) {
		String[] n = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		for(int i=0;i<n.length;i++) {
			s = s.replace(n[i],String.valueOf(i));
		}       
        
        return Integer.valueOf(s);
    }
}