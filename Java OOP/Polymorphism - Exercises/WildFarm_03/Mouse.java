package WildFarm_03;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight,  String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass() != Vegetable.class) {
            System.out.println("Mice are not eating that type of food!");
            return;
        }

        super.addFood(food.getQuantity());
    }
}
