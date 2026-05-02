package peopleManager;

import java.util.ArrayList;

/**
 * Esta interfaz funciona como un contrato estricto que dice
 * qué acciones se pueden hacer en esa pantalla, pero no dice
 * cómo se hacen.
*/
public interface IListView {
    void abrirLista();
    void cargarFilaEmpleados(ArrayList<Empleado> empleado);
    String obtenerIdEmpleado();
    void cargarAccionSeleccionada(Runnable selectedAction);
    void cargarNuevaAccion(Runnable newAction);
}