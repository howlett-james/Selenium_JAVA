package NEETCode_Practise.ArraysHashing;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            
        }
        return true;
                                                                                         
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = {{'1','2','.','.','3','.','.','.','.'},{'4','.','.','5','.','.','.','.','.'},{'.','9','8','.','.','.','.','.','3'},{'5','.','.','.','6','.','.','.','4'},{'.','.','.','.','3','.','.','5'},{'7','.','.','.','2','.','.','.','6'},{'.','.','.','.','.','.','2','.','.'},{'.','.','.','.','1','9','.','.','8'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(vs.isValidSudoku(board));
    }
    
}
