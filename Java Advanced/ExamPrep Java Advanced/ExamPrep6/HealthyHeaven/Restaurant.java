package ExamPrep6.HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad){
        this.data.add(salad);
    }

    public boolean buy(String name){
        for (Salad salad : this.data ) {
            if(name.equals(salad.getName())){
                this.data.remove(salad);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad(){  // ????????
        int minCalories = Integer.MAX_VALUE;
        Salad healthy = null;

        for (Salad salad : this.data) {
            if(minCalories > salad.getTotalCalories()) {
                minCalories = salad.getTotalCalories();
                healthy = salad;
            }
        }
        return healthy;
    }

    public String generateMenu(){
        StringBuilder fill = new StringBuilder();

        fill.append(String.format("%s have %d salads:"
                , this.name, this.data.size())).append(System.lineSeparator());

        this.data.forEach(salad -> fill.append(salad.toString()).append(System.lineSeparator()));

        return fill.toString().trim();
    }

}
