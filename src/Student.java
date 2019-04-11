import org.apache.commons.lang3.StringUtils;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private int studentId;

    public static int STUDENT_ID_DEFAULT = 0;

    public Student(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = STUDENT_ID_DEFAULT;
    }

    public Student(String firstName, String lastName, int studentId) {

        this.firstName = firstName;
        this.lastName = lastName;

        if (!isIdTrue(studentId)) {
            throw new IncorrectStudentIdException("Incorrect ID number");
        } else {
            this.studentId = studentId;
        }

        if (StringUtils.isEmpty(firstName))
            throw new IncorrectNameException("Empty name");

        if (StringUtils.isEmpty(lastName))
            throw new IncorrectNameException("Empty surname");

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
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentId() {
        //TODO Тестануть всё что можно и если можно, то сделать удобный ексепшн чтоб в коде меньше херни было
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isIdTrue(int studentId){
        return Math.ceil(Math.log10(studentId)) == 6 || studentId > 0;
    }

    static class IncorrectStudentIdException extends RuntimeException {
        IncorrectStudentIdException(String message) {
            super(message);
        }
    }

    static class IncorrectNameException extends RuntimeException {
        IncorrectNameException(String message) {
            super(message);
        }
    }

    @Override
    public String toString() {
        //TODO
        return null;
}

}
