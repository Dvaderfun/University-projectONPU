public interface Activist {

    //возвращающий количество мероприятий, в которых участвовал студент;
    public int getEventNubmer();

    //возвращающий число призовых мест, занятых на олимпиадах;
    public int getPrizePlaceNumber();

    //возвращающий число докладов на конференциях
    public int getReportsNumber();

    //строка состоит из названий проектов,
    //за которые студент получил вознаграждение на соревнованиях.
    public String getNameProjects();
}
