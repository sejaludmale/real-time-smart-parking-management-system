
package project;

import java.util.*;
import java.text.SimpleDateFormat;

// ================= VEHICLE =================
abstract class Vehicle {
    String plate, type;

    Vehicle(String plate, String type) {
        this.plate = plate;
        this.type = type;
    }
}

class Car extends Vehicle {
    Car(String plate) {
        super(plate, "Car");
    }
}

class Bike extends Vehicle {
    Bike(String plate) {
        super(plate, "Bike");
    }
}

class Truck extends Vehicle {
    Truck(String plate) {
        super(plate, "Truck");
    }
}

// ================= TICKET =================
class Ticket {
    static int counter = 0;
    String number;
    Vehicle vehicle;
    int slot;
    long entryTime;
    String parkingDuration;

    Ticket(Vehicle v, int slot) {
        counter++;
        this.number = "TCK" + counter;
        this.vehicle = v;
        this.slot = slot;
        this.entryTime = System.currentTimeMillis();
        this.parkingDuration = "Not yet removed";
    }

    public String getFormattedDuration(long ms) {
        long seconds = ms / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        seconds %= 60;
        minutes %= 60;
        return hours + "h " + minutes + "m " + seconds + "s";
    }
}

// ================= PARKING LOT =================
class ParkingLot {
    int carSlots, bikeSlots, truckSlots;

    Map<String, Ticket> tickets = new HashMap<>();
    ArrayList<Integer> carOccupied = new ArrayList<>();
    ArrayList<Integer> bikeOccupied = new ArrayList<>();
    ArrayList<Integer> truckOccupied = new ArrayList<>();

    ParkingLot(int c, int b, int t) {
        carSlots = c;
        bikeSlots = b;
        truckSlots = t;
    }

    Ticket park(Vehicle v) {
        if (tickets.values().stream().anyMatch(t -> t.vehicle.plate.equals(v.plate))) {
            System.out.println("❌ Vehicle already parked!");
            return null;
        }

        int slot = findSlot(v.type);
        if (slot == -1) {
            System.out.println("❌ No slots available for " + v.type);
            return null;
        }

        Ticket ticket = new Ticket(v, slot);
        tickets.put(ticket.number, ticket);
        occupy(v.type, slot);

        System.out.println("✅ PARKED SUCCESSFULLY");
        System.out.println("🎫 Ticket: " + ticket.number + " | Slot: " + slot);

        return ticket;
    }

    void remove(String ticketNum) {
        Ticket t = tickets.remove(ticketNum);

        if (t == null) {
            System.out.println("❌ Invalid Ticket!");
            return;
        }

        long duration = System.currentTimeMillis() - t.entryTime;
        long hours = (duration / (1000 * 60 * 60)) + 1;

        double rate = switch (t.vehicle.type) {
            case "Car" -> 20;
            case "Bike" -> 10;
            default -> 50;
        };

        t.parkingDuration = t.getFormattedDuration(duration);
        free(t.vehicle.type, t.slot);

        System.out.println("🚪 VEHICLE REMOVED");
        System.out.println("Type     : " + t.vehicle.type);
        System.out.println("Duration : " + t.parkingDuration);
        System.out.println("Fee      : ₹" + (rate * hours));
    }

    int findSlot(String type) {
        int total = 0;
        ArrayList<Integer> occupied = null;

        switch (type) {
            case "Car" -> {
                total = carSlots;
                occupied = carOccupied;
            }
            case "Bike" -> {
                total = bikeSlots;
                occupied = bikeOccupied;
            }
            case "Truck" -> {
                total = truckSlots;
                occupied = truckOccupied;
            }
        }

        for (int i = 1; i <= total; i++) {
            if (!occupied.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    void occupy(String type, int slot) {
        switch (type) {
            case "Car" -> carOccupied.add(slot);
            case "Bike" -> bikeOccupied.add(slot);
            case "Truck" -> truckOccupied.add(slot);
        }
    }

    void free(String type, int slot) {
        switch (type) {
            case "Car" -> carOccupied.remove((Integer) slot);
            case "Bike" -> bikeOccupied.remove((Integer) slot);
            case "Truck" -> truckOccupied.remove((Integer) slot);
        }
    }

    void showTickets() {
        if (tickets.isEmpty()) {
            System.out.println("🚗 No vehicles parked.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-8s %-6s %-10s %-6s %-20s\n",
                "Ticket", "Type", "Plate", "Slot", "Entry Time");
        System.out.println("--------------------------------------------------------------");

        for (Ticket t : tickets.values()) {
            System.out.printf("%-8s %-6s %-10s %-6d %-20s\n",
                    t.number,
                    t.vehicle.type,
                    t.vehicle.plate,
                    t.slot,
                    sdf.format(new Date(t.entryTime)));
        }

        System.out.println("--------------------------------------------------------------");
    }

    void showSlots() {
        System.out.println("🚦 SLOT STATUS");
        System.out.println("--------------------------");
        System.out.println("🚗 Cars   : " + (carSlots - carOccupied.size()));
        System.out.println("🏍 Bikes  : " + (bikeSlots - bikeOccupied.size()));
        System.out.println("🚛 Trucks : " + (truckSlots - truckOccupied.size()));
    }
}

// ================= MAIN =================
public class SmartParkingSystem {

    static Scanner sc = new Scanner(System.in);

    static void line() {
        System.out.println("══════════════════════════════════════════════");
    }

    static void header() {
        line();
        System.out.println("🚗 SMART PARKING SYSTEM");
        line();
    }

    static void menu() {
        System.out.println("\n1️  Park Vehicle");
        System.out.println("2️  Remove Vehicle");
        System.out.println("3️  View Tickets");
        System.out.println("4️  View Slots");
        System.out.println("5️  Exit");
        System.out.print("\n👉 Enter Choice: ");
    }

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(5, 5, 2);

        while (true) {
            header();
            menu();

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    line();
                    System.out.println("🚘 PARK VEHICLE");
                    line();

                    System.out.print("Type (Car/Bike/Truck): ");
                    String type = sc.nextLine();

                    System.out.print("Plate Number: ");
                    String plate = sc.nextLine();

                    Vehicle v = switch (type.toLowerCase()) {
                        case "car" -> new Car(plate);
                        case "bike" -> new Bike(plate);
                        case "truck" -> new Truck(plate);
                        default -> null;
                    };

                    if (v != null) {
                        lot.park(v);
                    } else {
                        System.out.println("❌ Invalid type!");
                    }
                }

                case 2 -> {
                    line();
                    System.out.println(" REMOVE VEHICLE");
                    line();

                    System.out.print("Enter Ticket Number: ");
                    String ticket = sc.nextLine();
                    lot.remove(ticket);
                }

                case 3 -> {
                    line();
                    System.out.println(" ACTIVE TICKETS");
                    line();
                    lot.showTickets();
                }

                case 4 -> {
                    line();
                    System.out.println(" AVAILABLE SLOTS");
                    line();
                    lot.showSlots();
                }

                case 5 -> {
                    line();
                    System.out.println(" Thank you!");
                    line();
                    return;
                }

                default -> System.out.println("❗ Invalid choice!");
            }

            System.out.println("\n⏳ Press Enter to continue...");
            sc.nextLine();
        }
    }
}

