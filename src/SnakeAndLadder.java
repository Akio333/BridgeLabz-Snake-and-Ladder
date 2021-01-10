public class SnakeAndLadder {
    public static final int IS_LADDER = 1;
    public static final int IS_SNAKE = 2;

    // Variables
    int startPosition = 0;
    int currentPosition = 0;
    int diceFace = 0;
    int play = 0;
    int counterP1 = 0;
    int counterP2 = 0;
    int player = 1;

    public static void main(String[] args) throws Exception {
        // Welcome Message
        System.out.println("Welcome To Snake and Ladder Simulator .... ");
        System.out.println("************************************");

        // Object of SnakeAndLadder
        SnakeAndLadder sl = new SnakeAndLadder();

        // Initial Positions
        System.out.println("Player 1 is Starting at: " + sl.startPosition);
        System.out.println("Player 2 is Starting at: " + sl.startPosition);

        // Main loop
        while (sl.currentPosition != 100) {
            if (sl.player == 1) {
                sl.playCheck(1);
            } else {
                sl.playCheck(2);
            }
        }

    }

    // Dice face generation
    int diceGen() {
        return (int) ((Math.floor(Math.random() * 10) % 6) + 1);
    }

    // play generation
    int playGen() {
        return (int) ((Math.floor(Math.random() * 10) % 3));
    }

    // Check position is between 0 to 100
    void checkPosition(int p) {
        if (currentPosition == 100) {
            System.out.println("New Position of Player " + p + ": " + currentPosition);
            exitGame(p);
        } else if (currentPosition > 100) {
            currentPosition -= diceFace;
            System.out.println("Staying at same location.");
        } else if (currentPosition < 0) {
            currentPosition = startPosition;
            System.out.println("You came back to start.");
        } else {
            System.out.println("New Position of Player " + p + ": " + currentPosition);
        }
    }

    // Check the Snake, Ladder or no Play
    void playCheck(int p) {
        if (p == 1) {
            counterP1++;
        } else {
            counterP2++;
        }
        diceFace = diceGen();
        System.out.println("Current Dice Face for player " + p + ": " + diceFace);
        play = playGen();
        switch (play) {
            case IS_LADDER:
                currentPosition += diceFace;
                checkPosition(p);
                playCheck(p);
                break;
            case IS_SNAKE:
                currentPosition -= diceFace;
                checkPosition(p);
                checkPlayer();
                break;
            default:
                System.out.println("Player " + p + ": No play");
                checkPlayer();
                break;
        }
    }

    // Exit Game
    void exitGame(int p) {
        int count = p == 1 ? counterP1 : counterP2;
        System.out.println("Player " + p + " Won the game!. It took " + count + " Dice plays to win.");
        System.exit(0);
    }

    // Switch players
    void checkPlayer() {
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
    }
}
