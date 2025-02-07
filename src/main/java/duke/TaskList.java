package duke;

import duke.exception.DukeException;
import duke.exception.DukeExceptionCause;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Represents a list which contains all the tasks the user wants to store.
 * The TaskList object contains methods to allow the user to search, add, update and delete tasks from the list.
 */

public class TaskList {
    private ArrayList<Task> listOfTasks;

    public TaskList(ArrayList<Task> listOfTasks) {
        setListOfTasks(listOfTasks);
    }

    public TaskList() {
        ArrayList<Task> listOfTasks = new ArrayList<>();
        setListOfTasks(listOfTasks);
    }

    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    private void setListOfTasks(ArrayList<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public void addTask(Task newTask) {
        getListOfTasks().add(newTask);
    }

    /**
     * Returns the acknowledgement message containing the name and type of the task being updated
     * as well as the updated status of the task.
     * The task status of a task is whether the task is done.
     *
     * @param taskIndex  The index of the task that the user wants to update within the task list.
     * @param isTaskDone The new status of the task whereby true represents that the task is done and false
     *                   represents that the task is not yet done.
     * @return An acknowledgement message informing the user that the task's status has been updated as well as the
     * task's new status.
     * @throws DukeException if the index of the task to be updated is out of range.
     */
    public String updateTask(int taskIndex, boolean isTaskDone) throws DukeException {
        String acknowledgementMessage;
        if (taskIndex >= getListSize() || taskIndex < 0) {
            throw new DukeException(DukeExceptionCause.TaskIndexOutOfRange);
        }
        Task taskToUpdate = getListOfTasks().get(taskIndex);
        if (isTaskDone) {
            taskToUpdate.setDone(true);
        } else {
            taskToUpdate.setDone(false);
        }
        acknowledgementMessage = taskToUpdate.getTaskUpdatedMessage();
        return acknowledgementMessage;
    }

    public int getListSize() {
        return listOfTasks.size();
    }

    public Task getTask(int taskIndex) {
        return getListOfTasks().get(taskIndex);
    }

    public String removeTask(int taskIndex) {
        Task taskToRemove = getListOfTasks().get(taskIndex);
        String acknowledgementMessage = taskToRemove.removeTaskMessage();
        getListOfTasks().remove(taskIndex);
        return acknowledgementMessage;
    }

    public TaskList findTasks(String keyWord) {
        TaskList listOfMatchingTasks = new TaskList();
        String taskDescription;
        Task currentTask;
        for (int i = 0; i < getListSize(); i++) {
            currentTask = listOfTasks.get(i);
            taskDescription = currentTask.getTaskDescription();
            if (taskDescription.contains(keyWord)) {
                listOfMatchingTasks.addTask(currentTask);
            }
        }
        return listOfMatchingTasks;
    }
}
