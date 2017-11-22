package p51_p60;

public class P58 {
    public int lengthOfLastWord(String s) {
        int count=0;
        int i;
        for (i=s.length()-1;i>=0;i--) {
            if (s.charAt(i)!=' ') {
                break;
            }
        }
        for (;i>=0;i--,count++) {
            if (s.charAt(i)==' ') {
                return count;
            }
        }
        return count;
    }

    //others
    public int lengthOfLastWord2(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
