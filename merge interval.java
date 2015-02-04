/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new newComparator());
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= res.get(res.size() - 1).end){
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            }
            else res.add(intervals.get(i));
        }
        return res;
    }
}
class newComparator implements Comparator<Interval>{
    public int compare(Interval interval1, Interval interval2){
        return interval1.start - interval2.start;
    }
}