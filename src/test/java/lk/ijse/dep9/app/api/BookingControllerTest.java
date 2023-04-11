package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.BookingDTO;
import lk.ijse.dep9.app.dto.PassengerInfoDTO;
import lk.ijse.dep9.app.dto.PaymentInfoDTO;
import lk.ijse.dep9.app.service.custom.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @Mock
    private BookingService bookingService;
    @InjectMocks
    private BookingController bookingController;

    @Test
    void createBooking() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-10-30");
        PassengerInfoDTO passengerInfoDTO = new PassengerInfoDTO("Pubudu", "pubudu@gmail.com", "Sri Lanka", "India", date, BigDecimal.valueOf(25000));
        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO("account 1", "VISA");
        BookingDTO bookingDTO = new BookingDTO(passengerInfoDTO, paymentInfoDTO);

        bookingService.createNewBooking(bookingDTO);

        assertDoesNotThrow(() -> {
            bookingController.createBooking(bookingDTO);
        });
    }
}