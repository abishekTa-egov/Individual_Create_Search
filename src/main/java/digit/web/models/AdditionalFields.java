package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Field;
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
 * AdditionalFields
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-28T12:28:01.525636017+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdditionalFields   {
        @JsonProperty("schema")

        @Size(min=2,max=64)         private String schema = null;

        @JsonProperty("version")

        @Min(1)        private Integer version = null;

        @JsonProperty("fields")
          @Valid
                private List<Field> fields = null;


        public AdditionalFields addFieldsItem(Field fieldsItem) {
            if (this.fields == null) {
            this.fields = new ArrayList<>();
            }
        this.fields.add(fieldsItem);
        return this;
        }

}
