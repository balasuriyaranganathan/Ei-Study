public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        DisplayDevice display1 = new DisplayDevice();
        DisplayDevice display2 = new DisplayDevice();

        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        weatherStation.setTemperature(30);
    }
}
