public class sudoku {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (solve(matrix)) {
            System.out.println("Solution reached. Now printing it out. ");
            System.out.println();
            print(matrix);
        } else {
            System.out.println("Solution cannot be reached. "); //error handling code for unsolvable sudoku puzzle;
        }
    }
    public static void print(int[][] matrix) {
        for (int[] i : matrix) {
            for (int f : i) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
    }
    public static int[] coordinates(int[][] matrix) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }
    public static boolean check(int[][] matrix, int num) {
        int[] arr = coordinates(matrix);
        int x = arr[0];
        int y = arr[1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[x][i] == num || matrix[i][y] == num) {
                return false;
            }
        }
        int startx = x - x % 3;
        int starty = y - y % 3;
        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 3; j++) {
                if (matrix[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solve(int[][] matrix) {
        int[] arr = coordinates(matrix);
        if (arr == null) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (check(matrix,i)) {
                matrix[arr[0]][arr[1]] = i;
                if (solve(matrix)) {
                    return true;
                }
                matrix[arr[0]][arr[1]] = 0;
            }
        }
        return false;
    }
}
