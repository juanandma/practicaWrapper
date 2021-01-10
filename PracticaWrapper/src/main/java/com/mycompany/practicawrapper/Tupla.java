/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicawrapper;

/**
 *
 * @author juanm
 */
public class Tupla {
    
    private String item;
    private String precio;

    public Tupla(String item, String precio) {
        this.item = item;
        this.precio = precio;
    }
    

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
}
