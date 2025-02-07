package duke.command;

public abstract class Command {
    public enum CommandType {
        AddTaskCommand, ExitProgramCommand, PrintListCommand, UpdateTaskStatusCommand, DeleteTaskCommand,
        FindTaskCommand
    }

    private CommandType type;

    public Command(CommandType type) {
        setType(type);
    }

    public CommandType getType() {
        return type;
    }

    private void setType(CommandType type) {
        this.type = type;
    }

}
