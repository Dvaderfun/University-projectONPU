import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;


public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private int studentId;

    private final static int STUDENT_ID_DEFAULT = 0;

    public Student(String firstName, String lastName) {
        if (StringUtils.isEmpty(firstName))
            throw new IncorrectDataException("Empty name");

        if (StringUtils.isEmpty(lastName))
            throw new IncorrectDataException("Empty surname");

        this.studentId = STUDENT_ID_DEFAULT;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, int studentId) {
        this(firstName, lastName);

        if (!isIdTrue(studentId))
            throw new IncorrectDataException("Incorrect ID number");

        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isEmpty(firstName))
            throw new IncorrectDataException("Empty name");

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isEmpty(lastName))
            throw new IncorrectDataException("Empty surname");

        this.lastName = lastName;
    }

    public void setYear(int year) {
        if (year < 0 || year > LocalDateTime.now().getYear())
            throw new IncorrectDataException("Incorrect Year. Only >0 and <2019");

        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (!isIdTrue(studentId)) {
            throw new IncorrectDataException("Incorrect ID number. Only 6-digit");
        }

        this.studentId = studentId;

    }

    public boolean isIdTrue(int studentId) {
        return (Math.ceil(Math.log10(studentId)) == 6 && studentId > 0);
    }

    static class IncorrectDataException extends RuntimeException {
        IncorrectDataException(String message) {
            super(message);
        }


        @Override
        public String toString() {
            //TODO
            return null;
        }
    }
}
