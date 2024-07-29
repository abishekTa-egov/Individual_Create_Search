package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * A representation of an Individual.
 */
@Schema(description = "A representation of an Individual.")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-28T12:28:01.525636017+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Individual   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("individualId")

        @Size(min=2,max=64)         private String individualId = null;

        @JsonProperty("tenantId")

        @Size(min=2,max=1000)         private String tenantId = null;

        @JsonProperty("clientReferenceId")

        @Size(min=2,max=64)         private String clientReferenceId = null;

        @JsonProperty("userId")

        @Size(min=2,max=64)         private String userId = null;

        @JsonProperty("name")


          @Valid
                private Name name = null;

        @JsonProperty("dateOfBirth")

          @Valid
                private LocalDate dateOfBirth = null;

        @JsonProperty("gender")

          @Valid
                private Gender gender = null;

        @JsonProperty("bloodGroup")

        @Size(max=3)         private String bloodGroup = null;

        @JsonProperty("mobileNumber")

        @Size(max=20)         private String mobileNumber = null;

        @JsonProperty("altContactNumber")

        @Size(max=16)         private String altContactNumber = null;

        @JsonProperty("email")

                private String email = null;

        @JsonProperty("address")
          @Valid
                private List<Address> address = null;

        @JsonProperty("fatherName")

        @Size(max=100)         private String fatherName = null;

        @JsonProperty("husbandName")

        @Size(max=100)         private String husbandName = null;

        @JsonProperty("relationship")

        @Size(max=100)         private String relationship = null;

        @JsonProperty("identifiers")
          @Valid
                private List<Identifier> identifiers = null;

        @JsonProperty("skills")
          @Valid
                private List<Skill> skills = null;

        @JsonProperty("photo")

                private String photo = null;

        @JsonProperty("additionalFields")

          @Valid
                private AdditionalFields additionalFields = null;

        @JsonProperty("isDeleted")

                private Boolean isDeleted = null;

        @JsonProperty("isSystemUser")

                private Boolean isSystemUser = null;

        @JsonProperty("rowVersion")

                private Long rowVersion = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;


        public Individual addAddressItem(Address addressItem) {
            if (this.address == null) {
            this.address = new ArrayList<>();
            }
        this.address.add(addressItem);
        return this;
        }

        public Individual addIdentifiersItem(Identifier identifiersItem) {
            if (this.identifiers == null) {
            this.identifiers = new ArrayList<>();
            }
        this.identifiers.add(identifiersItem);
        return this;
        }

        public Individual addSkillsItem(Skill skillsItem) {
            if (this.skills == null) {
            this.skills = new ArrayList<>();
            }
        this.skills.add(skillsItem);
        return this;
        }


}
