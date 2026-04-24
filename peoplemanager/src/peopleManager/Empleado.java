/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peopleManager;

/**
 *
 * @author alumno
 */
public class Empleado {
    public String objectId;
    public String nombre;
    public String apellido;
    public String antiguedad;
    public Categoria categoria;

    public Empleado(String objectId, String nombre, String apellido, String antiguedad, Categoria categoria) {
        this.objectId = objectId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
        this.categoria = categoria;
    }
}
