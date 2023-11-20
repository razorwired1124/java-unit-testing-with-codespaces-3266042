import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {

        String[] expected = new String[] {"Monday", "Tuesday"};

        String[] actual = hairSalon.getOpeningDays();

        assertArrayEquals(expected, actual);
        
    }

    @Test
    public void testSalonIsOpenOnMonday() {
        boolean actual = hairSalon.isOpen("Monday");

        assertTrue(hairSalon.isOpen("Monday"));

    }

    @Test
    public void testSalonIsClosedOnWednesday() {
        assertFalse(hairSalon.isOpen("Wednesday"));

    }

    @Test
    public void testExceptionIsThrownIfWeekdayDoesNotEndInDay() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpen("Hello"));

        String expected = "The weekday argument bust end in the letters 'day'";

        String actual = exception.getMessage();

        assertEquals(expected, actual);

    }

}