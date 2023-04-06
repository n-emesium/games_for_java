import java.util.Scanner;
public class xox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[3][3];
        int wins = 0;
        int losses = 0;
        int draws = 0;
        while (true) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print(grid[i][j] + ", ");
                }
                System.out.println();
            }
            // start method
            if (start() == 0) {
                //player starts
                System.out.println("You go first! ");
                char player_input = 'x';
                char bot_input = 'o';
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        System.out.print(grid[i][j] + ", ");
                    }
                    System.out.println();
                }
                System.out.println("Choose where to put your element in the grid. Specify the row. ");
                int row = sc.nextInt();
                sc.nextLine();
                System.out.println("Now choose the column. ");
                int col = sc.nextInt();
                sc.nextLine();
                grid[row-1][col-1] = player_input;
                int[] bot_in = bot_randomize(grid);
                grid[bot_in[0]][bot_in[1]] = bot_input;
                //inputs are placed
                if (check(grid) == 1) {
                    wins++;
                    System.out.println("Congrats! You have won! Want to play again? ");
                    String cont = sc.nextLine().toLowerCase();
                    if (cont.equals("yes")) {
                        System.out.println("Understood continuing. ");
                    } else {
                        System.out.println("Understood, qutting. ");
                        break;
                    }
                } else if(check(grid) == -1) {
                    losses++;
                    System.out.println("Aw! You have lost! Want to play again? ");
                    String cont = sc.nextLine().toLowerCase();
                    if (cont.equals("yes")) {
                        System.out.println("Understood continuing. ");
                    } else {
                        System.out.println("Understood, qutting. ");
                        break;
                    }
                } else {
                    draws++;
                    System.out.println("It's a draw! Want to play again? ");
                    String cont = sc.nextLine().toLowerCase();
                    if (cont.equals("yes")) {
                        System.out.println("Understood continuing. ");
                    } else {
                        System.out.println("Understood, qutting. ");
                        break;
                    }
                }
            } else {
                //bot starts
                System.out.println("The bot goes first! ");
                char bot_input = 'o';
                int[] bot_in = bot_randomize(grid);
                grid[bot_in[0]][bot_in[1]] = bot_input;
                System.out.println("Now you can make your move! ");
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        System.out.print(grid[i][j] + ", ");
                    }
                    System.out.println();
                }
                System.out.println("Choose where to put your element in the grid. Specify the row. ");
                int row = sc.nextInt();
                sc.nextLine();
                System.out.println("Now choose the column. ");
                int col = sc.nextInt();
                sc.nextLine();
                grid[row-1][col-1] = 'x';
                if (check(grid) == 1) {
                    wins++;
                    System.out.println("Congrats! You have won! Want to play again? ");
                    String cont = sc.nextLine().toLowerCase();
                    if (cont.equals("yes")) {
                        System.out.println("Understood continuing. ");
                    } else {
                        System.out.println("Understood, qutting. ");
                        break;
                    }
                } else if(check(grid) == -1) {
                    losses++;
                    System.out.println("Aw! You have lost! Want to play again? ");
                    String cont = sc.nextLine().toLowerCase();
                    if (cont.equals("yes")) {
                        System.out.println("Understood continuing. ");
                    } else {
                        System.out.println("Understood, qutting. ");
                        break;
                    }
                } else {
                    draws++;
                    System.out.println("It's a draw! Want to play again? ");
                    String cont = sc.nextLine().toLowerCase();
                    if (cont.equals("yes")) {
                        System.out.println("Understood continuing. ");
                    } else {
                        System.out.println("Understood, qutting. ");
                        break;
                    }
                }
            }
        }
        System.out.println("Your wins are: " + wins);
        System.out.println("Your losses are: " + losses);
        System.out.println("Your draws are: " + draws);
    }
    public static int start() {
        int val = (int) (Math.random() * 2);
        return val;
    }
    public static int[] bot_randomize(char[][] twod) {
        int random = twod.length;
        int val_1 = (int) (Math.random() * random);
        int val_2 = (int) (Math.random() * random);
        int[] bot_val = new int[2];
        bot_val[0] = val_1;
        bot_val[1] = val_2;
        return bot_val;
    }
    public static int check(char[][] arr) {
        //check for rows
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] != ' ' && arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]) {
                if (arr[i][0] == 'x') {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        //check for columns
        for (int j = 0; j < arr[j].length; j++) {
            if (arr[0][j] != ' ' && arr[0][j] == arr[0][j + 1] && arr[0][j] == arr[0][j + 2]) {
                if (arr[0][j] == 'x') {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        //check diagonally
        if (arr[0][0] != ' ' && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] || arr[0][2] != ' ' && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]) {
            if (arr[0][0] == 'x') {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
        //1 means player has won
        //-1 means player has lost
        //0 means draw
    }
}
