package com.threerive.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTaskRequest {
  @NotNull
  private String name;
  @NotNull
  private String description;
}
