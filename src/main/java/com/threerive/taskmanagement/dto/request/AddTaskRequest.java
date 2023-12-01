package com.threerive.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTaskRequest {
    private String name;
    private String description;
}