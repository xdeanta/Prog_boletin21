/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
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
        int existe=0;
        Iterator<Libro> it=libreria.iterator();
        if(libreria.isEmpty()){
            libreria.add(l);
        }else{
            while(it.hasNext()){
                aux=it.next();
                if(aux.getISBN().equals(l.getISBN())){
                    existe=1;
                    index=libreria.indexOf(aux);
                    unidades=aux.getUnidades();
                    unidades++;
                    aux.setUnidades(unidades);
                }else{
                    existe=0;
                }
            }
            if(existe==0){
                libreria.add(l);
            }
        }
    }
    
    public void venderLibro(Libro l) throws ExceptionEmpty{
        int indx,aux2;
        Libro aux;
        if(libreria.isEmpty()){
            throw new ExceptionEmpty("La biblioteca esta vacia");
        }else{
            if(libreria.contains(l)){
                indx=libreria.indexOf(l);
                aux=libreria.get(indx);
                aux2=aux.getUnidades();
                if(aux2 > 0){
                    aux2--;
                    aux.setUnidades(aux2);
                    libreria.set(indx, aux);
                }else{
                    System.out.println("No hay existencia de este libro");
                }
            }else{
                System.out.println("Este libro no esta registrado");
            }
        }
    }
    
    public void buscarLibro(String l) throws ExceptionEmpty{
        if(libreria.isEmpty()){
            throw new ExceptionEmpty("Biblioteca vacía");
        }else{
            Iterator<Libro> it = libreria.iterator();
            Libro aux;
            while(it.hasNext()){
                aux=it.next();
                if(l.equals(aux.getISBN())){
                    System.out.println(aux.toString());
                }
            }
        }
        
    }
    
    /*public void mostrarBiblioteca() throws ExceptionEmpty{
        if(libreria.isEmpty()){
            throw new ExceptionEmpty("Biblioteca vacia");
        }else{
            ArrayList<String> ordenar = new ArrayList<String>();
            String[] ordena;
            String aux;
            Libro l;
            Iterator<Libro> it = libreria.iterator();
            while(it.hasNext()){
                l=it.next();
                aux=l.getTitulo();
                ordenar.add(aux);
                //System.out.println(aux);
            }
            ordena=new String[ordenar.size()];
            ordena=ordenar.toArray(ordena);
            Arrays.sort(ordena);
            for(int i=0;i<ordena.length;i++){
                System.out.println(ordena[i]);
            }
        }
    }*/
    
    public void mostrarBiblioteca() throws ExceptionEmpty{
        if(libreria.isEmpty()){
            throw new ExceptionEmpty("Biblioteca vacia");
        }else{
            Iterator<Libro> it = libreria.iterator();
            Libro aux;
            if(libreria.isEmpty()){
                System.out.println("Biblioteca vacia");
            }else{
                while(it.hasNext()){
                    aux=it.next();
                    System.out.println(aux.toString());
                }
            }
        }
    }
    
    public void purgar() throws ExceptionEmpty{
        if(libreria.isEmpty()){
            throw new ExceptionEmpty("Biblioteca vacia");
        }else{
            Iterator<Libro> it=libreria.iterator();
            Libro aux;
            //int indx = 0
            for(int i=0;i<libreria.size();i++){
                aux=libreria.get(i);
                if(aux.getUnidades() == 0){
                    libreria.remove(aux);
                }
            }
            System.out.println("Lista purgada");
        }
    }
}
