/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicawrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class Fichero {

    private String Ficheros;
    private String Practica = ".\\";

    public Fichero(String ficheros) {
        if(ficheros.charAt(ficheros.length()-1)!='/' || ficheros.charAt(ficheros.length()-1)!='\\'){
            ficheros=ficheros+'/';
        }
        this.Ficheros = ficheros;
    }

    public List<String> leerFichero(String fileName) {
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get(Ficheros + fileName));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lineas;

    }
    
    public String leerFichero2(String fileName) throws IOException {
        String pagina="";
        
        try {
            
            pagina = Files.readString(Paths.get(Ficheros + fileName));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pagina;

    }
    

    
    
}
