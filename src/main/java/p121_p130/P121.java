package p121_p130;

public class P121 {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1)
            return 0;
        int profit=0;
        int maxPos=prices.length-1;
        for (int i=prices.length-2;i>=0;i--) {
            if (prices[maxPos]-prices[i]>profit) {
                profit = prices[maxPos]-prices[i];
            } else if (prices[i]>prices[maxPos]) {
                maxPos = i;
            }
        }
        return profit;
    }
}
