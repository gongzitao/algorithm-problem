public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if(len % 2 == 1)
            return findKth(A,0,A.length - 1,B,0,B.length - 1,len/2 + 1);
        else
            return (findKth(A,0,A.length - 1,B,0,B.length - 1,len / 2) + findKth(A,0,A.length - 1,B,0,B.length - 1,len/2 + 1)) / 2.0;
    }
    private int findKth(int[] A, int m, int n, int[] B, int i, int j, int k){
        int alen = n - m + 1;
        int blen = j - i + 1;
        if(alen > blen) return findKth(B,i,j,A,m,n,k);
        if(alen == 0) return B[i + k - 1];
        if(k == 1) return Math.min(A[m],B[i]);
        int posA = Math.min(alen, k/2);
        int posB = k - posA;
        if(A[posA + m - 1] == B[posB + i - 1])
            return A[posA + m - 1];
        else if(A[posA + m - 1] > B[posB + i - 1])
            return findKth(A,m,m + posA - 1,B,posB + i, j, k - posB);
        else return findKth(A,m + posA ,n,B,i,i + posB - 1, k - posA);
    }
}