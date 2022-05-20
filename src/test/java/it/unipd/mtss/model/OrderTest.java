////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
    private EItem item;
    private List<EItem> itemsOrdered;
    private User user;
    private LocalTime time;
    private Order ordine;

    @Before
    public void setup() {
        itemsOrdered = new ArrayList<EItem>();
        user = new User("MattWasBwoken","Matteo","Marangon",LocalDate.of(2000, 8, 12));
        time = LocalTime.of(15,00);
        item = new EItem(ItemType.Processor, "Intel Processore i5", 265.00);
        itemsOrdered.add(item);
        ordine = new Order(itemsOrdered, user, time, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListaElementiVuota() {
        itemsOrdered.clear();
        new Order(itemsOrdered, user, time, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomeUtenteNullo() {
        new Order(itemsOrdered, null, time, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDataNulla() {
        new Order(itemsOrdered, user, null, 0);
    }

    @Test
    public void testGetListaElementi() {
        assertEquals(ordine.getListaElementi(), itemsOrdered);
    }

    @Test
    public void testGetOrarioOrdine() {
        assertEquals(ordine.getOrarioOrdine(), time);
    }

    @Test
    public void testSetPriceAndgetPrice() {
        ordine.setPrice(15);
        assertEquals(15,ordine.getPrice(),0.0);
    }

    @Test
    public void testGetUser() {
        assertEquals(ordine.getUser(), user);
    }
}
