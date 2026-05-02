/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peopleManager;

import java.util.ArrayList;
import peopleManager.Categoria;
import peopleManager.presenters.ListPresenter;

/**
 *
 * @author alumno
 */
public class App {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<Empleado> empleado = new ArrayList<Empleado>();
                empleado.add(new Empleado("1","Bob","Smith","5",Categoria.CTO));
                empleado.add(new Empleado("2","John","Doe","10",Categoria.MANAGER));
                
                ListFrame listView = new ListFrame();
                ListPresenter listPresenter = new ListPresenter(listView);
                listPresenter.mostrarEmpleados();
            }
        });
    }
}
