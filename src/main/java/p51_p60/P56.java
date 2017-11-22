package p51_p60;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
class IntervalSizeComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start!=o2.start)
            return o1.start - o2.start;
        else
            return o2.end - o1.end;
    }
}
public class P56 {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalSizeComparator());
        for (int i=0;i<intervals.size()-1;i++) {
            if (intervals.get(i).end>=intervals.get(i+1).start) {
                int start = intervals.get(i).start;
                int end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i,new Interval(start,end));
                i--;
            }
        }
        return intervals;
    }

    //others
    public List<Interval> merge2(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == intervals.size() - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
