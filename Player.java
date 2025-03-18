abstract class Player {
    private String username;
    private char symbol;

    public Player(String username, char symbol) {
        this.username = username;
        this.symbol = symbol;
    }

    public String getUsername() {
        return username;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void play();
}
