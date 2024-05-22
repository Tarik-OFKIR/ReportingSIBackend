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
public class BprDTO {

    private Long code;
    private String name;
    private String address;
//    private List<BPRDuplicatedDTO> bprDuplicatedDTOS;
//    private List<AgencyDTO> agencyDTOS;
//    private List<SuccursaleDTO> succursaleDTOS;

}
