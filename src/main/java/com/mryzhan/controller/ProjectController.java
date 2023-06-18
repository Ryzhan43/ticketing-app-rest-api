package com.mryzhan.controller;

import com.mryzhan.dto.ProjectDTO;
import com.mryzhan.dto.UserDTO;
import com.mryzhan.entity.Project;
import com.mryzhan.entity.ResponseWrapper;
import com.mryzhan.service.ProjectService;
import com.mryzhan.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;


    public ProjectController(ProjectController projectController, ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllProject() {
        List<ProjectDTO> projects = projectService.listAllProjects();
        return ResponseEntity.ok(new ResponseWrapper("All users were retrieved", projects, HttpStatus.OK));
    }

    @GetMapping("/{projectCode}")
    public ResponseEntity<ResponseWrapper> getUserByUserName(@PathVariable("projectCode") String projectCode){
        ProjectDTO projectDTO = projectService.getByProjectCode(projectCode);
        return ResponseEntity.ok(new ResponseWrapper("Project is successfully retrieved",projectDTO,HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProject(@RequestBody ProjectDTO project) {
        projectService.save(project);
        return ResponseEntity.ok(new ResponseWrapper("New user was successfully created", project, HttpStatus.CREATED));
    }


    @PutMapping
    public ResponseEntity<ResponseWrapper> updateUser(@RequestBody ProjectDTO projectDTO){
        projectService.update(projectDTO);
        return ResponseEntity.ok(new ResponseWrapper("User is successfully updated", projectDTO, HttpStatus.OK));
    }

    @DeleteMapping("/{projectCode}")
    public ResponseEntity<ResponseWrapper> deleteUser(@PathVariable("projectCode") String user){
        userService.deleteByUserName(user);
//        return ResponseEntity.ok(new ResponseWrapper("User is successfully deleted", HttpStatus.OK));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseWrapper("User is successfully deleted", HttpStatus.OK));
    }


}
