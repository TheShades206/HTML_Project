package controller;

import constants.Message;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import repository.TaskRepository;
import view.ConsoleView;
import java.util.List;

/**
 * Thin Controller: Only works with DTOs.
 * Does NOT directly use Model (Task class).
 * All Model operations are handled in Repository.
 */
public class TaskController {

    private final TaskRepository taskRepository;
    private final ConsoleView consoleView;

    public TaskController() {
        this.taskRepository = new TaskRepository();
        this.consoleView = new ConsoleView();
    }

    /**
     * Add task - Receives fully validated TaskRequestDTO
     */
    public void addTask(TaskRequestDTO requestDTO) {
        taskRepository.addTaskFromDTO(requestDTO);
    }

    /**
     * Delete task by ID
     */
    public void deleteTask(int id) throws Exception {
        if (!taskRepository.deleteTask(id)) {
            throw new Exception(Message.ERR_NOT_FOUND);
        }
    }

    /**
     * Check if task list is empty (for better UX in Main)
     */
    public boolean isTaskListEmpty() {
        return taskRepository.isEmpty();
    }

    /**
     * Display all tasks
     */
    public void displayTasks() {
        List<TaskResponseDTO> responseList = taskRepository.getAllAsResponseDTO();
        consoleView.setTaskList(responseList);
        consoleView.display();
    }
}