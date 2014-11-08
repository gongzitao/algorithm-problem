public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) return;
        int i = 0;
        int red = 0;
        int blue = A.length - 1;
        while(i <= blue){
            if(A[i] == 0){
                int temp = A[i];
                A[i] = A[red];
                A[red] = temp;
                red++;
                i++;
            }
            else if(A[i] == 2){
                int temp = A[i];
                A[i] = A[blue];
                A[blue] = temp;
                blue--;
            }
            else i++;
        }
    }
}