import java.time.LocalDate;

public class Assignment {
    private String details;
    private LocalDate deadline;

    public Assignment(String details, LocalDate deadline) {
        this.details = details;
        this.deadline = deadline;
    }

    public String getDetails() {
        return details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isDeadlineCrossed() {
        return LocalDate.now().isAfter(deadline);
    }
}
