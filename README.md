# Rihani Rentals Management System

(February 2025)

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/)

A console-based Java application for managing a small vehicle rental / leasing inventory including vehicles, clients, and lease contracts. Supports CRUD operations on multiple vehicle subclasses (gas cars, electric cars, diesel trucks, electric trucks), client management, and lease lifecycle (issue / return). Includes utility operations (largest truck lookup, inventory copying) and a hard‑coded test harness.

## Key Features

- **Vehicle Inventory Management**
    - Add, update, delete, and list vehicles by subtype
    - Separate typed arrays plus unified registry
    - Automatic plate number generation per subtype (GC, EC, DT, ET prefixes)
- **Client Management**
    - Add, edit, delete, and list clients
    - Validation of selection indexes
- **Lease Management**
    - Create (issue) leases linking a client to an available vehicle
    - Return (terminate) existing leases and free the vehicle
    - Display all leased vehicles or vehicles leased by a specific client
- **Additional Operations**
    - Determine the truck with the largest weight capacity
    - Deep copy electric truck inventory (copy constructor demo)
- **Hard Test Harness** (`HardTest`)
    - Preloads sample data for all vehicle types
    - Demonstrates equality, largest truck, and copy features
- **Standardized Console UI**
    - Centralized menu + banner rendering for consistent formatting
- **Modular Class Design**
    - Separation of concerns between managers (VehicleManager, ClientManager, LeaseManager)

## Class Structure Overview

| Area | Classes | Responsibility |
|------|---------|----------------|
| Core Domain | `Vehicle`, `Car`, `GasCar`, `ElectricCar`, `Truck`, `DieselTruck`, `ElectricTruck` | Data models / inheritance hierarchy |
| Clients & Leases | `Client`, `Lease` | Client records and client–vehicle contract |
| Management | `VehicleManager`, `ClientManager`, `LeaseManager` | CRUD and menu orchestration |
| UI / Driver | `RihaniVehicles` | Entry point & shared menu rendering helpers |
| Testing | `HardTest` | Pre-populated dataset & demonstration routines |

## Directory Layout

```
src/
  Driver/
    RihaniVehicles.java
  Client/
    Client.java
    Lease.java
  Vehicles/
    Vehicle.java
    Car.java
    GasCar.java
    ElectricCar.java
    Truck.java
    DieselTruck.java
    ElectricTruck.java
    Manager/
      VehicleManager.java
      ClientManager.java
      LeaseManager.java
      HardTest.java
```

## Getting Started

### Requirements

- Java 17 or higher (earlier versions may work but were not validated)
- Terminal or IDE (IntelliJ IDEA recommended)

### Build & Run

Compile all sources into a `bin` directory:
```bash
javac -d bin $(find src -name "*.java")
```
Run the application:
```bash
java -cp bin Driver.RihaniVehicles
```

### Main Menu Flow

1. Startup menu (Optionally run hard-coded scenario or go to main menu)
2. Main menu options:
    - Vehicle Management
    - Client Management
    - Lease Management
    - Additional Operations
    - Exit

### Sample Operations

Add a Gas Car (Vehicle Management → Add Vehicle → Gas Car):
```
Enter make: Toyota
Enter model: Camry
Enter year: 2023
Enter max passengers: 5
```
A new plate (e.g., GC1001) is automatically assigned.

Create a Lease (Lease Management → Lease a Vehicle):
1. Select a client index
2. Choose vehicle type
3. Select an available vehicle (not already leased)

Return a Lease (Lease Management → Return a Vehicle):
1. View leases listing
2. Enter lease number to terminate

### Hard Test Harness

From startup choose: `Hard-coded Scenario for testing`

Demonstrates:
- Populated mixed inventory
- `equals` comparisons across subclasses
- Retrieval of largest truck by weight capacity
- Deep copy of electric truck array

## Personal Practice Objectives

This project was intentionally designed as a hands-on exercise to practice core Object-Oriented Programming concepts in Java:

- **Inheritance**: A multi-level hierarchy (`Vehicle` → `Car` / `Truck` → concrete subclasses) emphasizing shared vs. specialized attributes.
- **Polymorphism**: Uniform handling of heterogeneous vehicle types through `Vehicle` references (e.g., listing, largest truck determination, update coordination) and overridden `toString()` methods.
- **Encapsulation**: Controlled access to fields via getters/setters; lease status modification through dedicated methods.
- **Copy Constructors**: Implemented across vehicle subclasses and leveraged in the deep copy of electric truck inventories.
- **Dynamic Dispatch & Type Checking**: Selective subtype-specific updates and capacity/range changes with safe `instanceof` branches.
- **Separation of Concerns**: Dedicated manager classes isolate UI/menu logic from domain models.

The code favors clarity and explicitness (manual array resizing, direct loops) to highlight these concepts without obscuring them behind advanced collections or frameworks. Future refactors (examples: introducing generics, collections, persistence) can build on this solid conceptual base.

---
Developed by Ahmed Gara Ali
