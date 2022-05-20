////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class UserTest {

    private User Demi = new User("MattWasBwoken", "Matteo", "Marangon", LocalDate.of(2000, 8, 12));

    @Test(expected = IllegalArgumentException.class)
    public void testUsernameNullo() {
        new User(null,"Matteo","Marangon",LocalDate.of(2000, 8, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomeNullo() {
        new User("MattWasBwoken",null,"Marangon",LocalDate.of(2000, 8, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCognomeNullo() {
        new User("MattWasBwoken","Matteo",null,LocalDate.of(2000, 8, 12));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDataNulla() {
        new User("MattWasBwoken","Matteo","Marangon",null);
    }

    @Test
    public void testGetAge() {
        assertEquals(Demi.getAge(), 22);
    }

    @Test
    public void testGetName() {
        assertEquals(Demi.getName(), "Matteo");
    }

    @Test
    public void testGetSurname() {
        assertEquals(Demi.getSurname(), "Marangon");
    }

    @Test
    public void testGetUsername() {
        assertEquals(Demi.getUsername(), "MattWasBwoken");
    }
}
