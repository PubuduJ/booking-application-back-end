package lk.ijse.dep9.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"name", "email", "source", "destination"})
public class PassengerInfoDTO implements Serializable {
    @NotBlank(message = "Passenger name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z][A-Za-z ]+$", message = "Invalid Passenger name")
    private String name;
    @NotBlank(message = "Passenger email cannot be empty or null")
    @Email
    private String email;
    @NotBlank(message = "Source cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z][A-Za-z ]+$", message = "Invalid source name")
    private String source;
    @NotBlank(message = "Destination cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z][A-Za-z ]+$", message = "Invalid destination name")
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Future
    private Date travelDate;
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100000.0")
    private BigDecimal fare;
}
