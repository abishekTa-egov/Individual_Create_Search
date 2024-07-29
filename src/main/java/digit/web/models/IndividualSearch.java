package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.ClientReferenceIdForSearch;
import digit.web.models.Gender;
import digit.web.models.IdForSearch;
import digit.web.models.Identifier;
import digit.web.models.Name;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
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
public class IndividualSearch   {
        @JsonProperty("individualId")

                private List<String> individualId = null;

        @JsonProperty("id")

          @Valid
                private IdForSearch id = null;

        @JsonProperty("clientReferenceId")

          @Valid
                private ClientReferenceIdForSearch clientReferenceId = null;

        @JsonProperty("name")

          @Valid
                private Name name = null;

        @JsonProperty("dateOfBirth")

          @Valid
                private LocalDate dateOfBirth = null;

        @JsonProperty("gender")

          @Valid
                private Gender gender = null;

        @JsonProperty("mobileNumber")

                private List<String> mobileNumber = null;

        @JsonProperty("socialCategory")

                private String socialCategory = null;

        @JsonProperty("identifier")

          @Valid
                private Identifier identifier = null;

        @JsonProperty("boundaryCode")

        @Size(max=64)         private String boundaryCode = null;

        @JsonProperty("wardCode")

        @Size(max=64)         private String wardCode = null;

        @JsonProperty("createdFrom")

          @Valid
                private BigDecimal createdFrom = null;

        @JsonProperty("createdTo")

          @Valid
                private BigDecimal createdTo = null;


        public IndividualSearch addIndividualIdItem(String individualIdItem) {
            if (this.individualId == null) {
            this.individualId = new ArrayList<>();
            }
        this.individualId.add(individualIdItem);
        return this;
        }

        public IndividualSearch addMobileNumberItem(String mobileNumberItem) {
            if (this.mobileNumber == null) {
            this.mobileNumber = new ArrayList<>();
            }
        this.mobileNumber.add(mobileNumberItem);
        return this;
        }

}
