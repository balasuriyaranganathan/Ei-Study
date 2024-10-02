import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

class DisplayDevice implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Display shows temperature: " + temperature);
    }
}
