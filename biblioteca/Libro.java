/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author xdeantabelisario
 */
public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private float precio;
    private int unidades;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Libro(String titulo, String autor, String ISBN, float precio, int unidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.precio = precio;
        this.unidades = unidades;
    }

    public Libro() {
        this(null,null,null,0,0);
    }
    
    @Override
    public String toString(){
        return titulo + ", " + autor + ", " + ISBN + ", " + precio + ", " + unidades;
    }
}
