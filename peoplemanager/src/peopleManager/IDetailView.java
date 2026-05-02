package peopleManager;

import java.util.ArrayList;

public interface IDetailView {
    void abrirPantalla();
    void cerrarPantalla();
    void mostrarListaDeCategorias(ArrayList<String> nombresDeCategorias);
    
    void cargarAccionCalcular(Runnable accionCalcular);
    
    Empleado crearEmpleadoDesdeFormulario();
    void mostrarDetallesDelEmpleadoSeleccionado(Empleado empleadoSeleccionado);
    void mostrarSalarioCalculado(String salario); /* Si no actualizarSalario */
}
