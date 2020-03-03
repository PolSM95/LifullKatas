package Bloaters.Longmethods;

public class Issue {
    private float effortManHours;

    private String description;

    private Priority priority;

    public Issue(float effortManHours, String description) {
        this.setEffortManHours(effortManHours);
        this.setDescription(description);
    }

    public Issue(float effortManHours, String description, Priority priority) {
        this(effortManHours, description);
        this.priority = priority;
    }

    public float getEffortManHours() {
        return effortManHours;
    }

    public void setEffortManHours(float effortManHours) {
        this.effortManHours = effortManHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
