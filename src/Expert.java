public class Expert implements State {
    @Override
    public void train(Character character) {
        character.addExperience(20);
        System.out.println(character.getName() + " trains hard and gains 20 experience points.");
        levelUp(character);
    }

    @Override
    public void meditate(Character character) {
        character.addHealth(5);
        System.out.println(character.getName() + " meditates to restore 5 health points.");
    }

    @Override
    public void fight(Character character) {
        if (character.getHealthPoints() > 10) {
            character.addExperience(30);
            character.addHealth(-10);
            System.out.println(character.getName() + " fights bravely and gains 30 experience points but loses 10 health points.");
        } else {
            System.out.println(character.getName() + " is too weak to fight.");
        }
        levelUp(character);
    }

    @Override
    public void levelUp(Character character) {
        if (character.getExperiencePoints() >= 500) {
            character.setState(new Master());
        }
    }

    @Override
    public String getStateName() {
        return "Expert";
    }
}
