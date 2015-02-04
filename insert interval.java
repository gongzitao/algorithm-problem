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
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(newInterval == null) return res;
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        int i = 0;
        int size = intervals.size();
        while(i < size && newInterval.start > intervals.get(i).end){
            res.add(intervals.get(i));
            i++;
        }
        if(i < size){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        while(i < size && newInterval.end >= intervals.get(i).start){
            newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while(i < size){
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}