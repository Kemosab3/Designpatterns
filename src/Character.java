public class Character {
    private String name;
    private State state;
    private int experiencePoints;
    private int healthPoints;

    public Character(String name) {
        this.name = name;
        this.state = new Novice();
        this.experiencePoints = 0;
        this.healthPoints = 100;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addExperience(int points) {
        this.experiencePoints += points;
    }

    public void addHealth(int points) {
        this.healthPoints += points;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getCurrentState() {
        return state.getStateName();
    }

    // delegate methods to state
    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }
}
