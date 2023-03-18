package lk.ijse.dep9.app.util;

import lk.ijse.dep9.app.service.exception.InsufficientAmountException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

public class PaymentUtils {
    private static final Map<String, BigDecimal> paymentMap = new HashMap<>();

    static {
        paymentMap.put("account 1", BigDecimal.valueOf(12000));
        paymentMap.put("account 2", BigDecimal.valueOf(10000));
        paymentMap.put("account 3", BigDecimal.valueOf(8000));
        paymentMap.put("account 4", BigDecimal.valueOf(6000));
    }

    public static void validateCreditLimit(String accountNo, BigDecimal paidAmount) {
        if (paidAmount.compareTo(paymentMap.get(accountNo)) > 0) throw new InsufficientAmountException("Insufficient amount at the ".concat(accountNo));
    }
}
