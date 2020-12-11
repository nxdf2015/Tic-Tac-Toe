package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter cells:");
        String cells = "_".repeat(9);
        Grid grid = new Grid(cells);
        System.out.println(grid);
        String player = "X";
        boolean gameOver = false;
        while(!gameOver) {

                while(true) {
                    int row, col;
                    while (true) {
                        System.out.println("Enter the coordinates:");
                        try {
                            col = in.nextInt();
                            row = in.nextInt();
                            if (grid.isValidPosition(row, col)) {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("You should enter numbers!");
                        }

                    }

                    if (!grid.cellIsEmpty(row, col)) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        grid.play(row, col, player);

                        break;
                    }
                }

                System.out.println(grid);
                System.out.println(grid.getStatus());
                gameOver = grid.finish() || grid.drawn() || grid.win(player);
                player = player.equals("X") ? "O" : "X";
            }

        }
}

