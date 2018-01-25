package p71_p80;

public class P79 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] == words[0]) {
                    boolean[][] flag = new boolean[board.length][board[0].length];
                    flag[i][j] = true;
                    if(findPath(flag,board,i,j,1,words))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean findPath(boolean[][] flag,char[][] board, int x,int y,int p,char[] words) {
        if (p==words.length)
            return true;
        if (x-1>=0 && !flag[x-1][y] &&  board[x-1][y]==words[p]) {
            flag[x-1][y] = true;
            if (findPath(flag,board,x-1,y,p+1,words))
                return true;
            flag[x-1][y] = false;
        }
        if (x+1<board.length && !flag[x+1][y] &&  board[x+1][y]==words[p]){
            flag[x+1][y] = true;
            if (findPath(flag,board,x+1,y,p+1,words))
                return true;
            flag[x+1][y] = false;
        }
        if (y-1>=0 && !flag[x][y-1] &&  board[x][y-1]==words[p]) {
            flag[x][y-1] = true;
            if (findPath(flag,board,x,y-1,p+1,words))
                return true;
            flag[x][y-1] = false;
        }
        if (y+1<board[0].length && !flag[x][y+1] &&  board[x][y+1]==words[p]) {
            flag[x][y+1] = true;
            if (findPath(flag,board,x,y+1,p+1,words))
                return true;
            flag[x][y+1] = false;
        }
        return false;
    }


    //others
    public boolean exist2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
}
