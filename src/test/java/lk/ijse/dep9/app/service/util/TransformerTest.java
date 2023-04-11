package lk.ijse.dep9.app.service.util;

import lk.ijse.dep9.app.dto.PassengerInfoDTO;
import lk.ijse.dep9.app.dto.PaymentInfoDTO;
import lk.ijse.dep9.app.entity.PassengerInfo;
import lk.ijse.dep9.app.entity.PaymentInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransformerTest {

    @InjectMocks
    private Transformer transformer;

    @Test
    void toPassengerInfoEntity() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-10-30");
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

        PassengerInfoDTO passengerInfoDTO = new PassengerInfoDTO("Pubudu", "pubudu@gmail.com", "Sri Lanka", "India", date, BigDecimal.valueOf(25000));
        PassengerInfo passengerInfo = new PassengerInfo(0, "Pubudu", "pubudu@gmail.com", "Sri Lanka", "India", sqlDate, BigDecimal.valueOf(25000));

        assertEquals(passengerInfo.toString(), transformer.toPassengerInfoEntity(passengerInfoDTO).toString());
    }

    @Test
    void toPaymentInfoEntity() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-10-30");
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

        PassengerInfo passengerInfo = new PassengerInfo(0, "Pubudu", "pubudu@gmail.com", "Sri Lanka", "India", sqlDate, BigDecimal.valueOf(25000));
        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO("account 1", "VISA");
        PaymentInfo paymentInfo = new PaymentInfo(0, "account 1", "VISA", passengerInfo);

        assertEquals(paymentInfo.getCardType(), transformer.toPaymentInfoEntity(paymentInfoDTO).getCardType());
    }
}