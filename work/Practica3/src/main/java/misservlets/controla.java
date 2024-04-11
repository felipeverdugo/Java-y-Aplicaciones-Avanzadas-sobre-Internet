package misservlets;

import java.io.IOException;
import java.io.PrintWriter;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("radio") != null) {

			String opcion = request.getParameter("radio");
			ServletContext ctx = this.getServletContext();
			ServletContext ctxCompras = getServletContext().getContext("/compras");

			RequestDispatcher dispatcher;

			switch (opcion) {
			case "servlet":
				System.out.println("Seleccionaste la opción 1");
				dispatcher = ctx.getRequestDispatcher("/holaservlet");
				if (dispatcher != null)
					dispatcher.include(request, response);
				break;
			case "productos":
				System.out.println("Seleccionaste la opción 2");
				response.sendRedirect("/compras/productos");

				break;
			case "productos2":
				dispatcher = ctxCompras.getRequestDispatcher("/productos");
				if (dispatcher != null)
					dispatcher.include(request, response);

				break;
			case "google":
				System.out.println("Seleccionaste la opción 3");
			      response.sendRedirect("http://www.google.com.ar");


				break;
			default:
				response.sendRedirect(request.getContextPath()+"/inicio.html");
				break;
			}

		}
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
