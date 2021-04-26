package Jpa.demo.Dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Jpa.demo.entities.*;
import Jpa.demo.util.*;

public class UserDao {

	private EntityManager entityManager= JpaUtil.getEntityManager("JpaProject");
	public void ajouter(User U) {
		EntityTransaction tx= entityManager.getTransaction();
		tx.begin();
		entityManager.persist(U);
		tx.commit();
	}
}
