package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.Empleado;
import peopleManager.IListView;

public class ListPresenter {
    private IListView view;
    private ArrayList<Empleado> empleados;
    private DetailPresenter detailPresenter;
    
    public ListPresenter(IListView view){
        this.view = view;
    }
    
    public void cargarDatos(ArrayList<Empleado> empleados){
        this.empleados = empleados;
        this.mostrarEmpleados();
        this.view.abrirLista();
    }
    
    public void mostrarEmpleados(){
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
        this.mostrarEmpleados();
    }
    
    public void insertarEmpleado(Empleado empleado){
        return;
    }
    
    public void establecerDetailPresenter(DetailPresenter detailPresenter){
        this.detailPresenter = detailPresenter;
    }
}
