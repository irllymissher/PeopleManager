package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.models.Empleado;
import peopleManager.views.FilaEmpleado;
import peopleManager.views.FormularioEmpleado;
import peopleManager.views.IListView;

public class ListPresenter {
    private IListView vistaListaEmpleados;
    private ArrayList<Empleado> registroDeEmpleados;
    private DetailPresenter presentadorPantallaDetalle;
    
    public ListPresenter(IListView vistaListaEmpleados){
        this.vistaListaEmpleados = vistaListaEmpleados;
        
        this.vistaListaEmpleados.asignarAccionAlSeleccionarEmpleado( ()->{
            String idSeleccionado = this.vistaListaEmpleados.obtenerIdDelEmpleadoSeleccionado();
            Empleado empleadoEncontrado = null;
            for (Empleado empleadoActual : this.registroDeEmpleados) {
                if(empleadoActual.objectId.equals(idSeleccionado)){
                    empleadoEncontrado = empleadoActual;
                    break;
                }
            }
            if (empleadoEncontrado != null && this.presentadorPantallaDetalle != null){
                FormularioEmpleado vm = new FormularioEmpleado(
                        empleadoEncontrado.getObjectId(),
                        empleadoEncontrado.getNombre(), 
                        empleadoEncontrado.getApellido(), 
                        empleadoEncontrado.getAntiguedad(),
                        empleadoEncontrado.getCategoria().toString()
                );
                this.presentadorPantallaDetalle.mostrarDetallesDelEmpleado(vm);
            }
        });
    }
    
    public void cargarDatos(ArrayList<Empleado> nuevosEmpleados){
        this.registroDeEmpleados = nuevosEmpleados;
        this.mostrarEmpleados();    
        this.vistaListaEmpleados.abrirLista();
    }
    
    public void mostrarEmpleados() {
        ArrayList<FilaEmpleado> filas = new ArrayList<FilaEmpleado>();
        for (Empleado empleado : this.registroDeEmpleados) {
            filas.add(new FilaEmpleado(
                empleado.getObjectId(),
                empleado.nombreCompleto(),
                empleado.getAntiguedad(),
                empleado.calcularSalario(),
                empleado.getCategoria().toString()
            ));
        }
        this.vistaListaEmpleados.asignarFilaDeEmpleado(filas);
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
