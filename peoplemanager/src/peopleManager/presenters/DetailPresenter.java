package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.Categoria;
import peopleManager.Empleado;
import peopleManager.IDetailView;

public class DetailPresenter {
    private IDetailView vistaPantallaDetalle;
    
    public DetailPresenter(IDetailView vistaPantallaDetalle){
        this.vistaPantallaDetalle = vistaPantallaDetalle;
        
        this.vistaPantallaDetalle.cargarAccionCalcular(() -> {
            this.calcularSalarioEmpleado();
        });
    }
    
    public void mostrarDetallesDelEmpleado(Empleado empleadoSeleccionado){
        ArrayList<String> nombreDeCategorias = new ArrayList<>();
        for (Categoria categoriaActual : Categoria.values()) {
            nombreDeCategorias.add(categoriaActual.name());
        }
        this.vistaPantallaDetalle.mostrarCategorias(nombreDeCategorias);
        
        this.vistaPantallaDetalle.mostrarDatosEmpleado(empleadoSeleccionado); 
        this.vistaPantallaDetalle.abrir();
    }
    
    public void calcularSalarioEmpleado(){
        Empleado empleadoEnFormulario = this.vistaPantallaDetalle.obtenerEmpleado();
        String salarioCalculado = empleadoEnFormulario.calcularSalario();
        this.vistaPantallaDetalle.mostrarSalario(salarioCalculado);
    }
}
