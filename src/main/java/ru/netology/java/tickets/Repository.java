package ru.netology.java.tickets;

public class Repository {

    private Ticket[] tickets = new Ticket[0];

    /**
     * Добавление билета в массив
     *
     * @param ticket билет
     */
    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    /**
     * @return Отображение всех билетов в массиве
     */
    public Ticket[] findAll() {
        return tickets;
    }


    /**
     * Удаления билета по Id
     *
     * @param id Айди билета
     * @return возвращаем массив без удаляемого объекта
     */
    public Ticket[] deleteId(int id) {
        int ticketsWithoutId = tickets.length - 1;
        Ticket[] tmp = new Ticket[ticketsWithoutId];
        int position = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[position] = ticket;
                position++;

            }
        }
        tickets = tmp;
        return tickets;
    }

}
