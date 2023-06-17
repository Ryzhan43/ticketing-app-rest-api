package com.mryzhan.service;

import com.mryzhan.dto.ProjectDTO;
import com.mryzhan.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProjectService {

    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProjects();
    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(String code);
    void complete(String projectCode);

    List<ProjectDTO> listAllProjectDetails();

    List<ProjectDTO> readAllByAssignedManager(User assignedManager);
}
