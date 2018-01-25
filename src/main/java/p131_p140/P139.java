package p131_p140;

import java.util.*;

public class P139 {
    public static void main(String[] args) {
        P139 t = new P139();
        String s = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("e");
        wordDict.add("cod");
        System.out.println(t.wordBreak(s,wordDict));
    }

    //递归超时
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || wordDict==null)
            return false;
        StringBuffer stringBuffer = new StringBuffer(s);
        return wordBreak(stringBuffer,wordDict);
    }
    protected boolean wordBreak(StringBuffer stringBuffer, List<String> wordDict){
        if (stringBuffer.length()==0)
            return true;
        for (int i=0;i<wordDict.size();i++) {
            String word = wordDict.get(i);
            int length = word.length();
            if (length>stringBuffer.length())
                continue;
            if (stringBuffer.subSequence(0,length).toString().equals(word)) {
                //wordDict.remove(i);
                stringBuffer.delete(0,length);
                if (wordBreak(stringBuffer,wordDict))
                    return true;
                //wordDict.add(0,word);
                stringBuffer.insert(0,word);
            }
        }
        return false;
    }

    //others
    public boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
