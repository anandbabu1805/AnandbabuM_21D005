import java.time.LocalDate;
import java.util.*;

public class VirtualClassroomManager {
    private static VirtualClassroomManager instance;
    private Map<String, Classroom> classrooms;

    private VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public static VirtualClassroomManager getInstance() {
        if (instance == null) {
            instance = new VirtualClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            System.out.println("Classroom already exists.");
            return;
        }
        classrooms.put(name, new Classroom(name));
        System.out.println("Classroom " + name + " has been created.");
    }

    public void removeClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            System.out.println("Classroom not found.");
            return;
        }
        classrooms.remove(name);
        System.out.println("Classroom " + name + " has been removed.");
    }

    public void addStudent(int id, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        if (classroom.findStudentById(id) != null) {
            System.out.println("Student already enrolled.");
            return;
        }
        classroom.addStudent(new Student(id));
        System.out.println("Student " + id + " has been enrolled in " + className + ".");
    }

    public void scheduleAssignment(String className, String details, LocalDate deadline) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }

        Assignment existingAssignment = classroom.findAssignmentByDetails(details);
        if (existingAssignment != null) {
            System.out.println("Assignment already scheduled.");
            return;
        }

        classroom.addAssignment(new Assignment(details, deadline));
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void submitAssignment(int studentId, String className, String details) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        Student student = classroom.findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Assignment assignment = classroom.findAssignmentByDetails(details);
        if (assignment == null) {
            System.out.println("Assignment not found.");
            return;
        }
        if (student.hasSubmitted(assignment)) {
            System.out.println("Assignment already submitted by Student " + studentId + ".");
            return;
        }
        if (assignment.isDeadlineCrossed()) {
            System.out.println("No longer accepting assignments. The deadline has passed.");
            student.submitAssignment(assignment, true);
        } else {
            student.submitAssignment(assignment, false);
        }
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
    }

    public void assignMarks(String className, String details, Scanner scanner) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        Assignment assignment = classroom.findAssignmentByDetails(details);
        if (assignment == null) {
            System.out.println("Assignment not found.");
            return;
        }

        List<Student> students = classroom.getStudents();
        boolean anySubmission = false;

        for (Student student : students) {
            if (student.hasSubmitted(assignment)) {
                anySubmission = true;
                System.out.println("Enter marks for Student " + student.getId() + ": ");
                int marks = scanner.nextInt();
                scanner.nextLine(); // consume newline
                student.assignMarks(assignment, marks);
                System.out.println("Marks assigned to Student " + student.getId() + " for assignment in " + className + ".");
            }
        }

        if (!anySubmission) {
            System.out.println("No submissions found for this assignment.");
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("Classrooms:");
            for (String className : classrooms.keySet()) {
                System.out.println("- " + className);
            }
        }
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        List<Student> students = classroom.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + className + ".");
        } else {
            System.out.println("Students in " + className + ":");
            for (Student student : students) {
                System.out.println("- " + student.getId());
            }
        }
    }

    public void listSubmittedStudents(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found.");
            return;
        }
        Assignment assignment = classroom.findAssignmentByDetails(assignmentDetails);
        if (assignment == null) {
            System.out.println("Assignment not found.");
            return;
        }
        List<Student> students = classroom.getStudents();
        System.out.println("Students who submitted the assignment:");
        for (Student student : students) {
            if (student.hasSubmitted(assignment)) {
                String submissionStatus = student.isLateSubmission(assignment) ? " (Late Submission)" : "";
                String markStatus = student.getMarks(assignment) == null ? " (Marks not assigned)" : " (Marks: " + student.getMarks(assignment) + ")";
                System.out.println("- " + student.getId() + submissionStatus + markStatus);
            }
        }
        System.out.println("Students who did not submit the assignment:");
        for (Student student : students) {
            if (!student.hasSubmitted(assignment)) {
                System.out.println("- " + student.getId());
            }
        }
    }
}
