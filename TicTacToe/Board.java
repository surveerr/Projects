package TicTacToe;

public class Board {
    private char board[][];
    private char p1symbol;
    private char p2symbol;
    // size is size of board;
    private int size = 3;
    // count is no. of turns played;
    private int count;

    public static final char EMPTY = ' ';

    public static final int PLAYER1WINS = 1;
    public static final int PLAYER2WINS = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALIDMOVE = 5;

    Board(char p1symbol, char p2symbol) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
        this.p1symbol = p1symbol;
        this.p2symbol = p2symbol;
    }

    public int move(char symbol, int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size || board[x][y] != EMPTY) {
            return INVALIDMOVE;
        }
        board[x][y] = symbol;
        count++;

        // Row
        if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        // column
        if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        // left Diagonal
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        // right Diagonal
        if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        if (count == size * size) {
            return DRAW;
        }
        return INCOMPLETE;
    }

    public void Print() {
        System.out.println("--------------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("--------------------");
    }

}
