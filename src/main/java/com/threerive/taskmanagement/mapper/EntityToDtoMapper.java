package com.threerive.taskmanagement.mapper;

import com.threerive.taskmanagement.dto.TaskDto;
import com.threerive.taskmanagement.entity.Task;

public class EntityToDtoMapper {
  public static TaskDto mapper(Task task) {
    return TaskDto.builder()
        .id(task.getId())
        .name(task.getName())
        .description(task.getDescription())
        .build();
  }
}
