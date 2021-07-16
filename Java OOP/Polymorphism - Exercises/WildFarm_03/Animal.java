package WildFarm_03;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
//        this.foodEaten = foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public void addFood(int foodEaten) {
        this.foodEaten += foodEaten;
    }

    abstract void makeSound();

    abstract void eat(Food food);


}
