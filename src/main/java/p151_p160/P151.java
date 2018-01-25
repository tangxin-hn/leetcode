package p151_p160;

public class P151 {
    public static void main(String[] args) {
        P151 t = new P151();
        System.out.print("a"+t.reverseWords("   c aaa   1   d") +"a");
    }
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        s = cleanSpaces(a,n);
        if (s=="")
            return "";

        String[] ss = s.split(" ");
        s="";
        for (int i=ss.length-1;i>0;i--)
            s = s + ss[i] +" ";
        return s+ss[0];
    }

    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }


    //others
    public String reverseWords2(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("\\ ");
        for(int i = str.length - 1; i >= 0; i--){
            String ss = str[i];
            if(!ss.isEmpty()){
                sb.append(ss).append(" ");
            }
        }
        if(sb.length() != 0)
            sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
