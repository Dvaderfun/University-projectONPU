import java.lang.reflect.Array;

public class Group {

    private int groupId;
    private Student student;
    private Student[] students;

    public Group(int groupId) {
        this.groupId = groupId;
        this.students = new Student[0];
    }

    public Group(int groupId, int numberOfStud) {
        this.groupId = groupId;
        this.students = new Student[numberOfStud];
    }

    public Group(Student[] students) {
        this.students = students;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getNumOfStudents() {
        return students.length;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student findStudent(int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                return s;
            }
        }
        return null;
    }

    private int findStudentIndex(int studentId) {

        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentId() == studentId) {
                return i;
            }
        }
        return 0;
    }


    public boolean removeStudent(Student[] students, int studentId) {
        if (!student.isIdTrue(studentId)) {
            throw new Student.IncorrectStudentIdException("Incorrect ID number");
        }

        int studentIndex = findStudentIndex(studentId);

        if (studentIndex != 0) {
            System.arraycopy(students, studentIndex + 1, students, studentIndex,
                    students.length - 1 - studentIndex);
            this.students = students;
            return true;
        }
        return false;
    }

    public void addStudent(Student[] students, Student newStudent) {

        Student[] newArray = (Student[]) Array.newInstance(students.getClass().getComponentType(),
                            students.length + 1);
        System.arraycopy(students, 0, newArray, 0, students.length);
        System.arraycopy(new Student[] {newStudent}, 0, newArray, students.length, 1);
        this.students = newArray;
    }


}




