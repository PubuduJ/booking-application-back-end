package lk.ijse.dep9.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentInfo implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;
    @Column(name = "account_number", nullable = false, columnDefinition = "VARCHAR(100)")
    private String accountNo;
    @Column(name = "card_type", nullable = false, columnDefinition = "VARCHAR(100)")
    private String cardType;
    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id", nullable = false)
    private PassengerInfo passengerInfo;
}
