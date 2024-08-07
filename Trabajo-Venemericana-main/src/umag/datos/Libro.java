
package umag.datos;

import java.io.Serializable;

public class Libro implements Comparable<Libro>, Serializable{
    
    private int idLibro;
    private String titulo;
    private String categoria;
    private String editorial;
    private int precio;
    private int cantEjemplares;
    private boolean esFavorito;

    public Libro(int idLibro, String titulo, String categoria, String editorial, int cantEjemplares) throws noSeleccionado {
        if (titulo.equals("") || editorial.equals("")) throw new noSeleccionado("Los campos deben estar llenos");
        if(cantEjemplares <= 0 ) throw new noSeleccionado("No puede agregar un libro sin ejemplares");
        
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.editorial = editorial;
        this.cantEjemplares = cantEjemplares;
        this.esFavorito = false;     
        precio();
        
    }

    @Override
    public String toString() {
        
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", categoria=" + categoria + ", editorial=" + editorial + ", precio=" + precio + ", cantidad de ejemplares=" + cantEjemplares+ ", favorito: "+esFavorito+ '}';
            
    }
     
    
    public int getIdLibro() {
        return idLibro;
    }

    
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    
    public String getTitulo() {
        return titulo;
    }

   
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the cantEjemplares
     */
    public int getCantEjemplares() {
        return cantEjemplares;
    }

    /**
     * @param cantEjemplares the cantEjemplares to set
     */
    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    /**
     * @return the esFavorito
     */
    public boolean isEsFavorito() {
        return esFavorito;
    }

    /**
     * @param esFavorito the esFavorito to set
     */
    public void setEsFavorito(boolean esFavorito) {
        this.esFavorito = esFavorito;
    }

    private void precio() {
        if(categoria.equals("Accion")){
            this.precio=200;
        }else if(categoria.equals("Fantasia")){
            this.precio=150;
        }else if(categoria.equals("Terror")){
            this.precio=100;
        }else{
            this.precio=50;
        }
    }

    @Override
    public int compareTo(Libro libro) {
        if(precio> libro.getPrecio()){
            return 1;
        }else if(precio< libro.getPrecio()){
            return -1;
        }else{
            return 0;
        }
    }
}
