package misservlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controla
 */
@WebServlet("/controla")
public class controla extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public controla() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		 String opcion = request.getParameter("radio");
     	ServletContext ctx=this.getServletContext();
     	RequestDispatcher dispatcher;
	        switch (opcion) {
	            case "servlet":
	            	 dispatcher=ctx.getRequestDispatcher("/holaservlet");
	            	if (dispatcher!=null) dispatcher.include(request,response);
	                break;
	            case "productos":

	            	 dispatcher=ctx.getRequestDispatcher("compras/Productos");
	            	if (dispatcher!=null) dispatcher.include(request,response);
	                System.out.println("Seleccionaste la opción 2");
	                break;
	            case "google":
	                System.out.println("Seleccionaste la opción 3");
	                break;
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
