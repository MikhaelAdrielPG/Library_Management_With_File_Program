package model;

import java.io.*;

public class FileManager {
    // Fungsi untuk menyimpan data ke dalam file
    public static void saveToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data); // Menulis data ke dalam file
        } catch (IOException e) {
            System.out.println("Error while saving data to file: " + e.getMessage());
        }
    }

    // Fungsi untuk membaca data dari file
    public static String loadFromFile(String filename) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n"); // Membaca setiap baris dan menambahkannya ke StringBuilder
            }
        } catch (IOException e) {
            System.out.println("Error while loading data from file: " + e.getMessage());
        }
        return data.toString();
    }
}
