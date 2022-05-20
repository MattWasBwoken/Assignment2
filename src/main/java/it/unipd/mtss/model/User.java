////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.time.LocalDate;

public class User {
    String username, Nome, Cognome;
    LocalDate dataNascita;

    public User(String username, 
            String Nome, 
            String Cognome, 
            LocalDate dataNascita) {
        if(username == null) {
            throw new IllegalArgumentException("Il nickname non e' valido");
        }
        if(Nome == null) {
            throw new IllegalArgumentException("Il nome non e' valido");
        }
        if(Cognome == null) {
            throw new IllegalArgumentException("Il cognome non e' valido");
        }
        if(dataNascita == null) {
            throw new IllegalArgumentException("La data di nascita non e' valida");
        }
        this.username = username;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.dataNascita = dataNascita;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getName() {
        return Nome;
    }
    
    public String getSurname() {
        return Cognome;
    }
    
    public int getAge() {
        return LocalDate.now().getYear()-dataNascita.getYear();
    }
}
