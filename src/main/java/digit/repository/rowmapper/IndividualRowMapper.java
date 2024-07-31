package digit.repository.rowmapper;

import digit.web.models.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class IndividualRowMapper implements ResultSetExtractor<List<Individual>> {
    @Override
    public List<Individual> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, Individual> individualMap = new LinkedHashMap<>();

        while (rs.next()) {
            String uuid = rs.getString("individualId");
            Individual individual = individualMap.get(uuid);

            if (individual == null) {
                Long lastModifiedTime = rs.getLong("lastModifiedTime");
                if (rs.wasNull()) {
                    lastModifiedTime = null;
                }

                Name name = Name.builder()
                        .givenName(rs.getString("givenName"))
                        .familyName(rs.getString("familyName"))
                        .otherNames(rs.getString("otherNames"))
                        .build();

                AuditDetails auditDetails = AuditDetails.builder()
                        .createdBy(rs.getString("createdBy"))
                        .createdTime(rs.getLong("createdTime"))
                        .lastModifiedBy(rs.getString("lastModifiedBy"))
                        .lastModifiedTime(lastModifiedTime)
                        .build();

                individual = Individual.builder()
                        .id(rs.getString("indId"))
                        .individualId(rs.getString("individualId"))
                        .tenantId(rs.getString("tenantId"))
                        .clientReferenceId(rs.getString("clientReferenceId"))
                        .userId(rs.getString("userId"))
                        .name(name)
                        .dateOfBirth(rs.getString("dateOfBirth"))
                        .gender(rs.getString("gender"))
                        .bloodGroup(rs.getString("bloodGroup"))
                        .mobileNumber(rs.getString("mobileNumber"))
                        .altContactNumber(rs.getString("altContactNumber"))
                        .email(rs.getString("email"))
                        .fatherName(rs.getString("fatherName"))
                        .husbandName(rs.getString("husbandName"))
                        .relationship(rs.getString("relationship"))
                        .photo(rs.getString("photo"))
                        .isDeleted(rs.getBoolean("isDeleted"))
                        .isSystemUser(rs.getBoolean("isSystemUser"))
                        .rowVersion(rs.getLong("rowVersion"))
                        .auditDetails(auditDetails)
                        .build();

                individualMap.put(uuid, individual);
            }

            addAddressToIndividual(rs, individual);
        }
        return new ArrayList<>(individualMap.values());
    }

    private void addAddressToIndividual(ResultSet rs, Individual individual) throws SQLException {
        Address address = Address.builder()
                .id(rs.getString("addressId"))
                .tenantId(rs.getString("addressTenantId"))
                .doorNo(rs.getString("doorNo"))
                .latitude(rs.getDouble("latitude"))
                .longitude(rs.getDouble("longitude"))
                .locationAccuracy(rs.getDouble("locationAccuracy"))
                .type(rs.getString("addressType"))
                .addressLine1(rs.getString("addressLine1"))
                .addressLine2(rs.getString("addressLine2"))
                .landmark(rs.getString("landmark"))
                .city(rs.getString("city"))
                .pincode(rs.getString("pincode"))
                .buildingName(rs.getString("buildingName"))
                .street(rs.getString("street"))
                .locality(Boundary.builder()
                        .code(rs.getString("lcode"))
                        .name(rs.getString("lname"))
                        .label(rs.getString("llabel"))
                        .latitude(rs.getString("llatitude"))
                        .longitude(rs.getString("llongitude"))
                        .build())
                .build();

        List<Address> addresses = individual.getAddress();
        if (addresses == null) {
            addresses = new ArrayList<>();
        }
        addresses.add(address);
        individual.setAddress(addresses);
    }
}
