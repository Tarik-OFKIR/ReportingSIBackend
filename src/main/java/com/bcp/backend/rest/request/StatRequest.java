package com.bcp.backend.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StatRequest {
    private String applicationName;
    private String statName;
    private String extension;
    private String startDate;
    private String endDate;
}


