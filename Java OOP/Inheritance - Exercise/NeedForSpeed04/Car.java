package ExInheritance04;

public class Car extends Vehicle{
    final static double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int housePower) {
        super(fuel, housePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
