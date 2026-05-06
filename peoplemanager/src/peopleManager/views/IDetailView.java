package peopleManager.views;

import java.util.ArrayList;

public interface IDetailView {
    void abrirPantalla();
    void cerrarPantalla();
    void mostrarListaDeCategorias(ArrayList<String> nombresDeCategorias);
    
    void cargarAccionCalcular(Runnable accionCalcular);
    void cargarAccionGuardar(Runnable accionGuardar);
    
    FormularioEmpleado obtenerDatosEmpleadoFormulario();
    void mostrarDatosDeEmpleadoEnFormulario(FormularioEmpleado formularioEmpleado);
    void mostrarSalarioCalculado(String salarioResultante); /* Si no actualizarSalario */
}
