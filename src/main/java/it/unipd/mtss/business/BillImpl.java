////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.ItemType;
import it.unipd.mtss.model.User;
import java.util.List;

public class BillImpl implements Bill{
    
    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
        double total = 0;
        int processori = 0;
        EItem ProcessoreMenoCostoso = null;
        
        if(itemsOrdered == null) {
            throw new BillException("La lista degli ordini e' nulla");
        }

        if(itemsOrdered.isEmpty()) {
            throw new BillException("La lista degli ordini e' vuota");
        }
        
        //Calcolo prezzo totale
        for (EItem item : itemsOrdered) {
            total += item.getPrice();
            if (item.getType() == ItemType.Processor) {
                processori++;
                if ((ProcessoreMenoCostoso == null) || (ProcessoreMenoCostoso.getPrice() > item.getPrice())) {
                    ProcessoreMenoCostoso = item;
                }
            }
        }

        if (processori > 5) {
            total -= ProcessoreMenoCostoso.getPrice() * 0.5;  
        }
        
        return total;
    }
}
