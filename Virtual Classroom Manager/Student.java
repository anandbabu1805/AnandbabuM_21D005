import java.util.*;

public class Student {
    private int id;
    private Map<Assignment, Boolean> assignments;
    private Map<Assignment, Integer> marks;

    public Student(int id) {
        this.id = id;
        this.assignments = new HashMap<>();
        this.marks = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void submitAssignment(Assignment assignment, boolean isLate) {
        assignments.put(assignment, isLate);
    }

    public boolean hasSubmitted(Assignment assignment) {
        return assignments.containsKey(assignment);
    }

    public boolean isLateSubmission(Assignment assignment) {
        return assignments.getOrDefault(assignment, false);
    }

    public void assignMarks(Assignment assignment, int marks) {
        this.marks.put(assignment, marks);
    }

    public Integer getMarks(Assignment assignment) {
        return marks.get(assignment);
    }
}
