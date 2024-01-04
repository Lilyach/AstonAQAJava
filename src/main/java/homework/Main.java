package homework;


public class Main {
    public static void main(String[] args) {

        AppData data = new AppData();

        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] dataValues = {{500, 200, 123}, {300, 400, 500}};
        data.setHeader(header);
        data.setData(dataValues);

        data.saveData("data.csv");

        AppData loadedData = new AppData();
        loadedData.loadData("data.csv");

        System.out.println("Loaded Header:");
        for (String column : loadedData.getHeader()) {
            System.out.print(column + "; ");
        }
        System.out.println();

        System.out.println("Loaded Data:");
        for (int[] row : loadedData.getData()) {
            for (int value : row) {
                System.out.print(value + "; ");
            }
            System.out.println();
        }
    }
}