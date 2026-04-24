/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peopleManager;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alumno
 */
public class ListController {
    private ListFrame vista;
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    public ListController() {
        this.vista = new ListFrame();
        this.vista.setVisible(true);
        
        empleados.add(new Empleado("1", "Augustus", "Caesar", "15", Categoria.CTO));
        empleados.add(new Empleado("2", "Tiberius", "Claudius", "12", Categoria.MANAGER));
        empleados.add(new Empleado("3", "Caligula", "Germanicus", "8", Categoria.BACKEND));
        empleados.add(new Empleado("4", "Claudius", "Nero", "10", Categoria.DEVOPS));
        empleados.add(new Empleado("5", "Nero", "Augustus", "6", Categoria.DEVELOPER));
        empleados.add(new Empleado("6", "Vespasian", "Flavius", "14", Categoria.TECHLEAD));
        empleados.add(new Empleado("7", "Titus", "Flavius", "9", Categoria.BACKEND));
        empleados.add(new Empleado("8", "Domitian", "Augustus", "11", Categoria.MANAGER));
        empleados.add(new Empleado("9", "Trajan", "Optimus", "13", Categoria.CTO));
        empleados.add(new Empleado("10", "Hadrian", "Aelius", "10", Categoria.DEVOPS));
        
        this.rellenarTablaEmpleados();
    }
    
    private void rellenarTablaEmpleados(){
        TableModel modelTable = this.vista.getjTableEmpleados().getModel();
        DefaultTableModel defaultModel = (DefaultTableModel) modelTable;
        defaultModel.setRowCount(empleados.size());
        
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            
            modelTable.setValueAt(empleado.objectId, i, 0);
            modelTable.setValueAt(empleado.nameDescription(), i, 1);
            modelTable.setValueAt(empleado.antiguedad, i, 2);
            modelTable.setValueAt(empleado.categoria.toString(), i, 3);
            modelTable.setValueAt(empleado.calcularSalario(), i, 4);
        }
    }
    
    
    
}
