package com.threerive.taskmanagement.service.impl;

import com.threerive.taskmanagement.dto.request.AddTaskRequest;
import com.threerive.taskmanagement.dto.TaskDto;
import com.threerive.taskmanagement.dto.request.UpdateTaskRequest;
import com.threerive.taskmanagement.entity.Task;
import com.threerive.taskmanagement.mapper.DtoToEntityMapper;
import com.threerive.taskmanagement.mapper.EntityToDtoMapper;
import com.threerive.taskmanagement.repository.TaskRepository;
import com.threerive.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskDto addTask(AddTaskRequest request) {
        Task task = Task.builder().name(request.getName()).description(request.getDescription()).build();
        Task task1= taskRepository.save(task);
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
    public Page<TaskDto> getTaskList() {
        return null;
    }



}
