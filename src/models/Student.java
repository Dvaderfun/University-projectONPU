package models;

import exceptions.IncorrectDataException;
import models.events.Competition;
import models.events.Conference;
import models.events.Event;
import models.events.Olympiad;

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

    public Student(String firstName, String lastName) {
        if (firstName.isEmpty())
            throw new IncorrectDataException("Empty name");

        if (lastName.isEmpty())
            throw new IncorrectDataException("Empty surname");

        this.studentId = STUDENT_ID_DEFAULT;
        this.firstName = firstName;
        this.lastName = lastName;

        arrayList = new ArrayList<>();
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
        if (firstName.isEmpty())
            throw new IncorrectDataException("Empty name");

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty())
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

    public void addEvent(Event e){
        arrayList.add(e);
    }

    public Event getEvent(int index){
        return arrayList.get(index);
    }

    public Event getEvent(Date date) {
        for (Event event : arrayList) {
            if (event.getDate() == date) {
                    return arrayList.listIterator().next();
            }
        }
        return null;
    }

    public void deleteEvent(Date date){
        for (Event event: arrayList) {
            if (event.getDate() == date){
                arrayList.remove(event);
            }
        }
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
                .append("models.Student id:\n")
                .append(studentId)
                .append("Ивенты: ");

        for (Event event : arrayList) {
            stringBuilder
                    .append(event.toString());
        }

        return stringBuilder.toString();
    }
}
