package repository;

import constants.Constants;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import model.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for storing task data in memory.
 * Handles CRUD operations and conversion between DTO and Model.
 */
public class TaskRepository {

    private List<Task> taskList = new ArrayList<>();

    public TaskRepository() {
    }

    /**
     * Adds a task from TaskRequestDTO (converts DTO → Model)
     */
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

    /**
     * Returns all tasks converted to TaskResponseDTO
     */
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

    public List<Task> getAll() {
        return taskList;
    }

    public int getLastId() {
        if (taskList.isEmpty()) {
            return 0;
        }
        return taskList.get(taskList.size() - 1).getId();
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}