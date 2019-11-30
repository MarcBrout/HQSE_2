import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.SimpleDateFormat;
import utils.CurrentDate;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentDateTest {
    @Test
    public void getCurrentDateTest() {
        CurrentDate currentDate = new CurrentDate();

        SimpleDateFormat dateTimeCurrentFullDate = new SimpleDateFormat("EEEE dd MMMM");
        String FormatedCurrentDateMin = dateTimeCurrentFullDate.format(new Date());
        String FormatedCurrentDate = FormatedCurrentDateMin.substring(0, 1).toUpperCase() + FormatedCurrentDateMin.substring(1);

        assertEquals(FormatedCurrentDate, currentDate.getCurrentDate());
    }

    @Test
    public void getCurrentHourTest() {
        CurrentDate currentDate = new CurrentDate();

        SimpleDateFormat dateTimeCurrentHour = new SimpleDateFormat("HH:mm");
        String FormatedCurrentHour = dateTimeCurrentHour.format(new Date());
        FormatedCurrentHour = FormatedCurrentHour.replace(":", "h");

        assertEquals(FormatedCurrentHour, currentDate.getCurrentHour());
    }
}
