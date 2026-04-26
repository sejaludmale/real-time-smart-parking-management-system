## 🚗 Smart Parking Management System with Real-Time Slot Tracking

This project is a console-based Smart Parking Management System developed using Java and Object-Oriented Programming principles. It efficiently manages vehicle parking operations by providing real-time slot tracking, automated ticket generation, and billing based on parking duration.

The system supports multiple vehicle types (Car, Bike, Truck) and ensures optimized slot allocation while preventing duplicate vehicle entries. It also maintains active parking records and provides a user-friendly interface for managing parking activities.

###  Key Features
- Real-time parking slot availability tracking
- Automated ticket generation with unique IDs
- Vehicle entry and exit management
- Parking duration calculation
- Fee calculation based on vehicle type
- Prevention of duplicate vehicle parking
- Organized display of active tickets and slot status

###  Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Collections Framework (HashMap, ArrayList)

###  How to Run

javac SmartParkingSystem.java
java SmartParkingSystem

### Output
```txt
══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 1
══════════════════════════════════════════════
🚘 PARK VEHICLE
══════════════════════════════════════════════
Type (Car/Bike/Truck): Car
Plate Number: MH12AB1234
✅ PARKED SUCCESSFULLY
🎫 Ticket: TCK1 | Slot: 1

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 1
══════════════════════════════════════════════
🚘 PARK VEHICLE
══════════════════════════════════════════════
Type (Car/Bike/Truck): Bike
Plate Number: MH01XY9999
✅ PARKED SUCCESSFULLY
🎫 Ticket: TCK2 | Slot: 1

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 1
══════════════════════════════════════════════
🚘 PARK VEHICLE
══════════════════════════════════════════════
Type (Car/Bike/Truck): Truck
Plate Number: MH20TR5678
✅ PARKED SUCCESSFULLY
🎫 Ticket: TCK3 | Slot: 1

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 3
══════════════════════════════════════════════
 ACTIVE TICKETS
══════════════════════════════════════════════
--------------------------------------------------------------
Ticket   Type   Plate      Slot   Entry Time          
--------------------------------------------------------------
TCK3     Truck  MH20TR5678 1      08:05:40 pm         
TCK2     Bike   MH01XY9999 1      08:05:22 pm         
TCK1     Car    MH12AB1234 1      08:05:03 pm         
--------------------------------------------------------------

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 4
══════════════════════════════════════════════
 AVAILABLE SLOTS
══════════════════════════════════════════════
🚦 SLOT STATUS
--------------------------
🚗 Cars   : 4
🏍 Bikes  : 4
🚛 Trucks : 1

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 2
══════════════════════════════════════════════
 REMOVE VEHICLE
══════════════════════════════════════════════
Enter Ticket Number: TCK3
🚪 VEHICLE REMOVED
Type     : Truck
Duration : 0h 0m 35s
Fee      : ₹50.0

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 3
══════════════════════════════════════════════
 ACTIVE TICKETS
══════════════════════════════════════════════
--------------------------------------------------------------
Ticket   Type   Plate      Slot   Entry Time          
--------------------------------------------------------------
TCK2     Bike   MH01XY9999 1      08:05:22 pm         
TCK1     Car    MH12AB1234 1      08:05:03 pm         
--------------------------------------------------------------

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 4
══════════════════════════════════════════════
 AVAILABLE SLOTS
══════════════════════════════════════════════
🚦 SLOT STATUS
--------------------------
🚗 Cars   : 4
🏍 Bikes  : 4
🚛 Trucks : 2

⏳ Press Enter to continue...

══════════════════════════════════════════════
🚗 SMART PARKING SYSTEM
══════════════════════════════════════════════

1️  Park Vehicle
2️  Remove Vehicle
3️  View Tickets
4️  View Slots
5️  Exit

👉 Enter Choice: 5
══════════════════════════════════════════════
 Thank you!
══════════════════════════════════════════════


###  Use Case
This system can be used in parking lots, malls, offices, and residential complexes to automate and streamline parking operations.
