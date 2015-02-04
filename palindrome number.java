public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        //if(x < 10) return true;
        int base = 1;
        int num = x;
        while(num / 10 != 0){
            base *= 10;
            num /= 10;
        }
        while(x != 0){
            int left = x / base;
            int right = x % 10;
            if(left != right) return false;
            x %= base;
            x /= 10;
            base /= 100;
        }
        return true;
    }
}