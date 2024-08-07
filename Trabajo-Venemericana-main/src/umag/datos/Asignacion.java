
package umag.datos;

import java.io.Serializable;


public class Asignacion implements Serializable{
    
    private int idAsignacion;
    private Libro libro;
    private Estanteria estanteria;

    public Asignacion(int idAsignacion, Libro libro, Estanteria estanteria) {
        this.idAsignacion = idAsignacion;
        this.libro = libro;
        this.estanteria = estanteria;
        estanteria.setCantLibro(estanteria.getCantLibro()+1);
    }
    
    

    /**
     * @return the idAsignacion
     */
    public int getIdAsignacion() {
        return idAsignacion;
    }

    /**
     * @param idAsignacion the idAsignacion to set
     */
    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the estanteria
     */
    public Estanteria getEstanteria() {
        return estanteria;
    }

    /**
     * @param estanteria the estanteria to set
     */
    public void setEstanteria(Estanteria estanteria) {
        this.estanteria = estanteria;
    }
    
    
    
    
}
