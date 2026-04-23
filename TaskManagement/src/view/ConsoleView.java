package view;

import constants.Message;
import dto.TaskResponseDTO;
import java.util.List;

// Chỗ này chuyên để in dữ liệu ra màn hình thôi.
// Cứ nhận data từ Controller đưa qua rồi in ra, không xử lý lằng nhằng.
public class ConsoleView {

    private List<TaskResponseDTO> taskList;

    // Nhận list task cần in nè
    public void setTaskList(List<TaskResponseDTO> taskList) {
        this.taskList = taskList;
    }

    // In cái bảng task ra console
    public void display() {
        // Tiêu đề bảng
        System.out.println("----------------------------------------- Task List "
                + "-----------------------------------------");

        

        // In tên mấy cái cột ra
        System.out.printf("%-5s %-20s %-10s %-12s %-8s %-12s %-12s\n",
                "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");

        // Lặp qua in từng task ra một
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