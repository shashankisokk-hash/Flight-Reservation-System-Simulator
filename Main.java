class Passenger {
    private String name;
    private int id;

    public Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Flight {
    private final int MAX_SEATS;
    private Passenger[] seats;

    public Flight(int capacity) {
        this.MAX_SEATS = capacity;
        seats = new Passenger[MAX_SEATS];
    }

    public boolean bookSeat(Passenger p) {
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == p.getId()) {
                return false;
            }
        }

        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                return true;
            }
        }

        return false;
    }

    public void displaySeats() {
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                System.out.println("Seat " + (i + 1) + ": Empty");
            } else {
                System.out.println("Seat " + (i + 1) + ": " + seats[i].getName());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight(5);

        Passenger p1 = new Passenger("Aman", 1);
        Passenger p2 = new Passenger("Rahul", 2);
        Passenger p3 = new Passenger("Riya", 3);

        if (flight.bookSeat(p1)) {
            System.out.println("Passenger Aman booked successfully");
        } else {
            System.out.println("Booking failed for Aman");
        }

        if (flight.bookSeat(p2)) {
            System.out.println("Passenger Rahul booked successfully");
        } else {
            System.out.println("Booking failed for Rahul");
        }

        if (flight.bookSeat(p1)) {
            System.out.println("Passenger Aman booked successfully");
        } else {
            System.out.println("Duplicate booking not allowed for Aman");
        }

        flight.displaySeats();

        flight.bookSeat(new Passenger("User4", 4));
        flight.bookSeat(new Passenger("User5", 5));

        if (!flight.bookSeat(p3)) {
            System.out.println("Flight Full! Booking failed for Passenger: Riya");
        }
    }
}