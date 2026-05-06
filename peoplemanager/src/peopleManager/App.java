/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peopleManager;

import peopleManager.models.Empleado;
import peopleManager.views.ListFrame;
import peopleManager.views.DetailFrame;
import java.util.ArrayList;
import peopleManager.models.Categoria;
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
                ArrayList<Empleado> listaInicialEmpleados = new ArrayList<Empleado>();
                
                listaInicialEmpleados.add(new Empleado("1","Antonio","Alvarado","5",Categoria.CTO));
                listaInicialEmpleados.add(new Empleado("2","Ana","Aguilar","10",Categoria.MANAGER));

                listaInicialEmpleados.add(new Empleado("3","Bernardo","Benavides","7",Categoria.DEVELOPER));
                listaInicialEmpleados.add(new Empleado("4","Beatriz","Barragán","3",Categoria.DEVELOPER));
                
                DetailFrame vistaPantallaDetalle = new DetailFrame();
                DetailPresenter presentadorPantallaDetalle = new DetailPresenter(vistaPantallaDetalle);
                
                
                ListFrame vistaListaEmpleados = new ListFrame();
                ListPresenter presentadorListaEmpleados = new ListPresenter(vistaListaEmpleados);
                
                presentadorPantallaDetalle.conectarPantallaDetallesConLista(presentadorListaEmpleados);
                presentadorListaEmpleados.establecerPresentadorPantallaDetalle(presentadorPantallaDetalle);
                
                presentadorListaEmpleados.cargarDatos(listaInicialEmpleados);
            }
        });
    }
}
