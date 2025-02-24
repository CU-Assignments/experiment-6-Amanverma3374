import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters for name, age, and salary
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // Override toString() for easier printing
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }

    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("David", 28, 45000));

        // Sort by name using a lambda expression
        System.out.println("Sorted by name:");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);

        // Sort by age using a lambda expression
        System.out.println("\nSorted by age:");
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(System.out::println);

        // Sort by salary using a lambda expression
        System.out.println("\nSorted by salary:");
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employees.forEach(System.out::println);
    }
}
