package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.Categoria;
import peopleManager.Empleado;
import peopleManager.IDetailView;

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
    
    public void mostrarDetallesDelEmpleado(Empleado empleadoSeleccionado){
        ArrayList<String> nombreDeCategorias = new ArrayList<>();
        for (Categoria categoriaActual : Categoria.values()) {
            nombreDeCategorias.add(categoriaActual.name());
        }
        this.vistaPantallaDetalle.mostrarListaDeCategorias(nombreDeCategorias);
        
        this.vistaPantallaDetalle.mostrarDetallesDelEmpleadoSeleccionado(empleadoSeleccionado); 
        this.vistaPantallaDetalle.abrirPantalla();
    }
    
    public void calcularSalarioEmpleado(){
        Empleado empleadoEnFormulario = this.vistaPantallaDetalle.crearEmpleadoDesdeFormulario();
        String salarioCalculado = empleadoEnFormulario.calcularSalario();
        this.vistaPantallaDetalle.mostrarSalarioCalculado(salarioCalculado);
    }
    
    public void guardarEmpleado(){
        Empleado empleadoAGuardar = this.vistaPantallaDetalle.crearEmpleadoDesdeFormulario();
        this.vistaPantallaDetalle.cerrarPantalla();
        this.presentadorPantallaEmpleados.actualizarEmpleado(empleadoAGuardar);
    }
    
    public void conectarPantallaDetallesConLista(ListPresenter presentadorPantallaEmpleados){
        this.presentadorPantallaEmpleados = presentadorPantallaEmpleados;
    }
}
