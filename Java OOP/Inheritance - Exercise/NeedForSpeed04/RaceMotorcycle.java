package ExInheritance04;

public class RaceMotorcycle extends Motorcycle{
    final static double DEFAULT_FUEL_CONSUMPTION = 8;
    public RaceMotorcycle(double fuel, int housePower) {
        super(fuel, housePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
