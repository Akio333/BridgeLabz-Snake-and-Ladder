public class SnakeAndLadder {
    public static final int IS_LADDER = 1;
    public static final int IS_SNAKE = 2;

    public static void main(String[] args) throws Exception {
        // Welcome Message
        System.out.println("Welcome To Snake and Ladder Simulator .... ");
        System.out.println("************************************");

        // Variables
        int startPosition = 0;
        int currentPosition = 0;
        int diceFace;
        int play;
        int counter = 0;

        // Computation
        System.out.println("Player is Starting at: " + startPosition);

        while (currentPosition != 100) {
            counter++;
            diceFace = (int) ((Math.floor(Math.random() * 10) % 6) + 1);
            System.out.println("Current Dice Face: " + diceFace);
            play = (int) ((Math.floor(Math.random() * 10) % 3));
            switch (play) {
                case IS_LADDER:
                    currentPosition += diceFace;
                    break;
                case IS_SNAKE:
                    currentPosition -= diceFace;
                    break;
                default:
                    break;
            }
            if (currentPosition == 100) {
                System.out.println("New Position: " + currentPosition);
                break;
            } else if (currentPosition > 100) {
                currentPosition -= diceFace;
                System.out.println("Staying at same location.");
            } else if (currentPosition < 0) {
                currentPosition = startPosition;
                System.out.println("You came back to start.");
            } else {
                System.out.println("New Position: " + currentPosition);
            }
        }
        System.out.println("Congratulations! You Won. You have taken total " + counter + " plays of dice to Win.");
    }
}
