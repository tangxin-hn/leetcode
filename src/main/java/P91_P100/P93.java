package P91_P100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P93 {
    public static void main(String[] args) {
        P93 t = new P93();
        String s = "010010";
        System.out.println(t.restoreIpAddresses(s));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> stringList = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = s.toCharArray();
        restoreIpAddresses(chars,stringList,stringBuffer,0,0);
        return stringList;
    }
    public void restoreIpAddresses(char[] chars,List<String> stringList,StringBuffer stringBuffer,int pos,int deep) {
        if (deep==4 || pos==chars.length) {
            if (deep==4 && pos==chars.length) {
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
                stringList.add(stringBuffer.toString());
                stringBuffer.append('.');
            }
            return;
        }
        for (int i=pos;i<chars.length;i++) {
            if (chars[pos]=='0' && i>pos)
                break;
            int sum=0;
            for (int j=pos;j<=i;j++)
                sum = sum*10+chars[j]-'0';
            if (sum>255)
                break;
            for (int j=pos;j<=i;j++)
                stringBuffer.append(chars[j]);
            stringBuffer.append('.');
            restoreIpAddresses(chars,stringList,stringBuffer,i+1,deep+1);
            stringBuffer.delete(stringBuffer.length()-i+pos-2,stringBuffer.length());
        }
    }

    //others
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
