import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LightTest {
    private Light light;
    private Light light1;


    @Before
    public void setup(){
       light = new Light(1, "Green");
       light1 = new Light(2, "Blue");
    }

    @Test
    public void lightIsOnByDefaultTest() {
        assertTrue(light.getState());
    }

    @Test
    public void getColourTest(){
        assertEquals("Green",light.getColour());
        assertEquals("Blue", light1.getColour());
    }

    @Test
    public void getPositionTest(){
        assertEquals(1, light.getPosition());
        assertEquals(2, light1.getPosition());
    }

    @Test
    public void changeStateTest() {
        light.changeState();
        assertFalse(light.getState());
    }

    @Test
    public void changeStateEvenTimes(){
        light.changeState();
        light.changeState();
        light.changeState();
        light.changeState();
        assertTrue(light.getState());
    }

    @Test
    public void changeStateOddTimes(){
        light.changeState();
        light.changeState();
        light.changeState();
        assertFalse(light.getState());
    }

    @Test
    public void testToStringStateOn() {
        assertEquals("1 Green Light On", light.toString());
    }

    @Test
    public void testToStringStateOff() {
        light.changeState();
        assertEquals("1 Green Light Off", light.toString());
    }
}