package digit.web.models;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Specify the type of operation being performed i.e. CREATE, UPDATE or DELETE
 */
public enum ApiOperation {
      CREATE("CREATE"),      UPDATE("UPDATE"),      DELETE("DELETE");

  private String value;

  ApiOperation(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ApiOperation fromValue(String text) {
    for (ApiOperation b : ApiOperation.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
