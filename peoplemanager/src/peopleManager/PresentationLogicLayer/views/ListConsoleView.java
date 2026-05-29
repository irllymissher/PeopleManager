package peopleManager.PresentationLogicLayer.views;

import java.util.ArrayList;
import java.util.Scanner;

public class ListConsoleView implements IListView{

    private Runnable nuevaAccion;
    private Runnable accionSeleccionada;
    private String idSeleccionado;
    private Scanner sc = new Scanner(System.in);
    
    @Override
    public void abrirLista() {
        System.out.println("*** LIST ***");
    }

    @Override
    public String obtenerIdDelEmpleadoSeleccionado() { return this.idSeleccionado; }

    @Override
    public void asignarAccionAlSeleccionarEmpleado(Runnable accionSeleccionar) { this.accionSeleccionada = accionSeleccionar; }

    @Override
    public void asignarAccionParaNuevoEmpleado(Runnable accionNuevoEmpleado) { this.nuevaAccion = accionNuevoEmpleado; }

    @Override
    public void asignarFilaDeEmpleado(ArrayList<FilaEmpleado> filaDeEmpleados){
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        
        for (FilaEmpleado fila : filaDeEmpleados) {
            System.out.println(String.format("ID: %s | Nombre: %s | Antigüedad: %s | Categoría: %s | Salario: %s",
                fila.EmpleadoId, fila.NombreCompleto, fila.Antiguedad, fila.Categoria, fila.Salario)); 
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Introduce el ID del empleado para ver detalles: ");
        
        String id = sc.nextLine();
        
        this.idSeleccionado = id;
        accionSeleccionada.run();
    }
    
}
