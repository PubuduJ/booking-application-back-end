package lk.ijse.dep9.app.service.custom;

import lk.ijse.dep9.app.dto.BookingDTO;
import lk.ijse.dep9.app.service.SuperService;

public interface BookingService extends SuperService {

    void createNewBooking(BookingDTO bookingDTO);
}
