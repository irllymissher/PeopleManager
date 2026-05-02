package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.Categoria;
import peopleManager.Empleado;
import peopleManager.IDetailView;

public class DetailPresenter {
    private IDetailView vista;
    
    public DetailPresenter(IDetailView view){
        this.vista = view;
        
        this.vista.cargarAccionCalcular(() -> {
            this.calcularSalarioEmpleado();
        });
    }
    
    public void cargarEmpleadoE(Empleado empleado){
        ArrayList<String> categorias = new ArrayList<>();
        for (Categoria cat : Categoria.values()) {
            categorias.add(cat.name());
        }
        this.vista.mostrarCategorias(categorias);
        
        this.vista.mostrarDatosEmpleado(empleado); 
        this.vista.abrir();
    }
    
    public void calcularSalarioEmpleado(){
        Empleado empleado = this.vista.obtenerEmpleado();
        String salarioCalculado = empleado.calcularSalario();
        this.vista.mostrarSalario(salarioCalculado);
    }
}
