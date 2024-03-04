package djh.learn.task.controller;

import djh.learn.task.model.Task;
import djh.learn.task.repo.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.post;


@RunWith(SpringRunner.class)
@SpringBootTest
class TaskRepoTest {


    @Autowired
    private TaskRepo taskRepo;

    private Task task;
    @BeforeEach
    public void setupTestData(){
        // Given : Setup object or precondition
        task = new Task("Read Aws","Read aws using Udemy course","To Do");

    }

    // JUnit Test for save employee operation
    @Test
    @DisplayName("JUnit test for creating Task")
    public void createTask(){
        Task savedTask = taskRepo.save(task);
        assertThat(savedTask.getTitle()).isEqualTo(task.getTitle());

    }

    @Test
    @DisplayName("JUnit test for updating Task")
    public void updateTask(){
        Task obtainedTask = taskRepo.findById(12).orElse(null);
        obtainedTask.setTitle("UpdatedTask");
        Task savedTask = taskRepo.save(obtainedTask);
        assertThat(savedTask.getTitle()).isEqualTo(obtainedTask.getTitle());

    }

    @Test
    @DisplayName("JUnit test for fetching task by id")
    public void getTask(){
        Task obtainedTask = taskRepo.findById(12).orElse(null);
        assertThat(obtainedTask.getTitle()).isEqualTo(task.getTitle());
    }

    @Test
    @DisplayName("JUnit test for fetching all the task")
    public void getAllTasks(){
        List<Task> obtainedTask = taskRepo.findAll();
        assertThat(obtainedTask.size()).isNotEqualTo(0);
    }



}