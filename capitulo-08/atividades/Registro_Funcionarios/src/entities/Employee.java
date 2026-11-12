package entities;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee(int id, String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }


    public void increaseSalary(double percentage){
        salary += (salary * percentage) / 100.0;
    }

    public String toString(){
        return id + ", "
                + name
                + ", "
                + String.format("%.2f", salary);
    }

}
