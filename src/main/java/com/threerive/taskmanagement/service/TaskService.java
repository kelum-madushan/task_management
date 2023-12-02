package com.threerive.taskmanagement.service;

import com.threerive.taskmanagement.dto.PaginationDto;
import com.threerive.taskmanagement.dto.request.AddTaskRequest;
import com.threerive.taskmanagement.dto.TaskDto;
import com.threerive.taskmanagement.dto.request.UpdateTaskRequest;
import com.threerive.taskmanagement.dto.response.TaskPageResponse;

public interface TaskService {
  TaskDto addTask(AddTaskRequest request);

  TaskDto updateTask(UpdateTaskRequest request);

  void deleteTask(Integer id);

  TaskPageResponse getTaskList(PaginationDto paginationDto);
}
