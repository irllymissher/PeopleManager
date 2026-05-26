package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.dataAccessLayer.RepositorioEmpleados;
import peopleManager.models.Categoria;
import peopleManager.models.Empleado;
import peopleManager.views.FormularioEmpleado;
import peopleManager.views.IDetailView;

public class DetailPresenter {
    private IDetailView vistaPantallaDetalle;
    private ListPresenter presentadorPantallaEmpleados;
    private RepositorioEmpleados repoEmpleados;
    
    public DetailPresenter(IDetailView vistaPantallaDetalle){
        
        this.vistaPantallaDetalle = vistaPantallaDetalle;
        this.repoEmpleados = new RepositorioEmpleados();
        
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
    
    public void cargarEmpleadoPorId(String objectId){
        Empleado empleadoEncontrado = this.repoEmpleados.obtenerIdEmpleado(objectId);
        
        if (empleadoEncontrado != null){
            FormularioEmpleado vm = new FormularioEmpleado(
                    empleadoEncontrado.getObjectId(),
                    empleadoEncontrado.getNombre(), 
                    empleadoEncontrado.getApellido(), 
                    empleadoEncontrado.getAntiguedad(),
                    empleadoEncontrado.getCategoria().toString()
            );
            this.vistaPantallaDetalle.mostrarDatosDeEmpleadoEnFormulario(vm);
            this.vistaPantallaDetalle.abrirPantalla();
        }
    }
    
    public void guardarCambios(FormularioEmpleado vm){
        Empleado empleadoActualizado = new Empleado(
                vm.EmpleadoId, 
                vm.Nombre, 
                vm.Apellido, 
                vm.Antiguedad, 
                Categoria.valueOf(vm.Categoria));
        this.repoEmpleados.ActualizarEmpleado(empleadoActualizado);
        this.vistaPantallaDetalle.cerrarPantalla();
        PresentManager.listPresenter.mostrarEmpleados();
    }
}
