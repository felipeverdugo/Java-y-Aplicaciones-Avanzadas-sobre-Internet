package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;

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
		urlPatterns = { "/Productos" }, 
		initParams = { 
				@WebInitParam(name = "cantidadTotal", value = "5"), 
				@WebInitParam(name = "golo1", value = "chupetin"), 
				@WebInitParam(name = "pu1", value = "2"), 
				@WebInitParam(name = "golo2", value = "chocolate"), 
				@WebInitParam(name = "pu2", value = "3"), 
				@WebInitParam(name = "golo3", value = "caramelo"), 
				@WebInitParam(name = "pu3", value = "6"), 
				@WebInitParam(name = "golo4", value = "alfajor"), 
				@WebInitParam(name = "pu4", value = "40"), 
				@WebInitParam(name = "golo5", value = "chicle"), 
				@WebInitParam(name = "pu5", value = "8")
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
		
		int cantidadTotal = Integer.parseInt(getInitParameter("cantidadTotal"));
		HttpSession sesion = request.getSession(true);

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
        out.println("<form action=\"Facturar\" method=\"POST\">");
        out.println("        <table>");
        out.println("            <thead>");
        out.println("                <tr>");
        out.println("                    <th>Golosina</th>");
        out.println("                    <th>Precio Unitario</th>");
        out.println("                    <th>Cantidad</th>");
        out.println("                </tr>");
        out.println("            </thead>");
        out.println("            <tbody>");
        Integer cant =0;
        for (int i = 1; i <= cantidadTotal; i++) {
            out.println("                <tr>");
            sesion.setAttribute("golo"+i , getInitParameter("golo"+i));
            out.println("                    <td>"+getInitParameter("golo"+i)+"</td>");
            sesion.setAttribute("pu"+i ,getInitParameter("pu"+i));
            out.println("                    <td>$"+getInitParameter("pu"+i)+"</td>");
            sesion.setAttribute("cant"+i ,cant);
            out.println("                    <td><input type=\"number\"  value=0 name=\"cantidad\" min=\"0\"></td>");
            out.println("                </tr>");

			
		}

        
        out.println("            </tbody>");
        out.println("        </table>");
        out.println("        <br>");
        out.println("        <input type=\"submit\" value=\"Enviar Pedido\">");
        out.println("    </form>");
        out.print("<a href=\"TerminarSesion\">Salir</a>");
        out.println("</body>");
        out.println("</html>");
		
		
		
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
