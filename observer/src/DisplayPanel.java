public class DisplayPanel implements WeatherObserver {
    private String name;

    public DisplayPanel(String name) {
        this.name = name;
    }

    @Override
    public void update(double temperature) {
        System.out.println("Display Panel " + name + ": Temperature is " + temperature);
    }
}
