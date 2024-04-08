package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
			sesion.setAttribute("cant" + (i + 1), Integer.parseInt(cantidadPorGolosina[i]));
		}

        // Imprimir el ID de la sesión
        System.out.println("ID de la sesión: " + sesion.getId());
        
        // Obtener los nombres de los atributos en la sesión y sus valores
        Enumeration<String> attributeNames = sesion.getAttributeNames();
        System.out.println("Facturar \n\n");

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = sesion.getAttribute(attributeName);
            System.out.println("Nombre: " + attributeName + ", Valor : " + attributeValue+ "Tipo Atribu"+attributeValue.getClass());
        }
    

		Integer cant;
		Double precioUnitario;
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Golosina</th>");
		out.println("<th>Cantidad</th>");
		out.println("<th>Total</th>");

		for (int i = 1; i < cantidadPorGolosina.length + 1; i++) {
			cant = (Integer) sesion.getAttribute("cant" + i);
//            Si compro algun producto
			if (cant != 0) {

				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + sesion.getAttribute("golo" + i) + "</td>");

				// Obtener precio unitario y cantidad
				precioUnitario = (Double) sesion.getAttribute("pu" + i);
				cant = (Integer) sesion.getAttribute("cant" + i);

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
