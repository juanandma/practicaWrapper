/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicawrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author juanm
 */
public class BuildHLRT {

    List<List<Tupla>> etiquetas;
    List<String> paginas;
    List<String> items;
    List<String> precios;

    public BuildHLRT(List<List<Tupla>> etiquetas, List<String> paginas) {
        this.etiquetas = etiquetas;
        this.paginas = paginas;

        items = new ArrayList<>();
        precios = new ArrayList<>();

    }

    public List<String> BuildHLRTimpl() {

        List<String> wrapper = new ArrayList<>();

        List<String> r1 = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        List<String> rk = new ArrayList<>();
        List<String> lk = new ArrayList<>();

        
        List<String> h=new ArrayList<>();
        List<String> t=new ArrayList<>();
        
        for (int i = 0; i < paginas.size(); i++) {
            items.clear();
            precios.clear();
            
            for (int j = 0; j < etiquetas.size(); j++) {

                items.add(etiquetas.get(i).get(j).getItem());
                precios.add(etiquetas.get(i).get(j).getPrecio());
            }

            if (items.size() == precios.size()) {

                for (int j = 0; j < items.size(); j++) {

                    r1.add(Suffix(paginas.get(i), items.get(j)));
                    l1.add(Prefix(paginas.get(i), items.get(j)));
                    rk.add(Suffix(paginas.get(i), precios.get(j)));
                    lk.add(Prefix(paginas.get(i), precios.get(j)));
                    
                    
                }

            }

            //System.out.println(getCommonPrefix(rk));
            //System.out.println(getCommonSuffix(lk));
        }
        
        String r1Comun=getCommonPrefix(r1);
        String rkComun=getCommonPrefix(rk);
        String l1Comun=getCommonSuffix(l1);
        String lkComun=getCommonSuffix(lk);
        
        for (int i = 0; i < paginas.size(); i++) {
            for (int j = 0; j < 10; j++) {
                
            
            h.add(Prefix(paginas.get(i), l1Comun));
            t.add(Suffix2(paginas.get(i), rkComun));
            }
        }
        
        String hComun = getCommonSuffix(h);
        String tComun = getCommonPrefix(t);
        //System.out.println(hComun);
        //System.out.println(tComun);

        boolean valido=false;
        int m=0;
        //do{
            
            for (int i = 0; i < paginas.size(); i++) {
                int hi=paginas.get(i).indexOf(hComun);
                int l1i=paginas.get(i).indexOf(l1Comun);
                int ti=paginas.get(i).indexOf(tComun);
                
                if(hi<l1i){
                    if(ti>(l1i+l1Comun.length())){
                        if(!(ti>hi&&ti<l1i)){
                            if(!(l1i>ti)){
                                m++;
                            }
                        }
                    }
                }
            }
        //}while(m!=paginas.size());
        if(m==paginas.size())
        System.out.println("Exito");
        
        wrapper.add(hComun);
        wrapper.add(l1Comun);
        wrapper.add(r1Comun);
        wrapper.add(lkComun);
        wrapper.add(rkComun);
        wrapper.add(tComun);

        return wrapper;
    }

    public String Prefix(String pagina, String etiqueta) {

        int r = pagina.indexOf(etiqueta);
        return pagina.substring(0, r);
    }

    public String Suffix(String pagina, String etiqueta) {

        int r = pagina.indexOf(etiqueta);
        
        //System.out.println(pagina.substring(r + etiqueta.length(), pagina.length() - 1));
        return pagina.substring(r + etiqueta.length(), pagina.length() - 1);
    }
    
    public String Suffix2(String pagina, String etiqueta) {

        int r = pagina.lastIndexOf(etiqueta);
        
        //System.out.println(pagina.substring(r + etiqueta.length(), pagina.length() - 1));
        return pagina.substring(r + etiqueta.length(), pagina.length() - 1);
    }
    

    private static String getCommonPrefix(List<String> list) {
        int matchIndex = recursiveCheckerPrefix(0, list);
        return list.get(0).substring(0, matchIndex);
    }

    private static int recursiveCheckerPrefix(int strIndex, List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (strIndex >= list.get(i).length()) {
                return strIndex;
            }

            if (list.get(0).charAt(strIndex) != list.get(i).charAt(strIndex)) {
                return strIndex;
            }
        }

        return recursiveCheckerPrefix(strIndex + 1, list);

    }

    private static String getCommonSuffix(List<String> list) {
        int matchIndex = recursiveCheckerSuffix(1, list);
        return list.get(0).substring(list.get(0).length()-matchIndex+1, list.get(0).length());
    }

    private static int recursiveCheckerSuffix(int strIndex, List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (strIndex >= list.get(i).length()) {
                return strIndex;
            }

            if (list.get(0).charAt(list.get(0).length()-strIndex) != list.get(i).charAt(list.get(i).length()-strIndex)) {
                return strIndex;
            }
        }

        return recursiveCheckerSuffix(strIndex + 1, list);

    }

}
