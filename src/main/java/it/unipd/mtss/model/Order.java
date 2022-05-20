////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.util.List;
import java.time.LocalTime;

public class Order {
    List<EItem> listaElementi; 
    User utente;
    LocalTime orarioOrdine;
    double price; 
    
    public Order(List<EItem> listaElementi, 
            User utente,
            LocalTime orarioOrdine,
            double price) {
        if(listaElementi.isEmpty()) {
            throw new IllegalArgumentException("La lista e' vuota");
        }
        if(utente == null) {
            throw new IllegalArgumentException("L'utente non e' valido");
        }
        if(orarioOrdine == null) {
            throw new IllegalArgumentException("L'ora non e' valido");
        }
        this.listaElementi = listaElementi; 
        this.utente = utente;
        this.orarioOrdine = orarioOrdine;
        this.price = price;
    }
    
    public double getPrice() {
        return price; 
    }
    
    public LocalTime getOrarioOrdine() {
        return orarioOrdine;
    }
    
    public User getUser() {
        return utente;
    }
    
    public List<EItem> getListaElementi(){
        return listaElementi;
    }
    
    public void setPrice(double newPrice) {
        price = newPrice;
    }
}
