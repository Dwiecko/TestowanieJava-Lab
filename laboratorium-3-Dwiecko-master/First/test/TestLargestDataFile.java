import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLargestDataFile {

	static BufferedReader rdr;
	String line;
	
	private int[] toArray(ArrayList<Integer> argumentList){
		int[] arguments = new int[argumentList.size()];
		for(int i=0; i<argumentList.size(); i++) {
			arguments[i] = ((Integer) argumentList.get(i)).intValue();
		}
		return arguments;
	}
	
	private ArrayList<Integer> addToArgs(StringTokenizer st) {
		ArrayList<Integer> argumentList = new ArrayList<Integer>();
		while (st.hasMoreTokens()) {
			argumentList.add(Integer.valueOf(st.nextToken()));
		}
		return argumentList;
	}
	
	private Boolean checkIfStringContainsOtherTokenizers(String line, StringTokenizer st){
		if (!st.hasMoreTokens()) {
			return false;
		}
		return true;
	}
	
	private Boolean checkIfStingContainsComments(String line, StringTokenizer st){
		if (line.startsWith("#")) {
			return false;
		}
		return true;
	}
	
	@Before
	public void setUp() throws Exception {
		rdr = new BufferedReader(new FileReader("test/test.txt"));
	}
	
	@Test
	public void testFromFile() throws Exception {
		while((line = rdr.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			
			if(!checkIfStringContainsOtherTokenizers(line, st)){
				continue;
			}
			
			if(!checkIfStingContainsComments(line, st)){
				continue;
			}
			String val = st.nextToken();
			int expected = Integer.valueOf(val).intValue();
			ArrayList<Integer> argumentList = addToArgs(st);
			int[] arguments = toArray(argumentList);
			assertEquals(expected, Largest.largest(arguments));
		}
	}
	@After
	public void tearDown() {
		rdr = null;
	}
}
