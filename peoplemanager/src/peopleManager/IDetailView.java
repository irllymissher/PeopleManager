package peopleManager;

import java.util.ArrayList;

public interface IDetailView {
    void abir();
    void cerrar();
    void mostrarCategorias(ArrayList<String> categorias);
    
    void cargarAccionCalcular(Runnable accionCalcular);
    void cargarAccionGuardar(Runnable accionGuardar);
    
    Empleado obtenerEmpleado();
    void mostrarDatosEmpleado(Empleado empleaod);
    void mostrarSalario(String salario); /* Si no actualizarSalario */
}
