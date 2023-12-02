package com.threerive.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {
  private Integer id;
  private String name;
  private String description;
  private Integer status;
}
