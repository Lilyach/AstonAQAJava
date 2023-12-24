package homework;

public class Employee {
    private String surname;
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String surname, String name, String position, String email, String phoneNumber, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfoAboutEmployee() {
        System.out.println("Employee: " + surname + " " + name + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);
    }
}
