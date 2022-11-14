import ru.netology.java.tickets.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTickets {
    Repository repository = new Repository();
    ManagerTickets manager = new ManagerTickets(repository);


    Ticket ticket1 = new Ticket(5_000, "MOW", "LEN", 90);
    Ticket ticket9 = new Ticket(1_000, "MOW", "LEN", 180);
    Ticket ticket10 = new Ticket(5_000, "MOW", "LEN", 180);
    Ticket ticket2 = new Ticket(2500, "KRD", "SOC", 30);
    Ticket ticket3 = new Ticket(5_000, "LEN", "MOW", 90);
    Ticket ticket4 = new Ticket(10_000, "LEN", "MOW", 45);
    Ticket ticket5 = new Ticket(7_500, "BAR", "LON", 40);
    Ticket ticket6 = new Ticket(25_000, "NED", "MOW", 360);
    Ticket ticket7 = new Ticket(10_000, "KRD", "SOC", 20);
    Ticket ticket8 = new Ticket(25_000, "SOC", "KRD", 10);


    /**
     * Тест добавления и удаления объекта по ID из массива
     */
    @Test
    public void testDeleteId() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        manager.deleteId(ticket1.getId());

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Assertions.assertArrayEquals(expected, repository.findAll());

    }

    /**
     * Тест поиска
     */
    @Test
    public void testSearch() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);


        Ticket[] expected = {ticket9, ticket1, ticket10};
        Assertions.assertArrayEquals(expected, manager.findAll("MOW", "LEN"));
    }

    /**
     * Тест поиска с удалением
     */
    @Test
    public void testSearchWithDelete() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.deleteId(ticket1.getId());

        Ticket[] expected = {ticket9, ticket10};
        Assertions.assertArrayEquals(expected, manager.findAll("MOW", "LEN"));
    }

    /**
     * Тест поиска с нулевым результатом
     */
    @Test
    public void testSearchNullResult() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findAll("BNB", "SOC"));
    }
}
