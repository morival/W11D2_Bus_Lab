import java.util.ArrayList;

public class Bus {
    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<Person>();
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public void addPassenger(Person person) {
        if (this.capacity > countPassengers()) {
            this.passengers.add(person);
        }
    }

    public void removePassenger() {
        if (countPassengers()>0) {
            this.passengers.remove(0);
        }
    }

    public void takePassengerFromQueue(BusStop busStop) {
        Person person = busStop.removePerson();
        addPassenger(person);
    }
}
