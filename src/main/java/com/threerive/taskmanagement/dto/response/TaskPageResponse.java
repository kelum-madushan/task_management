package com.threerive.taskmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.threerive.taskmanagement.dto.TaskDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskPageResponse {
  private Long count;
  private List<TaskDto> list;
}
