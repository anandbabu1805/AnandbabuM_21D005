public class AddClassroomCommand implements Command {
    private VirtualClassroomManager manager;
    private String className;

    public AddClassroomCommand(VirtualClassroomManager manager, String className) {
        this.manager = manager;
        this.className = className;
    }

    @Override
    public void execute() {
        manager.addClassroom(className);
    }
}

