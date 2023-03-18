package lk.ijse.dep9.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    @JsonProperty("passengerInfo")
    @Valid
    private PassengerInfoDTO passengerInfoDTO;
    @JsonProperty("paymentInfo")
    @Valid
    private PaymentInfoDTO paymentInfoDTO;
}
