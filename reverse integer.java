public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = Math.abs(x);
        }
        int num = x;
        int digit = 0;
        while(num / 10 != 0){
            num /= 10;
            digit ++;
        }
        int left = 0;
        int right = digit;
        int res = 0;
        while(left <= right){
            int number = x % 10;
            //check overflow
            if(!negative && res > (Integer.MAX_VALUE - num) / 10) return 0;
            if(negative && res > -((Integer.MIN_VALUE + num) / 10)) return 0;
            res = res * 10 + number;
            left ++;
            x /= 10;
        }
        if(negative) return -res;
        else return res;
    }
}