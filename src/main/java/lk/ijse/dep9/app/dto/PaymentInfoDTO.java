package lk.ijse.dep9.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"accountNo", "cardType"})
public class PaymentInfoDTO implements Serializable {
    @NotBlank(message = "Account number cannot be empty or null")
    @Pattern(regexp = "^account [1234]$", message = "account number must be 1 or 2 or 3 or 4")
    private String accountNo;
    @NotBlank(message = "Card type cannot be empty or null")
    @Pattern(regexp = "^(VISA|MASTER)$", message = "Card type should be VISA or MASTER")
    private String cardType;
}
