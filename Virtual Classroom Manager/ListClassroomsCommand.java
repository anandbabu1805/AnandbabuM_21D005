public class ListClassroomsCommand implements Command {
    private VirtualClassroomManager manager;

    public ListClassroomsCommand(VirtualClassroomManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.listClassrooms();
    }
}
