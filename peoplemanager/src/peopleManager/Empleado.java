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
    
    String calcularSalario() {

        int s = Integer.valueOf(antiguedad);

        if (s < 5) {
            return "20000";
        }

        if (s >= 5 && s < 10) {
            switch (categoria) {
                case BACKEND:
                    return "30000";
                case DEVOPS:
                    return "35000";
                default: /* TechLead */
                    return "45000";
            }
        }

        if (s >= 10) {
            switch (categoria) {
                case CTO:
                    return "60000";
                case DEVOPS:
                    return "55000";
                default: /* Backend */
                    return "50000";
            }
        }

        return "0";
    }
    
    public String nameDescription(){
        return nombre + apellido;
    }
}
