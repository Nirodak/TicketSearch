package ru.netology.java.tickets;

public class Ticket implements Comparable<Ticket> {


    protected int id;
    protected int price;
    protected String airportFrom;
    protected String airportTo;
    protected int timeInFlyMinutes;
    private static int count = 0;

    public int getId() {

        return id;
    }

    public String getAirportFrom() {
        return airportFrom;

    }

    public String getAirportTo() {

        return airportTo;
    }

    public Ticket(int price, String airportFrom, String airportTo, int timeInFlyMinutes) {
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.timeInFlyMinutes = timeInFlyMinutes;
        count++;
        this.id = count;

    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {

            return 0;
        }
    }
}
