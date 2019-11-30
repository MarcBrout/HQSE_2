import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.SimpleDateFormat;
import utils.CurrentDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentDateTest {
    @Test
    public void getCurrentDateTest() {
        CurrentDate currentDate = new CurrentDate();

        SimpleDateFormat dateTimeCurrentFullDate = new SimpleDateFormat("EEEE dd MMMM");
        String formatedCurrentDateMin = dateTimeCurrentFullDate.format(new Date());
        String formatedCurrentDate = formatedCurrentDateMin.substring(0, 1).toUpperCase()
                + formatedCurrentDateMin.substring(1);

        assertEquals(formatedCurrentDate, currentDate.getCurrentDate());
    }

    @Test
    public void getCurrentHourTest() {
        CurrentDate currentDate = new CurrentDate();

        SimpleDateFormat dateTimeCurrentHour = new SimpleDateFormat("HH:mm");
        String formatedCurrentHour = dateTimeCurrentHour.format(new Date());
        formatedCurrentHour = formatedCurrentHour.replace(":", "h");

        assertEquals(formatedCurrentHour, currentDate.getCurrentHour());
    }
}
