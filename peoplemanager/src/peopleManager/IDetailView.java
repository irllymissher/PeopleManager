package peopleManager;

import java.util.ArrayList;

public interface IDetailView {
    void abrir();
    void cerrar();
    void mostrarCategorias(ArrayList<String> categorias);
    
    void cargarAccionCalcular(Runnable accionCalcular);
    
    Empleado obtenerEmpleado();
    void mostrarDatosEmpleado(Empleado empleado);
    void mostrarSalario(String salario); /* Si no actualizarSalario */
}
