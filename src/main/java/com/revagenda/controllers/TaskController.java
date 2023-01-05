package com.revagenda.controllers;

import com.revagenda.models.Task;
import com.revagenda.models.User;
import com.revagenda.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


/**
 * This controller handles task resource requests. The @RestController annotation indicates this
 * is a Controller for component scanning as well as implying @ResponseBody on all methods.
 * The @RequestMapping annotation sets the path to this class as "/tasks"
 */
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    //we have this reference to hold the bean we depend on to do work
    private TaskService taskService;

    /*
    We autowire in dependencies here. This is constructor autowiring. Remember, constructor and
    setter wiring is good. But, field injection is bad. Never put @Autowired on a field, only on methods.
    This annotation tells Spring that when this constructor is invoked by the bean factory (or application context)
    that it should find a corresponding bean by type and pass it here to the constructor.
     */
    @Autowired
    public TaskController(TaskService taskService) {
        System.out.println("Task Controller constructor...");
        this.taskService = taskService;
    }

    /**
     * This method returns tasks associated with a user based on the given userId.
     * @param userId Path variable in the token .../tasks/{userId}
     * @return a List of task objects.
     */
    @GetMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Task> getTasksForUserByUserId(@PathVariable Integer userId) {
        return taskService.testOurFindByUserIdMethod(userId);
    }

    /**
     * This method POSTS a new task. The task JSON is de-serialized into a Task object. The
     * userId is given in a path variable so that we can associate this task with a user.
     * @param newTask - JSON representation of a new Task object
     * @param userId - integer user ID path variable from token ".../tasks/new/{userId}"
     * @return the resource representation of the newly created task
     */
    @PostMapping(value = "/new/{userId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Task createNewTask(@RequestBody Task newTask, @PathVariable Integer userId) {
        return taskService.createNewTask(newTask, userId);
    }

    /**
     * updateTask() modifies the persistent object by passing a resource representation
     * containing the new values for the Task object. The id is the only thing that cannot change.
     * @param task resource representation of a Task containing the new values to update the object
     * @return a current resource representation of the task that was changed.
     */
    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }


    /**
     * deleteTask() will delete a task from the database. Later we may
     * want to change this logic to just mark the row as inactive, rather than deleting it from the table.
     * @param taskId the taskId of the task to be deleted. Path variable found in token ".../tasks/{taskId}"
     */
    @DeleteMapping(value = "/{taskId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTask(@PathVariable Integer taskId) {
        taskService.deleteTask(taskId);
    }

}
