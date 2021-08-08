package demo.helper;

import junit.framework.TestCase;
import org.junit.Test;

public class RAConverterTest extends TestCase {
    @Test
    public void testRAto180(){
        Double actualDouble = null;
        Double expectedDouble = null;
        // test for RA less than 180 (Double)
        actualDouble = RAConverter.RAto180(179.0);
        expectedDouble = 179.0;
        assertEquals(expectedDouble, actualDouble);

        // test for RA greater than 180 (Double)
        actualDouble = RAConverter.RAto180(181.0);
        expectedDouble = -179.0;
        assertEquals(expectedDouble, actualDouble);


        // test for RA less than 180 (String)
        actualDouble = RAConverter.RAto180("179");
        expectedDouble = 179.0;
        assertEquals(expectedDouble, actualDouble);

        // test for RA greater than 180 (String)
        actualDouble = RAConverter.RAto180("181");
        expectedDouble = -179.0;
        assertEquals(expectedDouble, actualDouble);
    }
}