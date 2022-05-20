////////////////////////////////////////////////////////////////////
// Matteo Marangon 2009094
// Federica Bolognini 2011881
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

public class EItem {
    ItemType itemType;
    String name;
    double price;

    public EItem(ItemType itemType, String name, double price){
        if(itemType == null){
            throw new IllegalArgumentException("Il tipo non e' presente");
        }
        if(name == null){
            throw new IllegalArgumentException("Il nome non e' presente");
        }
        if(price <= 0){
            throw new IllegalArgumentException("Il prezzo e' inferiore a 0");
        }
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public ItemType getType(){
        return itemType;
    }

    public String getName(){
        return name;
    }
}
