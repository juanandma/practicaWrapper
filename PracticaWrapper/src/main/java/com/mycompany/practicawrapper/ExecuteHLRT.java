/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicawrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanm
 */
public class ExecuteHLRT {
    
    private String h;
    private String t;
    private String l [];
    private String r [];

    public ExecuteHLRT() {
        
        this.h = "<P>";
        this.t = "<HR>";
        this.l = new String[2];
        this.r = new String[2];
        l[0]="<B>";
        l[1]="<I>";
        r[0]="</B>";
        r[1]="</I>";
    }
    
    
            
    
    public List<Tupla> ExecuteHLRTimpl(String pagina){
        
        int cursor;
        
        String item, precio;
        
        List<Tupla> tuplas=new ArrayList<>();
        
        int h = pagina.indexOf(this.h);
        int t = pagina.indexOf(this.t);
        
        //System.out.println(pagina.substring(h));
        //System.out.println(pagina.substring(t));   
        
        
        cursor = pagina.indexOf(l[0], h);
        

        while(cursor < t && cursor != -1){
            
            //cursor=pagina.indexOf(cursor, pagina.indexOf(l[0]));
            
            item= pagina.substring(cursor+3, pagina.indexOf(r[0], cursor));
            
            precio= pagina.substring(pagina.indexOf(l[1], cursor)+3, pagina.indexOf(r[1], cursor));
            
            Tupla tupla=new Tupla(item, precio);
            tuplas.add(tupla);
            
            cursor=pagina.indexOf(l[0] , cursor+3);
            
            
        }
        return tuplas;
        
    }
    
}
