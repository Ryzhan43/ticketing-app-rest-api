package com.mryzhan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mryzhan.enums.Status;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectDTO {

    private Long id;
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int completeTaskCounts;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int unfinishedTaskCounts;

}