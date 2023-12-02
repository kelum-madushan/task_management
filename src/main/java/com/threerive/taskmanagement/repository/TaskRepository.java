package com.threerive.taskmanagement.repository;

import com.threerive.taskmanagement.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  Task getById(Integer id);

  Page<Task> findAll(Pageable pageable);
}
