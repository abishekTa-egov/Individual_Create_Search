package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Individual;
//import digit.web.models.ResponseInfo;
import org.egov.common.contract.response.ResponseInfo;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * IndividualBulkSearchResponse
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-28T12:28:01.525636017+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualBulkSearchResponse   {
        @JsonProperty("ResponseInfo")
          @NotNull

          @Valid
                private ResponseInfo responseInfo = null;

        @JsonProperty("Individuals")
          @Valid
                private List<Individual> individuals = null;


        public IndividualBulkSearchResponse addIndividualsItem(Individual individualsItem) {
            if (this.individuals == null) {
            this.individuals = new ArrayList<>();
            }
        this.individuals.add(individualsItem);
        return this;
        }

}
