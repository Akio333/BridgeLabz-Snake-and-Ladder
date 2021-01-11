public class SnakeAndLadder {
    // Static Attributes
    public static final int IS_LADDER = 1;
    public static final int IS_SNAKE = 2;
    public static final String PLAYER = "Player ";

    // Attributes
    int startPosition;
    int currentPosition;
    int diceFace;
    int play;
    int counterP1;
    int counterP2;
    int player;

    // Constructer
    SnakeAndLadder(int sP, int cP, int dP, int p, int cp1, int cp2, int pno) {
        startPosition = sP;
        currentPosition = cP;
        diceFace = dP;
        play = p;
        counterP1 = cp1;
        counterP2 = cp2;
        player = pno;
    }

    public static void main(String[] args) throws Exception {
        // Welcome Message
        System.out.println("Welcome To Snake and Ladder Simulator .... ");
        System.out.println("******************************************\n");

        // Object of SnakeAndLadder
        // SnakeAndLadder(int startPosition, int currentPosition, int diceFace, int
        // play, int counteP1, int counterP2, int player)
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder(0, 0, 0, 0, 0, 0, 1);

        // Initial Positions
        System.out.println("Player 1 is Starting at: " + snakeAndLadder.startPosition);
        System.out.println("Player 2 is Starting at: " + snakeAndLadder.startPosition + "\n");

        // Main loop
        while (snakeAndLadder.currentPosition != 100) {
            if (snakeAndLadder.player == 1) {
                snakeAndLadder.playCheck(1);
            } else {
                snakeAndLadder.playCheck(2);
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
    void checkBoundaryPositions(int p) {
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
                System.out.println(PLAYER + p + ": Got Ladder");
                currentPosition += diceFace;
                checkBoundaryPositions(p);
                playCheck(p);
                break;
            case IS_SNAKE:
                System.out.println(PLAYER + p + ": Bitten by snake.");
                currentPosition -= diceFace;
                checkBoundaryPositions(p);
                switchPlayer();
                break;
            default:
                System.out.println(PLAYER + p + ": No play");
                switchPlayer();
                break;
        }
    }

    // Exit Game
    void exitGame(int p) {
        int count = p == 1 ? counterP1 : counterP2;
        System.out.println(PLAYER + p + " Won the game!. It took " + count + " Dice plays to win.");
        System.exit(0);
    }

    // Switch players
    void switchPlayer() {
        System.out.println("");
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
    }
}
