import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = VirtualClassroomManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Virtual Classroom Manager");
        System.out.println("Commands: add_classroom, add_student, schedule_assignment, submit_assignment, list_classrooms, list_students, exit");

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
                    manager.addClassroom(parts[1]);
                    break;
                case "add_student":
                    String[] studentParts = parts[1].split(" ", 2);
                    int studentId = Integer.parseInt(studentParts[0]);
                    String className = studentParts[1];
                    manager.addStudent(studentId, className);
                    break;
                case "schedule_assignment":
                    String[] assignmentParts = parts[1].split(" ", 2);
                    String assignmentClassName = assignmentParts[0];
                    String assignmentDetails = assignmentParts[1];
                    manager.scheduleAssignment(assignmentClassName, assignmentDetails);
                    break;
                case "submit_assignment":
                    String[] submissionParts = parts[1].split(" ", 3);
                    int submitStudentId = Integer.parseInt(submissionParts[0]);
                    String submitClassName = submissionParts[1];
                    String submitAssignmentDetails = submissionParts[2];
                    manager.submitAssignment(submitStudentId, submitClassName, submitAssignmentDetails);
                    break;
                case "list_classrooms":
                    manager.listClassrooms();
                    break;
                case "list_students":
                    manager.listStudents(parts[1]);
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        } catch (Exception e) {
            CustomLogger.logError("An error occurred while processing command: " + command, e);
            System.out.println("An error occurred. Please check the command and try again.");
        }

        handleUserInput(manager, scanner); // Recursive call
    }
}
