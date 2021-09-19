package Web;

import Datos.ClienteDaoJDBC;
import Dominio.Cliente;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// cobertimos a servlet esta clase 
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    
    
    // sobreEscribimos metodos dopost y doget 
    
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
    
            // se encargara de recuperar el listado de clientes y compartir la informacion a otro jsp
            
            // recupera informacion de clientes
        ClienteDaoJDBC clientedao = new ClienteDaoJDBC();
        List<Cliente> clientes = new ArrayList();
        clientes = clientedao.listar();
        System.out.println("clientes =" + clientes);
        
        // esta colocando la informacion en un alcance request
        request.setAttribute("clientes", clientes);
        // compartimos en requets el tamaño total del arreglo 
        request.setAttribute("totalClientes", clientes.size());
        // comparimos  el saldo total q se calcula desde una funcion
        request.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        // envia la informacion a jsp clientres
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
    
    // metodo para sumar el saldo totalde los clientes 
    private double calcularSaldoTotal(List<Cliente> clientes){
    double saldototal=0;
    for(Cliente cl : clientes){
    
        saldototal += cl.getSaldo();
    }
    return saldototal;
    }
    
    
}
