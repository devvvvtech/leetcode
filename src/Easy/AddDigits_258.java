package Easy;

public class AddDigits_258 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(getDigit(num));
    }

    public static int getDigit(int num) {
        if(num==0){
            return 0;
        } else if (num % 9 != 0) {
            return num % 9;
        }
        return 9;
    }
}
