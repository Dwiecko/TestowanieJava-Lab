package mockNotes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoteTest {
	Note notes;
	String sampleName;
	float sampleGrade;
	@BeforeEach
	public void BuildUp(){
		sampleGrade = 4.5f;
		sampleName = "Mateusz Miotk";
		notes = Note.of(sampleName, sampleGrade);
	}

	@Test
	void testCreate() {
		final Note note = Note.of("Mateusz Miotk", 4.5f);
		assertEquals("Mateusz Miotk", note.getName());
		assertEquals(4.5f, note.getNote(),0.01f);
	}

	@Test
	void throwsExceptionAfterPassingNullableUsername(){
		assertThrows(IllegalArgumentException.class,()->{
            notes = Note.of(null, sampleGrade);
		});
	}

	@Test
	void throwsExceptionAfterPassingEmptyUsername(){
		assertThrows(IllegalArgumentException.class,()->{
            notes = Note.of("", sampleGrade);
		});
	}
	
	// @Test
	// void throwsExceptionMessageAfterPassingEmptyUsername(){
	// 	Throwable thrown = catchThrowable(() -> {
	// 		notes = Note.of(null, sampleGrade);
	// 	});
		
	// 	assertThat(thrown)
	// 	  	.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessageContaining("nie może być null");
	// }

	}
