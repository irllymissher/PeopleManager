package peopleManager.PresentationLogicLayer.presenters;

import java.util.ArrayList;
import peopleManager.DataAccessLayer.RepositorioEmpleados;
import peopleManager.BusinessLogicLayer.models.Categoria;
import peopleManager.BusinessLogicLayer.models.Empleado;
import peopleManager.BusinessLogicLayer.models.IRepositorioEmpleados;
import peopleManager.PresentationLogicLayer.views.FormularioEmpleado;
import peopleManager.PresentationLogicLayer.views.IDetailView;

public class DetailPresenter {
    private IDetailView vistaPantallaDetalle;
    private ListPresenter presentadorPantallaEmpleados;
    private IRepositorioEmpleados repoEmpleados;
    
    public DetailPresenter(IDetailView vistaPantallaDetalle, IRepositorioEmpleados repo){
        
        this.vistaPantallaDetalle = vistaPantallaDetalle;
        this.repoEmpleados = repo;
        
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
                Categoria.valueOf(datosEmpleadoAGuardar.Categoria)
        );

        // 1. Guardamos los cambios directamente en el almacén usando nuestro repositorio
        this.repoEmpleados.ActualizarEmpleado(empleadoTemporal);

        // 2. Cerramos la pantalla de detalles
        this.vistaPantallaDetalle.cerrarPantalla();

        // 3. Avisamos al presentador de la lista que vuelva a pintar los datos actualizados
        PresentManager.listPresenter.mostrarEmpleados();
    }
    
    public void conectarPantallaDetallesConLista(ListPresenter presentadorPantallaEmpleados){
        this.presentadorPantallaEmpleados = presentadorPantallaEmpleados;
    }
    
    public void cargarEmpleadoPorId(String objectId){
        Empleado empleadoEncontrado = this.repoEmpleados.obtenerIdEmpleado(objectId);
        
        // 1. CARGAMOS LAS CATEGORÍAS EN EL COMBOBOX PRIMERO
        ArrayList<String> nombreDeCategorias = new ArrayList<>();
        for (Categoria categoriaActual : Categoria.values()) {
            nombreDeCategorias.add(categoriaActual.name());
        }
        this.vistaPantallaDetalle.mostrarListaDeCategorias(nombreDeCategorias);
        
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

/*
[ App.java ] ──(Inserta 5 Héroes)──> [ empleados (RAM Estática) ] 📦 (Barry, Bruno, Clark...)
                                                 │
                                       (¡El bucle no miraba aquí!)
                                                 ▼
 [ Repositorio ] ➔ clonLista 📭 (Vacía) ──> [ FOR EACH ] 🔄 (Pregunta: "¿Hay algo dentro de clonLista?")
                                ▲                    │
                                │                    ▼
                                └──────( 0 vueltas )─❌ "No, está vacía". El bucle se rompe.
                                                     │
                                                     ▼
                                          Devuelve: 📭 (Lista Vacía)
                                                     │
                                                     ▼
                                            [ ListPresenter ]
                                                     │
                                                     ▼
                                            📺 [ PANTALLA EN BLANCO ]
















[ App.java ] ──(Inserta 5 Héroes)──> [ empleados (RAM Estática) ] 📦 (Barry, Bruno, Clark...)
                                                 │
                                                 ▼ (¡Conexión establecida!)
 [ Repositorio ] ➔ clonLista 📭 (Vacía) ──> [ FOR EACH ] 🔄 ◄─── Recorre los 5 héroes reales
                                ▲                    │
                                │                    ▼
                                └────( Inserta Clon )─ Fabricando Clon de Barry, Bruno... 
                                                     │
                                                     ▼
                                          Devuelve: 📦 (Lista con 5 Clones) 
                                                     │
                                                     ▼
                                            [ ListPresenter ]
                                                     │
                                                     ▼
                                            📺 [ 🚀 TABLA LLENA 🚀 ]
*/