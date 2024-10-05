package TicTacToe;

import java.util.Scanner;

public class tictactoe {
  private Player player1, player2;
  private Board board;
  private int numplayer;

  public static void main(String[] args) {
    tictactoe t = new tictactoe();
    t.startGame();
  }

  public void startGame() {
    Scanner sc = new Scanner(System.in);
    // players input
    player1 = takePlayerInput(++numplayer);
    player2 = takePlayerInput(++numplayer);
    while (player1.getsymbol() == player2.getsymbol()) {
      System.out.println("This symbol is already taken please choose another symbol");
      player2.setsymbol(sc.nextLine().charAt(0));
    }

    // Board game
    board = new Board(player1.getsymbol(), player2.getsymbol());

    boolean player1Turn = true;
    int status = Board.INCOMPLETE;
    while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
      if (player1Turn == true) {
        System.out.println("Player 1- " + player1.getname() + "'s turn");
        System.out.println("enter x: ");
        int x = sc.nextInt();
        System.out.println("enter y: ");
        int y = sc.nextInt();

        status = board.move(player1.getsymbol(), x, y);
        if (status == Board.INVALIDMOVE) {
          System.out.println("Invalid move !! " + player1.getname() + "please try again !!: ");
          continue;
        }

      } else {
        System.out.println("Player 2- " + player2.getname() + "'s turn");
        System.out.println("enter x: ");
        int x = sc.nextInt();
        System.out.println("enter y: ");
        int y = sc.nextInt();

        status = board.move(player2.getsymbol(), x, y);
        if (status == Board.INVALIDMOVE) {
          System.err.println("Invalid move !! " + player2.getname() + " please try again !!: ");
          continue;
        }

      }
      player1Turn = !player1Turn;
      board.Print();
    }

    if (status == Board.PLAYER1WINS) {
      System.out.println("player1- " + player1.getname() + " wins !!");
    } else if (status == Board.PLAYER2WINS) {
      System.out.println("player2- " + player2.getname() + " wins !!");
    } else {
      System.out.println("Draw !!");
    }
    // sc.close();

  }

  public Player takePlayerInput(int num) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter player " + num + " name");
    String name = sc.nextLine();
    System.out.println("Enter player " + num + " symbol");
    char symbol = sc.nextLine().charAt(0);
    Player p = new Player(name, symbol);
    // sc.close();
    return p;
  }

}
