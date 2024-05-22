package com.bcp.backend.services.concretions;

import com.bcp.backend.exception.AgencyNotFoundException;
import com.bcp.backend.exception.BprDuplicatedNotExicetException;
import com.bcp.backend.exception.DirectoryNotExitException;
import com.bcp.backend.exception.ExtensionNotExicetException;
import com.bcp.backend.model.Agency;
import com.bcp.backend.model.BprDuplicated;
import com.bcp.backend.repository.AgencyRepository;
import com.bcp.backend.repository.BprDuplicatedRepository;
import com.bcp.backend.rest.request.StatRequest;
import com.bcp.backend.rest.response.StateResponse;
import com.bcp.backend.services.abstractions.ReportingSIService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class ReportingSIServiceImpl implements ReportingSIService {
    AgencyRepository agencyRepository;
    BprDuplicatedRepository bprDuplicatedRepository;
    private static final List<String> DATE_PATTERNS = List.of(
            "yyyy-MM-dd", "dd/MM/yyyy", "MM-dd-yyyy", "yyyyMMdd", "dd-MM-yyyy"
    );
    @Override
    public String generateCodeAgency(Long idAgency) throws AgencyNotFoundException, BprDuplicatedNotExicetException {
        String code;
        Agency agency = agencyRepository.findById(idAgency).orElseThrow(() -> new AgencyNotFoundException("Agency not found"));
        if (String.valueOf(agency.getCode()).length() >= 2) {
            //I need to search about bp with agenceduplicated = 0
            BprDuplicated bprDuplicated = bprDuplicatedRepository
                    .findByBprCode(agency.getBpr().getCode())
                    .stream()
                    .filter(bp -> bp.getCodeAgencyDuplicated() == 0)
                    .findFirst().orElseThrow(() -> new BprDuplicatedNotExicetException("Bpr Duplicated not found"));
            code = String.valueOf(bprDuplicated.getCode()) + String.format("%02d", agency.getCode().intValue() % 100);
        } else {
            //I need to search about bp with quadruplicated =! 0
            BprDuplicated bprDuplicated = bprDuplicatedRepository
                    .findByBprCode(agency.getBpr().getCode())
                    .stream()
                    .filter(bp -> bp.getCodeAgencyDuplicated() == Character.getNumericValue(String.valueOf(agency.getCode()).charAt(0)))
                    .findFirst().orElseThrow(() -> new BprDuplicatedNotExicetException("Bpr Duplicated not found"));
            code = String.valueOf(bprDuplicated.getCode()) + String.format("%02d", agency.getCode().intValue() % 100);
        }
        return code;
    }

    @Override
    public List<StateResponse> files(StatRequest statRequest) throws DirectoryNotExitException, ExtensionNotExicetException{

        String path = "D:\\" + statRequest.getApplicationName() + "\\" + statRequest.getStatName();
        Date startDate = extractDate(statRequest.getStartDate());
        Date endDate = extractDate(statRequest.getEndDate());
        String extension = statRequest.getExtension();

        List<String> filteredFiles = List.of(getStrings(startDate, endDate, path, extension));
        if (filteredFiles.isEmpty()) {
            throw new DirectoryNotExitException("The directory does not exist or an I/O error occurred.");
        }
        List<StateResponse> stateResponse = new ArrayList<>();
        for (String file : filteredFiles) {
            stateResponse.add(StateResponse.builder()
                    .fileName(file)
                    .fileExtension(file.substring(file.lastIndexOf('.') + 1))
                    .build());
        }

        return stateResponse;
    }

    private static String[] getStrings(Date startDate, Date endDate, String path, String extinction) throws ExtensionNotExicetException {
        List<String> dateFormats = Arrays.asList("dd-MM-yyyy", "ddMMyyyy", "dd/MM/yyyy", "MM-yyyy", "yyyy");

        // Create a FilenameFilter using a lambda expression
        FilenameFilter filter = (dir, name) -> {
            if (name.toLowerCase().endsWith("." + extinction.toLowerCase())) {
                String fileDateStr = extractDateFromFileName(name, dir.getName());
                Date fileDate = parseDate(fileDateStr, dateFormats);
                return fileDate != null && !fileDate.before(startDate) && !fileDate.after(endDate);
            }
            return false;
        };

        // List and filter files
        File directory = new File(path);
        String[] filteredFiles = directory.list(filter);

        // Check if any files were found with the specified extension
        if (filteredFiles == null || filteredFiles.length == 0) {
            throw new ExtensionNotExicetException("No files with the specified extension were found in the directory.");
        }

        return filteredFiles;
    }

    public static Date extractDate(String dateString) {
        for (String pattern : DATE_PATTERNS) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                dateFormat.setLenient(false); // Ensures strict parsing
                return dateFormat.parse(dateString);
            } catch (ParseException e) {
                // Continue to the next pattern if parsing fails
            }
        }
        throw new IllegalArgumentException("Date format not recognized for: " + dateString);
    }

    private static Date parseDate(String dateString, List<String> patterns) {
        for (String pattern : patterns) {
            try {
                return new SimpleDateFormat(pattern).parse(dateString);
            } catch (ParseException ignored) {
            }
        }
        return null;
    }

    private static String extractDateFromFileName(String fileName, String folderName) {
        String datePart = fileName.substring(folderName.length() + 1, fileName.lastIndexOf('.')).trim();
        // Remove potential extension from the date part
        if (datePart.contains(" ")) {
            datePart = datePart.split(" ")[1];
        }
        return datePart;
    }
}



