////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.business.BillImpl;
import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.ItemType;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillImplTest {
    
    private List<EItem> itemsOrdered;
    private BillImpl testBill; 
    private User user; 
    
    @Before
    public void setup() {
        itemsOrdered = new ArrayList<EItem>();
        testBill = new BillImpl();
        user = new User("MattWasBwoken","Matteo","Marangon",LocalDate.of(2000, 8, 12));
    }
    
    @Test
    public void testCalcoloDelTotale(){
        
        itemsOrdered.add(new EItem( ItemType.Processor, "Intel Processore i5",265.00));
        itemsOrdered.add(new EItem( ItemType.Motherboard, "MSI Scheda Madre", 90.00));
        itemsOrdered.add(new EItem( ItemType.Mouse, "Logitech Mouse Wireless", 65.00));
        itemsOrdered.add(new EItem( ItemType.Mouse, "Logitech Mouse Wireless", 65.00));
        itemsOrdered.add(new EItem( ItemType.Keyboard, "Logitech Tastiera", 80.00));
        
        assertEquals(565, testBill.getOrderPrice(itemsOrdered,user), 0.0);
    }
    
    @Test(expected=BillException.class)
    public void testCalcoloDelTotaleConListaOrdiniVuota() {
        
        testBill.getOrderPrice(itemsOrdered, user);
    }
    
    @Test(expected=BillException.class)
    public void testCalcoloDelTotaleConListaOrdiniNulla() {
        itemsOrdered = null;
        testBill.getOrderPrice(itemsOrdered, user);
    }
    
    @Test
    public void testScontoProcessori() {
        for(int i=0; i<6; i++) {
            itemsOrdered.add(new EItem(ItemType.Processor, "Intel Processore i5",265.00));
        }       
        assertEquals(1311.75, testBill.getOrderPrice(itemsOrdered,user), 0.0);
    }
    
    @Test
    public void testMouseRegalo() {

        for(int i=0; i<11; i++) {
            itemsOrdered.add(new EItem( ItemType.Mouse, "Logitech Mouse Wireless",65.00));
        }       
        assertEquals(650.00, testBill.getOrderPrice(itemsOrdered,user), 0.0);
    }
    
    @Test
    public void testArticoloRegalo() {

        for(int i=0; i<3; i++) {
            itemsOrdered.add(new EItem( ItemType.Mouse, "Logitech Mouse Wireless",65.00));
        }       
        for(int i=0; i<3; i++) {
            itemsOrdered.add(new EItem( ItemType.Keyboard, "Logitech Tastiera",80.00));
        }
        assertEquals(370.00, testBill.getOrderPrice(itemsOrdered,user), 0.0);
    }
    
    @Test
    public void testSconto1000(){
        for(int i=0; i<12; i++) {
            itemsOrdered.add(new EItem( ItemType.Motherboard, "MSI Scheda Madre",90.00));
        }    
        assertEquals(972.00, testBill.getOrderPrice(itemsOrdered,user), 0.0);
    }
    
    @Test(expected=BillException.class)
    public void testOrdineMax30() {

        for(int i=0; i<32; i++) {
            itemsOrdered.add(new EItem( ItemType.Motherboard, "MSI Scheda Madre",90.00));
        }

        testBill.getOrderPrice(itemsOrdered, user);
    }
}
