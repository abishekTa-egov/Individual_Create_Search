package digit.repository.queryBuilder;

import digit.web.models.IndividualSearch;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class IndApplicationQueryBuilder {

    private static final String BASE_IND_QUERY = " SELECT ind.id as indId, ind.individualId as individualId, ind.tenantId as tenantId, ind.clientReferenceId as clientReferenceId, ind.user_id as userId, ind.givenName as givenName, ind.familyName as familyName, ind.otherNames as otherNames, ind.dateOfBirth as dateOfBirth, ind.gender as gender, ind.bloodGroup as bloodGroup, ind.mobileNumber as mobileNumber, ind.altContactNumber as altContactNumber, ind.email as email, ind.fatherName as fatherName, ind.husbandName as husbandName, ind.relationship as relationship, ind.photo as photo, ind.additionalFields as additionalFields, ind.is_deleted as isDeleted, ind.is_SystemUser as isSystemUser, ind.rowVersion as rowVersion, ind.createdBy as createdBy, ind.lastModifiedBy as lastModifiedBy, ind.createdTime as createdTime, ind.lastModifiedTime as lastModifiedTime, ";

    private static final String ADDRESS_SELECT_QUERY = " add.id as addressId,add.tenantId as addressTenantId, add.doorNo as doorNo, add.latitude as latitude, add.longitude as longitude, add.locationAccuracy as locationAccuracy, add.type as addressType, add.addressLine1 as addressLine1, add.addressLine2 as addressLine2, add.landmark as landmark, add.city as city, add.pincode as pincode, add.buildingName as buildingName, add.street as street, add.locality_code as lcode, add.locality_name as lname, add.locality_label as llabel,add.locality_latitude as llatitude,add.locality_longitude as llongitude ";

    private static final String FROM_TABLES = " FROM eg_ind_registration ind LEFT JOIN eg_address add ON ind.individualId = add.individualId ";

    private final String ORDERBY_CREATEDTIME = " ORDER BY ind.createdTime DESC ";

    public String getIndividualSearchQuery(IndividualSearch criteria, List<Object> preparedStmtList){
        StringBuilder query = new StringBuilder(BASE_IND_QUERY);
        query.append(ADDRESS_SELECT_QUERY);
        query.append(FROM_TABLES);

        // Add dynamic conditions based on search criteria
//        if (!ObjectUtils.isEmpty(criteria.getTenantId())) {
//            addClauseIfRequired(query, preparedStmtList);
//            query.append(" ind.tenantId = ? ");
//            preparedStmtList.add(criteria.getTenantId());
//        }

//        if (!ObjectUtils.isEmpty(criteria.getIndividualId())) {
//            addClauseIfRequired(query, preparedStmtList);
//            query.append(" ind.individualId = ? ");
//            preparedStmtList.add(criteria.getIndividualId());
//        }

        // order by createdTime in descending order
        query.append(ORDERBY_CREATEDTIME);

        return query.toString();
    }

    private void addClauseIfRequired(StringBuilder query, List<Object> preparedStmtList) {
        if (preparedStmtList.isEmpty()) {
            query.append(" WHERE ");
        } else {
            query.append(" AND ");
        }
    }



    private String createQuery(List<String> ids) {
        StringBuilder builder = new StringBuilder();
        int length = ids.size();
        for (int i = 0; i < length; i++) {
            builder.append(" ?");
            if (i != length - 1)
                builder.append(",");
        }
        return builder.toString();
    }

    private void addToPreparedStatement(List<Object> preparedStmtList, List<String> ids) {
        ids.forEach(id -> {
            preparedStmtList.add(id);
        });
    }
}
