package Projekt1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ReservationTest {

    private Reservation reservation;

    private String sampleRoom;
    private String room;
    private Date sampleDate;
    private Date date;


    @BeforeEach
    public void BuildUp() {
        sampleDate = Converters.StringToDate("2000-12-13 20:30");
        sampleRoom = "20";
        reservation = new Reservation(sampleDate, sampleRoom);
    }

    @Test
    void CausesExceptionAfterPassingNotFullTime() {
        date = Converters.StringToDate("2000-12-13 20:35");

        assertThrows(Exception.class, () -> {
            reservation = new Reservation(date, sampleRoom);
        });
    }

    @Test
    void FullTimeIsAddedProperly() {
        Date testDate = Converters.StringToDate("2000-12-13 20:00");
        date = reservation.getCheckInDate();
        //ASSERT
        MatcherAssert.assertThat(testDate, DateMatchers.sameDay(date));
    }

    @Test
    void ThrowsExceptionAfterPassingEmptyRoom() {
        room = "";

        assertThrows(IllegalArgumentException.class, () -> {
            reservation = new Reservation(sampleDate, room);
        });
    }

    @Test
    void ThrowsExceptionAfterPassingNullableRoom() {
        room = null;

        assertThrows(IllegalArgumentException.class, () -> {
            reservation = new Reservation(sampleDate, room);
        });
    }

    @Test
    void ReservationDateIsAddedProperly() {
        //ARRANGE
        Date testDate = Converters.StringToDate("2000-12-13 20:30");
        //ACT
        date = reservation.getCheckInDate();
        //ASSERT
        MatcherAssert.assertThat(testDate, DateMatchers.sameDay(date));
    }

    @Test
    void ReservationRoomIsAddedProperly() {
        room = reservation.getRoom();

        assertSame(sampleRoom, room);
    }

    @Test
    void ThrowsErrorAfterPassingDateInIncorrectFormat() {
        date = Converters.StringToDate("2000-22-13 20:30");
        assertThrows(IllegalArgumentException.class, () -> reservation = new Reservation(sampleDate, room));
    }

    @Test
    void ReservationIsInCorrect() {
        boolean reservationTest = reservation.ReservationDataIsCorrect("", sampleDate);
        assertFalse(reservationTest);
    }

    @Test
    void ReservationIsCorrect() {
        boolean reservationTest = reservation.ReservationDataIsCorrect(sampleRoom, sampleDate);
        assertTrue(reservationTest);
    }
}