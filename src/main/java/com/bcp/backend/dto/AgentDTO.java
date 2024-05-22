package com.bcp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class AgentDTO {

    private String registrationNumber;
    private String name;
    private Long agencyCode;
    private List<String> profilesNames;



}
