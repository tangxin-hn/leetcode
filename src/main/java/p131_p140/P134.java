package p131_p140;

public class P134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || cost==null || gas.length!=cost.length || gas.length==0)
            return -1;
        int total=0;
        int rest=0,pos=0;
        for (int i=0;i<gas.length;i++) {
            total = total + gas[i] - cost[i];
            rest = rest + gas[i] - cost[i];
            if (rest<0) {
                rest = 0;
                pos = i+1;
            }
        }
        if (total<0)
            return -1;
        return pos;
    }
}
