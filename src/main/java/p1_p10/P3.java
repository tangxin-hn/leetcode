package p1_p10;

public class P3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    //others
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int start=0,end=1,Max=1;
        for(int i=1;i<s.length();i++) {
            String ss = s.substring(start,end);
            char c = s.charAt(i);
            if(ss.indexOf(c)!=-1){
                start = start + ss.indexOf(c)+1;
                end = i+1;
            } else {
                end++;
            }
            if(end-start>Max)
                Max = end - start;
        }
        return Max;
    }
}
