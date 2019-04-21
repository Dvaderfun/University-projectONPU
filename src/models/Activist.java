package models;

public interface Activist {

    //возвращающий количество мероприятий, в которых участвовал студент;
    int getEventNumber();

    //возвращающий число призовых мест, занятых на олимпиадах;
    int getPrizePlaceNumber();

    //возвращающий число докладов на конференциях
    int getReportsNumber();

    //строка состоит из названий проектов,
    //за которые студент получил вознаграждение на соревнованиях.
    String getNameProjects();
}
