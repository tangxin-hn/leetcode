package p41_p50;

import java.util.*;

public class P49 {
    public static void main(String[] args) {
        String[] strings = {"",""};
        P49 t = new P49();
        System.out.println(t.groupAnagrams2(strings));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        boolean[] booleans = new boolean[strs.length];
        for (int i=0;i<strs.length;i++) {
            if (booleans[i]) continue;
            List<String> list = permuteUnique(strs[i]);
            List<String> list1 = new ArrayList<>();
            list1.add(strs[i]);
            booleans[i] = true;
            for (int j=i+1;j<strs.length;j++) {
                if (booleans[j]) continue;
                if (list.contains(strs[j])) {
                    list1.add(strs[j]);
                    booleans[j] = true;
                }
            }
            lists.add(list1);
        }
        return lists;
    }
    public List<String> permuteUnique   (String str) {
       List<String> res = new ArrayList<String>();
        if (str==null) return res;
        if (str.length()==0) {
            res.add("");
            return res;
        }
        boolean[] used = new boolean[str.length()];
        StringBuffer stringBuffer = new StringBuffer();
        dfs(str, used, stringBuffer, res);
        return res;
    }

    public void dfs(String str, boolean[] used, StringBuffer stringBuffer, List<String> res){
        if(stringBuffer.length()==str.length()){
            res.add(new String(stringBuffer));
            return;
        }
        for(int i=0;i<str.length();i++){
            if(used[i]) continue;
            used[i]=true;
            stringBuffer.append(str.charAt(i));
            dfs(str,used,stringBuffer,res);
            used[i]=false;
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }

    //others
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
