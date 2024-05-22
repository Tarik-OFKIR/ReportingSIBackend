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
public class ApplicationDTO {

    private Long id;
    private String code;
    private String name;
//    private List<StateDTO> stateDTOS;
//    private List<AgencyDTO> agencyDTOS;




}
