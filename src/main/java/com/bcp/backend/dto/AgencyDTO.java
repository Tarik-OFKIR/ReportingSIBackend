package com.bcp.backend.dto;

import com.bcp.backend.configuration.enums.AgencyType;
import com.bcp.backend.model.Agency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AgencyDTO {

    private Long code;
    private String name;
    private String address;
    private String type;
    private Long succursaleId;
    private Long bprId;
    //    private List<AgentDTO> agentDTOS;
    //    private List<ApplicationDTO> applicationDTOS;
}
