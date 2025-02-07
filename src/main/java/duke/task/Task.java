package duke.task;

public abstract class Task {
    private boolean isDone;
    private String taskName;
    private final String DONE_SYMBOL = "[X] ";
    private final String NOT_DONE_SYMBOL = "[ ] ";

    public String getDoneSymbol() {
        return DONE_SYMBOL;
    }

    public String getNotDoneSymbol() {
        return NOT_DONE_SYMBOL;
    }

    public Task(String taskName) {
        setDone(false);
        setTaskName(taskName);
    }

    public String getTaskInformation() {
        String taskNameAndStatus;
        if (isDone()) {
            taskNameAndStatus = getDoneSymbol();
        } else {
            taskNameAndStatus = getNotDoneSymbol();
        }
        taskNameAndStatus = taskNameAndStatus + getTaskName();
        return taskNameAndStatus;
    }

    public String getTaskDescription() {
        return getTaskName();
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getTaskUpdatedMessage() {
        String message;
        if (isDone()) {
            message = "\t Nice! I've marked this task as done:\n";
        } else {
            message = "\t OK, I've marked this task as not done yet:\n";
        }
        return message;
    }

    public String addTaskMessage() {
        String message = "\t Got it. I've added this task:\n";
        return message;
    }

    public String removeTaskMessage() {
        String acknowledgementMessage = "\t Noted. I've removed this task:\n";
        return acknowledgementMessage;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}
