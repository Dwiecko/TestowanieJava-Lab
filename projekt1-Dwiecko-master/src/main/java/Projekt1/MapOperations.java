package Projekt1;

import java.util.*;

import com.google.common.base.Strings;

public class MapOperations {
    private HashMap<String, List<String>> list;

    public MapOperations(HashMap<String, List<String>> database) {
        list = database;
    }

    public void PrintUsersReservations(String email) {
        HashSet<String> listOfKeys = getKeysForGivenTextInMap(email);
        if (listOfKeys.isEmpty()) throw new IllegalArgumentException("Searched key does not exist in database.");
        Iterator<String> iterator = listOfKeys.iterator();
        while (iterator.hasNext()) {
            System.out.println(list.get(iterator.next()));
        }
    }

    private HashSet<String> getKeysForGivenTextInMap(String text) {
        HashSet<String> listOfKeys = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : list.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equals(text)) listOfKeys.add(entry.getKey());
            }
        }
        return listOfKeys;
    }

    public boolean RoomIsReserved(String room, Date checkInDate) {
        boolean result = false;
        if (TextExists(room)) {
            HashSet<String> keys = getKeysForGivenTextInMap(room);
            for (String key : keys) {
                String checkInDateFromDatabase = list.get(key).get(3);
                String newDate = Converters.convertDateToString(checkInDate);
                if (newDate.equals(checkInDateFromDatabase)) return true;
            }
        }
        return result;
    }

    public boolean TextExists(String text) {
        boolean result = false;
        if (!getKeysForGivenTextInMap(text).isEmpty()) result = true;
        return result;
    }

    public boolean AddNewRecord(String id, String email, String name, String surname, Date checkInDate, String room) {
        boolean result = false;
        try {
            if (DataIsValid(id, email, name, surname, checkInDate, room) && (!RoomIsReserved(room, checkInDate))) {
                String dateToString = Converters.convertDateToString(checkInDate);
                List<String> record = new LinkedList<String>() {
                    private static final long serialVersionUID = 1L;

                    {
                        //add(id);
                        add(email);
                        add(name);
                        add(surname);
                        add(dateToString);
                        add(room);
                    }
                };

                list.put(id, record);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean DataIsValid(String id, String email, String name, String surname, Date checkInDate, String room) {
        boolean result = false;
        if (Strings.isNullOrEmpty(id) || RoomIsReserved(room, checkInDate)) return false;
        else {

            User user = new User(name, surname, email);
            boolean userIsOk = user.ValidateData(name, surname, email);
            Reservation reservation = new Reservation(checkInDate, room);
            boolean reservationIsOK = reservation.ReservationDataIsCorrect(room, checkInDate);
            if (userIsOk && reservationIsOK) result = true;

        }
        return result;
    }
    public int GetDatabaseSize(){return list.size();}
}