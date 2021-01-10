/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicawrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanm
 */
public class Main {
    
    public static void main(String[] args) {
        
        Fichero f=new Fichero("./src/main/java/paginas");
        ExecuteHLRT h=new ExecuteHLRT();
        
        List<String> wrapper = new ArrayList<>();
        List<Tupla> tuplas=new ArrayList<>();
        
        try {
            
            String pagina1=f.leerFichero2("p1.html");
            String pagina2=f.leerFichero2("p2.html");
            String pagina3=f.leerFichero2("p3.html");
            
            List<String> paginas=new ArrayList<>();
            paginas.add(pagina1);
            paginas.add(pagina2);
            paginas.add(pagina3);
            
            List<List<Tupla>> etiquetas=new ArrayList<>();
            
            
            tuplas=h.ExecuteHLRTimpl(pagina1);
            for (int i = 0; i < tuplas.size(); i++) {
                
                //System.out.println(tuplas.get(i).getItem()+" "+tuplas.get(i).getPrecio());
            }
            etiquetas.add(tuplas);
            
            tuplas=h.ExecuteHLRTimpl(pagina2);
            for (int i = 0; i < tuplas.size(); i++) {
                
                //System.out.println(tuplas.get(i).getItem()+" "+tuplas.get(i).getPrecio());
            }
            etiquetas.add(tuplas);
            
            tuplas=h.ExecuteHLRTimpl(pagina3);
            for (int i = 0; i < tuplas.size(); i++) {
                
                //System.out.println(tuplas.get(i).getItem()+" "+tuplas.get(i).getPrecio());
            }
            etiquetas.add(tuplas);
            
            
            BuildHLRT hl=new BuildHLRT(etiquetas, paginas);
            wrapper=hl.BuildHLRTimpl();
            
            System.out.println("H: "+wrapper.get(0));
            System.out.println("L1: "+wrapper.get(1));
            System.out.println("R1: "+wrapper.get(2));
            System.out.println("Lk: "+wrapper.get(3));
            System.out.println("Rk: "+wrapper.get(4));
            System.out.println("T: "+wrapper.get(5));

            
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
