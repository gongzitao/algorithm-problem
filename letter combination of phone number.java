import java.util.ArrayList;
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        res.add("");
        if(digits == null || digits.length() == 0) return res;
        
        for(int i = 0; i < digits.length(); i++){
            char c = digits.charAt(i);
            String panel = getLetters(c);
            //int size = res.size();
            ArrayList<String> list = new ArrayList<String>();
            for(int j = 0; j < res.size(); j++){
                //size = res.size();
                //list = new ArrayList<String>();
                for(int k = 0; k < panel.length(); k++){
                    
                    StringBuilder letters = new StringBuilder(res.get(j));
                    letters.append(panel.charAt(k));
                    list.add(letters.toString());
                }
            }
            res = list;
        }
        return res;
    }
    private String getLetters(char c){
        switch(c){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default : return "";
        }
    }
}