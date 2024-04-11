package misservlets.practica2;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Facturar
 */
@WebServlet("/facturar")
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

		HttpSession sesion = request.getSession(false);
		 Hashtable<String, Double> stockProductos = (Hashtable<String, Double>) (request.getServletContext().getAttribute("stock"));
		if (sesion == null){
        	response.sendRedirect(request.getContextPath()+"/login.html");
		} else {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String[] cantidadPorGolosina;

		cantidadPorGolosina = request.getParameterValues("cantidad");
		


		Integer cant;
		Double precioUnitario;
		String nombre;
		Golosina golosina;
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Golosina</th>");
		out.println("<th>Cantidad</th>");
		out.println("<th>Total</th>");
        out.println("            <tbody>");
		for (int i = 0; i < cantidadPorGolosina.length; i++) {
			cant = Integer.parseInt(cantidadPorGolosina[i]);
//            Si compro algun producto
			if (cant != 0) {
				nombre = request.getParameter("nombre"+i);
				precioUnitario =stockProductos.get(nombre);
				sesion.setAttribute("item"+i, new Golosina(nombre, precioUnitario, cant));
				
				out.println("<td>" + nombre + "</td>");
				out.println("<td>" + cant + "</td>");
				out.println("<td>" + precioUnitario * cant + "</td>");
				out.println("</tr>");
			}  

		}
		
		
        out.println("            </tbody>");
        out.println("<form action=\"productos\" method=\"get\">");
        out.println("    <button type=\"submit\" class=\"boton\">Seguir comprando</button>");
        out.println("</form>");
        out.println("<form action=\"terminarsesion\" method=\"get\">");
        out.println("    <button type=\"submit\" class=\"boton\">Salir</button>");
        out.println("</form>");
		out.println("</table>");
        out.println("</body>");
        out.println("</html>");

		
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
