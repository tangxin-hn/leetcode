package p21_p30;

public class P28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //others
    public int strStrz(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
