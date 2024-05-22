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

public class SuccursaleDTO {
    private Long id;
    private String name;
    private Long code;
    private Long bprId;
//    private List<AgencyDTO> agencyDTOS;

}
