package challenges.programmers.level1.p133499;

public class Solution {
    public int solution(String[] babbling){
        String[] canSpeak = {"aya","ye","woo","ma"};
        int count = 0;

        for(String word:babbling){
            String prev = "";
            String temp = word;

            boolean isValid = true;
            while(!temp.isEmpty()){
                boolean matched = false;
                for(String speak:canSpeak){
                    if(temp.startsWith(speak)){
                        if(speak.equals(prev)){
                            isValid = false;
                            break;
                        }
                        prev = speak;
                        temp = temp.substring(speak.length());
                        matched = true;
                        break;
                    }
                }
                if(!isValid || !matched){
                    isValid = false;
                    break;
                }
            }
            if(isValid) count++;
        }


        return count;
    }  
    
}
