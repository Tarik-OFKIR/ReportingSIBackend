package com.bcp.backend.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StateResponse {
    private String fileName;
    private String fileExtension;
    private Long fileSize;
}
