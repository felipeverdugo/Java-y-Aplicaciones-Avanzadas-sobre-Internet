package misServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private List<String> usrNames;
	private List<String> passWords;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginUsr() {
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		inicializarUsuarios();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		
		PrintWriter out=response.getWriter();	
		response.setContentType("text/html");
		
		
			if (cheaquearContraseña(verificarUsuario(user),pass) ) {
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Usuario Valido </title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<center><h1>Bienvenido " + user  + "</h1></center>");
				out.println("</body>");
				out.println("</html>");
				out.close();
				
			} else {
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Usuario Invalido </title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Su usuario o contraseña son incorrectas </h2>");
			    out.println("<button onclick=\"window.location.href='login.html';\">Volver</button>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			}
				
				
			
			
		
		
		
	
		
		


		
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		

	}

	private boolean cheaquearContraseña(int indexUser, String pass) {
		// TODO Auto-generated method stub
		if (indexUser != -1) {
			return passWords.get(indexUser).equals(pass);
		}
		return false;
	}

	private int verificarUsuario(String user) {
		
		return usrNames.indexOf(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void inicializarUsuarios() {
    	this.passWords = new ArrayList<String>();
    	this.usrNames = new ArrayList<String>();
		usrNames.add("usuario1");
		usrNames.add("usuario2");
		usrNames.add("usuario3");
		usrNames.add("usuario4");
		passWords.add("1234");
		passWords.add("4567");
		passWords.add("123");
		passWords.add("000");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		

		doGet(request, response);
	}

}
