import java.util.*;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public Assignment findAssignmentByDetails(String details) {
        for (Assignment assignment : assignments) {
            if (assignment.getDetails().equals(details)) {
                return assignment;
            }
        }
        return null;
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}

