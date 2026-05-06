package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.models.Categoria;
import peopleManager.models.Empleado;
import peopleManager.views.FilaEmpleado;
import peopleManager.views.FormularioEmpleado;
import peopleManager.views.IDetailView;

public class DetailPresenter {
    private IDetailView vistaPantallaDetalle;
    private ListPresenter presentadorPantallaEmpleados;
    
    public DetailPresenter(IDetailView vistaPantallaDetalle){
        this.vistaPantallaDetalle = vistaPantallaDetalle;
        
        this.vistaPantallaDetalle.cargarAccionCalcular(() -> {
            this.calcularSalarioEmpleado();
        });
        
        this.vistaPantallaDetalle.cargarAccionGuardar(() -> {
            this.guardarEmpleado();
        });
    }
    
    public void mostrarDetallesDelEmpleado(FormularioEmpleado empleadoSeleccionado){
        ArrayList<String> nombreDeCategorias = new ArrayList<>();
        for (Categoria categoriaActual : Categoria.values()) {
            nombreDeCategorias.add(categoriaActual.name());
        }
        this.vistaPantallaDetalle.mostrarListaDeCategorias(nombreDeCategorias);
        
        this.vistaPantallaDetalle.mostrarDatosDeEmpleadoEnFormulario(empleadoSeleccionado); 
        this.vistaPantallaDetalle.abrirPantalla();
    }
    
    public void calcularSalarioEmpleado(){
        FormularioEmpleado datosEmpleadoFormulario = this.vistaPantallaDetalle.obtenerDatosEmpleadoFormulario();
        
        Empleado empleadoTemporal = new Empleado(
                datosEmpleadoFormulario.EmpleadoId, 
                datosEmpleadoFormulario.Nombre, 
                datosEmpleadoFormulario.Apellido, 
                datosEmpleadoFormulario.Antiguedad, 
                Categoria.valueOf(datosEmpleadoFormulario.Categoria
                ));
        
        this.vistaPantallaDetalle.mostrarSalarioCalculado(empleadoTemporal.calcularSalario());
    }
    
    public void guardarEmpleado(){
        FormularioEmpleado datosEmpleadoAGuardar = this.vistaPantallaDetalle.obtenerDatosEmpleadoFormulario();
        
        Empleado empleadoTemporal = new Empleado(
                datosEmpleadoAGuardar.EmpleadoId, 
                datosEmpleadoAGuardar.Nombre, 
                datosEmpleadoAGuardar.Apellido, 
                datosEmpleadoAGuardar.Antiguedad, 
                Categoria.valueOf(datosEmpleadoAGuardar.Categoria
                ));
        
        this.vistaPantallaDetalle.cerrarPantalla();
        this.presentadorPantallaEmpleados.actualizarEmpleado(empleadoTemporal);
    }
    
    public void conectarPantallaDetallesConLista(ListPresenter presentadorPantallaEmpleados){
        this.presentadorPantallaEmpleados = presentadorPantallaEmpleados;
    }
}
