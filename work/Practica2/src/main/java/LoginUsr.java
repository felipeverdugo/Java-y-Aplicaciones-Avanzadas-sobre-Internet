


import java.io.IOException;

import java.util.Enumeration;
import java.util.Hashtable;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/loginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashtable<String, String> logins;

    /**
     * Default constructor. 
     */
	

	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	         logins = new Hashtable<>();
	         
	         Enumeration<String> initParamNames = config.getInitParameterNames();

	         
	         // Iterar sobre todos los parámetros de inicialización
	         while (initParamNames.hasMoreElements()) {
	             String nombreParametro = initParamNames.nextElement();
	             String contrasena = config.getInitParameter(nombreParametro);
	             logins.put(nombreParametro, contrasena);
	         }
	    }
	

    public LoginUsr() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
        try {
    		String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		  // Verificar si el usuario y la contraseña son válidos (aquí deberías agregar tu lógica de autenticación)
            boolean credencialesValidas = validarCredenciales(username, password);
            
            if (credencialesValidas) {
            	HttpSession sesion = request.getSession(true);
            	response.sendRedirect(request.getContextPath()+"/productos");
            	

            } else {
                // Si las credenciales son inválidas, redirigir al usuario nuevamente a la página de login
                response.sendRedirect(request.getContextPath()+"/login.html");
            }
        
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
		



	}

	
    // Método para validar las credenciales (aquí deberías implementar tu lógica de autenticación)
    private boolean validarCredenciales(String userParam, String passParam) {
    	if (logins.get(userParam) != null) {
    			return logins.get(userParam).equals(passParam);
    	}
    	
    	return false;

}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
