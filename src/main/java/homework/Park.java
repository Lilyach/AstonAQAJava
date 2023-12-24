package homework;

public class Park {
    private String nameOfThePark;

    public Park(String nameOfThePark) {
        this.nameOfThePark = nameOfThePark;
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("Attraction: " + name + " Working hours: " + workingHours + " Price: " + price);
        }
    }
}
