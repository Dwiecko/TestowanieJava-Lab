import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;

public class StringOperationsTest {
	private StringOperations text;
	
	@Before
	public void BeforeAll(){
		text = new StringOperations();
	}
	
	@Test
	public void ReverseTest(){
		String givenText = text.reverse("Test");
		assertThat(givenText, is("tseT"));
	}
	
	@Test
	public void ConcatTest(){
		String firstText = "Te";
		String secondText = "st";
		
		String givenText = text.concat(firstText, secondText);
		
		assertThat(givenText, is("Test"));
	}
	
	@Test
	public void ConcatNullTest(){
		String firstText = "Te";
		String secondText = null;
		
		String givenText = text.concat(firstText, secondText);
		
		assertThat(givenText, is("Te"));
	}
	
	@Test
	public void ConcatenateWhenFirstTextIsEmpty(){
		String firstText = "";
		String secondText = "st";
		
		String givenText = text.concat(firstText, secondText);
		assertThat(givenText, is(nullValue()));
	}
	
	@Test
	public void ConcatenateWhenFirstTextIsNullable(){
		String firstText = null;
		String secondText = "st";
		
		String givenText = text.concat(firstText, secondText);
		assertThat(givenText, is(nullValue()));
	}
	
	@Test
	public void ConcatenateWhenSecondTextIsNullable(){
		String firstText = "st";
		String secondText = null;
		
		text.concat(firstText, secondText);
	}

	@Test
	public void OneLetterPalindromeTest(){
		boolean givenText = text.isPalindrome("a");
		
		assertThat(givenText, is(true));
	}
	
	@Test
	public void TwoLetterPalindromeTest(){
		boolean givenText = text.isPalindrome("aa");
		
		assertThat(givenText, is(true));
	}
	
	@Test
	public void PalindromeFailTest(){
		boolean givenText = text.isPalindrome("abA");
		
		assertThat(givenText, is(false));
	}
	
	@After
	public void TearDown(){
		text = null;
	}

}
