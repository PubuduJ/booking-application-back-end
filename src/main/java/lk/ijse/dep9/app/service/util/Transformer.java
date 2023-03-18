package lk.ijse.dep9.app.service.util;

import lk.ijse.dep9.app.dto.PassengerInfoDTO;
import lk.ijse.dep9.app.dto.PaymentInfoDTO;
import lk.ijse.dep9.app.entity.PassengerInfo;
import lk.ijse.dep9.app.entity.PaymentInfo;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class Transformer {

    public PassengerInfo toPassengerInfoEntity(PassengerInfoDTO passengerInfoDTO) {
        PassengerInfo passengerInfo = new PassengerInfo();
        passengerInfo.setName(passengerInfoDTO.getName());
        passengerInfo.setEmail(passengerInfoDTO.getEmail());
        passengerInfo.setSource(passengerInfoDTO.getSource());
        passengerInfo.setDestination(passengerInfoDTO.getDestination());

        // Convert Util date to LocalDate.
        LocalDate localDate = passengerInfoDTO.getTravelDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // Convert LocalDate to SQL Date.
        passengerInfo.setTravelDate(Date.valueOf(localDate));
        passengerInfo.setFare(passengerInfoDTO.getFare());
        return passengerInfo;
    }

    public PaymentInfo toPaymentInfoEntity(PaymentInfoDTO paymentInfoDTO) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAccountNo(paymentInfoDTO.getAccountNo());
        paymentInfo.setCardType(paymentInfoDTO.getCardType());
        return paymentInfo;
    }
}
