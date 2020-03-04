package Dispensables.DataClass;

public class Issue {
    private float effortManHours;

    private String description;

    private Priority priority;

    public Issue(float effortManHours, String description)
    {
        this.setEffortManHours(effortManHours);
        this.setDescription(description);
    }

    public Issue(float effortManHours, String description, Priority priority)
    {
        this(effortManHours, description);
        this.setPriority(priority);
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEffortManHours(float effortManHours) {
        this.effortManHours = effortManHours;
    }

    public String getSummary() {
        return "Description:'" + this.description + "' Effort:'" + this.effortManHours + "' Priority:'" + this.priority + "'";

    }
}
