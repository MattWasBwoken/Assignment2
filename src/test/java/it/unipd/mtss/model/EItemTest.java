////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EItemTest {

    private EItem Processor;
    private EItem Motherboard;
    private EItem Mouse;
    private EItem Keyboard;

    @Before
    public void setup() {
        Processor = new EItem( ItemType.Processor, "Intel Processore i5",265.00);
        Motherboard = new EItem(ItemType.Motherboard, "MSI Scheda Madre", 90.00);
        Mouse = new EItem( ItemType.Mouse, "Logitech Mouse Wireless", 65.00);
        Keyboard = new EItem( ItemType.Keyboard, "Logitech Tastiera", 80.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTipologiaElementoNullo() {
        new EItem(null, "Intel Processore i5", 265.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomeElementoNullo() {
        new EItem(ItemType.Processor, null, 265);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrezzoElementoNegativo() {
        new EItem(ItemType.Processor, "Intel Processore i5", -3.00);
    }

    @Test
    public void testGetName() {
        assertEquals("Intel Processore i5", Processor.getName());
        assertEquals("MSI Scheda Madre", Motherboard.getName());
        assertEquals("Logitech Mouse Wireless", Mouse.getName());
        assertEquals("Logitech Tastiera", Keyboard.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(265.00, Processor.getPrice(), 0.0);
        assertEquals(90.00, Motherboard.getPrice(), 0.0);
        assertEquals(65.00, Mouse.getPrice(), 0.0);
        assertEquals(80.00, Keyboard.getPrice(), 0.0);
    }

    @Test
    public void testGetType() {
        assertEquals(ItemType.Processor, Processor.getType());
        assertEquals(ItemType.Motherboard, Motherboard.getType());
        assertEquals(ItemType.Mouse, Mouse.getType());
        assertEquals(ItemType.Keyboard, Keyboard.getType());
    }
}
