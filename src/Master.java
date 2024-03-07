public class Master implements State {
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " has nothing more to learn in training.");
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " has reached the pinnacle of health.");
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " has no more challenges to fight.");
    }

    @Override
    public void levelUp(Character character) {
        // This should never be called as the game ends when Master level is reached.
    }

    @Override
    public String getStateName() {
        return "Master";
    }
}
