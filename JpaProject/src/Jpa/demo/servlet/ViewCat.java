package Jpa.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Jpa.demo.entities.Cat;

/**
 * Servlet implementation class ViewCat
 */
@WebServlet("/ViewCat")
public class ViewCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf= (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em= emf.createEntityManager();
		try {
			List<Cat> c=em.createQuery("select c from cat c",Cat.class).getResultList();
			request.setAttribute("Catalogue", c);
			request.getRequestDispatcher("catalogue.jsp").forward(request, response);
		}finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();	
			em.close();	
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
