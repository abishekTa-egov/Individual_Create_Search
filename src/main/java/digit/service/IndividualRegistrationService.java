package digit.service;


import digit.kafka.Producer;
import digit.repository.ServiceRequestRepository;


import digit.web.models.*;
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

    public List<Individual> searchBtApplications(RequestInfo requestInfo, IndividualSearch indSearchCriteria) {
        // Fetch applications from database according to the given search criteria
        List<Individual> applications = indRegistrationRepository.getApplications(birthApplicationSearchCriteria);

        // If no applications are found matching the given criteria, return an empty list
        if(CollectionUtils.isEmpty(applications))
            return new ArrayList<>();

        // Enrich mother and father of applicant objects
        applications.forEach(application -> {
            enrichmentUtil.enrichFatherApplicantOnSearch(application);
            enrichmentUtil.enrichMotherApplicantOnSearch(application);
            ProcessInstance obj=workflowService.getCurrWorkflow(requestInfo, application);

            Workflow workflow = new Workflow();
            workflow.setStatus(obj.getState().getState());
            workflow.setComments(obj.getComment());
            workflow.setDocuments(obj.getDocuments());
            workflow.setAction(obj.getAction());

            application.setWorkflow(workflow);
        });



        // Otherwise return the found applications
        return applications;
    }





}
