
package umag.datos;

import java.io.Serializable;


public class Gerente extends Persona implements Serializable{
    
    private int añosExperiencia;
    private int salario;

    public Gerente(int añosExperiencia, int salario, String nombre, int identificacion, int edad, String genero, String ciudadResidencia) throws noSeleccionado {
        super(nombre, identificacion, edad, genero, ciudadResidencia);
        this.añosExperiencia = añosExperiencia;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Gerente{" +super.toString()+ "anios de Experiencia=" + añosExperiencia + ", salario=" + salario + '}';
    }
    
    public float comision(){
        if(añosExperiencia>=1 && añosExperiencia<=3){
            return salario*(5/100);
        }else if( añosExperiencia>3){
            return salario*(10/100);
        }else{
            return 0;
        }        
    }
    
    public float totalaPagar(){
        return salario+comision();
    }
    

    /**
     * @return the añosExperiencia
     */
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    /**
     * @param añosExperiencia the añosExperiencia to set
     */
    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    /**
     * @return the salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    
}
