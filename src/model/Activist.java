package model;

public interface Activist {

    //возвращающет количество мероприятий, в которых участвовал студент;
    int getEventNumber();

    //возвращающает число призовых мест, занятых на олимпиадах;
    int getPrizePlaceNumber();

    //возвращает число докладов на конференциях
    int getReportsNumber();

    String getNameProjects();
}
