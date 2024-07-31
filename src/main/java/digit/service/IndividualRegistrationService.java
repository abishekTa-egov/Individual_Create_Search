package digit.service;


import digit.kafka.Producer;
import digit.repository.IndRegistrationRepository;
import digit.repository.ServiceRequestRepository;


import digit.web.models.*;
import org.egov.common.contract.request.RequestInfo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.workflow.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class IndividualRegistrationService {



    @Autowired
    private Producer producer;

    @Autowired
    private IndRegistrationRepository indRegistrationRepository;

    public Individual registerIndRequest(IndividualRequest body) {


        // Push the application to the topic for persister to listen and persist
//        System.out.println(body);
        String uuid=UUID.randomUUID().toString();
        body.getIndividual().setIndividualId(uuid);

        List<Address> addresses = body.getIndividual().getAddress();
        System.out.println("hi"+addresses);
        for (Address address : addresses){
            address.setIndividualId(uuid);
        }

        List<Identifier> identifiers=body.getIndividual().getIdentifiers();
        for (Identifier identifier: identifiers){
            identifier.setIndividualId(uuid);
        }

        List<Skill> skills=body.getIndividual().getSkills();
        for(Skill skill: skills){
            skill.setIndividualId(uuid);
        }
        System.out.println("bye"+addresses);
        System.out.println("bye1"+body.getIndividual());
//        System.out.println(AuditDetails.builder().createdBy(String.valueOf(body.getRequestInfo().getUserInfo().getUuid())));
        AuditDetails auditDetails = AuditDetails.builder().createdBy(body.getRequestInfo().getUserInfo().getUuid()).createdTime(System.currentTimeMillis()).lastModifiedBy(body.getRequestInfo().getUserInfo().getUuid()).lastModifiedTime(System.currentTimeMillis()).build();
        body.getIndividual().setAuditDetails(auditDetails);
        System.out.println(body);
        producer.push("save-ind-application", body);

        // Return the response back to user
        return body.getIndividual();
    }

    public List<Individual> searchIndApplications(RequestInfo requestInfo, IndividualSearch indSearchCriteria) {
        // Fetch applications from database according to the given search criteria
        List<Individual> applications = indRegistrationRepository.getApplications(indSearchCriteria);

        // If no applications are found matching the given criteria, return an empty list
        if(CollectionUtils.isEmpty(applications))
            return new ArrayList<>();





        // Otherwise return the found applications
        return applications;
    }





}
