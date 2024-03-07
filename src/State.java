public interface State {
    void train(Character character);
    void meditate(Character character);
    void fight(Character character);
    void levelUp(Character character);
    String getStateName();
}
