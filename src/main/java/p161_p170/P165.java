package p161_p170;

public class P165 {
    public static void main(String[] args) {
        P165 t = new P165();
        System.out.println(t.compareVersion("01.0","1"));
    }
    public int compareVersion(String version1, String version2) {
        int i,j;
        for (i=0,j=0;i<version1.length() && j<version2.length();i++,j++) {
            int pos1=i;
            int pos2=j;
            while (i<version1.length() && version1.charAt(i)!='.')
                i++;
            while (j<version2.length() && version2.charAt(j)!='.')
                j++;
            int v1 = Integer.parseInt(version1.substring(pos1,i));
            int v2 = Integer.parseInt(version2.substring(pos2,j));
            if (v1>v2) {
                return 1;
            } else if (v1<v2) {
                return -1;
            }
        }
        if (i==version1.length()+1 && j==version2.length()+1)
            return 0;
        else if (i==version1.length()+1) {
            if (isZero(version2.substring(j,version2.length())))
                return 0;
            return -1;
        }
        else {
            if (isZero(version1.substring(i,version1.length())))
                return 0;
            return 1;
        }
    }

    public boolean isZero(String s) {
        for (int i=0;i<s.length();i++) {
            int pos = i;
            while (i<s.length() && s.charAt(i)!='.')
                i++;
            int v = Integer.parseInt(s.substring(pos,i));
            if (v!=0)
                return false;
        }
        return true;
    }

    //others
    public int compareVersion2(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int i = 0;
        int j = 0;
        int num1 = 0; int num2 = 0;
        while(i < v1.length || j < v2.length){
            while(i < v1.length && v1[i] != '.'){
                num1 = num1*10 + (v1[i] - '0');
                i++;
            }
            while(j < v2.length && v2[j] != '.'){
                num2 = num2*10 + (v2[j] - '0');
                j++;
            }
            if(num1 > num2){
                return 1;
            }
            if(num1 < num2){
                return -1;
            }
            i++;
            j++;
            num1 = 0;
            num2 = 0;
        }
        return 0;
    }
}
