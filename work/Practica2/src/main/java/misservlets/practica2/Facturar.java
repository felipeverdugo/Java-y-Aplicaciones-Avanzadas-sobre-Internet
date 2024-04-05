package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Facturar
 */
@WebServlet("/Facturar")
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Facturar() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sesion = request.getSession(true);

		if (sesion.isNew()) {
			response.sendRedirect("login.html");
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String[] cantidadPorGolosina;

		cantidadPorGolosina = request.getParameterValues("cantidad");


		for (int i = 0; i < cantidadPorGolosina.length; i++) {
			sesion.setAttribute("cant" + (i + 1), cantidadPorGolosina[i]);

		}


		Integer cant;
		Integer precioUnitario;
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Golosina</th>");
		out.println("<th>Cantidad</th>");
		out.println("<th>Total</th>");

		for (int i = 1; i < cantidadPorGolosina.length + 1; i++) {
			cant = Integer.parseInt((String) sesion.getAttribute("cant" + i));
//            Si compro algun producto
			if (cant != 0) {

				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + sesion.getAttribute("golo" + i) + "</td>");

				// Obtener precio unitario y cantidad
				precioUnitario = Integer.parseInt((String)sesion.getAttribute("pu" + i));
				cant = Integer.parseInt((String) sesion.getAttribute("cant" + i));

				out.println("<td>" + cant + "</td>");
				out.println("<td>" + precioUnitario * cant + "</td>");
				out.println("</tr>");
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
