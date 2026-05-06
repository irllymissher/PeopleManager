/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleManager;

import java.util.ArrayList;
import peopleManager.models.Categoria;
import peopleManager.models.Empleado;
import peopleManager.presenters.DetailPresenter;
import peopleManager.presenters.ListPresenter;
import peopleManager.views.DetailFrame;
import peopleManager.views.ListConsoleView;

/**
 *
 * @author alumno
 */
public class ConsoleApplication {
    public static void main(String[] args) {
        ArrayList<Empleado> registroDeEmpleados = new ArrayList<Empleado>();

        registroDeEmpleados.add(new Empleado("1","Antonio","Alvarado","5",Categoria.CTO));
        registroDeEmpleados.add(new Empleado("2","Ana","Aguilar","10",Categoria.MANAGER));
        registroDeEmpleados.add(new Empleado("3","Bernardo","Benavides","7",Categoria.DEVELOPER));
        registroDeEmpleados.add(new Empleado("4","Beatriz","Barragán","3",Categoria.DEVELOPER));
        
        DetailFrame vistaPantallaDetallesEmpleado = new DetailFrame();
        DetailPresenter presentadorPantallaDeDetallesEmpleado = new DetailPresenter(vistaPantallaDetallesEmpleado);
        
        ListConsoleView vistaConsolaListaEmpleados = new ListConsoleView();
        ListPresenter presentadorListaDeEmpleados = new ListPresenter(vistaConsolaListaEmpleados);
        presentadorListaDeEmpleados.establecerPresentadorPantallaDetalle(presentadorPantallaDeDetallesEmpleado);
        
        presentadorListaDeEmpleados.cargarDatos(registroDeEmpleados);
        
    }
    
}
