import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args){
        ValidSudoku vs = new ValidSudoku();

        char[][] board = new char[][]{
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        vs.isValidSudoku(board);

        char[][] board2 = new char[][]
                {{'.','9','.','.','4','.','.','.','.'},{'1','.','.','.','.','.','6','.','.'},{'.','.','3','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','7','.','.','.','.','.'},{'3','.','.','.','5','.','.','.','.'},{'.','.','7','.','.','4','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','7','.','.','.','.'}};
        vs.isValidSudoku(board2);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> seen = new HashSet<>();
        //for rows
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(seen.contains(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.')
                    seen.add(board[i][j]);
            }
            seen.clear();
        }
        //for columns
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(seen.contains(board[j][i])){
                    return false;
                }
                if(board[j][i] != '.')
                    seen.add(board[j][i]);
            }
            seen.clear();
        }
        //for squares
        for(int k = 0; k<9; k++ ){
            int n = (k*3)%9;
            int m = (k/3)*3;
            for(int i = m; i < m+3; i++){
                for(int j = n; j < n+3; j++){
                    if(seen.contains(board[i][j])){
                        return false;
                    }
                    if(board[i][j] != '.')
                        seen.add(board[i][j]);
                }
            }
            //end of square check
            seen.clear();
        }
        return true;
    }
}
