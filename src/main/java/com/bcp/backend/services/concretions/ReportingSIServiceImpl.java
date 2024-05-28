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
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
@AllArgsConstructor
public class ReportingSIServiceImpl implements ReportingSIService {
    AgencyRepository agencyRepository;
    BprDuplicatedRepository bprDuplicatedRepository;
    private final Logger logger = LoggerFactory.getLogger(ReportingSIService.class);
//    private static final List<String> DATE_PATTERNS = List.of(
//            "yyyy-MM-dd", "dd/MM/yyyy", "MM-dd-yyyy", "yyyyMMdd", "dd-MM-yyyy"
//    );
    private static final List<String> DATE_FORMATS = Arrays.asList("dd-MM-yyyy", "ddMMyyyy", "dd/MM/yyyy", "MM-yyyy", "yyyy");
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


        // Create a FilenameFilter using a lambda expression
        FilenameFilter filter = (dir, name) -> {
            if (name.toLowerCase().endsWith("." + extinction.toLowerCase())) {
                String fileDateStr = extractDateFromFileName(name, dir.getName());
                Date fileDate = parseDate(fileDateStr, DATE_FORMATS);
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
        for (String pattern : DATE_FORMATS) {
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



    public void prepareFilesForDownload(ZipOutputStream zipOut, StatRequest statRequest) throws DirectoryNotExitException, ExtensionNotExicetException {

        System.setProperty("user.home", "D:");
        final String home = System.getProperty("user.home");
        final File directory = new File(home + File.separator + "app" + File.separator + "Balance BAM");
        logger.info("Home directory: {}", home);
        logger.info("Target directory: {}", directory);

        if (directory.exists() && directory.isDirectory()) {
            Date startDate = extractDate(statRequest.getStartDate());
            Date endDate = extractDate(statRequest.getEndDate());
            logger.info("Start date: {}", startDate);
            logger.info("End date: {}", endDate);
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                logger.info("Checking file: {}", file.getName());

                try (InputStream inputStream = Files.newInputStream(file.toPath())) {
                    if (file.getName().toLowerCase().endsWith("." + statRequest.getExtension())) {
//                        Date fileDate = new Date(file.lastModified());
                        Date fileDate = extractDateFromFileNameTest(file.getName(), DATE_FORMATS);
                        logger.info("File date: {}", fileDate);
                        if (fileDate != null && !fileDate.before(startDate) && !fileDate.after(endDate)) {
                            logger.info("Adding file: {}", file.getName());
                            ZipEntry zipEntry = new ZipEntry(file.getName());
                            zipOut.putNextEntry(zipEntry);
                            byte[] bytes = new byte[8192];
                            int length;
                            while ((length = inputStream.read(bytes)) >= 0) {
                                zipOut.write(bytes, 0, length);
                            }
                            zipOut.closeEntry();
                        } else {
                            logger.info("File {} is not in the date range", file.getName()+ " starting: "+startDate+" ending: "+endDate);
                        }
                    }

                } catch (IOException e) {
                    logger.error("Error adding file to zip: {}", file.getName(), e);
                }
            }
        } else {
            logger.error("Directory does not exist or is not a directory: {}", directory.getAbsolutePath());
        }
    }
    private Date extractDateFromFileNameTest(String fileName, List<String> dateFormats) {
        for (String format : dateFormats) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            String regex = format.replace("dd", "\\d{2}").replace("MM", "\\d{2}").replace("yyyy", "\\d{4}");
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileName);

            if (matcher.find()) {
                String dateStr = matcher.group();
                try {
                    return dateFormat.parse(dateStr);
                } catch (ParseException e) {
                    logger.warn("Failed to parse date: {}", dateStr, e);
                }
            }
        }
        return null;
    }
}



