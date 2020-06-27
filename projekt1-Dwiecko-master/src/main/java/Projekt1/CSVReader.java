package Projekt1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {

    public HashMap<String, List<String>> read() {
        String csvFile = "dane.csv";
        String line;
        final String SEPARATOR = ";";
        HashMap<String, List<String>> list = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            //br.readLine();
            while ((line = br.readLine()) != null) {
                String[] record = line.split(SEPARATOR);
                List<String> recordValues = new LinkedList<>();

                for (int i = 1; i < record.length; i++) {
                    recordValues.add(record[i]);
                }

                list.put(record[0], recordValues);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }
}