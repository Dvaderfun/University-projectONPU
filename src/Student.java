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

        if (Math.ceil(Math.log10(studentId)) != 6 || studentId <= 0)
            throw new IncorrectStudentIdException("Incorrect ID number");

        if (firstName.contains(""))
            throw new IncorrectNameException("Empty name");

        if (lastName.contains(""))
            throw new IncorrectNameException("Empty surname");

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
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

    public class IncorrectStudentIdException extends RuntimeException {
        public IncorrectStudentIdException(String message) {
            super(message);
        }
    }

    public class IncorrectNameException extends RuntimeException {
        public IncorrectNameException(String message) {
            super(message);
        }
    }

}
