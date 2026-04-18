package main;

import constants.Constants;
import constants.Message;
import controller.TaskController;
import dto.TaskRequestDTO;
import utils.Validation;
import java.util.Scanner;

/**
 * Main class containing the primary workflow of the Task Management application.
 * Only works with Validation, Controller, and DTO. Scanner is used only here.
 * Service layer has been removed as per lecturer's requirement.
 */
public class Main {

    /** Main entry point of the application */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskController controller = new TaskController();

        while (true) {
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                int choice = Validation.getInt(sc.nextLine(), Constants.MENU_MIN, Constants.MENU_MAX);

                switch (choice) {

                    // ==================== CASE 1: ADD TASK ====================
                    case 1:
                        TaskRequestDTO dto = new TaskRequestDTO();

                        // Input requirement name
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_NAME);
                                dto.setName(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Input task type
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_TYPE);
                                dto.setTypeId(Validation.getInt(
                                        sc.nextLine(), Constants.TASK_TYPE_MIN, Constants.TASK_TYPE_MAX));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Input date
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_DATE);
                                dto.setDate(Validation.checkDate(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Input plan from time
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_FROM);
                                dto.setPlanFrom(Validation.getDoubleTime(
                                        sc.nextLine(), Constants.TIME_FROM_MIN, Constants.TIME_FROM_MAX));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Input plan to time
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_TO);
                                dto.setPlanTo(Validation.getDoubleTime(
                                        sc.nextLine(), Constants.TIME_TO_MIN, Constants.TIME_TO_MAX));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Business validation - Must be completed before calling Controller
                        Validation.validatePlanTime(dto.getPlanFrom(), dto.getPlanTo());

                        // Input assignee
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_ASSIGNEE);
                                dto.setAssignee(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Input reviewer
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_REVIEWER);
                                dto.setReviewer(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        controller.addTask(dto);
                        System.out.println(Message.SUCCESS_ADD);
                        break;

                    // ==================== CASE 2: DELETE TASK ====================
                    case 2:
                        // Check if list is empty first
                        if (controller.isTaskListEmpty()) {
                            System.out.println(Message.LIST_EMPTY);
                            break;
                        }

                        while (true) {
                            try {
                                System.out.print(Message.LABEL_ID);
                                int deleteId = Validation.getInt(sc.nextLine(), 1, Integer.MAX_VALUE);

                                controller.deleteTask(deleteId);
                                System.out.println(Message.SUCCESS_DELETE);
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;

                    // ==================== CASE 3: DISPLAY TASKS ====================
                    case 3:
                        controller.displayTasks();
                        break;

                    // ==================== CASE 4: EXIT ====================
                    case 4:
                        System.out.println(Message.EXIT_PROGRAM);
                        sc.close();
                        return;
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}