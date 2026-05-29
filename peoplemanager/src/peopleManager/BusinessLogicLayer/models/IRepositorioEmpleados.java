
package peopleManager.BusinessLogicLayer.models;

import java.util.ArrayList;

public interface IRepositorioEmpleados {
    ArrayList<Empleado> obtenerListaEmpleados();
    Empleado obtenerIdEmpleado(String id);
    void InsertarEmpleado(Empleado empleado);
    void ActualizarEmpleado(Empleado empleado);
}
