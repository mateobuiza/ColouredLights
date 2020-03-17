import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class MainTest {

    Main main = new Main();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getNumOfColoursStringInput(){

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        main.inputNumOfColours();
        assertEquals(5, main.getColoursList().length);
    }

//    @Test
//    public void getNumOfColoursStringWrongInput(){
//
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        String input = "hello\n5";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        main.inputNumOfColours();
//        assertEquals("Enter the number of colours you want: \nPlease enter a number...\nEnter the number of colours you want:", outContent.toString().trim());
//
//    }

    @Test
    public void getColoursStringInput(){

        String input = "3\nRed\nBlue\nGreen";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        main.inputNumOfColours();
        main.inputColours();
        assertEquals(3, main.getColoursList().length);
    }



}
