package com.threerive.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationDto {
  @NotNull
  @PositiveOrZero
  private Integer pageNo;

  @NotNull
  @Positive
  private Integer pageSize;
}
