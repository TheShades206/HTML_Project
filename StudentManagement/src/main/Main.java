package main;

import constants.CourseType;
import constants.Message;
import controller.StudentController;
import dto.StudentRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentController controller = new StudentController();

        while (true) {
            System.out.println(Message.MENU);
            int choice;

            // --- Nhập lựa chọn Menu ---
            while (true) {
                System.out.print(Message.INPUT_CHOICE);
                try {
                    choice = Validation.getChoice(sc.nextLine(), 1, 5);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            try {
                switch (choice) {
                    // ================= CREATE =================
                    case 1:
                        while (true) {
                            StudentRequestDTO dto = new StudentRequestDTO();
                            CourseType course;

                            // Nhập ID
                            while (true) {
                                System.out.print(Message.INPUT_ID);
                                try {
                                    dto.setId(Validation.getString(sc.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            // Nhập Name
                            while (true) {
                                System.out.print(Message.INPUT_NAME);
                                try {
                                    dto.setName(Validation.getString(sc.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            // Nhập Semester
                            while (true) {
                                System.out.print(Message.INPUT_SEMESTER);
                                try {
                                    dto.setSemester(Validation.getString(sc.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            // Nhập Course
                            while (true) {
                                System.out.print(Message.INPUT_COURSE);
                                try {
                                    course = Validation.validateCourse(sc.nextLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            dto.setCourse(course);

                            try {
                                controller.createStudent(dto);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            // Kiểm tra số lượng để hỏi Yes/No
                            if (!controller.isDatabaseLessThanTen()) {
                                String answer;
                                while (true) {
                                    System.out.print(Message.CONTINUE_CREATE);
                                    try {
                                        answer = Validation.validateYesNo(sc.nextLine());
                                        break;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                if (answer.equals("N")) {
                                    break;
                                }
                            }
                        }
                        break;

                    // ================= FIND AND SORT =================
                    case 2:
                        System.out.print(Message.INPUT_SEARCH_NAME);
                        controller.findAndSort(Validation.getString(sc.nextLine()));
                        break;

                    // ================= UPDATE / DELETE =================
                    case 3:
                        String id;
                        while (true) {
                            System.out.print(Message.INPUT_ID);
                            try {
                                id = Validation.getString(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        String action;
                        while (true) {
                            System.out.print(Message.UPDATE_OR_DELETE);
                            try {
                                action = Validation.validateUpdateDelete(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        if (action.equals("U")) {
                            StudentRequestDTO updateDto = new StudentRequestDTO();
                            updateDto.setId(id);

                            // Nhập Name mới
                            while (true) {
                                System.out.print(Message.INPUT_NAME);
                                try {
                                    updateDto.setName(Validation.getString(sc.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            // Nhập Semester mới
                            while (true) {
                                System.out.print(Message.INPUT_SEMESTER);
                                try {
                                    updateDto.setSemester(Validation.getString(sc.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            // Nhập Course mới
                            while (true) {
                                System.out.print(Message.INPUT_COURSE);
                                try {
                                    updateDto.setCourse(Validation.validateCourse(sc.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            controller.updateStudent(id, updateDto);
                            System.out.println(Message.UPDATE_SUCCESS);
                        } else {
                            controller.deleteStudent(id);
                            System.out.println(Message.DELETE_SUCCESS);
                        }
                        break;

                    case 4:
                        controller.report();
                        break;

                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
