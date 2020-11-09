package main.design;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
//    List<ParkingLevel> parkingLevels;
    Integer availableSpots;
    Integer occupiedSpots;





    public static void main(String[] args) {
        ParkingLot solution = new ParkingLot();
        System.out.println(solution.occupiedSpots);
    }

}


//class ParkingLevel {
//    Integer level;
//    List<ParkingSpot> availableParkingSpots;
//    List<ParkingSpot> occupiedParkingSpots;
//}

//class ParkingSpot {
//    VehicleSize size;
//    Integer location;
//    Boolean occupied;
//    Vehicle currentVehicle;
//}



// Vehicle and its inherited classes.
//enum VehicleSize { Motorcycle, Compact,Large }

//public abstract class Vehicle
//{
//    protected ArrayList<ParkingSpot> parkingSpots =
//            new ArrayList<ParkingSpot>();
//    protected String licensePlate;
//    protected int spotsNeeded;
//    protected VehicleSize size;
//
//    public int getSpotsNeeded()
//    {
//        return spotsNeeded;
//    }
//    public VehicleSize getSize()
//    {
//        return size;
//    }
//
//    /* Park vehicle in this spot (among others,
//       potentially) */
//    public void parkinSpot(ParkingSpot s)
//    {
//        parkingSpots.add(s);
//    }
//
//
//    /* Remove vehicle from spot, and notify spot
//       that it's gone */
//    public void clearSpots() { }
//
//    /* Checks if the spot is big enough for the
//       vehicle (and is available).
//       This * compares the SIZE only.It does not
//      check if it has enough spots. */
//    public abstract boolean canFitinSpot(ParkingSpot spot);
//}

//class Bus extends Vehicle
//{
//    public Bus()
//    {
//        spotsNeeded = 5;
//        size = VehicleSize.Large;
//    }
//
//    /* Checks if the spot is a Large. Doesn't check
//     num of spots */
//    public boolean canFitinSpot(ParkingSpot spot)
//    {
//        return spot.size == VehicleSize.Large;
//    }
//}
//
//class Car extends Vehicle
//{
//    public Car()
//    {
//        spotsNeeded = 1;
//        size = VehicleSize.Compact;
//    }
//
//    /* Checks if the spot is a Compact or a Large. */
//    public boolean canFitinSpot(ParkingSpot spot)
//    { return spot.size == VehicleSize.Large|| spot.size == VehicleSize.Compact; }
//}
//
//class Motorcycle extends Vehicle
//{
//    public Motorcycle()
//    {
//        spotsNeeded = 1;
//        size = VehicleSize.Motorcycle;
//    }
//    public boolean canFitinSpot(ParkingSpot spot)
//    { return true; }
//}

