public class Intermediate implements State {
    @Override
    public void train(Character character) {
        character.addExperience(15);
        System.out.println(character.getName() + " trains and gains 15 experience points.");
        levelUp(character);
    }

    @Override
    public void meditate(Character character) {
        character.addHealth(10);
        System.out.println(character.getName() + " meditates and gains 10 health points.");
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " can't fight at the Intermediate level.");
    }

    @Override
    public void levelUp(Character character) {
        if (character.getExperiencePoints() >= 200) {
            character.setState(new Expert());
        }
    }

    @Override
    public String getStateName() {
        return "Intermediate";
    }
}
