import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.length;
        
        // Create index array
        Integer[] index = new Integer[n];
        
        for(int i = 0; i < n; i++){
            index[i] = i;
        }
        
        // Sort index based on heights (descending)
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);
        
        // Create result array
        String[] result = new String[n];
        
        for(int i = 0; i < n; i++){
            result[i] = names[index[i]];
        }
        
        return result;
    }
}