package peopleManager;

import java.util.ArrayList;

public interface IListView {
    void abrirLista();
    void setFilaEmpleados(ArrayList<Empleado> empleado);
    String obtenerIdEmpleado();
    void setAccionSeleccionada(Runnable selectedAction);
    void setNuevaAccion(Runnable newAction);
}