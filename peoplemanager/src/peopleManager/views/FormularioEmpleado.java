package peopleManager.views;

public class FormularioEmpleado {
        public String EmpleadoId;
    public String NombreCompleto;
    public String Antiguedad;
    public String Salario;
    public String Categoria;

    public FormularioEmpleado(String EmpleadoId, String NombreCompleto, String Antiguedad, String Salario, String Categoria) {
        this.EmpleadoId = EmpleadoId;
        this.NombreCompleto = NombreCompleto;
        this.Antiguedad = Antiguedad;
        this.Salario = Salario;
        this.Categoria = Categoria;
    }
}
