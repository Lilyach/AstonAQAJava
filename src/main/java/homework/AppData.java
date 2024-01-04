package homework;

import java.io.*;

public class AppData {
    private String[] header;
    private int[][] data;

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String[] getHeader() {
        return header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void saveData(String filename) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < header.length - 1; i++) {
                bufferedWriter.write(header[i] + "; ");
            }
            bufferedWriter.write(header[header.length - 1] + "\n");
            for (int[] row : data) {
                for (int i = 0; i < row.length - 1; i++) {
                    bufferedWriter.write(row[i] + "; ");
                }
                bufferedWriter.write(row[row.length - 1] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    public void loadData(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String headerLine = bufferedReader.readLine();
            header = headerLine.split("; ");
            String line;
            int rowCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("; ");
                int colCount = values.length;
                if (data == null) {
                    data = new int[rowCount + 1][colCount];
                } else {
                    int[][] newData = new int[rowCount + 1][colCount];
                    System.arraycopy(data, 0, newData, 0, rowCount);
                    data = newData;
                }
                for (int i = 0; i < colCount; i++) {
                    data[rowCount][i] = Integer.parseInt(values[i]);
                }
                rowCount++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных из файла: " + e.getMessage());
        }
    }
}
