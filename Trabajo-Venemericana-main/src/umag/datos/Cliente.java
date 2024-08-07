
package umag.datos;

import java.io.Serializable;


public class Cliente extends Persona implements Serializable{
    
    private String ocupacion;
    private int cantLibros;

    public Cliente(String ocupacion, String nombre, int identificacion, int edad, String genero, String ciudadResidencia) throws noSeleccionado {
        super(nombre, identificacion, edad, genero, ciudadResidencia);
        this.ocupacion = ocupacion;
        this.cantLibros=0;
    }

    @Override
    public String toString() {
        return " Cliente{"+super.toString()+"ocupacion=" + ocupacion + ", cantidad de libros comprados=" + cantLibros+  '}';
    }
    
    
    public boolean descuentoCompra(){
        if(cantLibros==5){
            setCantLibros(0);            
            return true;
        }else{
            return false;
        }
    }
    
    
    
    /**
     * @return the ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion the ocupacion to set
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * @return the cantLibros
     */
    public int getCantLibros() {
        return cantLibros;
    }

    /**
     * @param cantLibros the cantLibros to set
     */
    public void setCantLibros(int cantLibros) {
        this.cantLibros = cantLibros;
    }
    
    
    
}
