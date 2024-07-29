package digit.service;


import digit.kafka.Producer;
import digit.repository.ServiceRequestRepository;


import digit.web.models.Individual;
import digit.web.models.IndividualRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.workflow.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import digit.web.models.AuditDetails;



@Service
@Slf4j
public class IndividualRegistrationService {



    @Autowired
    private Producer producer;

    public Individual registerIndRequest(IndividualRequest body) {


        // Push the application to the topic for persister to listen and persist
//        System.out.println(body);

        body.getIndividual().setId(UUID.randomUUID().toString());
//        System.out.println(AuditDetails.builder().createdBy(String.valueOf(body.getRequestInfo().getUserInfo().getUuid())));
        AuditDetails auditDetails = AuditDetails.builder().createdBy(body.getRequestInfo().getUserInfo().getUuid()).createdTime(System.currentTimeMillis()).lastModifiedBy(body.getRequestInfo().getUserInfo().getUuid()).lastModifiedTime(System.currentTimeMillis()).build();
        body.getIndividual().setAuditDetails(auditDetails);
        producer.push("save-ind-application", body);

        // Return the response back to user
        return body.getIndividual();
    }


}
