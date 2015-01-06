public class Solution {
    public int findPeakElement(int[] num) {
        if(num == null || num.length == 0)
            return 0;
        int left = 0;
        int right = num.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(mid == num.length - 1)
                if(num[mid] > num[mid - 1])
                    return mid;
                else return mid - 1;
            if(mid == 0)
                if(num[mid] > num[mid + 1])
                    return mid;
                else return mid + 1;
            if(num[mid] > num[mid - 1] && num[mid] > num[mid + 1])
                return mid;
            if(num[mid] > num[mid - 1] && num[mid] < num[mid + 1]){
                left = mid + 1;
            }
            //else right = mid - 1;
            if(num[mid] > num[mid + 1] && num[mid] < num[mid - 1]){
                right = mid - 1 ;
            }
            //else right = mid + 1;
            if(num[mid] < num[mid - 1] && num[mid] < num[mid + 1]){
                if(num[mid - 1] > num[mid + 1])
                    right = mid - 1;
                else left = mid + 1;
            }
            
        }
        return left;
    }
}