package com.threerive.taskmanagement.repository;

import com.threerive.taskmanagement.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  Optional<Task> getByName(String name);

  Page<Task> findAll(Pageable pageable);
}
