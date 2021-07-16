package Vehicles_01;

public abstract class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    protected abstract String drive(double distance);

    protected abstract void refuel(double litres);

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
