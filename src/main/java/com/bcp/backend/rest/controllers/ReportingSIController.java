package com.bcp.backend.rest.controllers;

import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;
import com.bcp.backend.exception.DirectoryNotExitException;
import com.bcp.backend.exception.ExtensionNotExicetException;
import com.bcp.backend.rest.request.StatRequest;
import com.bcp.backend.rest.response.StateResponse;
import com.bcp.backend.services.abstractions.ReportingSIService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.slf4j.Logger;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipOutputStream;

@RestController
@AllArgsConstructor
public class ReportingSIController {
    ReportingSIService reportingSIService;
    private final Logger logger = LoggerFactory.getLogger(ReportingSIController.class);
    @GetMapping("/generateCodeAgence/{id}")
    public String generateCodeAgency(@PathVariable Long id) throws AgencyNotFoundException, BprDuplicatedNotExicetException {
        return reportingSIService.generateCodeAgency(id);
    }

    @PostMapping("/folderPath")
    public List<StateResponse> extractFolderPath(@RequestBody StatRequest statRequest) throws DirectoryNotExitException, ExtensionNotExicetException {
        return reportingSIService.files(statRequest);
    }
    @PostMapping(value = "/download")
    public ResponseEntity<StreamingResponseBody> download(@RequestBody StatRequest statRequest,final HttpServletResponse response) {
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=sample.zip");

        StreamingResponseBody stream = out -> {
            try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
                logger.info("Preparing files for download");
                reportingSIService.prepareFilesForDownload(zipOut, statRequest);
                zipOut.finish(); // Ensure all entries are written to the stream
                logger.info("Files prepared successfully");
            } catch (IOException e) {
                logger.error("Error while preparing files for download", e);
            } catch (DirectoryNotExitException e) {
                throw new RuntimeException(e);
            } catch (ExtensionNotExicetException e) {
                throw new RuntimeException(e);
            }
        };

        return new ResponseEntity<>(stream, HttpStatus.OK);
    }
}
