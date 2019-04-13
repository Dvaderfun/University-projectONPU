import exceptions.IncorrectDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    Payment payment = new Payment();
//    Payment payment1;

    @Test
    void setDate() {
    }

    @Test
    @DisplayName("Отрицательное значение платы за учебу")
    void setEducationPayment() {
        assertThrows(IncorrectDataException.class, () -> payment.setEducationPayment(-23));

//        assertThrows(IncorrectDataException.class, () -> {
//            payment1 = new Payment(payment1.getDate(), -30);
//        });
    }
}