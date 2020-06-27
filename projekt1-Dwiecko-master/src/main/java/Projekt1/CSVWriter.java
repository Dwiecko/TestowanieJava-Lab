package Projekt1;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class CSVWriter {
    public void AddRecord(String id, String email, String name, String surname, Date start_date, String room) {
        String date = Converters.convertDateToString(start_date);
        String seed = String.valueOf(System.currentTimeMillis());

        String text = id + ";" + email + ";" + name + ";" + surname + ";" + date + ";" + room + ";" + seed + ";";
        String csvFile = "dane.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            bw.append("\n" + text);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
