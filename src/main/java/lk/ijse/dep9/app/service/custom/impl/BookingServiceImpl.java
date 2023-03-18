package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.BookingDTO;
import lk.ijse.dep9.app.dto.PassengerInfoDTO;
import lk.ijse.dep9.app.dto.PaymentInfoDTO;
import lk.ijse.dep9.app.entity.PassengerInfo;
import lk.ijse.dep9.app.entity.PaymentInfo;
import lk.ijse.dep9.app.repository.PassengerInfoRepository;
import lk.ijse.dep9.app.repository.PaymentInfoRepository;
import lk.ijse.dep9.app.service.custom.BookingService;
import lk.ijse.dep9.app.service.util.Transformer;
import lk.ijse.dep9.app.util.PaymentUtils;
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
        PassengerInfoDTO passengerInfo = bookingDTO.getPassengerInfoDTO();
        PassengerInfo savedPassenger = passengerInfoRepository.save(transformer.toPassengerInfoEntity(passengerInfo));

        PaymentInfoDTO paymentInfoDTO = bookingDTO.getPaymentInfoDTO();

        /**
         * Check the available amount in the account.
         * If request fare is exceed the available amount, Data will not save to both PassengerInfo and PaymentInfo tables, transaction will be rollback.
         */
        PaymentUtils.validateCreditLimit(paymentInfoDTO.getAccountNo(), savedPassenger.getFare());

        PaymentInfo paymentInfo = transformer.toPaymentInfoEntity(paymentInfoDTO);
        paymentInfo.setPassengerInfo(savedPassenger);
        paymentInfoRepository.save(paymentInfo);
    }
}
