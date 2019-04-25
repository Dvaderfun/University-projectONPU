package model;

import exception.IncorrectDataException;

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
        if (costEducationSemestr < 0) {
            throw new IncorrectDataException("Incorrect value cost education");
        } else { this.costEducationSemestr = costEducationSemestr;}
    }

    public double getAmountDebt() {
        Calendar thisYear = Calendar.getInstance();
        if (thisYear.get(Calendar.MONTH) < 3) {
            return
                    (thisYear.get(Calendar.YEAR) - this.getYear()) * SEMESTR_AMOUNT * this.costEducationSemestr - this.costEducationSemestr;
        } else {
            return
                    (thisYear.get(Calendar.YEAR) - this.getYear()) * SEMESTR_AMOUNT * this.costEducationSemestr;
        }
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

    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder();
        stringBuilder
                .append(super.toString())
                .append("\n")
                .append("Стоимость обучения за один семестр: ")
                .append(costEducationSemestr)
                .append("\n")
                .append("Список Платежей: \n");

        if(paymentsList.isEmpty()) {
            stringBuilder.append("\t-");
            return stringBuilder.toString();
        }

        for (Payment payment : paymentsList) {
            stringBuilder
                    .append(payment.toString())
                    .append("\n");

        }
        return stringBuilder.toString();
    }
}
