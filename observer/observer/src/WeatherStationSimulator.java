public class WeatherStationSimulator {
    public static void runSimulation() {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.start();

        // Create and register observers
        DisplayPanel panel1 = new DisplayPanel("1");
        DisplayPanel panel2 = new DisplayPanel("2");

        weatherStation.addObserver(panel1);
        weatherStation.addObserver(panel2);

        try {
            // Let the simulation run for a certain period
            Thread.sleep(10000);

            // Remove one observer
            weatherStation.removeObserver(panel1);
            System.out.println("Observer 1 removed.");

            // Let the simulation continue for a bit longer
            Thread.sleep(10000);

            // Stop the weather station
            weatherStation.stopStation();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
