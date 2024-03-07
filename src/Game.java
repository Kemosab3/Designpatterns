import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character = new Character("Aragon");

        while (!(character.getCurrentState().equals("Master"))) {
            System.out.println("Character: " + character.getName() + ", Level: " + character.getCurrentState() + ", EXP: " + character.getExperiencePoints() + ", HP: " + character.getHealthPoints());
            System.out.println("Choose action: Train, Meditate, Fight");
            String action = scanner.nextLine();

            if ("Train".equalsIgnoreCase(action)) {
                character.train();
            } else if ("Meditate".equalsIgnoreCase(action)) {
                character.meditate();
            } else if ("Fight".equalsIgnoreCase(action)) {
                character.fight();
            } else {
                System.out.println("Invalid action.");
            }
        }

        scanner.close();
        System.out.println(character.getName() + " has reached the Master level. Game Over.");
    }
}
