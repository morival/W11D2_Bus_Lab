import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;


    @Before
    public void setUp() {
        bus = new Bus("Ocean Terminal", 5);
        person = new Person();
        busStop = new BusStop("Pirlig");
        busStop.addPerson(person);

    }

    @Test
    public  void busStartsEmpty() {
        assertEquals(0, bus.countPassengers());
    }

    @Test
    public void canAddPassengers() {
        bus.addPassenger(person);
        assertEquals(1, bus.countPassengers());
    }

    @Test
    public void shouldNotAddPassengersIfNoSpace() {
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(5, bus.countPassengers());
    }

    @Test
    public void canRemovePassengers() {
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger();
        assertEquals(1, bus.countPassengers());
    }

    @Test
    public void cantRemovePassengers() {
        bus.removePassenger();
        assertEquals(0, bus.countPassengers());
    }

    @Test
    public void busCanTakePassengersFromBusStop() {
        bus.takePassengerFromQueue(busStop);
        assertEquals(1, bus.countPassengers());
        assertEquals(0, busStop.queueCount());
    }
}
