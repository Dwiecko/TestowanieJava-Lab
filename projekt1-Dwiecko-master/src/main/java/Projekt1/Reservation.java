package Projekt1;

import java.util.Date;

import com.google.common.base.Strings;

public class Reservation {
    private Date checkInDate;
    private String room;

    public Reservation(Date checkInDate, String room) {
        setCheckInDate(checkInDate);
        setRoom(room);
    }

    public boolean ReservationDataIsCorrect(String room, Date checkInDate) {
        if (!(Strings.isNullOrEmpty(room)) && DataIsCorrect(checkInDate)) return true;
        else return false;
    }

    public boolean DataIsCorrect(Date checkInDate) {
        boolean result = true;
        if (!TimeIsFull(checkInDate)) {
            result = false;
            throw new IllegalArgumentException("Please use full time format. Minutes can only contain: 0..10..20...60");
        }
        return result;
    }

    private boolean TimeIsFull(Date ReservationDate) {
        int minutes = ReservationDate.getMinutes();
        if ((minutes % 10 == 0) || (minutes % 10 == 10)) {
            return true;
        }
        return false;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        if (!DataIsCorrect(checkInDate)) {
            throw new IllegalArgumentException("Please correct checkin date.");
        } else {
            this.checkInDate = checkInDate;
        }
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        if (!(Strings.isNullOrEmpty(room))) {
            this.room = room;
        } else {
            throw new IllegalArgumentException("Room is Null or Empty. Please correct field.");
        }
    }
}
