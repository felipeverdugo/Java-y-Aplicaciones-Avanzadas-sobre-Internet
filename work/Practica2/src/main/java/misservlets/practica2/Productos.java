package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;


/**
 * Servlet implementation class Productos
 */
@WebServlet(
		urlPatterns = { "/productos" }, 
		initParams = { 
				@WebInitParam(name = "cantidadTotal", value = "5"), 
				@WebInitParam(name = "golo0", value = "chupetin"), 
				@WebInitParam(name = "pu0", value = "2"), 
				@WebInitParam(name = "golo1", value = "chocolate"), 
				@WebInitParam(name = "pu1", value = "3"), 
				@WebInitParam(name = "golo2", value = "caramelo"), 
				@WebInitParam(name = "pu2", value = "6"), 
				@WebInitParam(name = "golo3", value = "alfajor"), 
				@WebInitParam(name = "pu3", value = "40"), 
				@WebInitParam(name = "golo4", value = "chicle"), 
				@WebInitParam(name = "pu4", value = "8")
		})
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Productos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
        super.init(config);

		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(false);

		if (sesion == null){
        	response.sendRedirect(request.getContextPath()+"/login.html");
		} else {
		int cantidadTotal = Integer.parseInt(getInitParameter("cantidadTotal"));



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Imprimir el formulario HTML utilizando out.print()
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>Formulario de Pedido de Golosinas</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h2>Formulario de Pedido de Golosinas</h2>");
        out.println("<form action=\"facturar\" method=\"POST\">");
        out.println("        <table>");
        out.println("            <thead>");
        out.println("                <tr>");
        out.println("                    <th>Golosina</th>");
        out.println("                    <th>Precio Unitario</th>");
        out.println("                    <th>Cantidad</th>");
        out.println("                </tr>");
        out.println("            </thead>");
        out.println("            <tbody>");
        Golosina golo;
        Integer cant;
        String nombre;
        Double precioUnidad;
        for (int i = 0; i < cantidadTotal; i++) {
        	cant = 0;
            nombre = (getInitParameter("golo"+i));
            precioUnidad = Double.parseDouble(getInitParameter("pu"+i));
            golo =(Golosina) sesion.getAttribute("item"+i);
            if (golo != null) {
            	cant = golo.getCant();
            }
            out.println("                <tr>");
            out.println("                    <td><output\">" + nombre+ "</output></td>");
            out.println("                    <td><output>$" + precioUnidad + "</output></td>");
            out.println(" <input type=\"hidden\" name=\"nombre" + i + "\" value=\"" + nombre+ "\"></td>");
            out.println(" <input type=\"hidden\" name=\"precioUnidad" + i + "\" value=\"" + precioUnidad+ "\"></td>");
            
            out.println("                    <td><input type=\"number\"  value=\""+cant+"\" name=\"cantidad\" min=\"0\"></td>");
            out.println("                </tr>");
        }
        out.println("            </tbody>");
        out.println("        </table>");
        out.println("        <br>");
        out.println("        <input type=\"submit\" value=\"Enviar Pedido\">");
        out.println("    </form>");

        out.println("<form action=\"terminarsesion\" method=\"get\">");
        out.println("    <button type=\"submit\" class=\"boton\">Salir</button>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

        
        
        System.out.println("ID de la sesión: " + sesion.getId());
        // Obtener los nombres de los atributos en la sesión y sus valores
        Enumeration<String> attributeNames = sesion.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = sesion.getAttribute(attributeName);
            System.out.println("Nombre: " + attributeName + ", Valor : " + attributeValue+ "Tipo Atribu"+attributeValue.getClass());
        }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
