package com.mryzhan.controller;

import com.mryzhan.dto.ProjectDTO;
import com.mryzhan.entity.ResponseWrapper;
import com.mryzhan.service.ProjectService;
import com.mryzhan.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    @RolesAllowed({"Admin", "Manager"})
    public ResponseEntity<ResponseWrapper> listAllProject() {
        List<ProjectDTO> projects = projectService.listAllProjects();
        return ResponseEntity.ok(new ResponseWrapper("All users were successfully retrieved", projects, HttpStatus.OK));
    }

    @GetMapping("/{projectCode}")
    @RolesAllowed("Manager")
    public ResponseEntity<ResponseWrapper> getUserByUserName(@PathVariable("projectCode") String projectCode){
        ProjectDTO projectDTO = projectService.getByProjectCode(projectCode);
        return ResponseEntity.ok(new ResponseWrapper("Project is successfully retrieved",projectDTO,HttpStatus.OK));
    }

    @PostMapping
    @RolesAllowed("Manager")
    public ResponseEntity<ResponseWrapper> createProject(@RequestBody ProjectDTO project) {
        projectService.save(project);
        return ResponseEntity.ok(new ResponseWrapper("New user was successfully created", project, HttpStatus.CREATED));
    }


    @PutMapping
    @RolesAllowed("Manager")
    public ResponseEntity<ResponseWrapper> updateUser(@RequestBody ProjectDTO projectDTO){
        projectService.update(projectDTO);
        return ResponseEntity.ok(new ResponseWrapper("User is successfully updated", projectDTO, HttpStatus.OK));
    }

    @DeleteMapping("/{projectCode}")
    @RolesAllowed("Manager")
    public ResponseEntity<ResponseWrapper> deleteUser(@PathVariable("projectCode") String projectCode){
        projectService.delete(projectCode);
//        return ResponseEntity.ok(new ResponseWrapper("User is successfully deleted", HttpStatus.OK));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseWrapper("User is successfully deleted", HttpStatus.OK));
    }

    @GetMapping("/manager/project-status")
    @RolesAllowed("Manager")
    public ResponseEntity<ResponseWrapper> managerCompleteProject(){
        List<ProjectDTO> projects = projectService.listAllProjectDetails();
        return ResponseEntity.ok(new ResponseWrapper("Projects are successfully retrieved", projects, HttpStatus.OK));
    }

    @PutMapping("/manager/complete/{projectCode}")
    @RolesAllowed("Manager")
    public ResponseEntity<ResponseWrapper> managerCompleteProject(@PathVariable("projectCode") String code){
        projectService.complete(code);
        return ResponseEntity.ok(new ResponseWrapper("Project is successfully completed",HttpStatus.OK));
    }

}
