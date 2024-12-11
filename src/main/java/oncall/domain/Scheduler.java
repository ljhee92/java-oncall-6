package oncall.domain;

import java.util.Arrays;
import java.util.List;

public class Scheduler {
    private final Schedule schedule;
    private final Employees weekdayEmployees;
    private final Employees holidayEmployees;

    int holidayIndex = 0;
    int weekdayIndex = 0;

    private Scheduler(Schedule schedule, List<Employees> employees) {
        this.schedule = schedule;
        this.weekdayEmployees = employees.get(0);
        this.holidayEmployees = employees.get(1);
    }

    public static Scheduler create(Schedule schedule, List<Employees> employees) {
        return new Scheduler(schedule, employees);
    }

    public int getMonth() {
        return schedule.getMonth().getMonth();
    }

    public int getLastDay() {
        return schedule.getMonth().getLastDay();
    }

    private DayOfWeek getCurrentDayOfWeek(int day) {
        return DayOfWeek.values()[(schedule.getDayOfWeek().ordinal() + (day - 1)) % 7];
    }

    public String getDayOfWeek(int day) {
        DayOfWeek currentDayOfWeek = getCurrentDayOfWeek(day);
        String dayOfWeek = currentDayOfWeek.getName();
        if (!currentDayOfWeek.isWeekend() && Arrays.stream(Holidays.values()).anyMatch(holidays -> {
            return holidays.isHoliday(schedule.getMonth().getMonth(), day);
        })) {
            dayOfWeek = dayOfWeek + "(휴일)";
        }
        return dayOfWeek;
    }

    public String getAssignedEmployees(int day) {
        String name = "";
        int index = day - 1;

        DayOfWeek currentDayOfWeek = getCurrentDayOfWeek(day);
        if (currentDayOfWeek.isWeekend()) {
            name = holidayEmployees.getEmployees().get(index - (5 * holidayIndex)).getName();
            if (index % 7 == 1) {
                holidayIndex++;
            }
        }

        if (!currentDayOfWeek.isWeekend()) {
            if (index % 7 == 2) {
                weekdayIndex++;
            }
            name = weekdayEmployees.getEmployees().get(index - (2 * weekdayIndex)).getName();
        }
        return name;
    }
}
