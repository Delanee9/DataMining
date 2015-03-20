import java.util.Calendar;

class DateEntry {
    private final String date;
    private final int day;
    private final int month;
    private final int year;
    private final int dayOfWeek;

    public DateEntry(String date) {
        String[] dateArray = date.trim().split("/");
        this.day = Integer.parseInt(dateArray[0]);
        this.month = Integer.parseInt(dateArray[1]);
        this.year = Integer.parseInt(dateArray[2]);
        this.date = date;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDate() {
        return date;
    }
}