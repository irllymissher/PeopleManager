package peopleManager.presenters;

import java.util.ArrayList;
import peopleManager.dataAccessLayer.RepositorioEmpleados;
import peopleManager.models.Empleado;
import peopleManager.views.FilaEmpleado;
import peopleManager.views.IListView;

public class ListPresenter {
    private IListView vistaListaEmpleados;
    private RepositorioEmpleados repoEmpleados; /* Pedir datos al repositorio */
    
    public ListPresenter(IListView vistaListaEmpleados){
        
        this.vistaListaEmpleados = vistaListaEmpleados;
        this.repoEmpleados = new RepositorioEmpleados();
        
        this.vistaListaEmpleados.asignarAccionAlSeleccionarEmpleado( ()->{
            String idSeleccionado = this.vistaListaEmpleados.obtenerIdDelEmpleadoSeleccionado();
            
            if (idSeleccionado != null){
                PresentManager.detailPresenter.cargarEmpleadoPorId(idSeleccionado);
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
        for(Empleado empleado : empleadosAlmacen) {
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
}




/*

                [ ListPresenter ] ────( 1. Envía Objeto Empleado COMPLETO )───> [ DetailPresenter ]
                         ▲                                                               │
                         │                                                               │
                         └──────( 2. Devuelve Objeto Modificado "en mano" )──────────────┘
                                    (Dependencia Circular / Teléfono escacharrado)

















[ ListPresenter ] ──────────( 1. Pasa SOLO el ID: "2" )──────────> [ DetailPresenter ]
         │                                                                  │
         │ (2. getAll() para pintar)                                        │ (3. GetById("2"))
         │                                                                  │
         ▼                                                                  ▼
  ┌───────────────────────────────────────────────────
  │                        [ RepositorioEmpleados (static) ]                         │
  │                                                                                  │
  │   📦 Casillero Común en RAM:                                                      │ 
  │      [ID: 1] Barry Allen  (CTO)                                                  │
  │      [ID: 2] Bruno Díaz   (BACKEND)  ◄────( 4. repo.Update() guarda aquí )───
  │      [ID: 3] Clark Kent   (CTO)                                                  │
  │                                                                                  │
  └───────────────────────────────────────────────────
*/