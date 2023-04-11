package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.BookingDTO;
import lk.ijse.dep9.app.dto.PassengerInfoDTO;
import lk.ijse.dep9.app.dto.PaymentInfoDTO;
import lk.ijse.dep9.app.entity.PassengerInfo;
import lk.ijse.dep9.app.entity.PaymentInfo;
import lk.ijse.dep9.app.repository.PassengerInfoRepository;
import lk.ijse.dep9.app.repository.PaymentInfoRepository;
import lk.ijse.dep9.app.service.util.Transformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private Transformer transformer;
    @Mock
    private PassengerInfoRepository passengerInfoRepository;
    @Mock
    private PaymentInfoRepository paymentInfoRepository;
    @InjectMocks
    private BookingServiceImpl bookingServiceImpl;

    @Test
    void createNewBooking() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-10-30");
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        PassengerInfoDTO passengerInfoDTO = new PassengerInfoDTO("Pubudu", "pubudu@gmail.com", "Sri Lanka", "India", date, BigDecimal.valueOf(25000));
        PassengerInfo passengerInfo = new PassengerInfo(0, "Pubudu", "pubudu@gmail.com", "Sri Lanka", "India", sqlDate, BigDecimal.valueOf(25000));
        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO("account 1", "VISA");
        PaymentInfo paymentInfo = new PaymentInfo(0, "account 1", "VISA", passengerInfo);
        BookingDTO bookingDTO = new BookingDTO(passengerInfoDTO, paymentInfoDTO);

        when(transformer.toPassengerInfoEntity(passengerInfoDTO)).thenReturn(passengerInfo);
        when(passengerInfoRepository.save(passengerInfo)).thenReturn(passengerInfo);
        when(transformer.toPaymentInfoEntity(paymentInfoDTO)).thenReturn(paymentInfo);
        when(paymentInfoRepository.save(paymentInfo)).thenReturn(paymentInfo);

        assertDoesNotThrow(() -> {
            bookingServiceImpl.createNewBooking(bookingDTO);
        });
    }
}