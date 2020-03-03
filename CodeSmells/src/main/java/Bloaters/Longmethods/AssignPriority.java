package Bloaters.Longmethods;

public class AssignPriority {
    public AssignPriority() {
    }

    Priority set_priority_to_critical(float effortManHours, Priority priority) {
        if (effortManHours > 500) {
            priority = Priority.Critical;
        }
        return priority;
    }

    Priority set_priority_to_high(float effortManHours, Priority priority) {
        if (effortManHours > 250) {
            priority = Priority.High;
        }
        return priority;
    }

    Priority set_priority_to_medium(float effortManHours, Priority priority) {
        if (effortManHours > 100) {
            priority = Priority.Medium;
        }
        return priority;
    }

    void throw_exception_when_effort_is_bigger_than_maximum_hours_to_fix(float effortManHours) {
        if (effortManHours > 1000 || effortManHours <= 0) {
            throw new RuntimeException("Cannot register tech debt where effort is bigger than 1000 man hours to fix");
        }
    }

    private Priority set_priority_to_critical(float effortManHours, Priority priority, TechnicalDebt technicalDebt) {
        return set_priority_to_critical(effortManHours, priority);
    }

    private Priority set_priority_to_high(float effortManHours, Priority priority, TechnicalDebt technicalDebt) {
        return set_priority_to_high(effortManHours, priority);
    }

    private Priority set_priority_to_medium(float effortManHours, Priority priority, TechnicalDebt technicalDebt) {
        return set_priority_to_medium(effortManHours, priority);
    }

    private void throw_exception_when_effort_is_bigger_than_maximum_hours_to_fix(float effortManHours, TechnicalDebt technicalDebt) {
        throw_exception_when_effort_is_bigger_than_maximum_hours_to_fix(effortManHours);
    }
}