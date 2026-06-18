import java.util.Scanner;

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
        System.out.println("\nSeat Status:");
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
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Flight Capacity: ");
        int capacity = sc.nextInt();

        Flight flight = new Flight(capacity);

        System.out.print("Enter Number of Passengers to Book: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sc.nextLine(); 

            System.out.print("\nEnter Passenger Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Passenger ID: ");
            int id = sc.nextInt();

            Passenger p = new Passenger(name, id);

            if (flight.bookSeat(p)) {
                System.out.println("Booking Successful for " + name);
            } else {
                System.out.println("Booking Failed (Duplicate ID or Flight Full)");
            }
        }

        flight.displaySeats();

        sc.close();
    }
}
