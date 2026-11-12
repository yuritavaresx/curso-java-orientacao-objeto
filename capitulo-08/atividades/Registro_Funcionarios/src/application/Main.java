package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++){
            System.out.println("Emplyoee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            employees.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase : ");
        int idEmployee = sc.nextInt();
        Employee found = null;
        for (Employee e : employees){
            if (e.getId().equals(idEmployee)){
                found = e;
            }
        }

        if (found != null){
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            found.increaseSalary(percentage);
        }
        else {
            System.out.println("This id does not exist!");
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : employees){
            System.out.println(e);
        }







        sc.close();
    }
}
