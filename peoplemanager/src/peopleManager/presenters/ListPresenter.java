package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.Empleado;
import peopleManager.IListView;

public class ListPresenter {
    private IListView view;
    private ArrayList<Empleado> empleados;
    
    public ListPresenter(IListView view){
        this.view = view;
    }
    
    private void cargarDatos(ArrayList<Empleado> empleados){
        this.empleados = empleados;
        this.actualizarVista();
        this.view.abrirLista();
    }
    
    public void actualizarVista(){
        this.view.cargarFilaEmpleados(this.empleados);
    }
    
    public void actualizarEmpleado(Empleado empleadoActualizado){
        String id = empleadoActualizado.objectId;
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.equals(id)){
                empleados.set(i, empleadoActualizado);
                break;
            }
        }
        this.actualizarVista();
    }
    
    public void insertarEmpleado(Empleado empleado){
        return;
    }
    
}
