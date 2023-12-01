package com.threerive.taskmanagement.service.impl;

import com.threerive.taskmanagement.dto.PaginationDto;
import com.threerive.taskmanagement.dto.request.AddTaskRequest;
import com.threerive.taskmanagement.dto.TaskDto;
import com.threerive.taskmanagement.dto.request.UpdateTaskRequest;
import com.threerive.taskmanagement.dto.response.TaskPageResponse;
import com.threerive.taskmanagement.entity.Task;
import com.threerive.taskmanagement.mapper.DtoToEntityMapper;
import com.threerive.taskmanagement.mapper.EntityToDtoMapper;
import com.threerive.taskmanagement.repository.TaskRepository;
import com.threerive.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskDto addTask(AddTaskRequest request) {
        Task task = Task.builder().name(request.getName()).description(request.getDescription()).build();
        Task task1 = taskRepository.save(task);
        return EntityToDtoMapper.mapper(task1);
    }

    @Override
    public TaskDto updateTask(UpdateTaskRequest request) {
        Task task = taskRepository.getById(request.getId());
        Task task1 = taskRepository.save(DtoToEntityMapper.mapper(request));
        return EntityToDtoMapper.mapper(task1);
    }

    @Override
    public void deleteTask(Integer id) {
        Task task = taskRepository.getById(id);
        task.setStatus(2);
        taskRepository.save(task);
    }

    @Override
    public TaskPageResponse getTaskList(PaginationDto paginationDto) {
        TaskPageResponse taskPageResponse = new TaskPageResponse();
        List<TaskDto> list = new ArrayList<>();
        Pageable paging = PageRequest.of(paginationDto.getPageNo(), paginationDto.getPageSize(), Sort.by("id").descending());
        Page<Task> tasks = taskRepository.findAll(paging);
        if (tasks.hasContent()) {
            tasks.get().forEach(task -> list.add(TaskDto.builder().name(task.getName()).id(task.getId()).description(task.getDescription()).status(task.getStatus()).build()));
        }
        taskPageResponse.setList(list);
        taskPageResponse.setCount(tasks.getTotalElements());
        return taskPageResponse;
    }


}
