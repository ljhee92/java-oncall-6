package oncall.domain;

import java.util.List;

public class Scheduler {
    private final Schedule schedule;
    private final Employees weekdayEmployees;
    private final Employees holidayEmployees;

    int holidayIndex = 0;
    int weekdayIndex = 1;

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
        return currentDayOfWeek.getName();
    }

    public String getAssignedEmployees(int day) {
        String name = "";
        int index = day - 1;

        DayOfWeek currentDayOfWeek = getCurrentDayOfWeek(day);
        if (currentDayOfWeek.isHoliday()) {
            name = holidayEmployees.getEmployees().get(index - (5 * holidayIndex)).getName();
            if (day % 7 == 2) {
                holidayIndex++;
            }
        }

        if (!currentDayOfWeek.isHoliday()) {
            name = weekdayEmployees.getEmployees().get(index - (2 * weekdayIndex)).getName();
            if (day % 7 == 0) {
                weekdayIndex++;
            }
        }
        return name;
    }
}
