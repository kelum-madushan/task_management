package com.threerive.taskmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddTaskRequest {
  @NotNull
  private String name;
  private String description;
}
