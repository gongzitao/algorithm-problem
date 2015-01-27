import java.util.LinkedList;
import java.util.HashSet;
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || start.length() == 0 || end == null || end.length() == 0) return 0;
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        int pre_count = 1;
        int cur_count = 0;
        int level = 0;
        while(!queue.isEmpty()){
            String word = queue.poll();
            pre_count --;
            if(word.equals(end)) return level + 1;
            
            for(int i = 0; i < word.length(); i++){
                for(char j = 'a'; j <= 'z'; j++){
                    char[] letters = word.toCharArray();
                    letters[i] = j;
                    String new_word = new String(letters);
                    if(dict.contains(new_word) && !visited.contains(new_word)){
                        queue.offer(new_word);
                        cur_count ++;
                        visited.add(new_word);
                    }
                }
            }
            if(pre_count == 0){
                pre_count = cur_count;
                cur_count = 0;
                level ++;
            }
        }
        return 0;
    }
}