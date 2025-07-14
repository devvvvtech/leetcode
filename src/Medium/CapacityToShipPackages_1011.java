package Medium;

public class CapacityToShipPackages_1011 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int result = shipWithinDays(weights, days);
        System.out.println(result);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isValid(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] arr, int days, int capacity) {
        int totaldays = 1;
        int current = 0;

        for(int weight : arr) {
            if(current + weight <= capacity) {
                current += weight;
            }
            else {
                totaldays++;
                current = weight;
            }
            if(totaldays > days) {
                return false;
            }
        }
        return true;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for(int num:arr) {
            sum += num;
        }
        return sum;
    }
}
