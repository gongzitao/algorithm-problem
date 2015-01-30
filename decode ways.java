public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i - 1) != '0') {
                res[i] = res[i - 1];
            }
            if(s.charAt(i  -2) != '0'){
                int num = Integer.parseInt(s.substring(i - 2, i));
                if(num > 0 && num <= 26){
                    res[i] += res[i - 2];
                }
            }
        }
        return res[s.length()];
    }
}