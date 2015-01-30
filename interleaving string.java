public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null || s3.length() == 0){
            if((s2 == null || s2.length() == 0) && (s1 == null || s1.length() == 0)) return true;
            else return false;
        }
        if(s2 == null || s2.length() == 0) return s1.equals(s3);
        if(s3 == null || s3.length() == 0) return s1.equals(s2);
        if(s3.length() != s2.length() + s1.length()) return false;
        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        res[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            if(res[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1))
                res[i][0] = true;
        }
        for(int j = 1; j <= s2.length(); j++){
            if(res[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1))
                res[0][j] = true;
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if((s1.charAt(i - 1) == s3.charAt(i + j - 1) && res[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && res[i][j - 1]))
                    res[i][j] = true;
            }
        }
        return res[s1.length()][s2.length()];
    }
}