package dto;

/**
 * Data Transfer Object for sending display data from Controller to View.
 * Declares all fields that will be displayed through the view.
 */
public class TaskResponseDTO {

    private int id;
    private String name;
    private String type;
    private String date;
    private double time;
    private String assignee;
    private String reviewer;

    /** Constructor with all parameters */
    public TaskResponseDTO(int id, String name, String type, String date,
            double time, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    /** Gets task id */
    public int getId() {
        return id;
    }

    /** Gets task name */
    public String getName() {
        return name;
    }

    /** Gets task type name */
    public String getType() {
        return type;
    }

    /** Gets task date */
    public String getDate() {
        return date;
    }

    /** Gets total time (planTo - planFrom) */
    public double getTime() {
        return time;
    }

    /** Gets assignee name */
    public String getAssignee() {
        return assignee;
    }

    /** Gets reviewer name */
    public String getReviewer() {
        return reviewer;
    }
}