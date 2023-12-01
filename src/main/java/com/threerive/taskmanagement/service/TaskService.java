package com.threerive.taskmanagement.service;

import com.threerive.taskmanagement.dto.PaginationDto;
import com.threerive.taskmanagement.dto.request.AddTaskRequest;
import com.threerive.taskmanagement.dto.TaskDto;
import com.threerive.taskmanagement.dto.request.UpdateTaskRequest;
import com.threerive.taskmanagement.dto.response.TaskPageResponse;
import com.threerive.taskmanagement.entity.Task;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {
    TaskDto addTask(AddTaskRequest request);

    TaskDto updateTask(UpdateTaskRequest request);

    void deleteTask(Integer id);

    TaskPageResponse getTaskList(PaginationDto paginationDto);
}
