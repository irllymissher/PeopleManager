package peopleManager;

/**
 *
 * @author alumno
 */
public class DetailController {
    private DetailFrame vista;
    private Empleado empleado;
    
    public void cargarEmpleado(Empleado empleado){
        this.empleado = empleado;
        this.vista.open();
        this.vista.getjTextFieldNombreEmpleado().setText(empleado.nombre);
        this.vista.getjTextFieldApellidoEmpleado().setText(empleado.apellido);
        this.vista.getjTextFieldAntiguedadEmpleado().setText(empleado.antiguedad);
        this.vista.getjComboBoxCategoria().setSelectedItem(empleado.categoria);  
        
        this.vista.open();
    }
    
    public void calcularSalario(){
        
        String antiguedad = this.vista.getjTextFieldAntiguedadEmpleado().getText();
        String categoria = this.vista.getjComboBoxCategoria().getSelectedItem().toString();
        
        this.empleado.antiguedad = antiguedad;
        this.empleado.categoria = Categoria.valueOf(categoria);
        
        this.vista.getjLabelSalarioEmpleado().setText(empleado.calcularSalario());
    }
}
