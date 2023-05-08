import java.util.Scanner;

public class grid_randomize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many rows you want. ");
        int row = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter how many columns you want. ");
        int col = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter primary character. ");
        String c = sc.nextLine();
        System.out.println("Enter odd character. ");
        String odd_c = sc.nextLine();
        String[][] grid = new String[row][col];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = c;
            }
        }
        int[] coordinates = new int[2];
        coordinates[0] = (int) (Math.random() * row);
        coordinates[1] = (int) (Math.random() * col);
        grid[coordinates[0]][coordinates[1]] = odd_c;
        for (String[] s : grid) {
            for (String j : s) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("You have 10 seconds to enter the row and column of the odd character, start! Row first!");
        long startTime = System.currentTimeMillis();
        int m = -1, n = -1;
        while ((System.currentTimeMillis() - startTime) < 10000 && (m == -1 || n == -1)) {
            if (sc.hasNextInt()) {
                if (m == -1) {
                    m = sc.nextInt();
                    System.out.println("Alright! Now column! ");
                } else {
                    n = sc.nextInt();
                }
            } else {
                sc.nextLine();
            }
        }
        if (grid[m][n].equals(odd_c)) {
            System.out.println("Congrats! You have won! ");
        } else {
            System.out.println("Tough luck, wrong answer. ");
        }

        System.out.println();
        System.out.println("Want to receive coordinates for where the odd characters was? ");
        String cont = sc.nextLine();
        if (cont.toLowerCase().equals("yes")) {
            for (int i : coordinates(grid,odd_c)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void works(String[][] arr, String m) {
        for (String[] s : arr) {
            for (String j : s) {
                if (j.equals(m)) {
                    System.out.println("Method works! ");
                    return;
                }
            }
        }
        System.out.println("Doesn't work! ");
    }

    public static int[] coordinates(String[][] arr, String m) {
        int[] val = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(m)) {
                    val[0] = i;
                    val[1] = j;
                    return val;
                }
            }
        }
        return val;
    }
}
