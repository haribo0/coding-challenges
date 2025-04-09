package p138476;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int solution(int k, int[] tangerine) {
        int types = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int size : tangerine){
            countMap.put(size, countMap.getOrDefault(size,0)+1);
        }
        List<Integer> frequencies = new ArrayList<>(countMap.values());
        frequencies.sort(Collections.reverseOrder());
        for(Integer n : frequencies){
            k -= n;
            types++;
            if(k<=0) break;
        }

        return types;
    }

}
