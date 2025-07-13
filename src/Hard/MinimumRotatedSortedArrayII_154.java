package Hard;

public class MinimumRotatedSortedArrayII_154 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,0,1,2,2,2,2};
        int result = findMin(nums);
        System.out.println(result);
    }

    public static int findMin(int[] nums) {
        //here we can use binary search to find the minimum element
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            else if(nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
