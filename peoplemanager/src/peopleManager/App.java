package peopleManager;

import peopleManager.models.Empleado;
import peopleManager.views.ListFrame;
import peopleManager.views.DetailFrame;
import java.util.ArrayList;
import peopleManager.dataAccessLayer.RepositorioEmpleados;
import peopleManager.models.Categoria;
import peopleManager.presenters.DetailPresenter;
import peopleManager.presenters.ListPresenter;
import peopleManager.presenters.PresentManager;

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
                
                PresentManager.listPresenter = new ListPresenter(pantallaRegistroDeEmpleados);
                PresentManager.detailPresenter = new DetailPresenter(pantallaDetallesDeEmpleado);
                
                PresentManager.listPresenter.cargarDatos();
            }
        });
    }
}
