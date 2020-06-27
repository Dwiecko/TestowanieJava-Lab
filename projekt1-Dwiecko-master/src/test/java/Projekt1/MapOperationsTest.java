package Projekt1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class MapOperationsTest {
    public static List<String> testList;
    public static HashMap<String, List<String>> sampleDatabase;
    public static MapOperations mapOperations;
    private static String Id, email, name, surname, date, room;

    @BeforeClass
    public static void environmentBuild() {
        Id = "5788968278142";
        email = "Test@test.com";
        name = "Name";
        surname = "Surname";
        date = "2001-11-12 20:40";
        room = "20";

        testList = Arrays.asList("email2@email.com", "Nname", "Ssurname", "2000-11-12 20:40", "20");
        sampleDatabase = new HashMap<String, List<String>>() {
            private static final long serialVersionUID = 1L;

            {
                put("9658968278142", testList);
            }
        };
        mapOperations = new MapOperations(sampleDatabase);
    }

    @Test
    public void DataIsValid() {
        Date testDate = Converters.StringToDate(date);

        boolean isValid = mapOperations.DataIsValid(Id, email, name, surname, testDate, room);

        assertTrue(isValid);
    }

    @Test
    public void PersonNameExistsInDatabase() {
        boolean personExists = mapOperations.TextExists("Nname");
        assertTrue(personExists);
    }

    @Test
    public void ThrowsExceptionIfRoomIsNotReservedInAConcreteTime() {
        Date testDate = Converters.StringToDate("2000-11-13 20:30");
        boolean roomIsReserved = mapOperations.RoomIsReserved("100", testDate);
        assertFalse(roomIsReserved);
    }

    @Test
    public void RoomIsReservedInAConcreteTime() {
        Date testDate = Converters.StringToDate("2000-11-12 20:40");
        boolean isReserved = mapOperations.RoomIsReserved("20", testDate);

        assertTrue(isReserved);
    }

    @Test
    @Parameters(value = {"9658968278963, email2@email.com, Nname, Ssurname, 2000-11-12 20:40, 20" })
    public void AddingSameRoomInTheSameTimeAffectsInFailure(String testid, String testemail, String testname, String testsurname,
                                                            String testdate, String testroom){
        Date newDate = Converters.StringToDate(testdate);
        boolean isValid = mapOperations.AddNewRecord(testid, testemail, testname, testsurname, newDate,testroom);

        assertFalse(isValid);
    }

    @Test
    @Parameters(value = {"8956968278963, email2@email.com, Nname, Ssurname, 2000-11-12 20:40, 21" })
    public void AddingNewRecord(String testid, String testemail, String testname, String testsurname,
                                                            String testdate, String testroom){
        int currentSize = mapOperations.GetDatabaseSize();
        Date newDate = Converters.StringToDate(testdate);

        boolean isValid = mapOperations.AddNewRecord(testid, testemail, testname, testsurname, newDate,testroom);
        int sizeAfterAfterAddingRecord = mapOperations.GetDatabaseSize();

        assertTrue(sizeAfterAfterAddingRecord > currentSize);
    }

}