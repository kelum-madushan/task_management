package com.threerive.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {
  private Integer id;
  private String name;
  private String description;
  private Integer status;
}
