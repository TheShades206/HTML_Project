package main;

import constants.Constants;
import constants.Message;
import controller.TaskController;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import utils.Validation;
import java.util.List;
import java.util.Scanner;

// Class Main dieu khien luong chinh cua chuong trinh
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskController controller = new TaskController();

        while (true) {
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                // Lay lua chon menu va check khoang hop le
                int choice = Validation.getInt(sc.nextLine(), Constants.MENU_MIN, Constants.MENU_MAX);

                switch (choice) {
                    case 1 -> {
                        TaskRequestDTO dto = new TaskRequestDTO();

                        // Nhap ten task
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_NAME);
                                dto.setName(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Nhap loai task (Code, Test, Design, Review)
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

                        // Nhap ngay thang (dd-mm-yyyy)
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_DATE);
                                dto.setDate(Validation.checkDate(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Nhap gio bat dau
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

                        // Nhap gio ket thuc
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

                        // Check logic: gio ket thuc phai lon hon gio bat dau
                        Validation.validatePlanTime(dto.getPlanFrom(), dto.getPlanTo());

                        // Nhap nguoi thuc hien
                        while (true) {
                            try {
                                System.out.print(Message.LABEL_ASSIGNEE);
                                dto.setAssignee(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }

                        // Nhap nguoi review
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
                    }
                    case 2 -> {
                        try {
                            // Lay list tu Controller va check rong bang ham moi trong Validation
                            List<TaskResponseDTO> list = controller.getTaskList();
                            Validation.checkEmptyList(list);

                            // Neu list co data thi moi cho nhap ID de xoa
                            System.out.print(Message.LABEL_ID);
                            int deleteId = Validation.getInt(sc.nextLine(), 1, Integer.MAX_VALUE);

                            controller.deleteTask(deleteId);

                        } catch (Exception e) {
                            // In loi "Danh sach trong" hoac "Khong tim thay ID" tai day
                            System.err.println(e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            // Check rong ngay tai Main cho dong bo voi Case 2
                            List<TaskResponseDTO> list = controller.getTaskList();
                            Validation.checkEmptyList(list);

                            // Vượt qua check rong thi moi goi hien thi
                            controller.displayTasks(list);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    case 4 -> {
                        sc.close();
                        return;
                    }
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
