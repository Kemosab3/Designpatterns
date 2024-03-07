public class Novice implements State {
    @Override
    public void train(Character character) {
        character.addExperience(10);
        System.out.println(character.getName() + " trains and gains 10 experience points.");
        levelUp(character);
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " can't meditate at the Novice level.");
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " can't fight at the Novice level.");
    }

    @Override
    public void levelUp(Character character) {
        if (character.getExperiencePoints() >= 100) {
            character.setState(new Intermediate());
        }
    }

    @Override
    public String getStateName() {
        return "Novice";
    }
}
