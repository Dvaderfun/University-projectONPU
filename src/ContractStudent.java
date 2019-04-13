import java.util.LinkedList;
import java.util.Calendar;
import java.util.Date;

public class ContractStudent extends Student {
    private LinkedList<Payment> paymentsList;
    private double costEducationSemestr;
    private final static int SEMESTR_AMOUNT = 2;

    public ContractStudent() {
        paymentsList = new LinkedList<>();
    }

    public ContractStudent(String firstName, String lastName) {
        super(firstName, lastName);
        paymentsList = new LinkedList<>();
        ;
    }

    public ContractStudent(String firstName, String lastName, int studentId) {
        super(firstName, lastName, studentId);
        paymentsList = new LinkedList<>();
    }

    public ContractStudent(String firstName, String lastName, int studentId, LinkedList<Payment> payments) {
        super(firstName, lastName, studentId);
        paymentsList = payments;
    }

    public LinkedList<Payment> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(LinkedList<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public double getCostEducationSemestr() {
        return costEducationSemestr;
    }

    public void setCostEducationSemestr(double costEducationSemestr) {
        this.costEducationSemestr = costEducationSemestr;
    }

    public double getAmountDebt() {
        Calendar thisYear = Calendar.getInstance();
        return
                (thisYear.get(Calendar.YEAR) - this.getYear()) * SEMESTR_AMOUNT * this.costEducationSemestr;
    }

    public void addPayment(Payment payments) {
        paymentsList.add(payments);
    }

    public void deletePayment(Date date, double educationPayment) {
        for (Payment payment : paymentsList) {
            if (payment.getDate() == date && payment.getEducationPayment() == educationPayment) {
                paymentsList.remove(payment);
            }
        }
    }
}
