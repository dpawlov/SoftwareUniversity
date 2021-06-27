package ExamPrep5.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        if (!data.isEmpty()) {
            for (Pet p : data) {
                if (p.getName().equals(name)) {
                    int index = data.indexOf(p);
                    data.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        if (!data.isEmpty()){
            for (Pet p: data) {
                if (p.getName().equals(name) && p.getOwner().equals(owner)){
                    return p;
                }
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        int maxAge = Integer.MIN_VALUE;

        for (Pet pet : data) {
            if(pet.getAge() > maxAge) {
                maxAge = pet.getAge();
            }
        }
        for (Pet pet : data) {
            if(pet.getAge() == maxAge) {
                return pet;
            }
        }
        return null;
    }


    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet p: data) {
            sb.append(p.getName()).append(" ").append(p.getOwner()).append(System.lineSeparator());
        }
        //returns a String in the following format:
        //o "The clinic has the following patients:
        //{name} {owner}
        //{name} {owner}
        //   (…)"

        return sb.toString();
    }
}


