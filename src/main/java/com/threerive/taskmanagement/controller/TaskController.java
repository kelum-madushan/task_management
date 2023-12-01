package com.threerive.taskmanagement.controller;

import com.threerive.taskmanagement.dto.request.AddTaskRequest;
import com.threerive.taskmanagement.dto.response.GenericResponse;
import com.threerive.taskmanagement.dto.request.UpdateTaskRequest;
import com.threerive.taskmanagement.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @PostMapping
    GenericResponse addTask(@RequestBody AddTaskRequest request) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.OK);
        response.setResponse(taskService.addTask(request));
        logger.info("Get all Credit Note. response: {}", response);
        return response;
    }

    @PutMapping
    GenericResponse updateTask(@RequestBody UpdateTaskRequest request) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.OK);
        response.setResponse(taskService.updateTask(request));
        logger.info("Get all Credit Note. response: {}", response);
        return response;
    }

    @DeleteMapping("/{id}")
    GenericResponse deleteTask(@PathVariable("id") Integer id) {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.OK);
        taskService.deleteTask(id);
        logger.info("Get all Credit Note. response: {}", response);
        return response;
    }

    @GetMapping
    GenericResponse getTaskList() {
        GenericResponse response = new GenericResponse();
        response.setStatus(HttpStatus.OK);
        response.setResponse(taskService.getTaskList());
        logger.info("Get all Credit Note. response: {}", response);
        return response;
    }

}
