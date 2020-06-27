package Projekt1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public class User {
    private String Username;
    private String Surname;
    private String Email;

    public User(String Username, String Surname, String Email) {
        setUsername(Username);
        setSurname(Surname);
        setEmail(Email);
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        if (!(Strings.isNullOrEmpty(Surname))) {
            this.Surname = Surname;
        } else {
            throw new IllegalArgumentException("Surname is Null or Empty. Please correct field.");
        }
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        if (!(Strings.isNullOrEmpty(Username))) {
            this.Username = Username;
        } else {
            throw new IllegalArgumentException("Username is Null or Empty. Please correct field.");
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        if (!(Strings.isNullOrEmpty(Email)) && (emailIsCorrect(Email))) {
            this.Email = Email;
        } else {
            throw new IllegalArgumentException("Email is incorrect. Please correct field.");
        }
    }

    private boolean emailIsCorrect(String email) {
        boolean result = false;
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) result = true;
        return result;
    }

    public boolean ValidateData(String name, String surname, String email) {
        if (!Strings.isNullOrEmpty(email) && !Strings.isNullOrEmpty(name) && !Strings.isNullOrEmpty(surname) && (emailIsCorrect(email)))
            return true;
        else return false;
    }
}
