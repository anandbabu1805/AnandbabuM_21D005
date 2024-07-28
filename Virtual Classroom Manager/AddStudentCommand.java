public class AddStudentCommand implements Command {
    private VirtualClassroomManager manager;
    private int studentId;
    private String className;

    public AddStudentCommand(VirtualClassroomManager manager, int studentId, String className) {
        this.manager = manager;
        this.studentId = studentId;
        this.className = className;
    }

    @Override
    public void execute() {
        manager.addStudent(studentId, className);
    }
}
