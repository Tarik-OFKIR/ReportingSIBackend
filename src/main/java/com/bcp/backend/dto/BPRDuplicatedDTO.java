package com.bcp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BPRDuplicatedDTO {

    private Long id;
    private Long code;
    private int codeAgencyDuplicated;
    private Long bprId;

}
