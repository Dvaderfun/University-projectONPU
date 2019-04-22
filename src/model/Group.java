package model;



import exception.IncorrectDataException;
import org.apache.commons.lang3.ArrayUtils;


import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private final int DEFAULT_GROUP_ID = 1;
    private int groupId;
    private Student[] students;


    public Group(int groupId) throws IncorrectDataException {
        if (!isIdTrue(groupId)) {
            throw new IncorrectDataException("Incorrect group Id. Pos. number expected");
        } else {
            this.groupId = groupId;
            this.students = new Student[0];
        }
    }

    public Group(int groupId, int numberOfStud) throws IncorrectDataException {
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

    public void setGroupId(int groupId) throws IncorrectDataException {
        if (!isIdTrue(groupId)) {
            throw new IncorrectDataException("Incorrect group id");
        } else {
            this.groupId = groupId;
        }
    }

    public int getStudentsNumber() {
        return students.length;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student getStudentById(int studentId) throws IncorrectDataException{
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

    public void removeStudent(int studentId) throws IncorrectDataException{
        if (!Student.isIdTrue(studentId)) {
            throw new IncorrectDataException("Incorrect ID number");
        }

        Student removingStudent = getStudentById(studentId);

        this.students = ArrayUtils.removeElement(this.students, removingStudent);
    }

    public void addStudent(Student s) {

        this.students = ArrayUtils.add(this.students, s);

    }

    public Student[] getSortedStudents(Student[] students) {

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

    public Student[] getActiveStudents() {
        Student[] activeStudents = new Student[0];
        Group subgroup = new Group(activeStudents);
        for (Student s : this.students) {
            if (s.getEventNumber() > 0) {
                subgroup.addStudent(s);
            }
        }
        return subgroup.getStudents();
    }

    public Student[] getWinnerStudents() {
        Student[] activeStudents = new Student[0];
        Group subgroup = new Group(activeStudents);
        for (Student s : this.students) {
            if (s.equals(null))
                continue;
            if (s.getPrizePlaceNumber() > 0) {
                subgroup.addStudent(s);
            }
        }
        return subgroup.getStudents();
    }

    public int getActivStudentsNumber() {
        Student[] activeStudents = new Student[0];
        Group subgroup = new Group(activeStudents);
        for (Student s : this.students) {
            if (s.getEventNumber() > 0) {
                subgroup.addStudent(s);
            }
        }
        return subgroup.getStudentsNumber();
    }

    public int getContractStdNumber() {
        int count = 0;
        for (Student s : this.students) {
            if (s instanceof ContractStudent) {
                count++;
            }
        }
        return count;
    }

    public int getScholarshipStdNumber() {

        return this.getStudentsNumber() - this.getContractStdNumber();
    }

    public int getDebtorsNumber() {
        int count = 0;
        for (Student s : this.students) {
            if (s instanceof ContractStudent)
                if (((ContractStudent) s).getAmountDebt() > 0)
                    count++;
        }
        return count;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Группа №")
                .append(groupId)
                .append("\n")
                .append("Учащиеся:\n");

        if (this.getStudents().length < 1) {
            stringBuilder.append("\t-");
        } else {
            for (Student s : this.students) {
                stringBuilder.append("\t")
                            .append(s.getLastName())
                            .append(" ")
                            .append(s.getFirstName())
                            .append("\n");
            }
        }


        return stringBuilder.toString();

    }
}





