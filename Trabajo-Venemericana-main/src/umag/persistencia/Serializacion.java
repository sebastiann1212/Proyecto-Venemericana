/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umag.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import umag.control.ControlLibreria;

/**
 *
 * @author scava
 */
public class Serializacion {

    public void guardar(ControlLibreria x, String archi) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream(archi);

        ObjectOutputStream gua = new ObjectOutputStream(file);
        gua.writeObject(x);
        file.close();
        gua.close();
    }

    public ControlLibreria recuperar(String archi) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(archi);
        ObjectInputStream rec = new ObjectInputStream(file);
        ControlLibreria con = (ControlLibreria) rec.readObject();
        file.close();
        rec.close();
        return con;
    }
}
