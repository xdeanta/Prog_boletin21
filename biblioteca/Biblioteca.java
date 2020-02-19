/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author xdeantabelisario
 */
public class Biblioteca {
    private ArrayList<Libro> libreria;

    public Biblioteca() {
        libreria=new ArrayList<Libro>();
    }
    
    public void insertarLibro(Libro l){
        Libro aux;
        int index, unidades;
        Iterator<Libro> it=libreria.iterator();
        if(libreria.isEmpty()){
            libreria.add(l);
        }else{
            while(it.hasNext()){
                aux=it.next();
                if(aux.getISBN().equals(l.getISBN())){
                    index=libreria.indexOf(aux);
                    unidades=aux.getUnidades();
                    unidades++;
                    aux.setUnidades(unidades);
                }else{
                    libreria.add(l);
                }
            }
        }
    }
    
    public void venderLibro(Libro l) throws ExceptionEmpty{
        if(libreria.isEmpty()){
            throw new ExceptionEmpty("La biblioteca esta vacia");
        }
    }
    
    public void buscarLibro(Libro l){
        
    }
    
    public void mostrarBiblioteca(){
        
    }
    
    public void purgar(){
        
    }
}
