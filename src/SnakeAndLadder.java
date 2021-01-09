public class SnakeAndLadder {
    public static void main(String[] args) throws Exception {
        // Welcome Message
        System.out.println("Welcome To Snake and Ladder Simulator .... ");
        System.out.println("************************************");

        // Variables
        int startPosition = 0;
        int currentPosition = 0;

        // Computation
        System.out.println("Player is Starting at: " + startPosition);
        int diceFace = (int) ((Math.floor(Math.random() * 10) % 6) + 1);
        System.out.println("Current Dice Face: " + diceFace);

    }
}
