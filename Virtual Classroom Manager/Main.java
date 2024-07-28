import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = VirtualClassroomManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Virtual Classroom Manager");
        System.out.println("Commands: add_classroom, remove_classroom, add_student, schedule_assignment, submit_assignment, assign_marks, list_classrooms, list_students, list_submitted_students, exit");

        handleUserInput(manager, scanner);
        scanner.close();
    }

    private static void handleUserInput(VirtualClassroomManager manager, Scanner scanner) {
        System.out.print("> ");
        String command = scanner.nextLine();
        String[] parts = command.split(" ", 2);

        try {
            switch (parts[0]) {
                case "exit":
                    return;
                case "add_classroom":
                    if (parts.length < 2) throw new IllegalArgumentException("Invalid format. Correct format: add_classroom <class_name>");
                    manager.addClassroom(parts[1]);
                    break;
                case "remove_classroom":
                    if (parts.length < 2) throw new IllegalArgumentException("Invalid format. Correct format: remove_classroom <class_name>");
                    manager.removeClassroom(parts[1]);
                    break;
                case "add_student":
                    if (parts.length < 2) throw new IllegalArgumentException("Invalid format. Correct format: add_student <student_id> <class_name>");
                    String[] studentParts = parts[1].split(" ", 2);
                    if (studentParts.length < 2) throw new IllegalArgumentException("Invalid format. Correct format: add_student <student_id> <class_name>");
                    int studentId = Integer.parseInt(studentParts[0]);
                    String className = studentParts[1];
                    manager.addStudent(studentId, className);
                    break;
                case "schedule_assignment":
                    handleScheduleAssignment(manager, parts[1]);
                    break;
                case "submit_assignment":
                    handleSubmitAssignment(manager, parts[1]);
                    break;
                case "assign_marks":
                    handleAssignMarks(manager, parts[1], scanner);
                    break;
                case "list_classrooms":
                    manager.listClassrooms();
                    break;
                case "list_students":
                    if (parts.length < 2) throw new IllegalArgumentException("Invalid format. Correct format: list_students <class_name>");
                    manager.listStudents(parts[1]);
                    break;
                case "list_submitted_students":
                    handleListSubmittedStudents(manager, parts[1]);
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred. Please check the command and try again.");
        }

        handleUserInput(manager, scanner);
    }

    private static void handleScheduleAssignment(VirtualClassroomManager manager, String input) {
        String[] parts = input.split(" ", 3);
        if (parts.length < 3) {
            System.out.println("Invalid format. Correct format: schedule_assignment <class_name> <assignment_details> <deadline(yyyy-mm-dd)>");
            return;
        }
        String className = parts[0];
        String details = parts[1];
        try {
            LocalDate deadline = LocalDate.parse(parts[2]);
            manager.scheduleAssignment(className, details, deadline);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Correct format: schedule_assignment <class_name> <assignment_details> <deadline(yyyy-mm-dd)>");
        }
    }

    private static void handleSubmitAssignment(VirtualClassroomManager manager, String input) {
        String[] parts = input.split(" ", 3);
        if (parts.length < 3) {
            System.out.println("Invalid format. Correct format: submit_assignment <student_id> <class_name> <assignment_details>");
            return;
        }
        int studentId;
        try {
            studentId = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid student_id format. Correct format: submit_assignment <student_id> <class_name> <assignment_details>");
            return;
        }
        String className = parts[1];
        String details = parts[2];
        manager.submitAssignment(studentId, className, details);
    }

    private static void handleAssignMarks(VirtualClassroomManager manager, String input, Scanner scanner) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Invalid format. Correct format: assign_marks <class_name> <assignment_details>");
            return;
        }
        String className = parts[0];
        String details = parts[1];
        manager.assignMarks(className, details, scanner);
    }

    private static void handleListSubmittedStudents(VirtualClassroomManager manager, String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Invalid format. Correct format: list_submitted_students <class_name> <assignment_details>");
            return;
        }
        String className = parts[0];
        String assignmentDetails = parts[1];
        manager.listSubmittedStudents(className, assignmentDetails);
    }
}
