package digit.web.models;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.Builder;

/**
 * IdForSearch
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-28T12:28:01.525636017+05:30[Asia/Kolkata]")
@Data
@Builder
public class IdForSearch extends ArrayList<String>  {

}
