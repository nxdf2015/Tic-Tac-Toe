package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter cells:");
        String cells = in.nextLine().strip();

        Grid grid = new Grid(cells);
        System.out.println(grid);
        System.out.println(grid.getStatus());

    }
}
