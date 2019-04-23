package model;

import exception.DuplicateEventException;
import exception.IncorrectDataException;
import model.event.Competition;
import model.event.Conference;
import model.event.Olympiad;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


public class Student implements Activist {
    private String firstName;
    private String lastName;
    private int year;
    private int studentId;
    private ArrayList<Event> arrayList;

    private final static int STUDENT_ID_DEFAULT = 0;
    private final static String STUDENT_NAME_DEFAULT = "noname";

    public Student(){
        studentId = STUDENT_ID_DEFAULT;
        firstName = STUDENT_NAME_DEFAULT;
        lastName = STUDENT_NAME_DEFAULT;
    }

    public Student(String firstName, String lastName) throws IncorrectDataException {
        if (firstName.isEmpty())
            throw new IncorrectDataException("Empty name");

        if (lastName.isEmpty())
            throw new IncorrectDataException("Empty surname");

        this.studentId = STUDENT_ID_DEFAULT;
        this.firstName = firstName;
        this.lastName = lastName;

        arrayList = new ArrayList<>();
    }

    public Student(String firstName, String lastName, int studentId) throws IncorrectDataException {
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

    public void setFirstName(String firstName) throws IncorrectDataException {
        if (firstName.isEmpty())
            throw new IncorrectDataException("Empty name");

        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws IncorrectDataException {
        if (lastName.isEmpty())
            throw new IncorrectDataException("Empty surname");

        this.lastName = lastName;
    }

    public void setYear(int year) throws IncorrectDataException {
        if (year < 0 || year > LocalDateTime.now().getYear())
            throw new IncorrectDataException("Incorrect Year. Only >0 and <2019");

        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) throws IncorrectDataException {
        if (!isIdTrue(studentId)) {
            throw new IncorrectDataException("Incorrect ID number. Only 6-digit");
        }

        this.studentId = studentId;
    }

    public static boolean isIdTrue(int studentId) {
        return (Math.ceil(Math.log10(studentId)) == 6 && studentId > 0);
    }

    @Override
    public int getEventNumber() {
        return arrayList.size();
    }

    @Override
    public int getPrizePlaceNumber() {
        int i = 0;
        for (Event event: arrayList) {
            if (event instanceof Olympiad){
                Olympiad olympiad = (Olympiad) event;
                int olympiadPlace = olympiad.getPodiumPlace();

                if (olympiadPlace == 1 || olympiadPlace == 2 || olympiadPlace == 3){
                    i++;
                }

            }
        }
        return i;
    }

    //возвращающий число докладов на конференциях
    @Override
    public int getReportsNumber() {
        int i = 0;
        for (Event event: arrayList) {
            if (event instanceof Conference){
                Conference conference = (Conference) event;
                String conferenceArticleName = conference.getArticleName();
                if (!conferenceArticleName.isEmpty()){
                    i++;
                }

            }
        }
        return i;
    }
    //строка состоит из названий проектов,
    //за которые студент получил вознаграждение на соревнованиях.
    @Override
    public String getNameProjects() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();

        for (Event event: arrayList) {
            if (event instanceof Competition){
                Competition competition = (Competition) event;

                String projectName = competition.getProjectName();
                double winCash = competition.getWinCash();

                if (!projectName.isEmpty() && winCash > 0){
                    stringBuilder.append(projectName);
                }

            }
        }
        return stringBuilder.toString();
    }

    public void addEvent(Event event) throws DuplicateEventException {
        if (isDuplicateEvent(event)){
            throw new DuplicateEventException();
        }
        arrayList.add(event);
    }

    public Event getEvent(int index){
        return arrayList.get(index);
    }

    public Event getEvent(Date date) {
        for (Event event : arrayList) {
            //TODO date.equals ??
            if (event.getDate() == date) {
                    return arrayList.listIterator().next();
            }
        }
        return null;
    }

    public void removeEvent(Date date){
        for (Event event: arrayList) {
            if (event.getDate() == date){
                arrayList.remove(event);
            }
        }
    }

    public void removeEvent(Event e){
        arrayList.remove(e);
    }

    private boolean isDuplicateEvent(Event e){
        for (Event event: arrayList) {
            if (e.equals(event)){
                return true;
            }

            if (event instanceof Competition){
                Competition competition = (Competition) event;
                if(competition.equals(e))
                    return true;
            }

            if (event instanceof Olympiad){
                Olympiad olympiad = (Olympiad) event;
                if(olympiad.equals(e))
                    return true;
            }

            if (event instanceof Conference){
                Conference conference = (Conference) event;
                if(conference.equals(e))
                    return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();

        stringBuilder
                .append("Студент: ")
                .append(firstName)
                .append(" ")
                .append(lastName)
                .append("\n")
                .append("Год поступления:\n")
                .append(year)
                .append("model.Student id:\n")
                .append(studentId)
                .append("Ивенты: ");

        for (Event event : arrayList) {
            stringBuilder
                    .append(event.toString());
        }

        return stringBuilder.toString();
    }
}
