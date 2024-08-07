
package umag.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JOptionPane;
import umag.datos.Asignacion;
import umag.datos.Cliente;
import umag.datos.Compra;
import umag.datos.Estanteria;
import umag.datos.Gerente;
import umag.datos.Libro;
import umag.datos.Persona;



public class ControlLibreria implements Serializable{
    private String nombre;
    
    private ArrayList<Persona> personas; 
    private ArrayList<Libro> libros;
    private ArrayList<Compra> compras;
    private ArrayList<Estanteria> estanterias;
    private ArrayList<Asignacion> asignaciones;

    public ControlLibreria(String nombre) {
        this.nombre = nombre;
        personas= new ArrayList<>();
        libros = new ArrayList<>();
        compras = new ArrayList<>();
        estanterias= new ArrayList<>();
        asignaciones= new ArrayList<>();
    }
    
    public void addPersona(Persona pe){ //Polimorfismo con ligadura dinamica
        personas.add(pe);
    }
    
   public void addLibro(Libro li){
        libros.add(li);
    }
    
    public void addEstanteria(Estanteria es){
        estanterias.add(es);
    }
    
    public void addAsignacion(Asignacion as){
        asignaciones.add(as);
    }
    
    public void addCompras(Compra co){
        compras.add(co);
    }
    
    public boolean removeLibro(int id) {
        Libro encontrado = buscarLibro(id);
            if (encontrado != null && encontrado.getCantEjemplares() == 0) {
                libros.remove(encontrado);
                return true;
            } else {
                return false;
            }
    }
    
    public Cliente buscarCliente(int id){
        for (Persona pers: personas) {
            if (pers.getIdentificacion() == id) {
               return (Cliente) pers;
            }
        }        
        return null;
    }
    
    public boolean removeCliente(int cedula) {
        Cliente encontrado = buscarCliente(cedula);
        if(encontrado!=null){
            personas.remove(encontrado);
            return true;
        }
        return false;
    }
    
    public String listarCompras() {
        String lis = "";
        
        for (Compra compra : compras) {
            lis += compra.toString()+"\n";
        }
        return lis;
    }
    
    public float costoInventario(){
        int suma=0;
        
        for (Libro libro: libros) {
            suma+=libro.getCantEjemplares()*libro.getPrecio();
        }
        return suma;
    }
    
    public String ListarCliente(){
        String lis="LISTA DE CLIENTES:\n";
        for (Persona persona : personas) {
            if(persona instanceof Cliente){
                lis+=persona.toString()+"\n";
            }
        }
        return lis;
    }
    public String ListarPersona(){
        String lis="LISTA DE PERSONAS:\n";
        for (Persona persona : personas) {
            lis+=persona.toString()+"\n";
        }
        return lis;
    }
    
    public String listarLibrosEditorial(String editorial){
        String lis="";
        
        for(Libro libro: libros){
            if(libro.getEditorial().equals(editorial)){
                lis+=libro.toString()+"\n";
            }
        }
        return lis;
    }
    public String listarClientePorCiudad(String ciudad){
        String lis="";
        for (Persona persona : personas) {
            if(persona instanceof Cliente){
                if(persona.getCiudadResidencia().equals(ciudad)){
                    Cliente cl= (Cliente) persona;
                    lis+=cl.toString()+"\n";
                }
            }
        }
        return lis; 
    }
    public String historialCompra( int cedula){
        String lis = "";
        for (Compra comp : compras) {
            if (comp.getCliente().getIdentificacion()==cedula) {
                lis+="Titulo: "+comp.getLibro().getTitulo()+" Categoria: "+comp.getLibro().getCategoria()+"\n";
            }
        }
        return lis;
    }
    
    public Libro buscarLibro(int id) {
        Libro li = null;
        for (Libro libro : libros) {
            if (libro.getIdLibro()==id) {
                li = libro; 
            }
        }
        return li;
    }
    public Estanteria buscarEstanteria(int id) {
        Estanteria li = null;
        for (Estanteria estanteria: estanterias) {
            if (estanteria.getIdEstanteria()==id) {
                li = estanteria; 
            }
        }
        return li;
    }    
    public Cliente masLibrosCompradosCliente(){
        int mayor=0;
        Cliente cliente=null;
        
        for (Persona persona : personas) {
            if(persona instanceof Cliente){
                if(mayor< ((Cliente) persona).getCantLibros()){
                    mayor=((Cliente) persona).getCantLibros();
                    cliente= (Cliente) persona;
                }
            }
        }
        return cliente;
    }
    
    
    public float promedioComprasCliente(int id){
        
        float suma=0;
        float total=0;
                
        for(Compra compra: compras){
            if(compra.getCliente().getIdentificacion()==id){
                total=compra.getCliente().getCantLibros();
                suma+=compra.getLibro().getPrecio();
            }
        }
        return (float)suma/total;
    }
    
    public boolean modificarNombreCliente(int id, String newNombre){
        
        for (Persona persona : personas) {
            if(persona instanceof  Cliente){
                if(persona.getIdentificacion()==id){
                    persona.setNombre(newNombre);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean libroFavorito(int id) {
        Libro encontrado = buscarLibro(id);
        if(encontrado!=null){
            encontrado.setEsFavorito(true);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean cambiarCiudad(int cedula, String newCiudad) {
        for (Persona persona : personas) {
            if(persona instanceof Gerente){
                if (persona.getIdentificacion() == cedula) {
                persona.setCiudadResidencia(newCiudad);
                return true;
                }
            }
        }
        return false;
    }
    
    public String listarFavoritos() {
        String lis = "";
        for (Libro libro : libros) {
            if (libro.isEsFavorito()) {
                lis += libro.toString() + "\n";
            }
        }
        return lis;
    }
    
    public float promSalarioTotalGerente(){
        float suma=0;
        float index=0;
        for (Persona persona : personas) {
            if(persona instanceof  Gerente){
                Gerente gerente = (Gerente) persona;
                suma+= gerente.totalaPagar();
                index++;
                
            }
        }
        return (float)suma/index;
    }
    
    public void ordenarLibroPrecio(){
        Collections.sort(libros);
    }
    
    public String listarLibros()
    {
        String lis="";
        for (Libro libro: libros) {
            lis+=libro.toString()+"\n";
        }
        return lis;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    /**
     * @return the libros
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    /**
     * @return the compras
     */
    public ArrayList<Compra> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }


    /**
     * @return the estanterias
     */
    public ArrayList<Estanteria> getEstanterias() {
        return estanterias;
    }

    /**
     * @param estanterias the estanterias to set
     */
    public void setEstanterias(ArrayList<Estanteria> estanterias) {
        this.estanterias = estanterias;
    }

    /**
     * @return the asignaciones
     */
    public ArrayList<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    /**
     * @param asignaciones the asignaciones to set
     */
    public void setAsignaciones(ArrayList<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    
    
    
}
