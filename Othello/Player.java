package Othello;

public class Player {
    private String name;
    final static int player1symbol = 1;
    final static int player2symbol = 2;

    Player(String name) {
        setname(name);
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }
}
