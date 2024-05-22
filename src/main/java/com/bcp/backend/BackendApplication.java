package com.bcp.backend;

import com.bcp.backend.configuration.enums.Extension;
import com.bcp.backend.configuration.enums.Preference;
import com.bcp.backend.configuration.utils.Constants;
import com.bcp.backend.dto.*;
import com.bcp.backend.exception.*;
import com.bcp.backend.services.abstractions.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AgentService agentService,
                            AgencyService agencyService,
                            ApplicationService applicationService,
                            ProfileService profileService,
                            StateService stateService,
                            BprService bprService,
                            SuccursaleService succursaleService
    ) {


        return args -> {
            // *************************************** BPR instantiation
//            IntStream.range(0, 15).forEach(i -> {
//                BprDTO bprDTO = new BprDTO();
//                bprDTO.setCode(Constants.BprCodeData[new Random().nextInt(Constants.BprCodeData.length)]);
//                bprDTO.setName(Constants.bprName[new Random().nextInt(Constants.bprName.length)]);
//                bprDTO.setAddress(Constants.barAddress[new Random().nextInt(Constants.barAddress.length)]);
//                bprService.addBpr(bprDTO);
//            });

            // *************************************** Succursale instantiation
            List<BprDTO> bprDTOS = bprService.getAllBpr();
//            bprDTOS.forEach(bpr -> {
//                        SuccursaleDTO succursale = new SuccursaleDTO();
//                        succursale.setCode(Constants.succursaleCodeData[new Random().nextInt(Constants.succursaleCodeData.length)]);
//                        succursale.setName(Constants.bprName[new Random().nextInt(Constants.bprName.length)]);
//                        succursale.setBprId(bpr.getCode());
//                        try {
//                            succursaleService.addSuccursale(succursale, bpr.getCode());
//                        } catch (BprNotFoundException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//            );
            //******************************* Agency instantiation
//            bprDTOS.forEach(bpr -> {
//                        List<SuccursaleDTO> succursaleDTOS;
//                        try {
//                            succursaleDTOS = succursaleService.getBprSuccursales(bpr.getCode());
//                        } catch (BprNotFoundException e) {
//                            throw new RuntimeException(e);
//                        }
//                        succursaleDTOS.forEach(succursale -> {
//                                    AgencyDTO agency = new AgencyDTO();
//                                    agency.setCode(Constants.agencyCode[new Random().nextInt(Constants.agencyCode.length)]);
//                                    agency.setName(Constants.agencyName[new Random().nextInt(Constants.agencyName.length)]);
//                                    agency.setAddress(Constants.agencyAddress[new Random().nextInt(Constants.agencyAddress.length)]);
//                                    agency.setType(Math.random() < 0.5 ? AgencyType.personnel : AgencyType.nonPersonnel);
//                                    try {
//                                        Long succursaleId = Math.random() < 0.5 ? succursale.getId() : null;
//                                        agencyService.addAgency(agency, bpr.getCode(), succursaleId);
//
//                                    } catch (BprNotFoundException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                        );
//                    }
//            );
            //******************************** Application instantiation
//            IntStream.range(0, 15).forEach(i -> {
//                ApplicationDTO applicationDTO = new ApplicationDTO();
//                applicationDTO.setCode(Constants.applicationCode[new Random().nextInt(Constants.applicationCode.length)]);
//                applicationDTO.setName(Constants.applicationName[new Random().nextInt(Constants.applicationName.length)]);
//                try {
//                    applicationService.addApplication(applicationDTO);
//                } catch (ApplicationFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            });

            //******************************** Add applications to agencies
            List<ApplicationDTO> applicationDTOS = applicationService.getApplications();
//            bprDTOS.forEach(bpr -> {
//                applicationDTOS.forEach(application -> {
//                    List<AgencyDTO> agencyDTOS = agencyService.getBprAgencies(bpr.getCode());
//                    agencyDTOS.forEach(agency -> {
//
//                        try {
//                            agencyService.addApplicationToAgency(agency.getCode(), application.getId());
//                        } catch (AgencyNotFoundException | ApplicationNotFoundException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                });
//            });
            //******************************** states instantiation
//            applicationDTOS.forEach(application -> {
//                IntStream.range(0, 15).mapToObj(i -> new StateDTO()).forEach(stateDTO -> {
//                    stateDTO.setName(Constants.stateName[new Random().nextInt(Constants.stateName.length)]);
//                    stateDTO.setExtension(String.valueOf(Extension.values()[new Random().nextInt(Extension.values().length)]));
//                    stateDTO.setDescription(String.valueOf(new Random().nextInt(10)));
//
//                    try {
//                        stateService.addState(stateDTO, application.getId());
//                    } catch (ApplicationNotFoundException | StateNotFondeException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            });
            //******************************** profiles instantiation
//            List<String> shuffledProfiles = Arrays.asList(Constants.profiles);
//            Collections.shuffle(shuffledProfiles);
//
//            for (String shuffledProfile : shuffledProfiles) {
//                ProfileDTO profileDTO = new ProfileDTO();
//                profileDTO.setName(shuffledProfile);
//                profileDTO.setDescription(String.valueOf(new Random().nextInt(10)));
//                profileDTO.setPreference(String.valueOf(Preference.values()[new Random().nextInt(Preference.values().length)]));
//                try {
//                    profileService.addProfile(profileDTO);
//                } catch (ProfileFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }

            List<ProfileDTO> profileDTO = profileService.getAllProfiles();

        };
    }

}
