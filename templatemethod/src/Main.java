public class Main {
    public static void main(String[] args) {
        Game game = new Ristinolla();
        game.play(2); // Ristinolla is a 2-player game
        if (game instanceof Ristinolla) {
            ((Ristinolla) game).closeScanner(); // Properly close the scanner
        }
    }
}
