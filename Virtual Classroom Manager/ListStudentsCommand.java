public class ListStudentsCommand implements Command {
    private VirtualClassroomManager manager;
    private String className;

    public ListStudentsCommand(VirtualClassroomManager manager, String className) {
        this.manager = manager;
        this.className = className;
    }

    @Override
    public void execute() {
        manager.listStudents(className);
    }
}

