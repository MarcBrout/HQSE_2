package utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrentDate {
    private String   currentDate;
    private String   currentHour;

    public CurrentDate() {
        this.currentDate = "";
        this.currentHour = "";
    }

    public String getCurrentDate() {
        setCurrentDate();

        return this.currentDate;
    }

    public String getCurrentHour() {
        setCurrentHour();

        return this.currentHour;
    }

    private void setCurrentDate() {
        SimpleDateFormat dateTimeCurrentFullDate = new SimpleDateFormat("EEEE dd MMMM");
        String formatedCurrentDateMin = dateTimeCurrentFullDate.format(new Date());

        this.currentDate = formatedCurrentDateMin.substring(0, 1).toUpperCase() + formatedCurrentDateMin.substring(1);
    }

    private void setCurrentHour() {
        SimpleDateFormat dateTimeCurrentHour = new SimpleDateFormat("HH:mm");
        String formatedCurrentHour = dateTimeCurrentHour.format(new Date());
        formatedCurrentHour = formatedCurrentHour.replace(":", "h");

        this.currentHour = formatedCurrentHour;
    }
}
