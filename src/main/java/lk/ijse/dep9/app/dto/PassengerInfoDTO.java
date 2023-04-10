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
    @Email(message = "Invalid email type")
    private String email;
    @NotBlank(message = "Source cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z][A-Za-z ]+$", message = "Invalid source name")
    private String source;
    @NotBlank(message = "Destination cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z][A-Za-z ]+$", message = "Invalid destination name")
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Date cannot be null")
    @Future(message = "Date must be a future date")
    private Date travelDate;
    @DecimalMin(value = "10000.0", message = "Fare must be greater than 10,000")
    @DecimalMax(value = "10000000.0", message = "Fare must be less than 1,000,000")
    private BigDecimal fare;
}
