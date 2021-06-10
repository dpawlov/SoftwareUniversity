package SpeedRacing03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void drive(double distance) {
        double totalDistance = distance * this.fuelCost;
        if (totalDistance <= this.fuelAmount) {
            this.fuelAmount -= totalDistance;
            this.distanceTravelled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.getModel(), getFuelAmount(), getDistanceTravelled());
    }
}
