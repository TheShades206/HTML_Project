package view;

import constants.Message;
import dto.TaskResponseDTO;
import java.util.List;

/**
 * View class for displaying task data to the console.
 * Only receives data from Controller via setter, never prints elsewhere.
 */
public class ConsoleView {

    private List<TaskResponseDTO> taskList;

    /** Sets the task list to be displayed */
    public void setTaskList(List<TaskResponseDTO> taskList) {
        this.taskList = taskList;
    }

    /** Displays task list table to the console */
    public void display() {
        // Display table header
        System.out.println("----------------------------------------- Task List "
                + "-----------------------------------------");

        // Check if list is empty before displaying
        if (taskList == null || taskList.isEmpty()) {
            System.out.println(Message.LIST_EMPTY);
            return;
        }

        // Display column headers
        System.out.printf("%-5s %-20s %-10s %-12s %-8s %-12s %-12s\n",
                "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");

        // Display each task row
        for (TaskResponseDTO task : taskList) {
            System.out.printf("%-5d %-20s %-10s %-12s %-8.1f %-12s %-12s\n",
                    task.getId(),
                    task.getName(),
                    task.getType(),
                    task.getDate(),
                    task.getTime(),
                    task.getAssignee(),
                    task.getReviewer());
        }
    }
}