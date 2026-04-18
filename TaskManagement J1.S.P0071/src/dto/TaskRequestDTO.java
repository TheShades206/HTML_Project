package dto;

/**
 * Data Transfer Object for receiving input data from Main to Controller.
 * Declares all fields needed to pass from main into controller.
 */
public class TaskRequestDTO {

    private String name;
    private String date;
    private String assignee;
    private String reviewer;
    private int typeId;
    private double planFrom;
    private double planTo;

    /** Constructor with no parameters */
    public TaskRequestDTO() {
    }

    /** Gets requirement name */
    public String getName() {
        return name;
    }

    /** Sets requirement name */
    public void setName(String name) {
        this.name = name;
    }

    /** Gets task type id */
    public int getTypeId() {
        return typeId;
    }

    /** Sets task type id */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /** Gets task date */
    public String getDate() {
        return date;
    }

    /** Sets task date */
    public void setDate(String date) {
        this.date = date;
    }

    /** Gets plan from time */
    public double getPlanFrom() {
        return planFrom;
    }

    /** Sets plan from time */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /** Gets plan to time */
    public double getPlanTo() {
        return planTo;
    }

    /** Sets plan to time */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /** Gets assignee name */
    public String getAssignee() {
        return assignee;
    }

    /** Sets assignee name */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /** Gets reviewer name */
    public String getReviewer() {
        return reviewer;
    }

    /** Sets reviewer name */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}