package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.BookingDTO;
import lk.ijse.dep9.app.repository.PassengerInfoRepository;
import lk.ijse.dep9.app.repository.PaymentInfoRepository;
import lk.ijse.dep9.app.service.custom.BookingService;
import lk.ijse.dep9.app.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

    private final Transformer transformer;

    private final PassengerInfoRepository passengerInfoRepository;

    private final PaymentInfoRepository paymentInfoRepository;

    @Autowired
    public BookingServiceImpl(Transformer transformer, PassengerInfoRepository passengerInfoRepository, PaymentInfoRepository paymentInfoRepository) {
        this.transformer = transformer;
        this.passengerInfoRepository = passengerInfoRepository;
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public void createNewBooking(BookingDTO bookingDTO) {

    }
}
