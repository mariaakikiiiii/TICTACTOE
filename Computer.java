import java.util.Random;

class Computer extends Player {
    private Random random = new Random();

    public Computer(String username, char symbol) {
        super(username, symbol);
    }

    @Override
    public void play() {
        System.out.println(getUsername() + " (Computer) is playing.");
    }

    public char randomXorO() {
        return Math.random() < 0.5 ? 'X' : 'O';
    }
}