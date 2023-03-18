package lk.ijse.dep9.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PassengerInfo implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private int passengerId;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String source;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String destination;
    @Column(name = "travel_date", nullable = false, columnDefinition = "DATE")
    private Date travelDate;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal fare;
}
