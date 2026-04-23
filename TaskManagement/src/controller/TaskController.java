package controller;

import constants.Message;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import repository.TaskRepository;
import view.ConsoleView;
import java.util.List;

// Controller mỏng nhẹ: Chỉ làm việc qua DTO.
// Không đụng chạm gì tới Model (Task) đâu.
// Mọi thao tác với Model thì ném hết cho Repository lo.
public class TaskController {

    private final TaskRepository taskRepository;
    private final ConsoleView consoleView;

    public TaskController() {
        this.taskRepository = new TaskRepository();
        this.consoleView = new ConsoleView();
    }

    // Thêm task - Nhận cái DTO đã được check lỗi kỹ càng
    public void addTask(TaskRequestDTO requestDTO) {
        taskRepository.addTaskFromDTO(requestDTO);
    }

    // Xóa task theo ID
    public void deleteTask(int id) throws Exception {
        if (!taskRepository.deleteTask(id)) {
            throw new Exception(Message.ERR_NOT_FOUND);
        }
    }

    public List<TaskResponseDTO> getTaskList() {
        return taskRepository.getAllAsResponseDTO();
    }
    

    // Show hết các task ra
    public void displayTasks(List<TaskResponseDTO> responseList) {
        consoleView.setTaskList(responseList);
        consoleView.display();
    }
}