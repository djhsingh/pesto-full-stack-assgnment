package djh.learn.task.service;

import djh.learn.task.model.Task;
import djh.learn.task.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskImpl implements TaskService{

    @Autowired
    private TaskRepo _taskRepo;

    public Task createTask(Task task){
       return _taskRepo.save(task);
    }
    public List<Task> getAllTasks(){
        return _taskRepo.findAll();
    }
    public Task updateTask(Task task){
        return _taskRepo.save(task);
    }
    public Task getTaskById(int taskId){
        return _taskRepo.findById(taskId).orElse(null);
    }
    public void deleteTask(int taskId){
         _taskRepo.deleteById(taskId);
    }
}
