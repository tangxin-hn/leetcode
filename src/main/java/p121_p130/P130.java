package p121_p130;

public class P130 {
    public void solve(char[][] board) {
        if (board==null || board.length<3 || board[0].length<3)
            return;
        for (int i=0;i<board.length;i++) {
            if (board[i][0]=='O')
                check(board,i,0);
            if (board[i][board[0].length-1]=='O')
                check(board,i,board[0].length-1);
        }
        for (int i=0;i<board[0].length;i++) {
            if (board[0][i]=='O')
                check(board,0,i);
            if (board[board.length-1][i]=='O')
                check(board,board.length-1,i);
        }
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j]=='O')
                    board[i][j] = 'X';
                if (board[i][j]=='1')
                    board[i][j] = 'O';
            }
        }
    }
    public void check(char[][] board,int col,int row) {
        board[col][row] ='1';
        if (col>0 && board[col-1][row]=='O') {
            check(board,col-1,row);
        }
        if (row>0 && board[col][row-1]=='O') {
            check(board,col,row-1);
        }
        if (col<board.length-1 && board[col+1][row]=='O') {
            check(board,col+1,row);
        }
        if (row<board[0].length-1 && board[col][row+1]=='O') {
            check(board,col,row+1);
        }
    }
}
