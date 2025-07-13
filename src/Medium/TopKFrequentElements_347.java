package Medium;
//This problem is solved using map and list
//we can solve this using heap too
/*Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

*/

import java.util.*;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
        //output [1,2]
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        //initializing a map
        Map<Integer, Integer> map =  new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //now we'll create a list & put all values of map inside it
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //sorting the list in descending order
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i=0; i<k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}
