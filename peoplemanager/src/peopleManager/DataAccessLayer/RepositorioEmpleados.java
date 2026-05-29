package peopleManager.DataAccessLayer;

import java.util.ArrayList;
import peopleManager.BusinessLogicLayer.models.Empleado;
import peopleManager.BusinessLogicLayer.models.IRepositorioEmpleados;
/**
 * ES INDISPENSABLE QUE SE DEBA DE ENVIAR COPIAS
 * DE LO CONTRARIO SE ESTARÍA MODIFICANDO EL DAO
 * DIRECTAMENTE DESDE LA RAM PERDIENDO EL CONTROL
 * DE LOS DATOS.
 * @author tomif
 */
public class RepositorioEmpleados implements IRepositorioEmpleados{
    
    /**
     * 
     * ----------------------ARQUITECTURA MULTICAPA-----------------------------------
     * Esto es necesario porque cada ve que se realiza un new RepositorioEmpleados()
     * se creará un objeto nuevo, pero al hacerlo static entonces todas las instacias
     * compartiran de la misma colección en memoria
     * -------------------------------------------------------------------------------
     * 
     * --------------------ARQUITECTURA EN CEBOLLA------------------------------------
     * Se borrará porque en el Main se creara la Base de datos la cual será inyectada
     * a todso los serviciso y presentacion, al haber una sola instancia circulando
     * no necesitamos una lista estatica
     * -------------------------------------------------------------------------------
     */
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    
    /**
     * Creamos una lista de empleados CLON
     * @return 
     */
    @Override
    public ArrayList<Empleado> obtenerListaEmpleados(){
        ArrayList<Empleado> clonListaEmpleados = new ArrayList<Empleado>();
        for(Empleado empleadoClon : empleados) {
            clonListaEmpleados.add(new Empleado(
                    empleadoClon.objectId, 
                    empleadoClon.nombre, 
                    empleadoClon.apellido, 
                    empleadoClon.antiguedad, 
                    empleadoClon.categorias));
        }
        return clonListaEmpleados;
    }
    
    /**
     * Al buscar el ID del empleado tenemos que 
     * devovler el ID del empleaod CLON por seguridad
     * no podemos pasarle desde la RAM porque lo 
     * podrían modificar
     * @param id
     * @return 
     */
    @Override
    public Empleado obtenerIdEmpleado(String id){
        for (Empleado empleadoClon : empleados) {
            if(empleadoClon.objectId.equals(id)){
                return new Empleado(
                        empleadoClon.objectId, 
                        empleadoClon.nombre, 
                        empleadoClon.apellido, 
                        empleadoClon.antiguedad, 
                        empleadoClon.categorias);
            }
        }
        return null;
    }
    @Override
    public void ActualizarEmpleado(Empleado empleado){
        String idEmpleadoActualizar = empleado.objectId;

        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleadoActual = empleados.get(i);

            if (empleadoActual.objectId.equals(idEmpleadoActualizar)){

                // Fabricamos un clon con los datos actualizados para proteger el DAO
                Empleado empleadoClon = new Empleado(
                        empleado.objectId, 
                        empleado.nombre, 
                        empleado.apellido, 
                        empleado.antiguedad, 
                        empleado.categorias);

                // Guardamos el clon, NO la referencia externa
                this.empleados.set(i, empleadoClon);
                break;
            }
        }
    }
    
    /**
     * Al crear un objeto nace sin ID. Es rensponsabilidad de este 
     * metodo del DAO calcular el identificar unico antes de meterlo
     * a la vista. 
     * @param empleado 
     */
    @Override
    public void InsertarEmpleado(Empleado empleado){
        Empleado empleadoClon = new Empleado(
                empleado.objectId, 
                empleado.nombre, 
                empleado.apellido, 
                empleado.antiguedad, 
                empleado.categorias);
        
        int size = empleados.size();
        empleadoClon.objectId = String.valueOf(size+1);
        empleados.add(empleadoClon);
    }
}
