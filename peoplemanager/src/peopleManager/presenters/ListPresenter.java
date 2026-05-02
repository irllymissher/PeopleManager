package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.Empleado;
import peopleManager.IListView;

public class ListPresenter {
    private IListView vistaListaEmpleados;
    private ArrayList<Empleado> registroDeEmpleados;
    private DetailPresenter presentadorPantallaDetalle;
    
    public ListPresenter(IListView vistaListaEmpleados){
        this.vistaListaEmpleados = vistaListaEmpleados;
        
        this.vistaListaEmpleados.cargarAccionSeleccionada( ()->{
            String idSeleccionado = this.vistaListaEmpleados.obtenerIdEmpleado();
            Empleado empleadoEncontrado = null;
            for (Empleado empleadoActual : this.registroDeEmpleados) {
                if(empleadoActual.objectId.equals(idSeleccionado)){
                    empleadoEncontrado = empleadoActual;
                    break;
                }
            }
            if (this.presentadorPantallaDetalle != null)
                this.presentadorPantallaDetalle.mostrarDetallesDelEmpleado(empleadoEncontrado);
        });
    }
    
    public void cargarDatos(ArrayList<Empleado> nuevosEmpleados){
        this.registroDeEmpleados = nuevosEmpleados;
        this.mostrarEmpleados();
        this.vistaListaEmpleados.abrirLista();
    }
    
    public void mostrarEmpleados(){
        this.vistaListaEmpleados.cargarFilaEmpleados(this.registroDeEmpleados);
    }
    
    public void actualizarEmpleado(Empleado empleadoActualizado){
        String idBuscado = empleadoActualizado.objectId;
        for (int i = 0; i < registroDeEmpleados.size(); i++) {
            Empleado empleadoActual = registroDeEmpleados.get(i);
            if (empleadoActual.objectId.equals(idBuscado)){
                this.registroDeEmpleados.set(i, empleadoActualizado);
                break;
            }
        }
        this.mostrarEmpleados();
    }
    
    public void insertarEmpleado(Empleado empleado){
        return;
    }
    
    public void establecerPresentadorPantallaDetalle(DetailPresenter presentadorPantallaDetalle){
        this.presentadorPantallaDetalle = presentadorPantallaDetalle;
    }
}
