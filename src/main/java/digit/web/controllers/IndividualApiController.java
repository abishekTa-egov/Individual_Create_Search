package digit.web.controllers;


import digit.service.IndividualRegistrationService;
import digit.util.ResponseInfoFactory;
import digit.web.models.*;
import org.egov.common.contract.response.ResponseInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.*;

    import jakarta.validation.constraints.*;
    import jakarta.validation.Valid;
    import jakarta.servlet.http.HttpServletRequest;
        import java.util.Optional;
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-28T12:28:01.525636017+05:30[Asia/Kolkata]")
@Controller
    @RequestMapping("")
    public class IndividualApiController{

        private final ObjectMapper objectMapper;

        private final HttpServletRequest request;

        private IndividualRegistrationService individualRegistrationService;

        @Autowired
        private ResponseInfoFactory responseInfoFactory;

        @Autowired
        public IndividualApiController(ObjectMapper objectMapper, HttpServletRequest request, IndividualRegistrationService individualRegistrationService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.individualRegistrationService= individualRegistrationService;
        }

                @RequestMapping(value="/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<IndividualResponse> individualV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Individual.", required=true, schema=@Schema()) @RequestBody IndividualRequest body,
                                                                                 @Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {

                    Individual individual = individualRegistrationService.registerIndRequest(body);



            //                        String accept = request.getHeader("Accept");
            //                            if (accept != null && accept.contains("application/json")) {
            //                            try {
            //                            return new ResponseEntity<IndividualResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Individual\" : {    \"fatherName\" : \"fatherName\",    \"address\" : [ {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    }, {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    } ],    \"gender\" : \"MALE\",    \"husbandName\" : \"husbandName\",    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 5,    \"altContactNumber\" : \"altContactNumber\",    \"mobileNumber\" : \"mobileNumber\",    \"identifiers\" : [ {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    }, {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    } ],    \"photo\" : \"photo\",    \"dateOfBirth\" : \"2000-01-23\",    \"individualId\" : \"individualId\",    \"clientReferenceId\" : \"clientReferenceId\",    \"skills\" : [ {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    }, {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    } ],    \"bloodGroup\" : \"bloodGroup\",    \"isDeleted\" : true,    \"auditDetails\" : {      \"lastModifiedTime\" : 7,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 2    },    \"tenantId\" : \"tenantA\",    \"name\" : {      \"otherNames\" : \"otherNames\",      \"givenName\" : \"givenName\",      \"familyName\" : \"familyName\"    },    \"isSystemUser\" : true,    \"id\" : \"id\",    \"relationship\" : \"relationship\",    \"email\" : \"\"  }}", IndividualResponse.class), HttpStatus.NOT_IMPLEMENTED);
            //                            } catch (IOException e) {
            //                            return new ResponseEntity<IndividualResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            //                            }
            //                            }
                    ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(body.getRequestInfo(), true);
                    IndividualResponse response = IndividualResponse.builder().individual(individual).responseInfo(responseInfo).build();

                    return new ResponseEntity<IndividualResponse>(response, HttpStatus.ACCEPTED);
                }

                @RequestMapping(value="/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<IndividualBulkSearchResponse> individualV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Individual details.", required=true, schema=@Schema()) @Valid @RequestBody IndividualSearchRequest body,
                                                                                           @NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,
                                                                                           @NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,
                                                                                           @NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
                                                                                           @Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,
                                                                                           @Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted) {
                      List<Individual> individuals=individualRegistrationService.searchIndApplications(body.getRequestInfo(),body.getIndividual());
//                    String accept = request.getHeader("Accept");
//                    if (accept != null && accept.contains("application/json")) {
//                        try {
//                            return new ResponseEntity<IndividualBulkSearchResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Individuals\" : [ {    \"fatherName\" : \"fatherName\",    \"address\" : [ {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    }, {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    } ],    \"gender\" : \"MALE\",    \"husbandName\" : \"husbandName\",    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 5,    \"altContactNumber\" : \"altContactNumber\",    \"mobileNumber\" : \"mobileNumber\",    \"identifiers\" : [ {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    }, {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    } ],    \"photo\" : \"photo\",    \"dateOfBirth\" : \"2000-01-23\",    \"individualId\" : \"individualId\",    \"clientReferenceId\" : \"clientReferenceId\",    \"skills\" : [ {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    }, {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    } ],    \"bloodGroup\" : \"bloodGroup\",    \"isDeleted\" : true,    \"auditDetails\" : {      \"lastModifiedTime\" : 7,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 2    },    \"tenantId\" : \"tenantA\",    \"name\" : {      \"otherNames\" : \"otherNames\",      \"givenName\" : \"givenName\",      \"familyName\" : \"familyName\"    },    \"isSystemUser\" : true,    \"id\" : \"id\",    \"relationship\" : \"relationship\",    \"email\" : \"\"  }, {    \"fatherName\" : \"fatherName\",    \"address\" : [ {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    }, {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    } ],    \"gender\" : \"MALE\",    \"husbandName\" : \"husbandName\",    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 5,    \"altContactNumber\" : \"altContactNumber\",    \"mobileNumber\" : \"mobileNumber\",    \"identifiers\" : [ {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    }, {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    } ],    \"photo\" : \"photo\",    \"dateOfBirth\" : \"2000-01-23\",    \"individualId\" : \"individualId\",    \"clientReferenceId\" : \"clientReferenceId\",    \"skills\" : [ {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    }, {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    } ],    \"bloodGroup\" : \"bloodGroup\",    \"isDeleted\" : true,    \"auditDetails\" : {      \"lastModifiedTime\" : 7,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 2    },    \"tenantId\" : \"tenantA\",    \"name\" : {      \"otherNames\" : \"otherNames\",      \"givenName\" : \"givenName\",      \"familyName\" : \"familyName\"    },    \"isSystemUser\" : true,    \"id\" : \"id\",    \"relationship\" : \"relationship\",    \"email\" : \"\"  } ]}", IndividualBulkSearchResponse.class), HttpStatus.NOT_IMPLEMENTED);
//                        } catch (IOException e) {
//                            return new ResponseEntity<IndividualBulkSearchResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//                        }
//                    }

                    return new ResponseEntity<IndividualBulkSearchResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/individual/v1/bulk/_create", method = RequestMethod.POST)
                public ResponseEntity<IndividualBulkResponse> individualV1BulkCreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Individual.", required=true, schema=@Schema()) @Valid @RequestBody IndividualBulkRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<IndividualBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", IndividualBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<IndividualBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<IndividualBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/individual/v1/bulk/_delete", method = RequestMethod.POST)
                public ResponseEntity<IndividualBulkResponse> individualV1BulkDeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the Individual.", required=true, schema=@Schema()) @Valid @RequestBody IndividualBulkRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<IndividualBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", IndividualBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<IndividualBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<IndividualBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/individual/v1/bulk/_update", method = RequestMethod.POST)
                public ResponseEntity<IndividualBulkResponse> individualV1BulkUpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the Individual.", required=true, schema=@Schema()) @Valid @RequestBody IndividualBulkRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<IndividualBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", IndividualBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<IndividualBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<IndividualBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }



                @RequestMapping(value="/v1/_delete", method = RequestMethod.POST)
                public ResponseEntity<IndividualResponse> individualV1DeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the Individual.", required=true, schema=@Schema()) @Valid @RequestBody IndividualRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<IndividualResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Individual\" : {    \"fatherName\" : \"fatherName\",    \"address\" : [ {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    }, {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    } ],    \"gender\" : \"MALE\",    \"husbandName\" : \"husbandName\",    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 5,    \"altContactNumber\" : \"altContactNumber\",    \"mobileNumber\" : \"mobileNumber\",    \"identifiers\" : [ {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    }, {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    } ],    \"photo\" : \"photo\",    \"dateOfBirth\" : \"2000-01-23\",    \"individualId\" : \"individualId\",    \"clientReferenceId\" : \"clientReferenceId\",    \"skills\" : [ {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    }, {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    } ],    \"bloodGroup\" : \"bloodGroup\",    \"isDeleted\" : true,    \"auditDetails\" : {      \"lastModifiedTime\" : 7,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 2    },    \"tenantId\" : \"tenantA\",    \"name\" : {      \"otherNames\" : \"otherNames\",      \"givenName\" : \"givenName\",      \"familyName\" : \"familyName\"    },    \"isSystemUser\" : true,    \"id\" : \"id\",    \"relationship\" : \"relationship\",    \"email\" : \"\"  }}", IndividualResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<IndividualResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<IndividualResponse>(HttpStatus.NOT_IMPLEMENTED);
                }



                @RequestMapping(value="/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<IndividualResponse> individualV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the Individual.", required=true, schema=@Schema()) @Valid @RequestBody IndividualRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<IndividualResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Individual\" : {    \"fatherName\" : \"fatherName\",    \"address\" : [ {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    }, {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    } ],    \"gender\" : \"MALE\",    \"husbandName\" : \"husbandName\",    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 5,    \"altContactNumber\" : \"altContactNumber\",    \"mobileNumber\" : \"mobileNumber\",    \"identifiers\" : [ {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    }, {      \"identifierId\" : \"ABCD-1212\",      \"identifierType\" : \"SYSTEM_GENERATED\"    } ],    \"photo\" : \"photo\",    \"dateOfBirth\" : \"2000-01-23\",    \"individualId\" : \"individualId\",    \"clientReferenceId\" : \"clientReferenceId\",    \"skills\" : [ {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    }, {      \"level\" : \"level\",      \"type\" : \"type\",      \"experience\" : \"experience\"    } ],    \"bloodGroup\" : \"bloodGroup\",    \"isDeleted\" : true,    \"auditDetails\" : {      \"lastModifiedTime\" : 7,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 2    },    \"tenantId\" : \"tenantA\",    \"name\" : {      \"otherNames\" : \"otherNames\",      \"givenName\" : \"givenName\",      \"familyName\" : \"familyName\"    },    \"isSystemUser\" : true,    \"id\" : \"id\",    \"relationship\" : \"relationship\",    \"email\" : \"\"  }}", IndividualResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<IndividualResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<IndividualResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

        }
