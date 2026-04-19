package repository;

import constants.Constants;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import model.Task;
import java.util.ArrayList;
import java.util.List;

// Kho cất dữ liệu trên RAM.
// Lẳng lặng ngồi xử lý mấy cái thêm sửa xóa và ép kiểu giữa DTO với Model.
public class TaskRepository {

    private List<Task> taskList = new ArrayList<>();

    public TaskRepository() {
    }

    // Thêm task từ DTO (biến DTO thành Model rồi mới cất vào)
    public void addTaskFromDTO(TaskRequestDTO dto) {
        int nextId = getLastId() + 1;

        Task newTask = new Task(
                nextId,
                dto.getTypeId(),
                dto.getName(),
                dto.getDate(),
                dto.getPlanFrom(),
                dto.getPlanTo(),
                dto.getAssignee(),
                dto.getReviewer()
        );

        taskList.add(newTask);
    }

    // Trả về hết đống task dưới dạng TaskResponseDTO
    public List<TaskResponseDTO> getAllAsResponseDTO() {
        List<TaskResponseDTO> responseList = new ArrayList<>();

        for (Task task : taskList) {
            responseList.add(new TaskResponseDTO(
                    task.getId(),
                    task.getName(),
                    Constants.getTaskTypeName(task.getTaskTypeId()),
                    task.getDate(),
                    (task.getPlanTo() - task.getPlanFrom()),
                    task.getAssignee(),
                    task.getReviewer()
            ));
        }
        return responseList;
    }

    public boolean deleteTask(int id) {
        return taskList.removeIf(t -> t.getId() == id);
    }


    public int getLastId() {
        if (taskList.isEmpty()) {
            return 0;
        }
        return taskList.get(taskList.size() - 1).getId();
    }

}