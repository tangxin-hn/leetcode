package p31_p40;

import java.util.Arrays;

public class P36 {
    public boolean isValidSudoku(char[][] board) {
        char[] cs = new char[9];
        for (int i=0;i<9;i++) {

            for (int j=0;j<9;j++) {
                cs[j] = board[i][j];
            }
            if (!isValid(cs))
                return false;

            for (int j=0;j<9;j++) {
                cs[j] = board[j][i];
            }
            if (!isValid(cs))
                return false;

            int x = i%3;
            int y = i/3;
            for (int j=0;j<3;j++) {
                for (int k=0;k<3;k++) {
                    cs[j*3+k] = board[y*3+j][x*3+k];
                }
            }
            if (!isValid(cs))
                return false;
        }
        return true;
    }
    public boolean isValid(char[] cs) {
        Arrays.sort(cs);
        for(int i=1;i<cs.length;i++) {
            if (cs[i]!='.' && cs[i]==cs[i-1])
                return false;
        }
        return true;
    }


    //others
    public boolean isValidSudoku2(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
}
