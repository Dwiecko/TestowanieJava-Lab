package Projekt1;

import java.util.Scanner;
import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
        CSVReader csv = new CSVReader();
        HashMap<String, List<String>> list = csv.read();
        MapOperations map = new MapOperations(list);
        CSVWriter csvWriter = new CSVWriter();
        String seed;

        char character = ' ';
        Scanner in = new Scanner(System.in);
        System.out.println("A - Add new Record S - Show User Reservations q - quit");
        character = in.next().charAt(0);

        switch (character) {
            case 'A': {
                in.nextLine();
                System.out.println("Adding new reservation.");
                seed = String.valueOf(System.currentTimeMillis());
                System.out.println("Email:");
                String email = in.nextLine();
                System.out.println("Username:");
                String username = in.nextLine();
                System.out.println("Surname:");
                String surname = in.nextLine();
                System.out.println("Date (Format YYYY-MM-DD HH:MM) ");
                String date = in.nextLine();
                System.out.println("Room: ");
                String room = in.nextLine();
                System.out.println("Given: ");
                System.out.print(seed + ";" + email + ";" + username + ";" + surname + ";" + date + ";" + room + "; \n");

                Date newDate = Converters.StringToDate(date);
                boolean addedRecord = false;
                try {
                    addedRecord = map.AddNewRecord(seed, email, username, surname, newDate, room);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (addedRecord) {
                    csvWriter.AddRecord(seed, email, username, surname, newDate, room);
                    System.out.println("Reservation is added successfully.");
                } else System.out.println("There was a problem with data. Please check fields.");
                break;
            }
            case 'S': {
                System.out.println("Show database option => Please type user email.");
                String text = in.next();
                map.PrintUsersReservations(text);
                break;
            }
            default: {
                System.out.println("Unknown Option.");
                break;
            }
        }
        in.close();
    }
}
