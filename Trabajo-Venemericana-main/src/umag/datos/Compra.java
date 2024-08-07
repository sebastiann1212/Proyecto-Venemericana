
package umag.datos;

import java.io.Serializable;


public class Compra implements Serializable{
    private int idCompra;
    private Cliente cliente;
    private Libro libro;

    public Compra(int idCompra, Cliente cliente, Libro libro) {
        this.idCompra = idCompra;
        this.cliente = cliente;
        this.libro = libro;
        libro.setCantEjemplares(libro.getCantEjemplares()-1);
        cliente.setCantLibros(cliente.getCantLibros()+1);
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", cliente=" + cliente.nombre + ", libro=" + libro.getTitulo() +", Total compra: "+totalCompra()+ '}';
    }
    
    public float descuentoCompraEstudiante(){
        if(cliente.getOcupacion().equals("Estudiante")){
            return libro.getPrecio()*0.10f;
        }else{
            return 0f;
        }
    }
    
    public String totalCompra(){
        float total= libro.getPrecio()-descuentoCompraEstudiante();
        return " "+total;
    }
    
    
    
    /**
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    
    
    
    
    
    
    
}
