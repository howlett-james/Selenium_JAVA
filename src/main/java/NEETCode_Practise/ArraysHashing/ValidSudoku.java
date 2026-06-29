package NEETCode_Practise.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    @SuppressWarnings("unchecked")
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[][] res = new HashSet[3][3];
        for(int i =0;i<9;i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                res[i][j] = new HashSet<>();
            }
        }
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                char val = board[i][j];
                if(val == '.') continue;

                if(row[i].contains(val)) return false;
                if(col[j].contains(val)) return false;
                if(res[i/3][j/3].contains(val)) return false;
                
                row[i].add(val);
                col[j].add(val);
                res[i/3][j/3].add(val);
            }
        }
        return true;
                                                                                         
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','8','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','.','.','.','7','9'}
        };
        char[][] board2 = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','1','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','.','.','.','7','9'}
        };
        System.out.println(vs.isValidSudoku(board));
        System.out.println(vs.isValidSudoku(board2));
    }
    
}
