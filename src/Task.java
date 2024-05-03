/**
 * Your name: Daniel Drummond
 * Date: 04/21/2024
 * Assignment CIS319 Project - Task Manager App
 * 
 * Description: This class defines a Task object with properties for title, description, deadline, priority, and status.
 */

 public class Task {
    private String title;
    private String description;
    private String deadline;
    private Priority priority;
    private Status status;

    public Task(String title, String description, String deadline, Priority priority, Status status) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}