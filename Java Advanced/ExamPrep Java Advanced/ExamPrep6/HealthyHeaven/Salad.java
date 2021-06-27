package ExamPrep6.HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;//???

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getTotalCalories(){
        int calories = this.products.stream().mapToInt(Vegetable::getCalories).sum();
        return calories;
    }

    public int getProductCount(){
        return this.products.size();
    }

    public void add(Vegetable product){
        this.products.add(product);
    }

    @Override
    public String toString(){
        StringBuilder fill = new StringBuilder();
        fill.append(String.format("* Salad %s is %d calories and have %d products:"
                ,this.getName(), this.getTotalCalories(), this.getProductCount())).append(System.lineSeparator());

        this.products.forEach(product -> fill.append(product.toString()).append(System.lineSeparator()));

        return fill.toString().trim();

    }
}
