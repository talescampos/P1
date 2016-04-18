package br.com.ex.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Conexao.jdbc.ProdutoDAO;
import br.com.b.bens.Produto;

 
@WebServlet("/ControlServelet")
public class ControlServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	
	public ControlServelet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Produto prod = new Produto();
		ProdutoDAO prodDAO = new ProdutoDAO();
		
		List<Produto> lista = prodDAO.buscarProduto(prod);
		
		request.setAttribute("lista", lista);
		RequestDispatcher saida = request.getRequestDispatcher("ListadeProduto.jsp");
		saida.forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
