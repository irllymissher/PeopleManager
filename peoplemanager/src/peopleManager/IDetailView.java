package peopleManager;

import java.util.ArrayList;

public interface IDetailView {
    void abrirPantalla();
    void cerrarPantalla();
    void mostrarListaDeCategorias(ArrayList<String> nombresDeCategorias);
    
    void cargarAccionCalcular(Runnable accionCalcular);
    void cargarAccionGuardar(Runnable accionGuardar);
    
    Empleado crearEmpleadoDesdeFormulario();
    void mostrarDetallesDelEmpleadoSeleccionado(Empleado empleadoSeleccionado);
    void mostrarSalarioCalculado(String salarioResultante); /* Si no actualizarSalario */
}
