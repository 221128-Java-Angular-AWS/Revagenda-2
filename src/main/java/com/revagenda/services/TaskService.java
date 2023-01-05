package com.revagenda.services;

import com.revagenda.models.Task;
import com.revagenda.models.User;
import com.revagenda.repositories.TaskRepository;
import com.revagenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepo;
    private UserRepository userRepo;

    @Autowired
    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public List<Task> testOurFindByUserIdMethod(Integer userId) {
        return taskRepo.findTaskByUserId(userId);
    }

    public Task createNewTask(Task task, Integer userId) {
        User user = userRepo.findById(userId).orElseThrow();
        task.setUser(user);
        return taskRepo.save(task);
    }

    public Task updateTask(Task changes) {
        Task task = taskRepo.findById(changes.getId()).orElseThrow();
        task.setTitle(changes.getTitle());
        task.setDescription(changes.getDescription());
        task.setCompleted(changes.getCompleted());
        task.setUser(userRepo.findById(task.getUser().getId()).orElseThrow());
        return taskRepo.save(task);
    }

    public void deleteTask(Integer taskId) {
        taskRepo.deleteById(taskId);
    }

//    public List<Task> testOurJpqlMethod(Integer userId) {
//        return taskRepo.findByUserIdJpql(userId);
//    }

}
