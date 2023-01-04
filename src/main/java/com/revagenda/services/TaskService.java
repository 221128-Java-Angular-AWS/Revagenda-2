package com.revagenda.services;

import com.revagenda.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository taskRepo;

    @Autowired
    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

}
