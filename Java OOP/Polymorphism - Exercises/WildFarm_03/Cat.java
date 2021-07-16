package WildFarm_03;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        super.addFood(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(),
                this.getBreed(), decimalFormat.format(super.getAnimalWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}
