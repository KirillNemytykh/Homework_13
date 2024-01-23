package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {

    @Test
    public void testSortByPriceFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 10, 12);
        Ticket ticket2 = new Ticket("KEM", "NSK", 50, 8, 9);
        Ticket ticket3 = new Ticket("NSK", "KEM", 50, 10, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 16, 18);
        Ticket ticket5 = new Ticket("SPB", "MSK", 350, 20, 22);
        Ticket ticket6 = new Ticket("KEM", "MSK", 500, 10, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 340, 11, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "SPB", null);
        Ticket[] expected = {ticket1, ticket7, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortByPriceOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 10, 12);
        Ticket ticket2 = new Ticket("KEM", "NSK", 50, 8, 9);
        Ticket ticket3 = new Ticket("NSK", "KEM", 50, 10, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 16, 18);
        Ticket ticket5 = new Ticket("SPB", "MSK", 350, 20, 22);
        Ticket ticket6 = new Ticket("KEM", "MSK", 500, 10, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 340, 11, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("SPB", "MSK", null);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortByPriceZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 10, 12);
        Ticket ticket2 = new Ticket("KEM", "NSK", 50, 8, 9);
        Ticket ticket3 = new Ticket("NSK", "KEM", 50, 10, 11);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 16, 18);
        Ticket ticket5 = new Ticket("SPB", "MSK", 350, 20, 22);
        Ticket ticket6 = new Ticket("KEM", "MSK", 500, 10, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 340, 11, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("SPB", "NSK", null);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWithComparatorFirsTicketLessTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 10, 12);
        Ticket ticket2 = new Ticket("KEM", "MSK", 50, 8, 13);

        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertTrue(actual < 0);
    }

    @Test
    public void testWithComparatorSecondTicketMoreTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 10, 12);
        Ticket ticket2 = new Ticket("KEM", "MSK", 50, 8, 9);

        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertTrue(actual > 0);
    }

    @Test
    public void testWithComparatorBothTicketsSameTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 10, 12);
        Ticket ticket2 = new Ticket("KEM", "MSK", 50, 8, 10);

        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertTrue(actual == 0);
    }


}
