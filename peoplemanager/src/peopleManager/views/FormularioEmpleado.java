package peopleManager.views;

public class FormularioEmpleado {
    public String EmpleadoId;
    public String Nombre;
    public String Apellido;
    public String Antiguedad;
    public String Salario;
    public String Categoria;

    public FormularioEmpleado(String EmpleadoId, String Nombre, String Apellido, String Antiguedad, String Salario, String Categoria) {
        this.EmpleadoId = EmpleadoId;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Antiguedad = Antiguedad;
        this.Salario = Salario;
        this.Categoria = Categoria;
    }
}
