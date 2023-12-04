package com.threerive.taskmanagement.mapper;

import com.threerive.taskmanagement.dto.request.AddTaskRequest;
import com.threerive.taskmanagement.dto.request.UpdateTaskRequest;
import com.threerive.taskmanagement.entity.Task;

public class DtoToEntityMapper {

  public static Task mapper(AddTaskRequest task) {
    return Task.builder().name(task.getName()).description(task.getDescription()).build();
  }

  public static Task mapper(UpdateTaskRequest task) {
    return Task.builder()
        .id(task.getId())
        .name(task.getName())
        .description(task.getDescription())
        .build();
  }
}
