package utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrentDate {
    public String CurrentDate = "";
    public String CurrentHour = "";

    public String getCurrentDate() {
        setCurrentDate();
        return this.CurrentDate;
    }

    public String getCurrentHour() {
        setCurrentHour();
        return this.CurrentHour;
    }

    private void setCurrentDate() {
        SimpleDateFormat dateTimeCurrentFullDate = new SimpleDateFormat("EEEE dd MMMM");
        String FormatedCurrentDateMin = dateTimeCurrentFullDate.format(new Date());
        String FormatedCurrentDate = FormatedCurrentDateMin.substring(0, 1).toUpperCase() + FormatedCurrentDateMin.substring(1);

        this.CurrentDate = FormatedCurrentDate;
    }

    private void setCurrentHour() {
        SimpleDateFormat dateTimeCurrentHour = new SimpleDateFormat("HH:mm");
        String FormatedCurrentHour = dateTimeCurrentHour.format(new Date());
        FormatedCurrentHour = FormatedCurrentHour.replace(":", "h");

        this.CurrentHour = FormatedCurrentHour;
    }
}
