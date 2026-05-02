/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peopleManager;

import java.util.ArrayList;
import peopleManager.Categoria;
import peopleManager.presenters.DetailPresenter;
import peopleManager.presenters.ListPresenter;

/**
 *
 * @author alumno
 */
public class App {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<Empleado> empleados = new ArrayList<Empleado>();
                empleados.add(new Empleado("1","Bob","Smith","5",Categoria.CTO));
                empleados.add(new Empleado("2","John","Doe","10",Categoria.MANAGER));
                
                DetailFrame detailView = new DetailFrame();
                DetailPresenter detailPresenter = new DetailPresenter(detailView);
                
                ListFrame listView = new ListFrame();
                ListPresenter listPresenter = new ListPresenter(listView);
                
                listPresenter.establecerDetailPresenter(detailPresenter);
                listPresenter.cargarDatos(empleados);
            }
        });
    }
}
