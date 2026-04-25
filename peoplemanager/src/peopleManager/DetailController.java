package peopleManager;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author alumno
 */
public class DetailController {
    private DetailFrame vista;
    private Empleado empleado;
    private ListController listController;

    public DetailController(ListController listController) {
        this.listController = listController;
        
        ArrayList<String> categorias = new ArrayList<String>();
        for(Categoria cat : Categoria.values()){
            categorias.add(cat.toString());
        }
        
        this.vista = new DetailFrame(categorias);
        
        JButton buttonCalculate= this.vista.getjButtonCalcularSalario();
        buttonCalculate.addActionListener((ActionEvent e) -> {
            calcularSalario();
            });
    }
    
    public void cargarEmpleado(Empleado empleado){
        this.empleado = empleado;
        
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
    
    public void save(){
        String objectID = this.empleado.objectId;
        String nombre = this.vista.getjTextFieldNombreEmpleado().getText();
        String apellido = this.vista.getjTextFieldApellidoEmpleado().getText();
        String antiguedad = this.vista.getjTextFieldAntiguedadEmpleado().getText();
        Categoria categoria = Categoria.valueOf(this.vista.getjComboBoxCategoria().getSelectedItem().toString());
        
        Empleado empleadoActualizar = new Empleado(objectID, nombre, apellido, antiguedad, categoria);
        
        this.listController.updateEmployee(empleadoActualizar);
        this.vista.close();
    }
}
