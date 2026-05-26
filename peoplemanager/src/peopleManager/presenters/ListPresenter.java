package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.dataAccessLayer.RepositorioEmpleados;
import peopleManager.models.Empleado;
import peopleManager.views.FilaEmpleado;
import peopleManager.views.FormularioEmpleado;
import peopleManager.views.IListView;

public class ListPresenter {
    private IListView vistaListaEmpleados;
    private DetailPresenter presentadorPantallaDetalle;
    private RepositorioEmpleados repoEmpleados; /* Pedir datos al repositorio */
    
    public ListPresenter(IListView vistaListaEmpleados){
        this.vistaListaEmpleados = vistaListaEmpleados;
        this.repoEmpleados = new RepositorioEmpleados();
        this.vistaListaEmpleados.asignarAccionAlSeleccionarEmpleado( ()->{
            String idSeleccionado = this.vistaListaEmpleados.obtenerIdDelEmpleadoSeleccionado();
            Empleado empleadoEncontrado = null;
            for (Empleado empleadoActual : this.repoEmpleados.obtenerListaEmpleados()) {
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
        this.mostrarEmpleados();    
        this.vistaListaEmpleados.abrirLista();
    }
    
    public void mostrarEmpleados() {
        ArrayList<FilaEmpleado> filas = new ArrayList<FilaEmpleado>();
        ArrayList<Empleado> empleadosAlmacen = this.repoEmpleados.obtenerListaEmpleados();
        for (Empleado empleado : empleadosAlmacen) {
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
        this.repoEmpleados.ActualizarEmpleado(empleadoActualizado);
        this.mostrarEmpleados();
    }
    
    public void insertarEmpleado(Empleado empleado){
        return;
    }
    
    public void establecerPresentadorPantallaDetalle(DetailPresenter presentadorPantallaDetalle){
        this.presentadorPantallaDetalle = presentadorPantallaDetalle;
    }
}
