/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleManager.PresentationLogicLayer.views;

/**
 *
 * @author alumno
 */
public class FilaEmpleado {
    public String EmpleadoId;
    public String NombreCompleto;
    public String Antiguedad;
    public String Salario;
    public String Categoria;

    public FilaEmpleado(String EmpleadoId, String NombreCompleto, String Antiguedad, String Salario, String Categoria) {
        this.EmpleadoId = EmpleadoId;
        this.NombreCompleto = NombreCompleto;
        this.Antiguedad = Antiguedad;
        this.Salario = Salario;
        this.Categoria = Categoria;
    }
}
