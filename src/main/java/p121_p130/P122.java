package p121_p130;

public class P122 {
    public int maxProfit(int[] prices) {
        if (prices==null)
            return 0;
        int getPos = -1;
        int sum=0;
        for (int i=0;i<=prices.length-2;i++) {
            if (getPos==-1 && prices[i]<prices[i+1]) {
                getPos = i;
            } else if (getPos!=-1 && prices[i]>prices[i+1]) {
                sum += prices[i] - prices[getPos];
                getPos = -1;
            }
        }
        if (getPos!=-1) {
            sum += prices[prices.length-1]-prices[getPos];
        }
        return sum;
    }

    //others
    public int maxProfit2(int[] prices) {
        int profit=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+= prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
