package digit.repository.queryBuilder;

import digit.web.models.IndividualSearch;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class IndApplicationQueryBuilder {

    private static final String BASE_IND_QUERY = " SELECT ind.id as indId, ind.tenantId as indTenantId, ind.applicationNumber as indapplicationnumber, btr.babyfirstname as bbabyfirstname, btr.babylastname as bbabylastname, btr.fatherid as bfatherid, btr.motherid as bmotherid, btr.doctorname as bdoctorname, btr.hospitalname as bhospitalname, btr.placeofbirth as bplaceofbirth, btr.timeofbirth as btimeofbirth, btr.createdby as bcreatedby, btr.lastmodifiedby as blastmodifiedby, btr.createdtime as bcreatedtime, btr.lastmodifiedtime as blastmodifiedtime, ";

    private static final String ADDRESS_SELECT_QUERY = " add.id as aid, add.tenantid as atenantid, add.type as atype, add.address as aaddress, add.city as acity, add.pincode as apincode, add.registrationid as aregistrationid ";

    private static final String FROM_TABLES = " FROM eg_ind_registration ind LEFT JOIN eg_ind_address add ON ind.individualId = add.individualId  ";

    private final String ORDERBY_CREATEDTIME = " ORDER BY ind.createdTime DESC ";

    public String getBirthApplicationSearchQuery(IndividualSearch criteria, List<Object> preparedStmtList){
        StringBuilder query = new StringBuilder(BASE_IND_QUERY);
        query.append(ADDRESS_SELECT_QUERY);
        query.append(FROM_TABLES);

        // order birth registration applications based on their createdtime in latest first manner
        query.append(ORDERBY_CREATEDTIME);

        return query.toString();
    }

    private void addClauseIfRequired(StringBuilder query, List<Object> preparedStmtList){
        if(preparedStmtList.isEmpty()){
            query.append(" WHERE ");
        }else{
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
