package oncall.domain;

public class Schedule {
    private final Month month;
    private final DayOfWeek dayOfWeek;

    private Schedule(Month month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public static Schedule of(Month month, DayOfWeek dayOfWeek) {
        return new Schedule(month, dayOfWeek);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "month=" + month +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
