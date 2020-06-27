import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Test;

public class TestLargestDataFile {

	static BufferedReader rdr;
	String line;
	
	@Test
	public void testFromFile() throws Exception {
		rdr = new BufferedReader(new FileReader("test/test.txt"));
		while((line = rdr.readLine()) != null) {
			if (line.startsWith("#")) {
				continue;
			}
			
			StringTokenizer st = new StringTokenizer(line);
			if (!st.hasMoreTokens()) {
				continue;
			}
			
			String val = st.nextToken();
			int expected = Integer.valueOf(val).intValue();
			ArrayList<Integer> argumentList = new ArrayList<Integer>();
			while (st.hasMoreTokens()) {
				argumentList.add(Integer.valueOf(st.nextToken()));
			}
			
			int[] arguments = new int[argumentList.size()];
			for(int i=0; i<argumentList.size(); i++) {
				arguments[i] = ((Integer) argumentList.get(i)).intValue();
			}
			assertEquals(expected, Largest.largest(arguments));
		}
	}

}
