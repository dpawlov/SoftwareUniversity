package WildFarm_03;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);

    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass() != Meat.class) {
            System.out.println("Tigers are not eating that type of food!");
            return;
        }

        super.addFood(food.getQuantity());
    }
}
