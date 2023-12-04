package com.threerive.taskmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UpdateTaskRequest {
  @NotNull
  private Integer id;
  @NotNull
  private String name;
  private String description;
}
