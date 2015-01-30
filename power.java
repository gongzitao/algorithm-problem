public class Solution {
    public double pow(double x, long n) {
        if(n == 0) return 1.0;
        if(n < 0) return 1.0 / pow(x,  -n);
        double half = pow(x, n / 2);
        if( n % 2 == 0) return half * half;
        else return half * half * x;
    }
}