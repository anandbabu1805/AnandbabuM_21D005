import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private Map<Assignment, Boolean> assignmentStatus;

    public Student(int id) {
        this.id = id;
        this.assignmentStatus = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public Map<Assignment, Boolean> getAssignmentStatus() {
        return assignmentStatus;
    }

    public void submitAssignment(Assignment assignment) {
        assignmentStatus.put(assignment, true);
    }
}
