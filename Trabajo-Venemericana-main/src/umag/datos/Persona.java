
package umag.datos;

import java.io.Serializable;


public class Persona implements Serializable{
    
    protected String nombre;
    protected int identificacion;
    protected int edad;
    protected String genero;
    protected String ciudadResidencia;

    public Persona(String nombre, int identificacion, int edad, String genero, String ciudadResidencia) throws noSeleccionado {
        if (nombre.equals("") || ciudadResidencia.equals("")) throw new noSeleccionado("Todos los campos deben estar llenos"); 
        if (edad <= 10 || edad>100) throw new noSeleccionado("Edad no válida");
        
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", identificacion=" + identificacion + ", edad=" + edad + ", genero=" + genero + ", ciudadResidencia=" + ciudadResidencia +",";
    }

    
    
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getIdentificacion() {
        return identificacion;
    }

 
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the ciudadResidencia
     */
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    /**
     * @param ciudadResidencia the ciudadResidencia to set
     */
    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
    
    
    
}
