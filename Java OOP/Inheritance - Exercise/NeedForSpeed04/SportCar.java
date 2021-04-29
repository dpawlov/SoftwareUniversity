package ExInheritance04;

public class SportCar extends Car{
    final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int housePower) {
        super(fuel, housePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
