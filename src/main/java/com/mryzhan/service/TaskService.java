package com.mryzhan.service;

import com.mryzhan.dto.ProjectDTO;
import com.mryzhan.dto.TaskDTO;
import com.mryzhan.entity.User;
import com.mryzhan.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    TaskDTO findById(Long id);
    List<TaskDTO> listAllTasks();
    void save(TaskDTO dto);
    void update(TaskDTO dto);
    void delete(Long id);
    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);

    void deleteByProject(ProjectDTO project);

    void completeByProject(ProjectDTO project);

    List<TaskDTO> listAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

    List<TaskDTO> listAllTasksByStatus(Status status);

    List<TaskDTO> readAllByAssignedEmployee(User assignedEmployee);

}
