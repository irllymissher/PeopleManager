package peopleManager;

import peopleManager.BusinessLogicLayer.models.Empleado;
import peopleManager.PresentationLogicLayer.views.ListFrame;
import peopleManager.PresentationLogicLayer.views.DetailFrame;
import java.util.ArrayList;
import peopleManager.DataAccessLayer.RepositorioEmpleados;
import peopleManager.BusinessLogicLayer.models.Categoria;
import peopleManager.BusinessLogicLayer.services.servicioEmpleados;
import peopleManager.PresentationLogicLayer.presenters.DetailPresenter;
import peopleManager.PresentationLogicLayer.presenters.ListPresenter;
import peopleManager.PresentationLogicLayer.presenters.PresentManager;

/**
 *
 * @author alumno
 */
public class App {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                RepositorioEmpleados repoEmpleados = new RepositorioEmpleados();
                
                repoEmpleados.InsertarEmpleado(new Empleado("1","Barry","Allen","5",Categoria.CTO));
                repoEmpleados.InsertarEmpleado(new Empleado("2","Bruno","Diaz","1",Categoria.BACKEND));
                repoEmpleados.InsertarEmpleado(new Empleado("3","Clark","Kent","3",Categoria.CTO));
                repoEmpleados.InsertarEmpleado(new Empleado("4","Hal","Jordan","9",Categoria.ANALYST));
                repoEmpleados.InsertarEmpleado(new Empleado("5","Eoboard","Thawne","5",Categoria.TECHLEAD));
                
                ListFrame pantallaRegistroDeEmpleados = new ListFrame();
                DetailFrame pantallaDetallesDeEmpleado = new DetailFrame();
                servicioEmpleados servicioEmpleado = new servicioEmpleados();
                
                PresentManager.listPresenter = new ListPresenter(pantallaRegistroDeEmpleados, repoEmpleados);
                PresentManager.detailPresenter = new DetailPresenter(pantallaDetallesDeEmpleado, repoEmpleados);
                
                PresentManager.listPresenter.cargarDatos();
            }
        });
    }
}
