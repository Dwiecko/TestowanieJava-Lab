package Projekt1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserTest {
    private User user;
    private String sampleName;
    private String sampleSurname;
    private String sampleEmail; 

    @BeforeEach
    public void BuildUp() {
        sampleName = "Andrzej";
        sampleSurname = "Polak";
        sampleEmail = "test@wp.com";
        user = new User(sampleName, sampleSurname, sampleEmail);
    }

    @Test
    void EmailIsCorrect(){
        String email = user.getEmail();
        
        assertEquals(sampleEmail, email);
    }
    @Test
    void SurnameIsCorrect(){
        String surname = user.getSurname();
        
        assertEquals(sampleSurname, surname);
    }

    @Test
    void CausesExceptionAfterPassingNullValue(){
        Throwable thrown = catchThrowable(() -> {
            user = new User("", "","");
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Username is Null or Empty. Please correct field.");
    }

    @Test
    void UsernameIsCorrect(){
        String username = user.getUsername();

        assertEquals(sampleName, username);
    }

    @Test
    void CausesExceptionAfterPassingEmailInIncorrectFormat(){
        String email = "something@";

        assertThrows(IllegalArgumentException.class,()->{
            user = new User(sampleName, sampleSurname, email);
        });
    }
   @Test
    void CausesExceptionAfterPassingNullableValues(){
        assertThrows(IllegalArgumentException.class,()->{
            user = new User(null, null, null);
        });
    }
    @Test
    void CausesExceptionAfterPassingNullableSurname(){
        assertThrows(IllegalArgumentException.class,()->{
            user.setSurname(null);
        });
    }
    @Test
    void DataValidates(){
        boolean userValidates = user.ValidateData("testName", "testSurname", "testMail@mail.com");
        assertTrue(userValidates);
    }
    @Test
    void PassingIncorrectDataToValidateMethodGivesFailure(){
        boolean userValidates = user.ValidateData("testName", "testSurname", "testMailcom");
        assertFalse(userValidates);
    }
}
