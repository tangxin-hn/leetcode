package p121_p130;

import java.util.List;
import java.util.*;

public class P127 {
    //超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord))
            return 0;
        int[] nums = new int[wordList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.MAX_VALUE-1;
            if (wordList.get(i).equals(endWord)) {
                nums[i] = 2;
            }
        }
        for (int k=0;k<wordList.size();k++) {
            for (int i = 0; i < wordList.size(); i++) {
                for (int j = 0; j < wordList.size(); j++) {
                    if (changeble(wordList.get(i), wordList.get(j)) && nums[i]>nums[j]+1) {
                        nums[i] = nums[j] + 1;
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<wordList.size();i++) {
            if (changeble(beginWord,wordList.get(i)) && min>nums[i])
                min = nums[i];
        }
        if (min==Integer.MAX_VALUE)
            return 0;
        return min;
    }
    public boolean changeble(String s1,String s2) {
        int count=0;
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        return count==1;
    }


    //很慢
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (wordList==null || !wordList.contains(endWord))
            return 0;
        List<String> reachable = new LinkedList<>();
        List<String> reachable2 = new LinkedList<>();
        int deepth = 2;
        reachable.add(beginWord);
        while (!reachable.isEmpty()) {
            for (String s:reachable) {
                for (int i=0;i<wordList.size();i++) {
                    if (changeble(s,wordList.get(i))) {
                        reachable2.add(wordList.get(i));
                        wordList.remove(i);
                        i--;
                    }
                }
            }
            if (reachable2.contains(endWord))
                return deepth;
            deepth++;
            reachable = reachable2;
            reachable2 = new LinkedList<>();
        }
        return 0;
    }

    //others
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        dict.remove(beginWord);
        dict.remove(endWord);
        Set<String> forward = new HashSet<>(), backward = new HashSet<>();
        forward.add(beginWord);
        backward.add(endWord);
        return bfs(forward, backward, dict, 1);
    }

    private int bfs(Set<String> forward, Set<String> backward, Set<String> dict, int len) {
        if (forward.size() > backward.size()) {
            return bfs(backward, forward, dict, len);
        }
        Set<String> next = new HashSet<>();
        for (String fw : forward) {
            char[] cs = fw.toCharArray();
            for (int i = 0; i < cs.length; ++i) {
                char oldC = cs[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == oldC) {
                        continue;
                    }
                    cs[i] = c;
                    String ss = new String(cs);
                    if (backward.contains(ss)) {
                        return len + 1;
                    }
                    if (dict.contains(ss)) {
                        next.add(ss);
                        dict.remove(ss);
                    }
                }
                cs[i] = oldC;
            }
        }
        if (next.size() == 0) {
            return 0;
        }
        return bfs(next, backward, dict, len + 1);
    }
}
