package VehiclesExtension_02;

import java.text.DecimalFormat;

public class Car extends Vehicles implements Drivable {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, 0.9);
    }
}