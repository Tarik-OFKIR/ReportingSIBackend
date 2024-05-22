package com.bcp.backend.dto;

import com.bcp.backend.configuration.enums.Preference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProfileDTO {
    private Long id;
    private String name;
    private String description;
    private String preference;
//    private List<AgentDTO> agentDTOS;
//    private List<StateDTO> stateDTOS;


}
