package Jpa.demo.servlet;
import Jpa.demo.Dao.UserDao;
import Jpa.demo.entities.*;
import Jpa.demo.util.JpaUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Inscription() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf= (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em= emf.createEntityManager();
		try {	
			String nom=request.getParameter("name");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String adresse=request.getParameter("adresse");
			
			User us=new User();
			us.setName(nom);
			us.setPassword(password);
			us.setEmail(email);
			us.setAdresse(adresse);
				
			if(nom!=null) {
				em.getTransaction().begin();
				em.persist(us);
				em.getTransaction().commit();
			}
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
			
		}
	}

}
