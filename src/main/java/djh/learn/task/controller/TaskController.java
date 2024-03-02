package djh.learn.task.controller;

import djh.learn.task.model.Task;
import djh.learn.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(method = RequestMethod.GET,value = "/tasks")
@RestController
public class TaskController {
    @Autowired
    private TaskService _taskService;

    @PostMapping ("/createTask")
    public Task createTask(@RequestBody Task task){
        return _taskService.createTask(task);
    }
    @GetMapping("/")
    public List<Task> getAllTasks(){
        return _taskService.getAllTasks();
    }
    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task){
        Task oldTask = _taskService.getTaskById(task.getId());
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setStatus(task.getStatus());
        return _taskService.updateTask(oldTask);
    }
    @GetMapping("/getTask/{taskId}")
    public Task getTaskById(@PathVariable Integer taskId){
        return _taskService.getTaskById(taskId);
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public void deleteTask(int taskId){
        _taskService.deleteTask(taskId);
    }
}
