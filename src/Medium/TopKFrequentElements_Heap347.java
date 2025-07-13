package Medium;
//this is solved using the maxHeap concept
//storing the map values inside the heap and then iterating over them

import java.util.*;

public class TopKFrequentElements_Heap347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
        //output [1,2]
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        for(int i=0; i<k; i++) {
            ans[i] = maxHeap.poll().getKey();
        }

        return ans;
    }
}
