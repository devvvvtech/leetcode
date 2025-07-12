package Medium;

public class KokoEatingBananas_875 {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getMax(piles);

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(canEat(piles, h, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static boolean canEat(int[] piles, int h, int k) {
        long hours = 0;

        for(int pile : piles) {
            hours += (pile + k-1L)/k;
        }

        return hours<=h;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int pile : arr) {
            if(pile > max) {
                max = pile;
            }
        }
        return max;
    }
}
