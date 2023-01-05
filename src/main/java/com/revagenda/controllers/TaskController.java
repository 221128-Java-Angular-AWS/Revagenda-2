package com.revagenda.controllers;

import com.revagenda.models.Task;
import com.revagenda.models.User;
import com.revagenda.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


/*
GET - all tasks for user that are not completed
POST - new task
PUT - update a tsk - probably to mark it complete
DELETE - delete, or "delete" a task
 */
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        System.out.println("Task Controller constructor...");
        this.taskService = taskService;
    }

    @GetMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Task> getTasksForUserByUserId(@PathVariable Integer userId) {
        return taskService.testOurFindByUserIdMethod(userId);
    }

    @PostMapping(value = "/new/{userId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Task createNewTask(@RequestBody Task newTask, @PathVariable Integer userId) {
        return taskService.createNewTask(newTask, userId);
    }


    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }


    @DeleteMapping(value = "/{taskId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTask(@PathVariable Integer taskId) {
        taskService.deleteTask(taskId);
    }

}
