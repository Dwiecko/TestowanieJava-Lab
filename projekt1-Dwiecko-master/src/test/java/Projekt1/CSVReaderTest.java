package Projekt1;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by DawidPC on 2018-04-10.
 */
public class CSVReaderTest {
    private CSVReader csv;

    @BeforeEach
    public void BuildUp(){
        csv = new CSVReader();
    }

    @Test
    public void ProperlyReadsFile(){
        HashMap<String, List<String>> database = csv.read();

        assertFalse(database.isEmpty());
    }
}
