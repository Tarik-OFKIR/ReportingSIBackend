package com.bcp.backend.dto;

import com.bcp.backend.configuration.enums.Extension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StateDTO {

    private Long id;
    private String name;
    private  String description;
    private String extension;
    private Long applicationId;

}
