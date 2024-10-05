package Othello;

public class Board {
    private int board[][];
    final static int player1symbol = 1;
    final static int player2symbol = 2;
    private int boardSize = 8;
    private int count;

    // public static final char isEMPTY = ' ';

    public Board() {
        board = new int[8][8];
        board[3][3] = player1symbol;
        board[3][4] = player2symbol;
        board[4][3] = player2symbol;
        board[4][4] = player1symbol;

    }

    int[] xDir = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] yDir = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public boolean move(int symbol, int x, int y) {
        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != 0) {
            return false;
        }
        boolean movepossible = false;
        for (int i = 0; i < xDir.length; i++) {
            int xstep = xDir[i];
            int ystep = yDir[i];
            int currentX = x + xstep;
            int currentY = y + ystep;

            while (currentX > 0 || currentX < boardSize || currentY > 0 || currentY < boardSize) {
                if (board[currentX][currentY] == 0) {
                    break;
                } else if (board[currentX][currentY] != symbol) {
                    currentX += xstep;
                    currentY += ystep;
                    count++;
                } else {
                    if (count > 0) {
                        movepossible = true;
                        int convertX = currentX - xstep;
                        int convertY = currentY - ystep;
                        while (convertX != x || convertY != y) {
                            board[convertX][convertY] = symbol;
                            convertX = convertX - xstep;
                            convertY = convertY - ystep;
                        }
                    }
                    break;
                }

            }
        }
        if (movepossible) {
            board[x][y] = symbol;
        }
        return movepossible;
    }

    public void Print() {
        System.out.println("------------------------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
