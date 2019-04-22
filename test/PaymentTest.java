import exception.IncorrectDataException;
import model.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {
    Payment payment = new Payment();
    Date date;


    @Test
    @DisplayName("Отрицательное значение платы за учебу")
    void setEducationPayment() {
        assertThrows(IncorrectDataException.class, () -> payment.setEducationPayment(-223));
    }


    @Test
    @DisplayName("Конструктор ругается")
    void checkConstructor() {
        assertThrows(IncorrectDataException.class, () ->{
            new Payment(date = new Date(2022,1,3), 22000);
        });
    }

}