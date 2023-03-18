package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.BookingDTO;
import lk.ijse.dep9.app.service.custom.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public BookingDTO createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        bookingService.createNewBooking(bookingDTO);
        return bookingDTO;
    }
}
