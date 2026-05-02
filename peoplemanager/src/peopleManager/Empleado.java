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
    public Categoria categorias;

    public Empleado(String objectId, String nombre, String apellido, String antiguedad, Categoria categoria) {
        this.objectId = objectId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
        this.categorias = categoria;
    }
    
    public String calcularSalario() {

        int aniosDeAntiguedad = Integer.valueOf(antiguedad);

        if (aniosDeAntiguedad < 5) {
            return "20000";
        }

        if (aniosDeAntiguedad >= 5 && aniosDeAntiguedad < 10) {
            switch (categorias) {
                case BACKEND:
                    return "30000";
                case DEVOPS:
                    return "35000";
                default: /* TechLead */
                    return "45000";
            }
        }

        if (aniosDeAntiguedad >= 10) {
            switch (categorias) {
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
        return this.nombre + this.apellido;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public Categoria getCategoria() {
        return categorias;
    }
}
