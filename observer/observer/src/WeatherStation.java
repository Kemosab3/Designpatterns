import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private List<WeatherObserver> observers;
    private double temperature;
    private boolean running;
    private final double MAX_TEMPERATURE = 100.0;
    private final double MIN_TEMPERATURE = -50.0;

    public WeatherStation() {
        observers = new ArrayList<>();
        temperature = generateInitialTemperature();
        running = true;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(getRandomTimeInterval()); // Sleep for a random time interval
                updateTemperature();
                notifyObservers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double generateInitialTemperature() {
        return MIN_TEMPERATURE + (new Random().nextDouble() * (MAX_TEMPERATURE - MIN_TEMPERATURE));
    }

    private void updateTemperature() {
        // Simulate temperature change
        temperature += (Math.random() > 0.5) ? 1 : -1;
        if (temperature > MAX_TEMPERATURE) temperature = MAX_TEMPERATURE;
        if (temperature < MIN_TEMPERATURE) temperature = MIN_TEMPERATURE;
    }

    private int getRandomTimeInterval() {
        return (int) (Math.random() * 4000) + 1000; // Random time interval between 1 to 5 seconds
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void stopStation() {
        running = false;
    }
}
