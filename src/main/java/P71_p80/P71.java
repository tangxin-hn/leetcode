package P71_p80;

import java.util.*;

public class P71 {
    public static void main(String[] args) {
        P71 t = new P71();
        System.out.println(t.simplifyPath("/a/./b/../../c/"));
    }
    public String simplifyPath(String path) {
        char[] paths = path.toCharArray();
        StringBuffer[] stringBuffers = new StringBuffer[path.length()/2];
        int count=0;
        for (int i=0;i<paths.length;i++) {
            while (i<paths.length-1 && paths[i+1]=='/') {
                i++;
            }
            if (i==paths.length-1) {
                if (count>0)
                    break;
                else
                    return "/";
            }
            if (paths[i+1]=='.') {
                if (i+2<paths.length && paths[i+2]=='.') {
                    if (count>0)
                        count--;
                    i+=2;
                } else {
                    i++;
                }
            } else {
                stringBuffers[count] = new StringBuffer();
                while (i+1<paths.length && paths[i+1] != '/') {
                    stringBuffers[count].append(paths[i]);
                    i++;
                }
                if (paths[i]!='/')
                    stringBuffers[count].append(paths[i]);
                count++;
            }
        }
        if (count==0)
            return "/";
        for (int i=1;i<count;i++)
            stringBuffers[0].append(stringBuffers[i]);
        return stringBuffers[0].toString();
    }

    //others
    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
