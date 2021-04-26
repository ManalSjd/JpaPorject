package Jpa.demo.servlet;
import Jpa.demo.entities.User;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf= (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em= emf.createEntityManager();
	     
	     try {
	    	 User user = new User();
		     user.setEmail(request.getParameter("email"));
		     user.setPassword(request.getParameter("password"));
		     
		     List<User> Us=em.createQuery("select u from user u where u.email like :pemail and u.password like:ppassword").setParameter("pemail","%"+request.getParameter("email")+"%").getResultList();
	    	 if (Us!=null) {
	    		 HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          response.sendRedirect("login-success.jsp"); //logged-in page      		
		     }
			        
		     else 
		          response.sendRedirect("login-error.jsp"); //error page
	    	 }finally {
	    		 if(em.getTransaction().isActive()) {
	    			 em.getTransaction().rollback();
	    		 }
	    		 em.close();
	     }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
