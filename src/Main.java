import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        Scanner scanner = new Scanner(System.in);
        Character character = new Character("Aragon");

        while (!(character.getCurrentState().equals("Master"))) {
            System.out.println("Character: " + character.getName() + ", Level: " + character.getCurrentState() + ", EXP: " + character.getExperiencePoints() + ", HP: " + character.getHealthPoints());
            System.out.println("Available actions: Train, Meditate, Fight");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    if (character.getCurrentState().equals("Expert")) {
                        character.fight();
                    } else {
                        System.out.println("Fighting is not available at your current level.");
                    }
                    break;
                default:
                    System.out.println("Invalid action. Please choose Train, Meditate, or Fight.");
                    break;
            }
        }

        System.out.println(character.getName() + " has reached the Master level. Congratulations! Game Over.");
        scanner.close();
    }
}
