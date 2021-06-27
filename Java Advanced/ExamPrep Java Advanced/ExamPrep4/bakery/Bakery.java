package ExamPrep4.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employeeList;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employeeList = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employeeList.size() < this.capacity) {
            this.employeeList.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int max = Integer.MIN_VALUE;
        Employee oldestEmployee = null;
        for (Employee employee : employeeList) {
            if(employee.getAge() > max){
                max = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employeeList.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:",this.name));
        sb.append(System.lineSeparator());
        for (Employee employee : employeeList) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
