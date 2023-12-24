package homework;


public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Geller", "Monika", "Cook", "kl76jj@mail.com", "89876543111", 30000, 35);
        employees[1] = new Employee("Kolobkov", "Peter", "Analyst", "petr456@mail.com", "89624788145", 250000, 50);
        employees[2] = new Employee("Sadikova", "Elina", "Accountant", "saadghjkova@mail.com", "smirnova@mail.com", 250000, 20);
        employees[3] = new Employee("Naumova", "Diana", "Programmer", "din233@mail.com", "89178569123", 500000, 40);
        employees[4] = new Employee("Valishin", "Ravil", "Courier", "valvalr5@mail.com", "89781236985", 50000, 25);

        for (Employee employee : employees) {
            employee.printInfoAboutEmployee();
        }

        Park park = new Park("Moscow park");

        Park.Attraction attraction1 = park.new Attraction("Ferris wheel", "11.00 - 23.00", 150);
        Park.Attraction attraction2 = park.new Attraction("Roller coaster", "12.00 - 22.00", 350);

        attraction1.printAttractionInfo();
        attraction2.printAttractionInfo();
    }
}