
package peopleManager.BusinessLogicLayer.services;

import java.util.ArrayList;
import peopleManager.BusinessLogicLayer.models.Empleado;
import peopleManager.BusinessLogicLayer.models.Categoria;
import peopleManager.DataAccessLayer.RepositorioEmpleados;

public class servicioEmpleados {
    private final RepositorioEmpleados repo;
    
    public servicioEmpleados(){
        this.repo = new RepositorioEmpleados();
    }
    
    /**
     * Intenta insertar un empleado validando primero las reglas de negocio[cite: 217, 223].
     * @param employee El empleado que se desea introducir.
     * @return true si el empleado cumple las reglas y fue insertado; false en caso contrario.
     */
    public Boolean Insert(Empleado employee) {
        // 1. Recuperamos la lista actual de empleados clonados desde el repositorio
        ArrayList<Empleado> listaEmpleados = this.repo.obtenerListaEmpleados();
        
        int contadorManagers = 0;
        int contadorDevsYAnalistas = 0;
        
        // 2. Contamos cuántos Managers, Developers y Analysts hay actualmente en el sistema
        for (Empleado e : listaEmpleados) {
            if (e.getCategoria() == Categoria.MANAGER) {
                contadorManagers++;
            } else if (e.getCategoria() == Categoria.DEVELOPER || e.getCategoria() == Categoria.ANALYST) {
                contadorDevsYAnalistas++;
            }
        }
        
        // 3. Aplicamos la Regla de Negocio:
        // "La cantidad de manager debe ser inferior a la mitad de la suma de developers y analistas"
        if (employee.getCategoria() == Categoria.MANAGER) {
            // Si sumamos el nuevo manager que se quiere insertar:
            int futurosManagers = contadorManagers + 1;
            double limiteMaximo = contadorDevsYAnalistas / 2.0;
            
            // Si la nueva cantidad NO es inferior al límite, rechazamos la inserción
            if (futurosManagers >= limiteMaximo) {
                return false; 
            }
        }
        
        // 4. Si la regla se cumple (o si el empleado no es un MANAGER), procedemos a guardarlo
        this.repo.InsertarEmpleado(employee);
        return true; 
    }
}
