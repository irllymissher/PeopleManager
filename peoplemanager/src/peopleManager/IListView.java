package peopleManager;

import java.util.ArrayList;

/**
 * Esta interfaz funciona como un contrato estricto que dice
 * qué acciones se pueden hacer en esa pantalla, pero no dice
 * cómo se hacen.
*/
public interface IListView {
    void abrirLista();
    void cargarEmpleadoEnTabla(ArrayList<Empleado> listaDeEmpleados);
    String obtenerIdDelEmpleadoSeleccionado();
    void asignarAccionAlSeleccionarEmpleado(Runnable accionSeleccionar);
    void asignarAccionParaNuevoEmpleado(Runnable accionNuevoEmpleado);
}