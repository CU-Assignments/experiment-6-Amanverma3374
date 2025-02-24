import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getter for name and marks
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + ": " + marks + "%";
    }

    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 72),
                new Student("Charlie", 90),
                new Student("David", 78),
                new Student("Eva", 68)
        );

        // Use lambda expressions and streams to filter, sort, and display names
        System.out.println("Students scoring above 75%, sorted by marks:");

        students.stream()
                // Filter students with marks above 75
                .filter(student -> student.getMarks() > 75)
                // Sort students by marks in descending order
                .sorted((s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks()))
                // Map to get the student names
                .map(Student::getName)
                // Display the names
                .forEach(System.out::println);
    }
}
