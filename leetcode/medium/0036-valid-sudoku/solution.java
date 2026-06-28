class Solution {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (!isValid(i, j, board))
                    return false;
            }
        }

        return true;
    }

    private boolean isValid(int row, int col, char[][] board) {

        if (board[row][col] == '.')
            return true;

        for (int i = 0; i < 9; i++) {

            if (col != i && board[row][i] == board[row][col])
                return false;

            if (row != i && board[i][col] == board[row][col])
                return false;

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (((r != row) || (c != col)) &&
                board[r][c] == board[row][col])
                return false;
        }

        return true;
    }
}












// class Solution {

//     public boolean isValidSudoku(char[][] board) {

//         Set<Character>[] rows = new HashSet[9];
//         Set<Character>[] cols = new HashSet[9];
//         Set<Character>[] boxes = new HashSet[9];

//         for (int i = 0; i < 9; i++) {
//             rows[i] = new HashSet<>();
//             cols[i] = new HashSet<>();
//             boxes[i] = new HashSet<>();
//         }

//         for (int row = 0; row < 9; row++) {

//             for (int col = 0; col < 9; col++) {

//                 char current = board[row][col];

//                 if (current == '.')
//                     continue;

//                 int box = (row / 3) * 3 + (col / 3);

//                 if (rows[row].contains(current))
//                     return false;

//                 if (cols[col].contains(current))
//                     return false;

//                 if (boxes[box].contains(current))
//                     return false;

//                 rows[row].add(current);
//                 cols[col].add(current);
//                 boxes[box].add(current);
//             }
//         }

//         return true;
//     }
// }