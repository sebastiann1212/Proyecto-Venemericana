
package umag.datos;

import java.io.Serializable;


public class Estanteria implements Serializable{
    
    private int idEstanteria;
    private String tipoCategoria;
    private int cantLibro;

    public Estanteria(int idEstanteria, String tipoCategoria) {
        this.idEstanteria = idEstanteria;
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public String toString() {
        return "Estanteria{" + "idEstanteria=" + idEstanteria + ", tipoCategoria=" + tipoCategoria + ", cantLibro=" + cantLibro + '}';
    }


    
    /**
     * @return the idEstanteria
     */
    public int getIdEstanteria() {
        return idEstanteria;
    }

    /**
     * @param idEstanteria the idEstanteria to set
     */
    public void setIdEstanteria(int idEstanteria) {
        this.idEstanteria = idEstanteria;
    }

    /**
     * @return the tipoCategoria
     */
    public String getTipoCategoria() {
        return tipoCategoria;
    }

    /**
     * @param tipoCategoria the tipoCategoria to set
     */
    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    /**
     * @return the cantLibro
     */
    public int getCantLibro() {
        return cantLibro;
    }

    /**
     * @param cantLibro the cantLibro to set
     */
    public void setCantLibro(int cantLibro) {
        this.cantLibro = cantLibro;
    }
    
    
}
