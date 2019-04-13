import exceptions.IncorrectDataException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private final int DEFAULT_GROUP_ID = 1;
    private int groupId;
    private Student[] students;


    public Group(int groupId) {
        if (!isIdTrue(groupId)) {
            throw new IncorrectDataException("Incorrect group Id. Pos. number expected");
        } else {
            this.groupId = groupId;
            this.students = new Student[0];
        }
    }

    public Group(int groupId, int numberOfStud) {
        this(groupId);
        if (numberOfStud < 0) {
            throw new IncorrectDataException("Incorrect number of student");
        }
        this.students = new Student[numberOfStud];
    }

    public Group(Student[] students) {
        this.students = students;
        this.groupId = DEFAULT_GROUP_ID;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int groupId) {
        if (!isIdTrue(groupId)) {
            throw new IncorrectDataException("Incorrect group id");
        } else {
            this.groupId = groupId;
        }
    }

    public int getNumOfStudents() {
        return students.length;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student findStudent(int studentId) {
        if (!Student.isIdTrue(studentId)) {
            throw new IncorrectDataException("Incorrect ID number");
        }

        for (Student s : students) {
            if (s == null) {
                continue;
            }
            if (s.getStudentId() == studentId) {
                return s;
            }
        }
        return null;
    }

    public void removeStudent(int studentId) {
        if (!Student.isIdTrue(studentId)) {
            throw new IncorrectDataException("Incorrect ID number");
        }

        Student removingStudent = findStudent(studentId);

        this.students = ArrayUtils.removeElement(this.students, removingStudent);
    }

    public void addStudent(Student s) {

        this.students = ArrayUtils.add(this.students, s);

    }

    public Student[] sortStudent(Student[] students) {

        Arrays.sort(students, (Comparator<Student>) (Student s1, Student s2) -> {
            String surname1 = s1.getLastName();
            String surname2 = s2.getLastName();
            int sComp = surname1.compareTo(surname2);

            if (sComp != 0) {
                return sComp;
            }

            String name1 = s1.getFirstName();
            String name2 = s2.getFirstName();
            return name1.compareTo(name2);

        });

        return students;
    }

    public boolean isIdTrue(int GroupId) {
        return (GroupId > 0);
    }

    //TODO: исправить навзания
    public Student[] getActiveStudents(){
        Student[] activeStudents = new Student[0];
        Group subgroup = new Group(activeStudents);
        for (Student s: this.students) {
            if(s.getEventNumber()>0){
                subgroup.addStudent(s);
            }
        }
        return subgroup.getStudents();
    }

    public Student[] getWinnerStudents(){
        Student[] activeStudents = new Student[0];
        Group subgroup = new Group(activeStudents);
        for (Student s: this.students) {
            if(s.equals(null))
                continue;
            if(s.getPrizePlaceNumber()>0){
                subgroup.addStudent(s);
            }
        }
        return subgroup.getStudents();
    }

    public int getActivStudentsNumber(){
        Student[] activeStudents = new Student[0];
        Group subgroup = new Group(activeStudents);
        for (Student s: this.students) {
            if(s.getEventNumber()>0){
                subgroup.addStudent(s);
            }
        }
        return subgroup.getNumOfStudents();
    }

    /*public int getContractStdNumber(){
        int count = 0;
        for (Student s: this.students) {
            if(s instanceof ContractStudent){
                count++;
            }
        }return count;
    }*/

   /* public int getScholarshipStdNumber(){

        return this.getNumOfStudents() - this.getContractStdNumber();
    }
*/
    /*public int getDebtorsNumber{
        int count = 0;
        for (Student s: this.students) {
            if(s instanceof Student)
                if(s.RAZMER_ZADOLJNOSTI>0)
                    count++;
        }
        return count;
    }*/
    //TODO: В ЭТИХ МЕТОДАХ, ОГРАНИЧЕНЫХ TODO


    private int findStudentIndex(int studentId) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentId() == studentId) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return "Group №" +  groupId +
                ": \n\tStudents:" + "\t" + Arrays.toString(students);
    }
}





