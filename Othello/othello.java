package Othello;

import java.util.Scanner;

public class othello {
    private Player player1, player2;
    final static int player1symbol = 1;
    final static int player2symbol = 2;
    // private Board board;
    private int numplayer;

    public static void main(String[] args) {
        Board O = new Board();
        Scanner sc = new Scanner(System.in);
        boolean player1Turn = true;

        int x = sc.nextInt();
        int y = sc.nextInt();
        boolean ans = false;
        if (player1Turn) {
            ans = O.move(player1symbol, x, y);
        } else {
            ans = O.move(player2symbol, x, y);
        }

        if (ans) {
            O.Print();
            player1Turn = !player1Turn;
        }

    }

}
