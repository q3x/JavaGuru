public class AiPlayer extends Player {
    public AiPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    int move() {
        int random = (int) (Math.random() * 7);
        System.out.println(getName() + " choice is " + (random + 1) + "\n");
        return random;
    }
}
