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
            
            if (idSeleccionado != null && this.presentadorPantallaDetalle != null){
                this.presentadorPantallaDetalle.cargarEmpleadoId(idSeleccionado);
            }
        });
    }
    
    public void cargarDatos(){
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
        this.repoEmpleados.InsertarEmpleado(empleado);
        this.mostrarEmpleados();
    }
    
    public void establecerPresentadorPantallaDetalle(DetailPresenter presentadorPantallaDetalle){
        this.presentadorPantallaDetalle = presentadorPantallaDetalle;
    }
}
