/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import biblioteca.*;
import java.util.Scanner;

/**
 *
 * @author xavier
 */
public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Biblioteca b=new Biblioteca();
    public void mostrarMenuInit(){
        int opt;
        System.out.println("Que desea hacer?");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Vender Libro");
        System.out.println("3. Lista ordenada Libros");
        System.out.println("4. Consultar Libro");
        System.out.println("5. Dar Baja Libros no existentes");
        System.out.println("6. Visualizar Biblioteca");
        System.out.println("7. Salir");
        opt=sc.nextInt();
        llamarFuncion(opt);
        //return opt;
    }
    
    public void llamarFuncion(int opt){
        Libro ent;
        String ent2;
        switch(opt){
            case 1:
                ent=crearLibro();
                System.out.println("ent:" + ent);
                b.insertarLibro(ent);
                mostrarMenuInit();
                break;
            case 2:
                ent=crearLibro();
                try{
                    b.venderLibro(ent);
                }catch(ExceptionEmpty e){
                    System.out.println("Error: " + e.toString());
                }
                mostrarMenuInit();
                break;
            case 3:
                try{
                    b.mostrarBiblioteca();
                }catch(ExceptionEmpty e){
                    System.out.println("Error: " + e.toString());
                }
                mostrarMenuInit();
                break;
                
                case 4:
                    System.out.println("Ingrese el titulo para buscar:");
                    ent2=sc.nextLine();
                try{
                    b.buscarLibro(ent2);
                }catch(ExceptionEmpty e){
                    System.out.println("Error: " + e.toString());
                }
                mostrarMenuInit();
                break;
                
                case 5:
                try{
                    b.purgar();
                }catch(ExceptionEmpty e){
                    System.out.println("Error: " + e.toString());
                }
                mostrarMenuInit();
                break;
                case 6:
                    try{
                        b.visualizarBiblioteca();
                    }catch(ExceptionEmpty e){
                          System.out.println("Error: " + e.toString());  
                    }
                break;
                default:
                    System.exit(0);
                    
        }
    }
    public Libro crearLibro(){
        Libro l;
        String nomb=null, tit=null, isbn=null;
        float pre=0;
        int unid=0;
        System.out.println("Ingrese el titulo del libro:");
        tit=sc.next();
        System.out.println("Ingrese el autor del libro:");
        nomb=sc.next();
        System.out.println("Ingrese el precio del libro:");
        pre=sc.nextFloat();
        System.out.println("Ingrese las unidades del libro:");
        unid=sc.nextInt();
        l=new Libro(tit,nomb,pre,unid);
        return l;
    }
}
