package ru.netology.java.tickets;

import java.util.Arrays;

public class ManagerTickets {
    public Repository repository;

    public ManagerTickets(Repository repository) {
        this.repository = repository;

    }

    /**
     * Используем метод добавления в массив из репозитория методов.
     *
     * @param ticket Билет
     */
    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public void deleteId(int id) {
        repository.deleteId(id);
    }

    /**
     * @param ticket      Берём переменную билет
     * @param airportFrom - проверяем аэропорт отправки
     * @return - возвращаем аэропорты соответствующие запросы по отправке
     */
    public boolean matchesAirportFrom(Ticket ticket, String airportFrom) {
        return ticket.getAirportFrom().equals(airportFrom);

    }

    /**
     * @param ticket    - переменная билет
     * @param airportTo - проверяем аэропорт прибытия
     * @return - возвращаем аэропорты соответствующие запросу прибытия
     */
    public boolean matchesAirportTo(Ticket ticket, String airportTo) {
        return ticket.getAirportTo().equals(airportTo);

    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];

            if (matchesAirportFrom(ticket, from)) {
                if (matchesAirportTo(ticket, to)) {
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;

                }
            }
        }

        Arrays.sort(result);
        return result;
    }
}


