public class AiPlayer extends Player {
    @Override
    int move() {
        int random = (int) (Math.random() * 7);
        System.out.println("Computer choice is " + (random + 1) + "\n");
        return random;
    }
}
