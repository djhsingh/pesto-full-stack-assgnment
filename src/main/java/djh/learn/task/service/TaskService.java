package djh.learn.task.service;

import djh.learn.task.model.Task;

import java.util.List;

public interface TaskService {
    public Task createTask(Task task);
    public List<Task> getAllTasks();
    public Task updateTask(Task task);
    public Task getTaskById(int taskId);
    public void deleteTask(int taskId);
}
